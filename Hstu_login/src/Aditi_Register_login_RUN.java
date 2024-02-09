import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aditi_Register_login_RUN extends JFrame{
    private JPanel Main;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel p1;
    private JPanel p2;
    private JTextField txtid;
    private JPasswordField txtpass;
    private JButton adminButton;

    public Aditi_Register_login_RUN(){
        setContentPane(Main);
       // p2.setBounds(100,10000,10000,1000);

        setSize(800, 400);
      //  p2.setSize(200,200);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                 new Aditi_Registrationform_sign_up();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Shovan_Admin_Loginform1();
            }
        });
    }


    public void check(){

        JDBC_Connection ob=new JDBC_Connection();
        Connection connection=ob.getConnection();//mysql


        try {
            Statement statement=connection.createStatement();


            String sql="select Id,Password from  RegisterForm ";//query
            ResultSet resultSet=statement.executeQuery(sql);
            String id=txtid.getText();
            String pass=txtpass.getText();
            int ans=0;
            while (resultSet.next()){
                String i=resultSet.getString("Id");
                String p= resultSet.getString("Password");
               // System.out.println(i);
                if(p.equals(pass) && i.equals(id)){

                    ans=1;
                    //  System.out.println("done");

                    break;
                }
            }
            if(ans==1){
                dispose();
                new Aditi_Student_Reading_Room();

            }
            else{
                JOptionPane.showMessageDialog(this, "Check your Information", "Alert", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(this, "Check your Information", "Alert", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(e);
        }

    }



    public static void main(String[] args) {
         new Aditi_Register_login_RUN();
    }



}
