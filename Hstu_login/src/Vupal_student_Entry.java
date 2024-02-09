import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Vupal_student_Entry extends JFrame implements ActionListener {
    private JPanel Main;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton backButton;
    private JTextField txtstname;
    private JTextField txtstid;
    private JTextField txtsemester;
    private JTextField txtdepart;
    private JTextField txtdegree;
    private JTextField txtpass;

    private JButton a14;
    private JButton a1;
    private JButton a27;
    private JButton a40;
    private JButton a2;
    private JButton a28;
    private JButton a15;
    private JButton a41;
    private JButton a29;
    private JButton a3;
    private JButton a42;
    private JButton a16;
    private JButton a30;
    private JButton a17;
    private JButton a4;
    private JButton a43;
    private JButton a31;
    private JButton a44;
    private JButton a5;
    private JButton a18;
    private JButton a45;
    private JButton a6;
    private JButton a32;
    private JButton a19;
    private JButton a20;
    private JButton a33;
    private JButton a46;
    private JButton a7;
    private JButton a34;
    private JButton a21;
    private JButton a8;
    private JButton a47;
    private JButton a48;
    private JButton a35;
    private JButton a9;
    private JButton a22;
    private JButton a10;
    private JButton a36;
    private JButton a23;
    private JButton a49;
    private JButton a24;
    private JButton a11;
    private JButton a50;
    private JButton a37;
    private JButton a51;
    private JButton a25;
    private JButton a12;
    private JButton a38;
    private JButton a52;
    private JButton a13;
    private JButton a39;
    private JButton a26;
    private JTextField txtseatno;
    private JTextField txtcnpass;
    private JTextField txtlevel;
    private JButton clear;
    private JButton v1;
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
    private JButton Search;
    private JButton bookedSeatsButton;
    public int Seat_no=0;
    public int[] array=new int[1000];
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
    String formattedTime = currentTime.format(formatter);
    String ddate = String.valueOf(java.time.LocalDate.now());

    Connection connection;
    PreparedStatement pnt;
    Statement statement;
    public Vupal_student_Entry(){

        setContentPane(Main);

        setSize(1220, 800);
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
        Button_work();
        //txtseatno.setText(String.valueOf(Seat_no));


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int a=check();
               if(a==0){
                   JFrame f=new JFrame();
                   JOptionPane.showMessageDialog(f,"Please check Your information");
                   return;
               }
                 save();

            }
            });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                dispose();
                Vupal_Entering_Outside aa=new Vupal_Entering_Outside();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtstname.setText(" ");
                txtseatno.setText(" ");
                txtcnpass.setText(" ");
                txtcnpass.setText(" ");
                txtlevel.setText(" ");
                txtdepart.setText(" ");
                txtsemester.setText(" ");
                txtstid.setText(" ");
                txtdegree.setText(" ");
                txtpass.setText(" ");
                txtstname.requestFocus();

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JDBC_Connection ob=new JDBC_Connection();
                Connection connection=ob.getConnection();
                String id=txtstid.getText();
                try {
                    PreparedStatement prep=connection.prepareStatement("select Name,Level,Semester,Department,Degree from Registerform where ID=?");

                    prep.setString(1,id);
                    ResultSet resultSet=prep.executeQuery();
                    if(resultSet.next()==true){
                        String name=resultSet.getString(1);
                        String level=resultSet.getString(2);
                        String semester=resultSet.getString(3);
                        String depart=resultSet.getString(4);
                        String degree=resultSet.getString(5);
                       // System.out.println(name);
                        txtstid.setText(id);
                        txtstname.setText(name);
                        txtlevel.setText(level);
                        txtsemester.setText(semester);
                        txtdepart.setText(depart);
                        txtdegree.setText(degree);

                    }



                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

    public int check(){
       JDBC_Connection ob=new JDBC_Connection();
        Connection connection=ob.getConnection();



        try {
            Statement statement=connection.createStatement();


            String sql="select Id,Password from  RegisterForm ";
            ResultSet resultSet=statement.executeQuery(sql);
            String id=txtstid.getText();
            String pass=txtpass.getText();
            int ans=0,b=0;
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
            String query="select id from st_en_form";
            ResultSet resultSet1=statement.executeQuery(query);
            while (resultSet1.next()){
                String i=resultSet1.getString("id");
                if(i.equals(id)){
                    b=1;
                    break;
                }
            }
            if(ans==1 && b==0){
                return 1;

            }
            else{
                //JOptionPane.showMessageDialog(this, "Check your Information", "Alert", JOptionPane.WARNING_MESSAGE);
              return 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



   private void save(){



          String student_name=txtstname.getText();
          String student_id=txtstid.getText();
          String Level=txtlevel.getText();
          String ssemester=txtsemester.getText();
          String ddepart=txtdepart.getText();
          String ddegree=txtdegree.getText();
          String ppass=txtpass.getText();
          String ccon_pass=txtcnpass.getText();
          String seatnno=txtseatno.getText();
          if(student_name.isEmpty() || student_id.isEmpty()|| Level.isEmpty() || ssemester.isEmpty() || ddepart.isEmpty() || ddegree.isEmpty() || ppass.isEmpty() || ccon_pass.isEmpty() ||
           seatnno.isEmpty()) {

              JOptionPane.showMessageDialog(this, "Please fill all the information!", "Alert", JOptionPane.WARNING_MESSAGE);

          }
          if(!ppass.equals(ccon_pass)){

              JOptionPane.showMessageDialog(this, "Correct password!", "Alert", JOptionPane.WARNING_MESSAGE);


          }
          else{


            try {
                String url = "jdbc:mysql://localhost:3306/student";
                String username = "root";
                String password = "password";
                Connection con = DriverManager.getConnection(url, username, password);
                //Connection con = DriverManager.getConnection(url, username, password);
                Statement stat = con.createStatement();
                //String sql="insert into st_en_form(seat_no)"+"VALUES(?)";
                String sql = "insert into st_en_form(id,name,level,semester,depart,degree,pass,con_pass,seat_no,Date,Time) " +
                        "values('" + student_id + "','" + student_name + "','" + Level + "','" + ssemester + "','" + ddepart + "'," + "'" + ddegree + "','" + ppass + "'," +
                        "'" + ccon_pass + "','" + seatnno + "','" + ddate + "','" + formattedTime + "')";
                String query = "insert into library_form(id,name,level,semester,depart,degree,pass,con_pass,seat_no,Date,Time) " +
                        "values('" + student_id + "','" + student_name + "','" + Level + "','" + ssemester + "','" + ddepart + "','" +
                        ddegree + "','" + ppass + "','" + ccon_pass + "','" + seatnno + "','" + ddate + "','" + formattedTime + "')";
                int rowaffacted = stat.executeUpdate(sql);
                int rowaffacted1=stat.executeUpdate(query);

                JOptionPane.showMessageDialog(this, "Successfully register", "Alert", JOptionPane.WARNING_MESSAGE);
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select seat_no from st_en_form");
                while (resultSet.next()) {
                    int seat = resultSet.getInt("seat_no");
                   // System.out.println(seat);
                    array[seat] = 1;
                    //System.out.println(seat);
                }

                seat_color();
                txtstname.setText(" ");
                txtseatno.setText(" ");
                txtcnpass.setText(" ");
                txtcnpass.setText(" ");
                txtlevel.setText(" ");
                txtdepart.setText(" ");
                txtsemester.setText(" ");
                txtstid.setText(" ");
                txtdegree.setText(" ");
                txtpass.setText(" ");
                txtstname.requestFocus();
                con.close();
                statement.close();
                dispose();
                //Entering_Outside aa=new Entering_Outside();
                new Vupal_Entering_Outside();

            } catch (SQLException e) {
               // throw new RuntimeException(e);
                e.printStackTrace();
            }


        }

    }
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
            }
            //connection.close();
           // statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
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

        Vupal_student_Entry studentEntering=new Vupal_student_Entry();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==a1 && array[1]==0){

            //a1.setBackground(Color.BLUE);
            txtseatno.setText(String.valueOf(1));

        }
        else if (e.getSource()==a2 && array[2]==0) {
            txtseatno.setText(String.valueOf(2));
        }
        else if (e.getSource()==a3 && array[3]==0) {
            txtseatno.setText(String.valueOf(3));

        }
        else if (e.getSource()==a4 && array[4]==0) {

            txtseatno.setText(String.valueOf(4));

        }
        else if (e.getSource()==a5 && array[5]==0) {
            txtseatno.setText(String.valueOf(5));

        }
        else if (e.getSource()==a6 && array[6]==0) {
            txtseatno.setText(String.valueOf(6));
        }
        else if (e.getSource()==a7 && array[7]==0) {
            txtseatno.setText(String.valueOf(7));

        }
        else if (e.getSource()==a8 && array[8]==0) {
            txtseatno.setText(String.valueOf(8));

        }
        else if (e.getSource()==a9 && array[9]==0) {
            txtseatno.setText(String.valueOf(9));
        }
        else if (e.getSource()==a10 && array[10]==0) {
            txtseatno.setText(String.valueOf(10));

        }


        else if(e.getSource()==a11 && array[11]==0){

            //a1.setBackground(Color.BLUE);
            txtseatno.setText(String.valueOf(11));

        }
        else if (e.getSource()==a12 && array[12]==0) {
            txtseatno.setText(String.valueOf(12));
        }
        else if (e.getSource()==a13 && array[13]==0) {
            txtseatno.setText(String.valueOf(13));

        }
        else if (e.getSource()==a14 && array[14]==0) {

            txtseatno.setText(String.valueOf(14));

        }
        else if (e.getSource()==a15 && array[15]==0) {
            txtseatno.setText(String.valueOf(15));

        }
        else if (e.getSource()==a16 && array[16]==0) {
            txtseatno.setText(String.valueOf(16));
        }
        else if (e.getSource()==a17 && array[17]==0) {
            txtseatno.setText(String.valueOf(17));

        }
        else if (e.getSource()==a18 && array[18]==0) {
            txtseatno.setText(String.valueOf(18));

        }
        else if (e.getSource()==a19 && array[19]==0) {
            txtseatno.setText(String.valueOf(19));
        }
        else if (e.getSource()==a20 && array[20]==0) {
            txtseatno.setText(String.valueOf(20));
        }
        else if (e.getSource()==a21 && array[21]==0) {
            txtseatno.setText(String.valueOf(21));
        }
        else if (e.getSource()==a22 && array[22]==0) {
            txtseatno.setText(String.valueOf(22));
        }
        else if (e.getSource()==a23 && array[23]==0) {
            txtseatno.setText(String.valueOf(23));
        }
        else if (e.getSource()==a24 && array[24]==0) {
            txtseatno.setText(String.valueOf(24));
        }
        else if (e.getSource()==a25 && array[25]==0) {
            txtseatno.setText(String.valueOf(25));
        }
        else if (e.getSource()==a26 && array[26]==0) {
            txtseatno.setText(String.valueOf(26));
        }
        else if (e.getSource()==a27 && array[27]==0) {
            txtseatno.setText(String.valueOf(27));
        }else if (e.getSource()==a28 && array[28]==0) {
            txtseatno.setText(String.valueOf(28));
        }else if (e.getSource()==a29 && array[29]==0) {
            txtseatno.setText(String.valueOf(29));
        }
        else if (e.getSource()==a30 && array[30]==0) {
            txtseatno.setText(String.valueOf(30));
        }
        else if (e.getSource()==a31 && array[31]==0) {
            txtseatno.setText(String.valueOf(31));
        }
        else if (e.getSource()==a32 && array[32]==0) {
            txtseatno.setText(String.valueOf(32));
        }
        //Ac room
        else if (e.getSource()==v1 && array[53]==0) {
            txtseatno.setText(String.valueOf(53));
        }
        else if (e.getSource()==v2 && array[54]==0) {
            txtseatno.setText(String.valueOf(54));
        }
        else if (e.getSource()==v3 && array[55]==0) {
            txtseatno.setText(String.valueOf(55));
        }
        else if (e.getSource()==v4 && array[56]==0) {
            txtseatno.setText(String.valueOf(56));
        }
        else if (e.getSource()==v5 && array[57]==0) {
            txtseatno.setText(String.valueOf(57));
        }
        else if (e.getSource()==v6 && array[58]==0) {
            txtseatno.setText(String.valueOf(58));
        }
        else if (e.getSource()==v7 && array[59]==0) {
            txtseatno.setText(String.valueOf(59));
        }
        else if (e.getSource()==v8 && array[60]==0) {
            txtseatno.setText(String.valueOf(60));
        }
        else if (e.getSource()==v9 && array[61]==0) {
            txtseatno.setText(String.valueOf(61));
        }
        else if (e.getSource()==v10 && array[62]==0) {
            txtseatno.setText(String.valueOf(62));
        }
        else if (e.getSource()==v11 && array[63]==0) {
            txtseatno.setText(String.valueOf(63));
        }
        else if (e.getSource()==v12 && array[64]==0) {
            txtseatno.setText(String.valueOf(64));
        }
        else if (e.getSource()==v13 && array[65]==0) {
            txtseatno.setText(String.valueOf(65));
        }

        else if (e.getSource()==v66 && array[66]==0) {
            txtseatno.setText(String.valueOf(66));
        }
        else if (e.getSource()==v67 && array[67]==0) {
            txtseatno.setText(String.valueOf(67));
        }
        else if (e.getSource()==v68 && array[68]==0) {
            txtseatno.setText(String.valueOf(68));
        }
        else if (e.getSource()==v69 && array[69]==0) {
            txtseatno.setText(String.valueOf(69));
        }
        else if (e.getSource()==v70 && array[70]==0) {
            txtseatno.setText(String.valueOf(70));
        }
        else if (e.getSource()==v71 && array[71]==0) {
            txtseatno.setText(String.valueOf(71));
        }
        else if (e.getSource()==v72 && array[72]==0) {
            txtseatno.setText(String.valueOf(72));
        }
        else if (e.getSource()==v73 && array[73]==0) {
            txtseatno.setText(String.valueOf(73));
        }
        else if (e.getSource()==v74 && array[74]==0) {
            txtseatno.setText(String.valueOf(74));
        }
        else if (e.getSource()==v75 && array[75]==0) {
            txtseatno.setText(String.valueOf(75));
        }

        else if (e.getSource()==v77 && array[77]==0) {
            txtseatno.setText(String.valueOf(77));
        }else if (e.getSource()==v78 && array[78]==0) {
            txtseatno.setText(String.valueOf(78));
        }
        else if (e.getSource()==v79 && array[79]==0) {
            txtseatno.setText(String.valueOf(79));
        }





    }
}
