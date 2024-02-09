import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jbox extends  JFrame{
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPanel Main;
    private JButton button1;

    public jbox(){


        setContentPane(Main);

        //setContentPane(kl);
        setSize(800, 600);
        setMaximumSize(new Dimension(800, 600));
        //setMinimumSize(new Dimension(800,600));
        //setUndecorated(true);
        //setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value=comboBox1.getSelectedItem().toString();
                textField1.setText(value);

            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value=comboBox1.getSelectedItem().toString();
                textField1.setText(value);
            }
        });
    }

    public static void main(String[] args) {
        new jbox();
    }
}
