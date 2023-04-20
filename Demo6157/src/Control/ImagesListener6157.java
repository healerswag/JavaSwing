package Control;

import Model.ImageComponent;
import View.MainJFrame6157;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImagesListener6157 implements ActionListener {
    MainJFrame6157 jFrame6157;
    public int eachPageCount = 4;
    public int curPageIndex = 1;
    public List<String> list;//可变化
    public int totalPages = 0;//向上取整;

    public int curPages;

    public ImagesListener6157(List<String> list) {
        // 传入图片数组
        this.list = list;
    }

    public ImagesListener6157() {
    }

    public ImagesListener6157(MainJFrame6157 mainJFrame) {
        this.jFrame6157 = mainJFrame;
    }

    // 通过输入目录寻找图片路径
    public List<String> getImages(String path) {
        List<String> list = new ArrayList<>();
        File file = null;
        file = new File(path);
        if (!file.isDirectory()) { //判断目录是否存在，不存在就使用默认目录
            file = new File("Images\\"+ jFrame6157.getTitle());
        }//     // 添加路径到指定目录
        try{
            for (File f : file.listFiles()) {
                list.add(f.getPath());
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(jFrame6157, "无图片");
        }

        return list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        路径需要修改 从数据库里面获取路径
         */
        list = getImages("Images\\"+ jFrame6157.getTitle());
        totalPages = (int) Math.ceil(list.size() / (eachPageCount * 1.0));
        if (e.getActionCommand().equals("下一页")) {
            if (curPageIndex < totalPages) {
                curPageIndex++;
                setContex(curPageIndex);
            } else JOptionPane.showMessageDialog(null, "已经是最后一页啦 ！！！");
        } else { //上一页
            if (curPageIndex > 1) {
                curPageIndex--;
                setContex(curPageIndex);
            } else JOptionPane.showMessageDialog(null, "已经是第一页啦 ！！！");
        }

        jFrame6157.curPageLabel.setText("当前第" + curPageIndex + "页，共" + totalPages + "页");
    }

    public void setContex(int curPage) {
        if (list!=null){
            jFrame6157.centerCenterJPanel.removeAll();
            jFrame6157.centerCenterJPanel.repaint();
        }
        /*
        路径需要修改 从数据库里面获取路径
         */
        list = getImages("Images\\"+ jFrame6157.getTitle());
        totalPages = (int) Math.ceil(list.size() / (eachPageCount * 1.0));
        int pos = (curPage - 1) * eachPageCount;
        for (int i = 0; i < eachPageCount; i++) {
            if (i + pos >= list.size()) {
                break;
            }
            ImageComponent imageComponent = new ImageComponent(list.get(i + pos), i + 1 + pos + ".jpg");
            jFrame6157.centerCenterJPanel.add(imageComponent);
        }
        jFrame6157.curPageLabel.setText("当前第" + curPageIndex + "页，共" + totalPages + "页");
    }
}
