package extra.utilities;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class daysleftofschool extends JFrame {
	ArrayList<JLabel> l = new ArrayList<JLabel>(0);

	public daysleftofschool () {
		super("Days Until End Of School");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(setgui());
		setVisible(false);
		//super.setContentPane(setgui());
		pack();
		new java.util.Timer().schedule(new UpdateUITask(), 0, 3600000);
	}

	private JPanel setgui () {
		JPanel p = new JPanel(new GridLayout(2, 2, 0, 0));
		p.add(new JLabel("Days Left: ", 0));
		l.add(new JLabel("", 0));
		p.add(l.get(0));
		p.add(new JLabel("Months Left", 0));
		l.add(new JLabel("", 0));
		p.add(l.get(1));
		return p;
	}

	public void appear () {
		setVisible(true);
	}

	private void framepack () {
		super.pack();
	}

	private int daysleft (int month, int day, ArrayList<Holiday> holidays) {
		int index = -1;
		for (int i = 0; i < holidays.size(); i++)
			if (holidays.get(i).getname().equals("Last Day Of School")) index = i;
		if (month == holidays.get(index).getmonth()) {
			l.get(0).setText(holidays.get(index).getday() - day + "");
			l.get(1).setText("");
		} else {
			if (month > holidays.get(index).getmonth()) {
				if (day > holidays.get(index).getday()) {
					int days = 0;
					for (int i = month; i != holidays.get(index).getmonth(); i++) {
						switch (i) {
							case 1:
								days += 31;
								break;
							case 4:
								days += 30;
								break;
							case 2:

								break;
						}

						if (i == 12) i = 0;
					}
				} else {
					l.get(0).setText(holidays.get(index).getday() - day + "");
					l.get(1).setText(12 - month + holidays.get(index).getmonth() + "");
				}
			} else {
				if (day > holidays.get(index).getday()) {

				} else {
					l.get(0).setText(holidays.get(index).getday() - day + "");
					l.get(1).setText(holidays.get(index).getmonth() - month + "");
				}
			}
		}
		return 0;
	}

	private class UpdateUITask extends TimerTask {
		@Override
		public void run () {
			Calendar time = Calendar.getInstance();
			int month = time.get(Calendar.MONTH) + 1, day = time.get(Calendar.DAY_OF_MONTH), year = time.get(Calendar.YEAR);
		}
	}
}
