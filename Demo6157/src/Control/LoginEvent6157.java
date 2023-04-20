/**
 * 
 */
package Control;

import Model.DBUtil6157;
import View.LoginView;
import View.MainJFrame6157;
import View.RegisterView6157;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author 登录页面控制器
 *
 */
public class LoginEvent6157 implements ActionListener {
    private static LoginEvent6157 event6157;
    LoginView view;
    String iconAcount;
    String iconPassword;
    //数据库返回的字符串
    String str;
    MainJFrame6157 mainJFrame = new MainJFrame6157();
    public LoginEvent6157(LoginView loginView) {
        this.view = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("登录")){
            // loginView.dispose();
            try {
                toLogin();
            } catch (SQLException ex) {
                System.out.println("登录方法有错误");
            } catch (ClassNotFoundException ex) {
                System.out.println("登录方法有错误");
            }
        }
        if(e.getActionCommand().equals("注册")){
            view.dispose();
            toRegister();
        }

    }
    public void toRegister(){
        RegisterView6157 registerView = new RegisterView6157();
        registerView.init();
    }
    public void toLogin() throws SQLException, ClassNotFoundException {
        try {
            iconAcount = view.textAcount.getText();
            iconPassword = view.passwordField.getText();
            System.out.println("登录信息:"+iconAcount+iconPassword);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "请正确输入相应的信息");
        }
        /*
         * 调用数据库包装方法判断
         * */
        if (iconAcount.equals("")||iconPassword.equals("")){
            JOptionPane.showMessageDialog(null, "请正确输入相应的信息");
        }else {
            str = DBUtil6157.findUser(Integer.parseInt(iconAcount),iconPassword);
        }
        try {
            if(!str.equals("false")){
                //这里判断账号是否存在，不存在提示用户
                System.out.println("登录成功");
                view.dispose();
                mainJFrame.MainJFrame();
                mainJFrame.setTitle(str);
                ImagesListener6157 i = new ImagesListener6157(mainJFrame);
                i.setContex(1);
            }else {
                //加提示
                view.warningAcount.setText("账号输入有误");
                view.warningPassword.setText("密码输入有误");

            }
        }catch (Exception e){
            System.out.println("登录失败：登录信息有误");
        }
    }
}
