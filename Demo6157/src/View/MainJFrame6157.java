package View;


import Control.ExitJMenuItemLister6157;
import Control.ImagesListener6157;
import Control.SetJMenuItemLister6157;
import Control.StartBtnListener6157;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainJFrame6157 extends JFrame{
    //作者信息
    String creator = "211906157陈茜乐";
    public JPanel centerCenterJPanel;
    public JLabel curPageLabel;
    private static String filePathName ;
    public TextArea textArea ;
    public JPanel topJPanel;
    public JLabel urlLabel;
    public JTextField jTextField;
    public JButton startBtn;
    public JLabel timeLabel;
    public void  MainJFrame() {
        Toolkit kit =Toolkit.getDefaultToolkit();//对象大小 设置窗口位置
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width;//获取屏幕高度和宽度
        int height=screenSize.height;
        int x=(width-800)/2;
        int y=(height-600)/2;
        this.setBounds(x, y,WIDTH,HEIGHT);
        this.resize(800, 600);
        //创建菜单栏/条
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单
        JMenu fileMenu = new JMenu("文件");
        JMenu aboutMenu = new JMenu("关于");
        JMenu aboutUser = new JMenu("作者信息："+creator);
        jMenuBar.add(fileMenu);
        jMenuBar.add(aboutMenu);
        jMenuBar.add(aboutUser);

        JMenuItem setJMenuItem = new JMenuItem("设置");
        JMenuItem exitJMenuItem = new JMenuItem("退出");
        fileMenu.add(setJMenuItem);
        fileMenu.add(exitJMenuItem);
        this.setJMenuBar(jMenuBar);
        // 为设置功能添加监听
        SetJMenuItemLister6157 setJMenuItemLister = new SetJMenuItemLister6157(this);
        setJMenuItem.addActionListener(setJMenuItemLister);
        // 为退出功能添加监听
        ExitJMenuItemLister6157 exitJMenuItemLister = new ExitJMenuItemLister6157(this);
        exitJMenuItem.addActionListener(exitJMenuItemLister);
        //布局管理器 Layout
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        //顶部的JPanel
        topJPanel = new JPanel();
        topJPanel.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        this.add(topJPanel,BorderLayout.NORTH);
        urlLabel = new JLabel("URL:");
        topJPanel.add(urlLabel);

        jTextField = new JTextField(20);
        topJPanel.add(jTextField);

        startBtn = new JButton("启动");
        topJPanel.add(startBtn);
        //创建一个监听窗口
        StartBtnListener6157 startBtnListener = new StartBtnListener6157(this);
        startBtn.addActionListener(startBtnListener);
        //实现时间的动态变化
        timeLabel = new JLabel("2022-03-01 11:22:33");
        topJPanel.add(timeLabel);
        Timer timerAction = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                long timeMillis = System.currentTimeMillis();
                //定义时间的格式
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //System.out.println(df.format(new Date(timeMillis)));
                timeLabel.setText(df.format(new Date(timeMillis)));
            }
        });
        timerAction.start();

        //中间的JPanel
        JPanel centerJPanel = new JPanel();
        centerJPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        this.add(centerJPanel,BorderLayout.CENTER);
        //为中间设置一个布局管理器
        BorderLayout centerLayout = new BorderLayout();
        centerJPanel.setLayout(centerLayout);
        //设置3个JPanel
        JPanel centerTopJPanel = new JPanel();
        centerCenterJPanel = new JPanel();
        JPanel centerBottomJPanel = new JPanel();

        centerTopJPanel.setBorder(BorderFactory.createLineBorder(Color.orange,3));
        centerCenterJPanel.setBorder(BorderFactory.createLineBorder(Color.pink,3));
        centerBottomJPanel.setBorder(BorderFactory.createLineBorder(Color.pink,3));
        centerJPanel.add(centerTopJPanel,BorderLayout.NORTH);
        centerJPanel.add(centerCenterJPanel,BorderLayout.CENTER);
        centerJPanel.add(centerBottomJPanel,BorderLayout.SOUTH);

        JButton preBtn = new JButton("上一页");
        centerBottomJPanel.add(preBtn);

        curPageLabel = new JLabel();
        centerBottomJPanel.add(curPageLabel);
        JButton nextBtn = new JButton("下一页");
        centerBottomJPanel.add(nextBtn);

        textArea = new TextArea("",5,40);
        //创建一个窗口监听对象
        ImagesListener6157 mainJFrameListener  = new ImagesListener6157(this);

        preBtn.addActionListener(mainJFrameListener);
        nextBtn.addActionListener(mainJFrameListener);

        //底部的JPanel
        JPanel bottomJPanel = new JPanel();
        bottomJPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        this.add(bottomJPanel,BorderLayout.SOUTH);
        JLabel urlLabel1 = new JLabel("日志信息");
        bottomJPanel.add(urlLabel1);

        bottomJPanel.add(textArea);

        this.setVisible(true);
    }
}
