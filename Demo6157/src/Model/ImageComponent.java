package Model;

import View.ImageViewJFrame6157;
import View.MainJFrame6157;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ImageComponent extends JPanel implements MouseListener {
    JLabel ImgLabel ;
    JLabel NameLabel ;
    String ImgPath;
    String ImgName;
    MainJFrame6157 mainJFrame;
    public ImageComponent(String path, String name){
            this.resize(230,230);
            this.ImgPath=path;
            this.ImgName=name;
            ImgLabel = new JLabel();
            ImageIcon icon = new ImageIcon(this.ImgPath);
            icon.setImage(icon.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
            ImgLabel.setIcon(icon);
            NameLabel = new JLabel(this.ImgName);
            this.setLayout(new BorderLayout());
            this.add(ImgLabel,BorderLayout.NORTH);
            this.add(NameLabel,BorderLayout.SOUTH);
            this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));

        //实现监听
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ImageViewJFrame6157 win = new ImageViewJFrame6157(this.ImgPath,this.ImgName);
        //mainJFrame.textArea.append("您点击了"+this.ImgName+"图片");
        win.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
