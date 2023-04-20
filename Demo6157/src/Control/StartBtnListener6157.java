package Control;

import Model.CSpider6157;
import View.MainJFrame6157;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class StartBtnListener6157 implements ActionListener {
    MainJFrame6157 jFrame6157;

    public StartBtnListener6157(MainJFrame6157 jFrame6157) {
        this.jFrame6157 = jFrame6157;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("启动")){
            try {
                // 获取用户填写的url
                URL url = new URL(jFrame6157.jTextField.getText());
                // 用户在设置中选择的保存路径
                String path = jFrame6157.textArea.getText();
                // 创建一个File对象
                File file = new File(path);
                //获取用户昵称，来加载目录
                String str = jFrame6157.getTitle();
                // 判断是否存在该目录
                if(!file.isDirectory()){
                    // 不存在则使用默认路径
                    path = "Images";
                }
                // 先有一个爬虫对象
                CSpider6157 spider = new CSpider6157(url.toString(),path,str);
                // 调用爬虫对象的方法
                spider.start(jFrame6157);
                ImagesListener6157 imagesListener = new ImagesListener6157(jFrame6157);
                imagesListener.setContex(1);
            } catch (IOException ex) {
                System.out.println("图片爬取失败");
            }
            JOptionPane.showMessageDialog(null, "图片爬取成功！");
        }
    }
}
