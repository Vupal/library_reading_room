import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Shovan_Display_Particular_Date3_2 extends JFrame{
    private JTable table1;
    private JPanel Main;
    private JScrollPane tabletxt;
    private JPanel jpCalendar;
    private JPanel jpcald;
    private JButton OKButton;
    private JButton backButton;
    SimpleDateFormat sdft;
    Calendar cld=Calendar.getInstance();
    JDateChooser dateChooser=new JDateChooser(cld.getTime());


    public Connection connection;
    PreparedStatement preparedStatement;
    Shovan_Display_Particular_Date3_2(){

        setContentPane(Main);

        setSize(1010, 600);
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800,600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setResizable(true);
        setVisible(true);
        dateChooser.setDateFormatString("yyyy/MM/dd");
        jpcald.add(dateChooser);
         sdft=new SimpleDateFormat("yyyy-MM-dd");
         //table();


        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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




            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Shovan_AdminPage();
            }
        });
    }
    void table(){


    }
    public static void main(String[] args) {
        Shovan_Display_Particular_Date3_2 displayParticularDate =new Shovan_Display_Particular_Date3_2();
    }

    //Calendar cld = Calendar.getInstance();
}
