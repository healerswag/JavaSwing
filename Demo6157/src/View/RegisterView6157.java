package View;

import Control.ExitJMenuItemLister6157;
import Control.RegisterEvent6157;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterView6157 extends JFrame{
	//定义布局
	FlowLayout layout;//定义一个布局
	//定义窗口的高度和宽度
	final int WIDTH=410;//设置顶层框架的宽度
	final int HEIGHT=460;//设置顶层框架的高度
	//定义箱子
	javax.swing.JPanel jpanel_1;//放图片和其他的盘子
	javax.swing.JPanel jpanel_2;//只是放标题
	javax.swing.JPanel jpanel_3;//只是放标题
	
	//定义监听
	ActionListener lintener_1;//账号文本框 的监听

	//定义按钮和标签
	JLabel bgimg;//定义背景  标签
	JLabel title;//定义标题   标签
	JLabel name;//定义名字标签
	public  JTextField nametext;//定义名文本框
	
	
	JLabel account;//定义账号标题
	public  JTextField accounttext;//定义账号输入文本
	
	
	JLabel password;//定义密码标签
	public  JPasswordField passwordtext;//定义密码文本框

	
	JLabel okpassword;//定义确认
	public  JPasswordField okpasswordtext;//定义确认密码文本框
	
	
	public  JButton reg;//注册按钮
	public  JButton ext;
	
	public void init() {

		layout =new FlowLayout(FlowLayout.CENTER);//定义布局  居中
		
		//先设置窗口显示的位置和大小
		Toolkit kit =Toolkit.getDefaultToolkit();//对象大小 设置窗口位置
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;//获取屏幕高度和宽度
		int height=screenSize.height;
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		this.setBounds(x, y,WIDTH,HEIGHT);
		jpanel_1=new javax.swing.JPanel();
		jpanel_1.setPreferredSize(new Dimension (WIDTH,HEIGHT));
		jpanel_1.setLayout(null);//设置布局
		jpanel_1.setOpaque(false);
		ImageIcon img=new ImageIcon("Images\\3.jpeg");//图片读取
		bgimg=new JLabel(img);
		Image img1=img.getImage();
        img1=img1.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);//调整图片大小
        img.setImage(img1);//将改变后的图片重新附给img
		bgimg.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//设置背景图片 设置背景位置
		
		title=new JLabel("账号注册");
		title.setFont(new Font("宋体",Font.PLAIN,24));
		title.setForeground(Color.blue);
		//对箱子二的内容进行初始化
		jpanel_2=new javax.swing.JPanel();
		jpanel_2.setBounds(0, 0, 10, 10);
		jpanel_2.setOpaque(false);//将当前的盘子设置成透明
		jpanel_2.setLayout(layout);
		//初始化第三箱子
		jpanel_3=new javax.swing.JPanel();
		jpanel_3.setBounds(20, 30,360,360);
		jpanel_3.setOpaque(false);//将当前的盘子设置成透明
		jpanel_3.setLayout(layout);//设置布局
		//第一行数据进行初始化
		name =new JLabel("姓        名:");
		name.setFont(new Font("宋体",Font.PLAIN,24));
		nametext=new JTextField(20);
		name.setForeground(Color.black);
		nametext.setForeground(new Color(0,225,0));
		nametext.setPreferredSize(new Dimension(15,28));
		nametext.setFont(new Font("宋体",Font.PLAIN,24));
	

		
		
		//第二行
		account =new JLabel("账        号:");
		account.setFont(new Font("宋体",Font.PLAIN,24));
		accounttext=new JTextField(20);
		account.setForeground(Color.black);
		accounttext.setForeground(new Color(0,225,0));
		accounttext.setPreferredSize(new Dimension(15,28));
		accounttext.setFont(new Font("宋体",Font.PLAIN,24));
			
	
		
		//第三行
		password =new JLabel("密        码:");
		password.setFont(new Font("宋体",Font.PLAIN,24));
		passwordtext=new JPasswordField(20);
		password.setForeground(Color.black);
		passwordtext.setForeground(new Color(0,225,0));
		passwordtext.setPreferredSize(new Dimension(15,28));
		passwordtext.setFont(new Font("宋体",Font.PLAIN,24));
		//第四行
		
		okpassword =new JLabel("确认密码:");
		okpassword.setFont(new Font("宋体",Font.PLAIN,24));
		okpasswordtext=new JPasswordField(20);
		okpassword.setForeground(Color.black);
		okpasswordtext.setForeground(new Color(0,225,0));
		okpasswordtext.setPreferredSize(new Dimension(15,28));
		okpasswordtext.setFont(new Font("宋体",Font.PLAIN,24));
	
		//第五行
		reg=new JButton("注册");
		reg.setPreferredSize(new Dimension(150,50));
		reg.setFont(new Font("宋体",Font.PLAIN,24));
		reg.setForeground(Color.black);

		ext = new JButton("返回");
		ext.setPreferredSize(new Dimension(150,50));
		ext.setFont(new Font("宋体",Font.PLAIN,24));
		ext.setForeground(Color.red);

		// 添加注册监听
		RegisterEvent6157 registerEvent = new RegisterEvent6157(this);
		reg.addActionListener(registerEvent);
		ext.addActionListener(new ExitJMenuItemLister6157(this));
	
		//第一行
		jpanel_3.add(name);
		jpanel_3.add(nametext);

		//第二行
		jpanel_3.add(account);
		jpanel_3.add(accounttext);

		//第三行
		jpanel_3.add(password);
		jpanel_3.add(passwordtext);

		//第四行
		jpanel_3.add(okpassword);
		jpanel_3.add(okpasswordtext);
	
		//最后一行
		jpanel_3.add(reg);
		jpanel_3.add(ext);
		// jpanel_2.add(new ImageComponent(), BorderLayout.NORTH);
		
		jpanel_3.setBorder(BorderFactory.createTitledBorder(""));
		
		jpanel_1.add(jpanel_3);
		jpanel_1.add(jpanel_2);
		jpanel_1.add(bgimg);
		this.add(jpanel_1);//将箱子1添加到最低层  

		setAllTag();

		setVisible(true); //设置当前窗口是否可显示
		setResizable(false);//窗口的大小不可边
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置默认关闭方式
		validate();//让组件生效


	}
	
	void setAllTag() {

		nametext.setName("nametext");//姓名
		accounttext.setName("accounttext");//账号
		passwordtext.setName("passwordtext");//定义密码文本框
		okpasswordtext.setName("okpasswordtext");//定义确认密码文本框
		reg.setName("reg");
		this.setTitle("账号注册");
		
	}
	public static void main(String[] args) {
		RegisterView6157 registerView = new RegisterView6157();
		registerView.init();
	}
}
