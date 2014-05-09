package main;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import extra.utilities.*;
public class checkversion {
    double version=3.6;
    double read=0.0;
    boolean updated=false;
    public void checkversiontime() {
        String url="https://dl.dropboxusercontent.com/u/109423311/timekeeper/timekeeperversion.txt";
        String filename="resources\\timekeeperversion.txt";
        util.downloadfile(url,filename);
        try {
            File file=new File("resources\\timekeeperversion.txt");
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String out=reader.readLine();
            reader.close();
            read=Double.parseDouble(out);
            file.delete();
            if (read>version) {
                JFrame f=new JFrame("UPDATE!");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Box box = Box.createVerticalBox();
                Box boxh = Box.createHorizontalBox();
                JLabel update = new JLabel("UPDATE is Downloading");
                boxh.add(update);
                box.add(box.createVerticalStrut(10));
                box.add(boxh);
                f.add(box);
                f.setSize(200,100);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                updated=true;
                url="https://dl.dropboxusercontent.com/u/109423311/timekeeper/timekeeperchangelog.txt";
                filename="resources\\changelog.txt";
                util.downloadfile(url,filename);
                url="https://dl.dropboxusercontent.com/u/109423311/timekeeper/timekeepercredits.txt";
                filename="resources\\credits.txt";
                util.downloadfile(url,filename);
                url="https://dl.dropboxusercontent.com/u/109423311/timekeeper/timekeeper.jar";
                filename="timekeeper"+read+".jar";
                util.downloadfile(url,filename);
                Runtime.getRuntime().exec("java -jar timekeeper"+read+".jar");
                System.exit(0);
            }
        } catch (Exception e) {System.out.println(e);}
    }
}