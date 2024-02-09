import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shovan_Admin_Loginform1 extends JFrame{
    private JButton exitButton;
    private JButton saveButton;
    private JButton clearButton1;
    private JPanel Mainplane;
    private JPasswordField passwordtxt;
    private JTextField emailtxt;
    private JButton backButton;
    private JButton backbutton;
    private JButton Back;

    public Shovan_Admin_Loginform1() {
           setContentPane(Mainplane);
           setTitle("Login");
           setSize(800,700);
           setMaximumSize(new Dimension(800,500));
           //setModal(true);
          setLocationRelativeTo(null);
           setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           setResizable(true);
           setUndecorated(true);
           setVisible(true);
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email=emailtxt.getText();
            String password=passwordtxt.getText();
            if(email.equals("hstu") && password.equals("1234")){
               // System.out.println("Hello");
                dispose();
               // Entering_Outside enteringOutside=
                new Shovan_Welcome2();

            }
            else{
                JOptionPane.showMessageDialog(null,"Enter correct information");
            }

        }
    });
    clearButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            emailtxt.setText(" ");
            passwordtxt.setText("");
            emailtxt.requestFocus();

        }
    });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               // Homepage homepage=
                new Aditi_Register_login_RUN();
            }
        });
    }

   /* public static void main(String[] args) {
        Loginform log=new Loginform();
    }*/



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
