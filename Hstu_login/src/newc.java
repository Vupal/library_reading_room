import javax.swing.*;
import java.awt.*;

public class newc extends  JFrame{
    private JPanel Main;
    private JPanel j;
    private JLabel a;

    public newc(){
          //j.setSize(20,20);
          //a.setText("vupal");
        setSize(420, 300);
          a=new JLabel("Fisy");
        //  a.setBounds(20,30,30,10);
        j=new JPanel();
        j.setBackground(Color.getHSBColor(35,24,42));
        j.setSize(100,100);
        j.add(a);

        //  p2.setSize(200,200);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(j);
        setVisible(true);
    }

    public static void main(String[] args) {
        newc ne=new newc();

    }
}
