import javax.swing.*;
import java.awt.*;

public class Aditi_helpline extends JFrame {
    private JPanel main;
    Aditi_helpline(){
        setContentPane(main);

        setSize(800, 600);
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800,600));
        // l1.addMouseListener(this)
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Aditi_helpline();
    }

}
