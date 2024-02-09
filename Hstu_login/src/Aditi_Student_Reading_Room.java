import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Aditi_Student_Reading_Room extends JFrame implements MouseListener {
    private JPanel Main;
   // private JLabel l1;
    private JLabel l2;
    private JLabel l3;
  //  private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel l7;
    private JLabel l8;
    private JLabel l9;

    public Aditi_Student_Reading_Room()
    {
        setContentPane(Main);

        setSize(800, 600);
        setMaximumSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800,600));
       // l1.addMouseListener(this);
        l2.addMouseListener(this);
        l3.addMouseListener(this);
        l7.addMouseListener(this);
        l5.addMouseListener(this);
        l8.addMouseListener(this);
        l9.addMouseListener(this);
        l6.addMouseListener(this);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       // setUndecorated(true);
        setResizable(true);
        setVisible(true);



    }

    public static void main(String[] args) {
        Aditi_Student_Reading_Room homepage=new Aditi_Student_Reading_Room();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
       if (e.getSource() == l2) {
            dispose();
            Vupal_Showform showform = new Vupal_Showform();
        } else if (e.getSource() == l3) {
            dispose();
           // Display_today_information displayTodayInformation =
            new Shovan_Display_today_information();

        }
       else if (e.getSource() == l8) {
            dispose();
            new Aditi_Register_login_RUN();

        }
        else if (e.getSource() == l6) {
           // dispose();
           // Url obj=
            new Aditi_Url();

        }
        else if (e.getSource() == l9) {
            dispose();
           // Outside outside=
            new Vupal_Exit_from_the_Library();

        } else if (e.getSource()==l5) {
            new Aditi_helpline();

       } else if (e.getSource() == l7) {
           try {
               Desktop.getDesktop().browse(new URI("https://hstu.ac.bd/page/notice_all"));
           } catch (IOException a) {
               throw new RuntimeException(a);
           } catch (URISyntaxException a) {
               throw new RuntimeException(a);
           }

       }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
