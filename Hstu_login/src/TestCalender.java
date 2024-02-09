import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalender extends  JFrame {
    private JPanel jpCalendar;
    private JPanel jpcald;
    private JButton getButton;
    private JButton setButton;
    private JTextField textField1;
    Calendar cld=Calendar.getInstance();
    Date date=cld.getTime();
   // JDateChooser dateChooser=new JDateChooser(cld.getTime());
  //JDateChooser dateChooser=new JDateChooser(cld.getTime());
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

    public TestCalender(){
        setContentPane(jpCalendar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,250);
        setVisible(true);
        //calendar
       //dateChooser.setDateFormatString("yyyy/MM/dd");
        //jpcald.add(dateChooser);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        // calendar

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdft=new SimpleDateFormat("yyyy-MM-dd");

               // String dt=sdft.format(dateChooser.getDate());
                String dt=sdft.format(date);
                textField1.setText(dt);
            }
        });
    }


    public static void main(String[] args) {
        //new  TestCalender().setVisible(true);
            TestCalender ts=new TestCalender();
    }

}
