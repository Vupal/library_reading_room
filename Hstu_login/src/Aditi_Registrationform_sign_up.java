import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Aditi_Registrationform_sign_up extends JFrame {

    private JTextField txtname;

    private JButton registerButton;
    private JPanel Registerform;
    private JTextField txtid;
    private JTextField txtdepart;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField txtpass;
    private JTextField txtconpass;
    private JButton Button;
    String level,semester,degree;

    public Aditi_Registrationform_sign_up() {
        setContentPane(Registerform);

        setSize(450, 400);
        //setMaximumSize(new Dimension(600, 600));
        //setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);


        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 level=comboBox3.getSelectedItem().toString();
                //txtlevel.setText(level);
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                semester =comboBox2.getSelectedItem().toString();
               // textsemester.setText(semester);
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                degree=comboBox1.getSelectedItem().toString();
                //textdegree.setText(val);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registeruser();


            }
        });
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Aditi_Register_login_RUN();
            }
        });
    }

   private void registeruser() {

        String name = txtname.getText();
        String stid=txtid.getText();
        String depart=txtdepart.getText();
       // String level=txtlevel.getText();
        //String semester=textsemester.getText();
       // String degree=textdegree.getText();
        String password = txtpass.getText();
        String conpass = txtconpass.getText();
        if (name.isEmpty() || stid.isEmpty() || depart.isEmpty() || level.isEmpty() || password.isEmpty() || conpass.isEmpty() || semester.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill all the information!", "Alert", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!password.equals(conpass)) {
            JOptionPane.showMessageDialog(this, "Confirm password dooes not match!", "Alert", JOptionPane.WARNING_MESSAGE);
              return;
        }

         user = addUserToDatabase(name, stid,depart,level,semester,degree,password,conpass);
      /*  if(user!=null)
        {


            dispose();
            JOptionPane.showMessageDialog(this, "Successfully register", "Alert", JOptionPane.WARNING_MESSAGE);
        }*/

    }

    public User user;
    private User addUserToDatabase( String name,String stid,String depart,String level,String semest,String degree,String password,String conpass) {
        User user=null;
        JDBC_Connection aa=new JDBC_Connection();
        Connection con =aa.getConnection();
        try {
            Statement stat= con.createStatement();
            String sql = "INSERT INTO RegisterForm(Id,Name,Level,Semester,Department,Degree,Password,ConPassword)" +
                    "VALUES(?,?,?,?,?,?,?,?)";


            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, stid);
            preparedStatement.setString(2, name);

            preparedStatement.setString(3, level);
            preparedStatement.setString(4, semest);
            //
            preparedStatement.setString(5, depart);

            preparedStatement.setString(6, degree);
            preparedStatement.setString(7, password);
            preparedStatement.setString(8, conpass);

            int addesRows = preparedStatement.executeUpdate();
            if(addesRows>0){
                JOptionPane.showMessageDialog(this, "Successfully register", "Alert", JOptionPane.WARNING_MESSAGE);
                 dispose();
                 new Aditi_Register_login_RUN();

            }


        } catch (SQLException e) {
            dispose();
            JOptionPane.showMessageDialog(this, "you Already Register ", "Alert", JOptionPane.WARNING_MESSAGE);
            new Aditi_Registrationform_sign_up();
            //throw new RuntimeException(e);
        }



        return user;
        //return null;

    }




    public static void main(String[] args) {
        Aditi_Registrationform_sign_up Reg=new Aditi_Registrationform_sign_up();
        //User user=Reg.user;



    }



}

