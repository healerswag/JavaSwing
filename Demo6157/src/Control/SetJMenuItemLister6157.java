package Control;

import View.MainJFrame6157;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SetJMenuItemLister6157 implements ActionListener {
    MainJFrame6157 JFrame;
    String filePathName;
    public SetJMenuItemLister6157(MainJFrame6157 jFrame6157) {
        this.JFrame = jFrame6157;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //会弹窗出来
        int retValue =  chooser.showSaveDialog(null);
        if(retValue == 1){
            //表示弹窗按了取消
        }
        if(retValue == 0 ){
            File path = chooser.getSelectedFile();//获取你选择的文件夹的对象
            filePathName = path.toString();
            JFrame.textArea.append(filePathName);
        }
    }
}
