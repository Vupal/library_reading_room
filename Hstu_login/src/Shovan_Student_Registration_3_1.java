import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Shovan_Student_Registration_3_1 extends JFrame {
    private JPanel Main;
    private JTable t1;
    private JScrollPane jt1;
    private JButton backButton;

    public Shovan_Student_Registration_3_1(){
        setContentPane(Main);

        setSize(1010, 600);
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800,600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setResizable(true);
        setVisible(true);
        JJTable();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Shovan_AdminPage();
            }
        });
    }
    public void JJTable(){
        JDBC_Connection aa=new JDBC_Connection();
        Connection connection = aa.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(" select Id,Name,Level,Semester,Department,Degree,Password,ConPassword From Registerform");
            ResultSet resultSet=preparedStatement.executeQuery();
            t1.setModel(DbUtils.resultSetToTableModel(resultSet));


        } catch (SQLException e) {

            throw new RuntimeException(e);

        }


    }
    /*
       JDBC_Connection aa=new JDBC_Connection();
                connection=aa.getConnection();

                try {

                    String dt=sdft.format(dateChooser.getDate());
                    preparedStatement =connection.prepareStatement("select id,name,level,semester,Date,Time,seat_no,Exit_time from library_form where Date='"+dt+"' ");
                    //if(preparedStatement) System.out.println();
                    ResultSet resultSet=preparedStatement.executeQuery();
                    //if(resultSet.first()) System.out.println("True");
                    table1.setModel(DbUtils.resultSetToTableModel(resultSet));

                } catch (SQLException a) {
                    throw new RuntimeException(a);
                }

     */

    public static void main(String[] args) {
        new Shovan_Student_Registration_3_1();
    }
}
