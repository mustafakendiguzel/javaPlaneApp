import javax.swing.*;
import java.awt.*;


public class ui {
    public static  int syc1= 0,syc2 = 0,syc3 = 0,syc4 = 0;

    public static void main(String[] args) {
        uiVision();
    }
    public static void uiVision() {
        ImageIcon eyes = new ImageIcon("a.png");
        Globals.jf.setTitle("Deneme Uygulamasi");
        Globals.jf.setLocation(100,200);
        JLabel label1,label2,label3;
        Globals.jf.getContentPane().setLayout(new FlowLayout());
        JTextField isim = new JTextField(20);
        JTextField soyisim = new JTextField(20);
        JTextField pasaport = new JTextField(20);
        JTextField mail = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(10);
        JPasswordField passwordField2 = new JPasswordField(10);



        JButton buton1 = new JButton("Send");
        JButton buton2 = new JButton(eyes);
        JButton buton3 = new JButton(eyes);
        JButton buton4 = new JButton("!");

        label1 = new JLabel("Name:");// -8
        label2 = new JLabel("Surname:");// -9
        label3 = new JLabel("Passaport-ID:");//+ 10
        JLabel label4 = new JLabel("Mail:");// +10
        JLabel label5 = new JLabel("Password:");//+10
        JLabel label6 = new JLabel("Re-Password:");// +20

        buton1.setBounds(170,400,150,30);
        buton2.setBounds(320,190,50,30);
        buton3.setBounds(320,230,50,30);
        buton4.setBounds(370,230,50,30);

        isim.setBounds(170,30,150,30);
        soyisim.setBounds(170,70,150,30);
        pasaport.setBounds(170,110,150,30);
        mail.setBounds(170,150,150,30);
        passwordField.setBounds(170,190,150,30);
        passwordField2.setBounds(170,230,150,30);


        label1.setBounds(125,30,150,30);
        label2.setBounds(106,70,150,30);
        label3.setBounds(90,110,150,30);
        label4.setBounds(132,150,150,30);
        label5.setBounds(105,190,150,30);
        label6.setBounds(91,230,150,30);

        Globals.jf.add(buton1);Globals.jf.add(buton2);Globals.jf.add(buton3);
        Globals.jf.add(label1);Globals.jf.add(label2);Globals.jf.add(label3);Globals.jf.add(label4); Globals.jf.add(label5);Globals.jf.add(label6);
        Globals.jf.add(isim);Globals.jf.add(soyisim);Globals.jf.add(pasaport);Globals.jf.add(mail);Globals.jf.add(passwordField);Globals.jf.add(passwordField2);
        Globals.jf.setSize(1000,500);



        buton2.addActionListener(l -> {
            if ( passwordField.getEchoChar() != '\u0000' ) {
                passwordField.setEchoChar('\u0000');
            } else {
                passwordField.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            }
        });

        buton3.addActionListener(l -> {
            if ( passwordField2.getEchoChar() != '\u0000' ) {
                passwordField2.setEchoChar('\u0000');

            } else {
                passwordField2.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            }
        });
        buton1.addActionListener(e -> {
            checkEmpty(isim.getText(),label1.getText(),label1,syc1);
            checkEmpty(soyisim.getText(),label2.getText(),label2,syc2);
            checkEmpty(pasaport.getText(),label3.getText(),label3,syc3);
            checkEmpty(mail.getText(),label4.getText(),label4,syc4);
            ExitWhenLoopEnd();
            Globals.globalInt = 0;
            System.out.println(passwordField.getPassword());
            System.out.println(passwordField2.getPassword());
            Globals.clickCount++;

        });
        Globals.jf.setLayout(null);
        Globals.jf.setVisible(true);
        Globals.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void checkEmpty(String value,String label,JLabel labelname,int syc) {
        if(value != null && !value.trim().isEmpty()) {
            if(Globals.globalInt != 4) {
                Globals.globalInt++;
            }

        }
        else {
            JLabel sd = CreateEmptyMessageError(label,labelname,Globals.jf);
            if(syc == 1)
                sd.setText("");
                sd.setText("");
            syc++;
        }
        System.out.println(syc);

    }

    public static JLabel CreateEmptyMessageError(String labelError, JLabel label, JFrame jf) {
        Globals.labelx = new JLabel(labelError.split(":")[0]+" is empty!");
        Globals.labelx.setBounds(label.getBounds().x+250,label.getBounds().y,label.getWidth(),label.getHeight());
        Globals.labelx.setForeground(Color.RED);
        jf.add(Globals.labelx);
        jf.revalidate();
        jf.repaint();
        return Globals.labelx;

    }
    public class Globals {
        public static int globalInt = 0;
        public static JLabel labelx = null;
        public static JFrame jf = new JFrame();
        public static int clickCount = 0;
        public static int lastVal = 0;
        public static int syc = 0;


    }

    public static void ExitWhenLoopEnd() {
        if(Globals.globalInt == 4)  {
            System.exit(0);
        }
    }
}