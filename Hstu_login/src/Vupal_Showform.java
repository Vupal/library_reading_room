import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Vupal_Showform extends JFrame{
    private JPanel Main;
    private JButton backButton;
    private JButton a1;
    private JButton a14;
    private JButton a15;
    private JButton a16;
    private JButton a17;
    private JButton a18;
    private JButton a19;
    private JButton a20;
    private JButton a21;
    private JButton a22;
    private JButton a23;
    private JButton a24;
    private JButton a25;
    private JButton a26;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private JButton a5;
    private JButton a6;
    private JButton a7;
    private JButton a8;
    private JButton a9;
    private JButton a10;
    private JButton a11;
    private JButton a12;
    private JButton a13;
    private JButton a40;
    private JButton a41;
    private JButton a42;
    private JButton a43;
    private JButton a44;
    private JButton a45;
    private JButton a46;
    private JButton a47;
    private JButton a48;
    private JButton a49;
    private JButton a50;
    private JButton a51;
    private JButton a52;
    private JButton a27;
    private JButton a28;
    private JButton a29;
    private JButton a30;
    private JButton a32;
    private JButton a33;
    private JButton a34;
    private JButton a35;
    private JButton a36;
    private JButton a37;
    private JButton a38;
    private JButton a39;
    private JButton a31;
    private JButton v1;
    private JButton v66;
    private JButton v67;
    private JButton v68;
    private JButton v69;
    private JButton v70;
    private JButton v71;
    private JButton v72;
    private JButton v73;
    private JButton v74;
    private JButton v75;
    private JButton v77;
    private JButton v78;
    private JButton v79;
    private JButton v2;
    private JButton v3;
    private JButton v4;
    private JButton v5;
    private JButton v6;
    private JButton v7;
    private JButton v8;
    private JButton v9;
    private JButton v10;
    private JButton v11;
    private JButton v12;
    private JButton v13;
    private JButton v14;
    private JButton v15;
    private JButton v16;
    private JButton v17;
    private JButton v19;
    private JButton v20;
    private JButton v21;
    private JButton v22;
    private JButton v23;
    private JButton v24;
    private JButton v25;
    private JButton v26;
    private JButton v27;
    private JButton v80;
    private JButton v81;
    private JButton v82;
    private JButton v83;
    private JButton v84;
    private JButton v85;
    private JButton v86;
    private JButton v87;
    private JButton v88;
    private JButton v89;
    private JButton v90;
    private JButton v91;
    private JButton v92;
    private JTextField a105TextField;
    private JTextField seattext;
    private JButton bookedSeatsButton;
    int cnt=0;
    public int[] array=new int[1000];

    Connection connection;
    PreparedStatement pnt;
    Statement statement;
    public Vupal_Showform(){


        setContentPane(Main);

        setSize(1000, 800);
        //setMaximumSize(new Dimension(1000, 1000));
        // setMinimumSize(new Dimension(600,600));
        //validate();
        //setModal(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        connect();
        seat_color();
        seattext.setText(String.valueOf(105-cnt ));
        seattext.requestFocus(false);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Aditi_Student_Reading_Room homepage=new Aditi_Student_Reading_Room();
            }
        });
    }

    // connect
    public void connect(){
        JDBC_Connection aa=new JDBC_Connection();
        connection=aa.getConnection();
        statement=null;
        try {
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select seat_no from st_en_form");
            while (resultSet.next()){
                int seat= resultSet.getInt("seat_no");
                array[seat]=1;
                cnt++;
            }
            //connection.close();
            // statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //Button work
    void Button_work(){
        a1.addActionListener((ActionListener) this);
        a2.addActionListener((ActionListener) this);
        a3.addActionListener((ActionListener) this);
        a4.addActionListener((ActionListener) this);
        a5.addActionListener((ActionListener) this);
        a6.addActionListener((ActionListener) this);
        a7.addActionListener((ActionListener) this);
        a8.addActionListener((ActionListener) this);
        a9.addActionListener((ActionListener) this);
        a10.addActionListener((ActionListener) this);
        a11.addActionListener((ActionListener) this);
        a12.addActionListener((ActionListener) this);
        a13.addActionListener((ActionListener) this);
        a14.addActionListener((ActionListener) this);
        a15.addActionListener((ActionListener) this);
        a16.addActionListener((ActionListener) this);
        a17.addActionListener((ActionListener) this);
        a18.addActionListener((ActionListener) this);
        a19.addActionListener((ActionListener) this);
        a20.addActionListener((ActionListener) this);
        a21.addActionListener((ActionListener) this);
        a22.addActionListener((ActionListener) this);
        a23.addActionListener((ActionListener) this);
        a24.addActionListener((ActionListener) this);
        a25.addActionListener((ActionListener) this);
        a26.addActionListener((ActionListener) this);
        a27.addActionListener((ActionListener) this);
        a28.addActionListener((ActionListener) this);
        a29.addActionListener((ActionListener) this);
        a30.addActionListener((ActionListener) this);
        a31.addActionListener((ActionListener) this);
        a32.addActionListener((ActionListener) this);
        a33.addActionListener((ActionListener) this);
        a34.addActionListener((ActionListener) this);
        a35.addActionListener((ActionListener) this);
        a36.addActionListener((ActionListener) this);
        a37.addActionListener((ActionListener) this);
        a38.addActionListener((ActionListener) this);
        a39.addActionListener((ActionListener) this);
        a40.addActionListener((ActionListener) this);
        a41.addActionListener((ActionListener) this);
        a42.addActionListener((ActionListener) this);
        a43.addActionListener((ActionListener) this);
        a44.addActionListener((ActionListener) this);
        a45.addActionListener((ActionListener) this);
        a46.addActionListener((ActionListener) this);
        a47.addActionListener((ActionListener) this);
        a48.addActionListener((ActionListener) this);
        a49.addActionListener((ActionListener) this);
        a50.addActionListener((ActionListener) this);
        a51.addActionListener((ActionListener) this);
        a52.addActionListener((ActionListener) this);
        //Ac room

        v1.addActionListener((ActionListener) this);
        v2.addActionListener((ActionListener) this);
        v3.addActionListener((ActionListener) this);
        v4.addActionListener((ActionListener) this);
        v5.addActionListener((ActionListener) this);
        v6.addActionListener((ActionListener) this);
        v7.addActionListener((ActionListener) this);
        v8.addActionListener((ActionListener) this);
        v9.addActionListener((ActionListener) this);
        v10.addActionListener((ActionListener) this);
        v11.addActionListener((ActionListener) this);
        v12.addActionListener((ActionListener) this);
        v13.addActionListener((ActionListener) this);
        v66.addActionListener((ActionListener) this);
        v67.addActionListener((ActionListener) this);
        v68.addActionListener((ActionListener) this);
        v69.addActionListener((ActionListener) this);
        v70.addActionListener((ActionListener) this);
        v71.addActionListener((ActionListener) this);
        v72.addActionListener((ActionListener) this);
        v73.addActionListener((ActionListener) this);
        v74.addActionListener((ActionListener) this);
        v75.addActionListener((ActionListener) this);
        v77.addActionListener((ActionListener) this);
        v78.addActionListener((ActionListener) this);
        v79.addActionListener((ActionListener) this);
                            /*v80.addActionListener((ActionListener) this);
                             .addActionListener((ActionListener) this);
                             .addActionListener((ActionListener) this);
                             .addActionListener((ActionListener) this);
                              .addActionListener((ActionListener) this);


                             .addActionListener((ActionListener) this);*/



    }
    void seat_color(){
        if(array[1]==1){
            a1.setBackground(Color.BLUE);
        }
        if(array[2]==1){
            a2.setBackground(Color.BLUE);
        }
        if(array[3]==1){
            a3.setBackground(Color.BLUE);
        }
        if(array[4]==1){
            a4.setBackground(Color.BLUE);
        }
        if(array[5]==1){
            a5.setBackground(Color.BLUE);
        }
        if(array[6]==1){
            a6.setBackground(Color.BLUE);
        }
        if(array[7]==1){
            a7.setBackground(Color.BLUE);
        }
        if(array[8]==1){
            a8.setBackground(Color.BLUE);
        }
        if(array[9]==1){
            a9.setBackground(Color.BLUE);
        }
        if(array[10]==1){
            a10.setBackground(Color.BLUE);
        }
        if(array[11]==1){
            a11.setBackground(Color.BLUE);
        }
        if(array[12]==1){
            a12.setBackground(Color.BLUE);
        }
        if(array[13]==1){
            a13.setBackground(Color.BLUE);
        }
        if(array[14]==1){
            a14.setBackground(Color.BLUE);
        }
        if(array[15]==1){
            a15.setBackground(Color.BLUE);
        }
        if(array[16]==1){
            a16.setBackground(Color.BLUE);
        }
        if(array[17]==1){
            a17.setBackground(Color.BLUE);
        }
        if(array[18]==1){
            a18.setBackground(Color.BLUE);
        }
        if(array[19]==1){
            a19.setBackground(Color.BLUE);
        }
        if(array[20]==1){
            a20.setBackground(Color.BLUE);
        }
        if(array[21]==1){
            a21.setBackground(Color.BLUE);
        }
        if(array[22]==1){
            a22.setBackground(Color.BLUE);
        }
        if(array[23]==1){
            a23.setBackground(Color.BLUE);
        }
        if(array[24]==1){
            a24.setBackground(Color.BLUE);
        }
        if(array[25]==1){
            a25.setBackground(Color.BLUE);
        }
        if(array[26]==1){
            a26.setBackground(Color.BLUE);
        }
        if(array[27]==1){
            a27.setBackground(Color.BLUE);
        }
        if(array[28]==1){
            a28.setBackground(Color.BLUE);
        }
        if(array[29]==1){
            a29.setBackground(Color.BLUE);
        }
        if(array[30]==1){
            a30.setBackground(Color.BLUE);
        }
        if(array[31]==1){
            a31.setBackground(Color.BLUE);
        }
        if(array[32]==1){
            a32.setBackground(Color.BLUE);
        }
        if(array[33]==1){
            a29.setBackground(Color.BLUE);
        }
        if(array[34]==1){
            a29.setBackground(Color.BLUE);
        }
        if(array[35]==1){
            a35.setBackground(Color.BLUE);
        }
        if(array[36]==1){
            a36.setBackground(Color.BLUE);
        }
        if(array[37]==1){
            a37.setBackground(Color.BLUE);
        }
        if(array[38]==1){
            a38.setBackground(Color.BLUE);
        }
        if(array[39]==1){
            a39.setBackground(Color.BLUE);
        }
        if(array[40]==1){
            a40.setBackground(Color.BLUE);
        }
        if(array[41]==1){
            a41.setBackground(Color.BLUE);
        }
        if(array[42]==1){
            a42.setBackground(Color.BLUE);
        }
        if(array[43]==1){
            a43.setBackground(Color.BLUE);
        }
        if(array[44]==1){
            a44.setBackground(Color.BLUE);
        }
        if(array[45]==1){
            a45.setBackground(Color.BLUE);
        }
        if(array[46]==1){
            a46.setBackground(Color.BLUE);
        }
        if(array[47]==1){
            a47.setBackground(Color.BLUE);
        }
        if(array[48]==1){
            a48.setBackground(Color.BLUE);
        }
        if(array[49]==1){
            a49.setBackground(Color.BLUE);
        }
        if(array[50]==1){
            a50.setBackground(Color.BLUE);
        }
        if(array[51]==1){
            a51.setBackground(Color.BLUE);
        }
        if(array[52]==1){
            a52.setBackground(Color.BLUE);
        }
        //Ac room
        if(array[53]==1){
            v1.setBackground(Color.BLUE);
        }
        if(array[54]==1){
            v2.setBackground(Color.BLUE);
        }
        if(array[55]==1){
            v3.setBackground(Color.BLUE);
        }
        if(array[56]==1){
            v4.setBackground(Color.BLUE);
        }
        if(array[57]==1){
            v5.setBackground(Color.BLUE);
        }
        if(array[58]==1){
            v6.setBackground(Color.BLUE);
        }
        if(array[59]==1){
            v7.setBackground(Color.BLUE);
        }
        if(array[60]==1){
            v8.setBackground(Color.BLUE);
        }
        if(array[61]==1){
            v9.setBackground(Color.BLUE);
        }
        if(array[62]==1){
            v10.setBackground(Color.BLUE);
        }
        if(array[63]==1){
            v11.setBackground(Color.BLUE);
        }
        if(array[64]==1){
            v12.setBackground(Color.BLUE);
        }
        if(array[65]==1){
            v13.setBackground(Color.BLUE);
        }

        if(array[66]==1){
            v13.setBackground(Color.BLUE);
        }
        if(array[67]==1){
            v66.setBackground(Color.BLUE);
        }
        if(array[68]==1){
            v68.setBackground(Color.BLUE);
        }
        if(array[69]==1){
            v69.setBackground(Color.BLUE);
        }
        if(array[70]==1){
            v70.setBackground(Color.BLUE);
        }
        if(array[71]==1){
            v71.setBackground(Color.BLUE);
        }
        if(array[72]==1){
            v72.setBackground(Color.BLUE);
        }
        if(array[73]==1){
            v73.setBackground(Color.BLUE);
        }
        if(array[74]==1){
            v74.setBackground(Color.BLUE);
        }
        if(array[75]==1){
            v75.setBackground(Color.BLUE);
        }
        if(array[77]==1){
            v77.setBackground(Color.BLUE);
        }
        if(array[78]==1){
            v78.setBackground(Color.BLUE);
        }
        if(array[79]==1){
            v79.setBackground(Color.BLUE);
        }
      /* if(array[80]==1){
           .setBackground(Color.BLUE);
       }
       if(array[81]==1){
           .setBackground(Color.BLUE);
       }
       if(array[]==1){
           .setBackground(Color.BLUE);
       }
       if(array[]==1){
           .setBackground(Color.BLUE);
       }if(array[]==1){
           .setBackground(Color.BLUE);
       }
       if(array[]==1){
           .setBackground(Color.BLUE);
       }
       if(array[]==1){
           .setBackground(Color.BLUE);
       }
       */







    }


    public static void main(String[] args) {

        Vupal_Showform ee=new Vupal_Showform();
    }

}
