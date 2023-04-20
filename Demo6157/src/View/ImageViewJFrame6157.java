package View;

import javax.swing.*;

public class ImageViewJFrame6157 extends JFrame {
    String Path ;
    JLabel Label;
    MainJFrame6157 mainJFrame;
    public ImageViewJFrame6157(String path , String name){
        this.Path=path;
        Label = new JLabel(new ImageIcon(this.Path));
        this.add(Label);
        this.setTitle(name);
        this.resize(600,600);
    }
}
