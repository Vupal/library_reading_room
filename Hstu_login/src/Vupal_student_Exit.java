import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Vupal_student_Exit extends JFrame {
    private JTextField txtid;
    private JPanel log;
    private JButton loginButton;
    private JPasswordField txtpass;
    private JButton Back;
    private JButton clear;
    String Pass,ID;


    public Vupal_student_Exit(){

        setContentPane(log);
        setSize(800,400);
        setMaximumSize(new Dimension(500,400));
        //setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        //setUndecorated(true);
        setVisible(true);




        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=txtid.getText();
                String pass=txtpass.getText();
                if(!id.isEmpty() && !pass.isEmpty())
                connect();
                else{
                   // JOptionPane.showMessageDialog(this, "Please fill all the information!", "Alert", JOptionPane.WARNING_MESSAGE);

                }
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtid.setText(" ");
                txtpass.setText("");
                txtid.requestFocus();
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Vupal_Entering_Outside aa=new Vupal_Entering_Outside();


            }
        });
    }
    public void connect(){
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formattedTime = currentTime.format(formatter);
        String ddate = String.valueOf(java.time.LocalDate.now());
        JDBC_Connection ob=new JDBC_Connection();
        Connection connection=ob.getConnection();

        try {


            Statement statement=connection.createStatement();
           // String sq = "insert into st_en_form(Exit_time,Exit_date) " + "values('" + ddate+ "','"+formattedTime+"')";
          /*  String query = "insert into library_form(Exit_time,Exit_date) " + "values('" + ddate+ "','"+formattedTime+"')";
           // int rowaffacted = statement.executeUpdate(sq);
            int rowaffacted1=statement.executeUpdate(query);*/
           String sql="select id,pass from st_en_form ";
           ResultSet resultSet=statement.executeQuery(sql);
           String a=txtpass.getText();
           int Id= Integer.parseInt(txtid.getText());




           // System.out.println(a+" "+Id);
            //String a=Pass;
            int ans=0;
           while (resultSet.next()){
               int i=resultSet.getInt("id");
               String p= resultSet.getNString("pass");
               //System.out.println(i+" "+p);
               if(p.equals(a) && i==Id){

                   ans=1;
                 //  System.out.println("done");

                   break;
               }
           }
           if(ans==1){
               dispose();
               String query="  delete from st_en_form  where id='"+Id+"'";
               String query1=" update library_form set Exit_time='"+formattedTime+"',Exit_date='"+ddate+"' where id='"+Id+"'";
               // update korte hobe ekane
              int result=statement.executeUpdate(query1);
               int resul=statement.executeUpdate(query);

               Vupal_Entering_Outside aa=new Vupal_Entering_Outside();

           }
           else {
               JOptionPane.showMessageDialog(this, "Check Stdudent id & password", "Outside", JOptionPane.WARNING_MESSAGE);


           }
           statement.close();
           connection.close();

           /* String sql="select * from st_en_form pass=? AND id=?";
            PreparedStatement pst=connection.prepareCall(sql);

            pst.setInt(1,ID);
            pst.setString(2,Pass);
            int resultSet;
            resultSet=pst.executeUpdate();
            if(resultSet>0){
                System.out.println("sucess");
            }
            else{
                System.out.println("fail");
            }*/



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Vupal_student_Exit a=new Vupal_student_Exit();

    }


}
