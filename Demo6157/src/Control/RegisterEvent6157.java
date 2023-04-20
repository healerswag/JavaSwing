/**
 * 
 */
package Control;

import Model.DBUtil6157;
import View.LoginView;
import View.RegisterView6157;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author 注册页面控制器
 *
 */
public class RegisterEvent6157 implements ActionListener {
    RegisterView6157 view6157;
    String name ;
    int account;
    String password;
    String rePassword;
    String userName = "";

    public RegisterEvent6157(RegisterView6157 registerView) {
        this.view6157 = registerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        toRegister();
    }
    public void toRegister(){
        try {
            // 空数据异常
            name = view6157.nametext.getText();
            account = Integer.parseInt(view6157.accounttext.getText());
            password = view6157.passwordtext.getText();
            rePassword = view6157.okpasswordtext.getText();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "添加用户失败！请注意格式：账号只能用数字");
        }
        System.out.println(name+account+password+rePassword);
        //确认数据库里面有没有此用户
        try {
            userName = DBUtil6157.findUser(account,password);
            if (!userName.equals("false")){
                JOptionPane.showMessageDialog(null, "添加用户失败！该用户账号已存在");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (password.equals(rePassword)){
            // 两次密码相同，可以存数据
            try {
                if (DBUtil6157.addUser(account,name,password)){
                    JOptionPane.showMessageDialog(null, "添加用户信息成功！");
                }
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "添加用户信息失败");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "添加用户信息失败");
            }
        }else{
            JOptionPane.showMessageDialog(null, "确认密码错误，请重新输入");
        }
        // 以上数据存入数据库
        // 存储成功 跳转到Login界面
        //点击注册按钮
            view6157.dispose();
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
    }
}
