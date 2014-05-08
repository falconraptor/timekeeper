package extra.utilities;
import javax.swing.*;
import java.util.*;
import java.awt.*;
public class daysleftofschool extends JFrame{
    public daysleftofschool() {
        super("Days Until End Of School");
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(false);
        //super.setContentPane(setgui());
        super.pack();
        new java.util.Timer().schedule(new UpdateUITask(), 0, 3600000);
    }
    public void appear() {super.setVisible(true);}
    private class UpdateUITask extends TimerTask {
        @Override
        public void run() {
            Calendar time=Calendar.getInstance();
            int month=time.get(time.MONTH)+1,day=time.get(time.DAY_OF_MONTH),year=time.get(time.YEAR);
        }
    }
    private void framepack() {super.pack();}
}
