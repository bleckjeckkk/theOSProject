package OSAlgos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;


class DisplayTimeline_FCFS extends JPanel implements ActionListener{
    Timer tm = new Timer(5,this);
    int x = 0, y= 10, velX = 1;
    int[] timeArr = new int[20];
    int totaltime = 0;
    
    DisplayTimeline_FCFS(){
        
    }
    
    DisplayTimeline_FCFS(int time[],int total){
        timeArr = time;
        totaltime = total;
        for(int i=0; i<18; i++){
            timeArr[i+1] = timeArr[i] + timeArr[i+1];
        }
    }
    
    public void paintComponent(Graphics g){
        
//        g.setColor(Color.GREEN);
//        g.fillRect(5,5,x,40);

        if((x <= timeArr[0]*10 && timeArr[0]!=0)){
            g.setColor(new Color(255,255,255));
            g.fillRect(timeArr[0]*10,5,x,40);
                g.drawString("Job 1", timeArr[0]*10,55);
        }
        else{
            if(x <= timeArr[1]*10 && timeArr[1]!=0){
                g.setColor(Color.RED);
                g.fillRect(timeArr[1]*10,5,x,40);
                g.drawString("Job 2", timeArr[1]*10,55);
            }   
            else{
                if(x <= timeArr[2]*10 && timeArr[2]!=0){
                    g.setColor(Color.ORANGE);
                    g.fillRect(timeArr[2]*10,5,x,40);
                    g.drawString("Job 3", timeArr[2]*10,55);
                }
                else{
                    if(x <= timeArr[3]*10 && timeArr[3]!=0){
                        g.setColor(Color.PINK);
                        g.fillRect(timeArr[3]*10,5,x,40);
                        g.drawString("Job 4", timeArr[3]*10,55);
                    }
                    else{
                        if(x <= timeArr[4]*10 && timeArr[4]!=0){
                            g.setColor(Color.MAGENTA);
                            g.fillRect(timeArr[4]*10,5,x,40);
                            g.drawString("Job 5", timeArr[4]*10,55);
                        }
                        else{
                            if(x <= timeArr[5]*10 && timeArr[5]!=0){
                                g.setColor(Color.CYAN);
                                g.fillRect(timeArr[5]*10,5,x,40);
                                g.drawString("Job 6", timeArr[5]*10,55);
                            }
                            else{
                                if(x <= timeArr[6]*10 && timeArr[6]!=0){
                                    g.setColor(Color.GRAY);
                                    g.fillRect(timeArr[6]*10,5,x,40);
                                    g.drawString("Job 7", timeArr[6]*10,55);
                                }
                                else{
                                    tm.stop();
                                }
                            }
                        }
                    }
                }
            }
        }
        tm.start();
    }
    
    public void actionPerformed(ActionEvent e){
        x = x + velX;
        repaint();
    }
}
