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
import java.util.Date;

public class Shovan_Display_today_information extends  JFrame {
    private JTable table1;
    private JScrollPane tabletxt;
    private JPanel Home;
    private JButton button;
    SimpleDateFormat sdft;
    Calendar cld=Calendar.getInstance();
    Date date=cld.getTime();

    public Connection connection;
    PreparedStatement preparedStatement;
    public Shovan_Display_today_information(){

        setContentPane(Home);

        setSize(1010, 600);
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800,600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setResizable(true);
        setVisible(true);
        sdft=new SimpleDateFormat("yyyy-MM-dd");
        String dt=sdft.format(date);

        JDBC_Connection aa=new JDBC_Connection();
        connection=aa.getConnection();

        try {


            preparedStatement =connection.prepareStatement("select id,name,level,semester,Date,Time,seat_no from st_en_form  where seat_no>0 && Date='"+dt+"' ");
            //if(preparedStatement) System.out.println();
            ResultSet resultSet=preparedStatement.executeQuery();
            //if(resultSet.first()) System.out.println("True");
            table1.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException a) {
            throw new RuntimeException(a);
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Aditi_Student_Reading_Room homepage=new Aditi_Student_Reading_Room();
            }
        });
    }

    public static void main(String[] args) {
        Shovan_Display_today_information displayTodayInformation=new Shovan_Display_today_information();
    }
}
