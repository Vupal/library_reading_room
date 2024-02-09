import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shovan_AdminPage extends JFrame {
    private JButton registrationInformationButton;
    private JButton seatInforrmationButton;
    private JPanel Main;
    private JButton backButton;

    public Shovan_AdminPage(){
        setContentPane(Main);
        setSize(450, 400);
        //setMaximumSize(new Dimension(600, 600));
        //setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
        registrationInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Shovan_Student_Registration_3_1();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Shovan_Welcome2();
            }
        });
        seatInforrmationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Shovan_Display_Particular_Date3_2();
            }
        });
    }

    public static void main(String[] args) {
        new Shovan_AdminPage();
    }
}
