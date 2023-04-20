package View;

import Control.LoginEvent6157;

import javax.swing.*;

import java.awt.*;



public class LoginView extends JFrame{
    private static LoginView view;
    public static JPasswordField passwordField;
    public static JTextField textAcount;
    public JLabel warningAcount;
    public JLabel warningPassword;
    public JFrame f = new JFrame("用户登录");

    // public static void create(){
    //     if (loginView==null){
    //         loginView = new LoginView();
    //         loginView.Start();
    //     }else {
    //         loginView.Start();
    //     }
    // }

    public LoginView(){
        this.setTitle("用户登录");
        //设置框架图标
        Image img = new ImageIcon("Images\\1.png").getImage();
        this.setIconImage(img);

        //禁止调整窗口大小
        this.setResizable(false);

        this.setSize(540,480);
        this.setLocation(550,270);


        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,8,15));


        JLabel iconAcount = new JLabel("账号：");
        iconAcount.setFont(new Font("宋体",Font.PLAIN,28));
        centerPanel.add(iconAcount);

        textAcount = new JTextField(24);
        textAcount.setFont(new Font("宋体",Font.PLAIN,28));
        warningAcount = new JLabel("请输入账号");
        centerPanel.add(textAcount);
        centerPanel.add(warningAcount);

        JLabel iconPassword = new JLabel("密码：");
        iconPassword.setFont(new Font("宋体",Font.PLAIN,28));
        centerPanel.add(iconPassword);


        passwordField = new JPasswordField(24);
        passwordField.setFont(new Font("宋体",Font.PLAIN,28));

        warningPassword = new JLabel("请输入密码");
        centerPanel.add(passwordField);
        centerPanel.add(warningPassword);

        centerPanel.setBackground(Color.MAGENTA);
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,30,20));



        bottomPanel.setBackground(Color.MAGENTA);
        JButton btnLogin = new JButton("登录");
        btnLogin.setFont(new Font("宋体",Font.PLAIN,24));
        btnLogin.setBackground(Color.MAGENTA);
        JButton btnRegister = new JButton("注册");
        btnRegister.setFont(new Font("宋体",Font.PLAIN,24));
        btnRegister.setBackground(Color.MAGENTA);
        btnRegister.setSize(12,12);

        bottomPanel.add(btnLogin);
        bottomPanel.add(btnRegister);

        this.add(new ImageComponent(), BorderLayout.NORTH);

        this.add(centerPanel,BorderLayout.CENTER);
        this.add(bottomPanel,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建登录及注册监听
        LoginEvent6157 loginEvent = new LoginEvent6157(this);
        btnLogin.addActionListener(loginEvent);
        btnRegister.addActionListener(loginEvent);
    }

}