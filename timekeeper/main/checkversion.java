package main;
import java.io.*;
import java.net.*;
import java.nio.channels.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class checkversion {
    double version=3.523;
    double read=0.0;
    boolean updated=false;
    public void downloadfile(String url,String filename) {
        try {
            URL download=new URL(url);
            ReadableByteChannel rbc=Channels.newChannel(download.openStream());
            FileOutputStream fileOut = new FileOutputStream(filename);
            fileOut.getChannel().transferFrom(rbc, 0, 1 << 24);
            fileOut.flush();
            fileOut.close();
            rbc.close();
        } catch(Exception e) {System.out.println(e);}
    }
    public void checkversiontime() {
        String url="https://dl.dropboxusercontent.com/u/109423311/timekeeper/timekeeperversion.txt";
        String filename="resources\\timekeeperversion.txt";
        downloadfile(url,filename);
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
                downloadfile(url,filename);
                url="https://dl.dropboxusercontent.com/u/109423311/timekeeper/timekeepercredits.txt";
                filename="resources\\credits.txt";
                downloadfile(url,filename);
                url="https://dl.dropboxusercontent.com/u/109423311/timekeeper/timekeeper.jar";
                filename="timekeeper"+read+".jar";
                downloadfile(url,filename);
                Runtime.getRuntime().exec("java -jar timekeeper"+read+".jar");
                System.exit(0);
            }
        } catch (Exception e) {System.out.println(e);}
    }
}