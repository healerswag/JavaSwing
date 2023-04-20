package Control;

import View.MainJFrame6157;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeLabelAction6157 implements ActionListener {
    MainJFrame6157 jFrame6157;

    public TimeLabelAction6157(MainJFrame6157 jFrame6157) {
        this.jFrame6157 = jFrame6157;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long timeMillis = System.currentTimeMillis();
        //定义时间的格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(df.format(new Date(timeMillis)));
        jFrame6157.timeLabel.setText(df.format(new Date(timeMillis)));
    }
}
