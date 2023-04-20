package View;

import javax.swing.*;
import java.awt.*;

//前端界面的图片组件

public class ImageComponent extends JComponent{
    public static final int DEFAULT_WIDTH = 535;
    public static final int DEFAULT_HEIGHT = 250;
    public void paintComponent(Graphics g){
        Image img = new ImageIcon("Images\\3.jpeg").getImage();
        g.drawImage(img,0,0,DEFAULT_WIDTH,DEFAULT_HEIGHT,null);

    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}