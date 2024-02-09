import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class X_Employment extends JFrame {
    private JTextField txtname;
    private JTextField txtsalary;
    private JTextField txtmobile;
    private JButton saveButton;
    private JTable table1;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JPanel Main;
    private JTextField txtsearch;
    private JScrollPane table_1;

    Connection con;
    PreparedStatement pnt;
    Statement stat;
    public X_Employment() {

    setContentPane(Main);

    setSize(800, 800);
    setMaximumSize(new Dimension(800, 800));
    //setModal(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   // table_load();
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String empname,salary,mobile;
          empname=txtname.getText();
          salary=txtsalary.getText();
          mobile=txtmobile.getText();
            try {
                pnt=con.prepareStatement("insert into employee(empname,salary,mobile) values(?,?,?)");
                pnt.setString(1,empname);
                pnt.setString(2,salary);
                pnt.setString(3,mobile);
                pnt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Record Added!");
                table_load();
                txtname.setText(" ");
                txtsalary.setText(" ");
                txtmobile.setText(" ");
                txtname.requestFocus();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
    });
    setVisible(true);
    connect();
   table_load();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emid=txtsearch.getText();
                try {
                    pnt=con.prepareStatement("select empname,salary,mobile from employee where id=? ");
                    pnt.setString(1,emid);
                    ResultSet rs=pnt.executeQuery();
                    if(rs.next()==true)
                    {
                        String empname=rs.getString(1);
                        String emsalary=rs.getString(2);
                        String emmobile= rs.getString(3);
                      txtname.setText(empname);
                      txtsalary.setText(emsalary);
                      txtmobile.setText(emmobile);

                    }
                    else{
                        txtname.setText(" ");
                        txtsalary.setText(" ");
                        txtmobile.setText(" ");

                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {






            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            String emid=txtsearch.getText();
                try {
                    pnt=con.prepareStatement("delete from employee where id= ?");
                    pnt.setString(1,emid);
                    pnt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Delete");
                    table_load();
                    txtname.setText(" ");
                    txtmobile.setText(" ");
                    txtsalary.setText(" ");
                    txtsearch.setText(" ");
                    txtname.requestFocus();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

    void table_load()
    {
        try {
            pnt=con.prepareStatement("select * from employee");
            ResultSet rs=pnt.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void connect(){
        String url = "jdbc:mysql://localhost:3306/ RB_data";
        String username = "root";
        String password = "T#9758@qlph";
        try {

            con = DriverManager.getConnection(url, username, password);
            stat = con.createStatement();
            System.out.println("Successfull");
        }
        catch (SQLException e) {
           e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        X_Employment employment=new X_Employment();
    }
}
