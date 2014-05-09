package main;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import extra.utilities.*;
public class checkversion {
    double version=3.61;
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
                int r=JOptionPane.showConfirmDialog(null,"Do you want to update to version "+read+"?","UPDATE!",JOptionPane.YES_NO_OPTION);
                if (r==JOptionPane.NO_OPTION) return;
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