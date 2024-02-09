import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vupal_Entering_Outside extends JFrame implements MouseListener{
    private JLabel Ma;
    private JLabel e1;
    private JLabel e2;
    private JPanel kl;
    private JLabel a4;
    private JButton backButton;
    private JButton exitButton;

    public Vupal_Entering_Outside()
    {
        setContentPane(kl);
        setSize(800, 600);
        setMaximumSize(new Dimension(800, 600));
        //setMinimumSize(new Dimension(800,600));
       // setUndecorated(true);
        //setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        e1.addMouseListener( this);
        e2.addMouseListener(this);

        a4.addMouseListener(this);
        // table_load();


       /* backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               // Loginform loginform=
                new Loginform();
            }
        });*/



    }

   public static void main(String[] args) {

        //Entering_Outside enteringOutside=
       new Vupal_Entering_Outside();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==e1)
        {
            dispose();
           //Student_Entering studentEntering=
            new Vupal_student_Entry();
        }

        else if(e.getSource()==a4){
             dispose();
            System.exit(0);
        }
        else{
            dispose();
           // outsidelogin aa=
            new Vupal_student_Exit();
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


   /* @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }*/
}
