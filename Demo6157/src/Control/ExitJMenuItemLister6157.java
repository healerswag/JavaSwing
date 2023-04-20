package Control;

import View.LoginView;
import View.MainJFrame6157;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitJMenuItemLister6157 implements ActionListener {
    MainJFrame6157 mainJFrame;
    JFrame jFrame;
    public ExitJMenuItemLister6157(MainJFrame6157 mainJFrame) {
        this.mainJFrame = mainJFrame;
    }

    public ExitJMenuItemLister6157(JFrame jFrame){
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("退出")){
            // 销毁该界面
            mainJFrame.dispose();
            // 进入一个新的界面
            LoginView view = new LoginView();
            view.setVisible(true);
        }
        if (e.getActionCommand().equals("返回")){
            jFrame.dispose();
            LoginView view = new LoginView();
            view.setVisible(true);
        }
    }
}
