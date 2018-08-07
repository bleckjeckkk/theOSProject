/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Dan
 */
public class FCFS extends Algo{
    private javax.swing.JTextArea textArea;
    int[] timeArr = new int[20];
    int total = 0;
    
    FCFS(ArrayList<Process> arr, javax.swing.JTextArea ta){
        super(arr,ta);
        
    }
    
    public void go() throws InterruptedException{
        ArrayList<Process> pList = super.getList();
        clearConsole();
        System.out.println("FCFS Algorithm");
        
        int time = 0;
        int cycles;
        String name;
        int j=0;
        for(Process p : pList){
            name = p.getName();
            cycles = p.getCycles();
            
            System.out.println("Allocating process: " + name + "...");
            System.out.println("Will take " + cycles + " cycles");

           
            time = time + cycles;
            int i=0;
            while(i!=time){
                System.out.print("|");
                i++;
            }
            timeArr[j] = cycles;
            System.out.println("Done!\n");
            j++;
        }
        System.out.println("FCFS done!\n" 
                + "Cycles elapsed: " + time);
        
        //DISPLAY
        total = time;
        System.out.print("proc:" + timeArr);
        DisplayTimeline d = new DisplayTimeline(timeArr,time);
        
        JFrame jf = new JFrame();
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1500,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(d);
        jf.setVisible(true);
    }
}

class DisplayTimeline extends JPanel implements ActionListener{
    Timer tm = new Timer(5,this);
    int x = 0, y= 10, velX = 1, i=1;
    int[] timeArr = new int[20];
    int totaltime = 0;
    
    
    DisplayTimeline(int time[],int total){
        timeArr = time;
        totaltime = total;
        for(int i=0; i<18; i++){
            if(timeArr[i+1] != 0)
                timeArr[i+1] = timeArr[i] + timeArr[i+1];
        }
    }
    
    public void paintComponent(Graphics g){
        
        g.setColor(Color.GREEN);
        g.fillRect(5,5,x,40);
        g.drawString("Job 1:" + timeArr[0]*10, 5,55);
        
        if((x > timeArr[0]*10 && timeArr[0]!=0)){
            g.setColor(Color.BLUE);
            g.fillRect(timeArr[0]*10,5,x,40);
            g.drawString("Job 2:" + timeArr[1]*10, timeArr[0]*10,55);
            i=1;
        }
        if(x > timeArr[1]*10 && timeArr[1]!=0){
            g.setColor(Color.RED);
            g.fillRect(timeArr[1]*10,5,x,40);
            g.drawString("Job 3:" + timeArr[2]*10, timeArr[1]*10,55);
            i=2;
        }
        if(x > timeArr[2]*10 && timeArr[2]!=0){
            g.setColor(Color.ORANGE);
            g.fillRect(timeArr[2]*10,5,x,40);
            g.drawString("Job 4:" + timeArr[3]*10, timeArr[2]*10,55);
            i=3;
        }
        if(x > timeArr[3]*10 && timeArr[3]!=0){
            g.setColor(Color.PINK);
            g.fillRect(timeArr[3]*10,5,x,40);
            g.drawString("Job 5:" + timeArr[4]*10 , timeArr[3]*10,55);
            i=4;
        }
        if(x >= timeArr[4]*10 && timeArr[4]!=0){
            g.setColor(Color.MAGENTA);
            g.fillRect(timeArr[4]*10,5,x,40);
            g.drawString("Job 6:" + timeArr[5]*10, timeArr[4]*10,55);
            i=5;
        }
        if(x > timeArr[5]*10 && timeArr[5]!=0){
            g.setColor(Color.CYAN);
            g.fillRect(timeArr[5]*10,5,x,40);
            g.drawString("Job 7:" + timeArr[6]*10, timeArr[5]*10,55);
            i=6;
        }
        if(x > timeArr[6]*10 && timeArr[6]!=0){
            g.setColor(Color.GRAY);
            g.fillRect(timeArr[6]*10,5,x,40);
            g.drawString("Job 8:" + timeArr[7]*10, timeArr[6]*10,55);
            i=7;
        }
        
        
        if(timeArr[i]!=0 && x<=timeArr[i]*10)
            tm.start();
        else
            tm.stop();
    }
    
    public void actionPerformed(ActionEvent e){
        x = x + velX;
        repaint();
        
    }
}
