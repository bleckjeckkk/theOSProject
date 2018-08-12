package OSAlgos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author Dan
 * let's do the spaghetti
 * derived from an online tutorial
 */
class DisplayTimeline_FCFS extends JPanel implements ActionListener{
    Timer tm = new Timer(5,this);
    
    int x = 0, y = 10, velX = 1;
    
    int i = 0;
    
    ArrayList<Animatable> pList;
    
    int startX = 100;
    Boolean cleared = false;
    
    DisplayTimeline_FCFS(){
        
    }
    
    DisplayTimeline_FCFS(ArrayList<Animatable> newList){
        pList = newList;
    }
    
    
    public void paintComponent(Graphics g){
        System.out.println("paintComponent");
        tm.start();
        
        try{
            //Prints the name of the process
            g.setColor(Color.BLACK);
            g.drawString(pList.get(i).processName, 5,y + 15);
            
            //draws the rectangle
            g.setColor(Color.WHITE);
            g.fillRect(startX,y,x,20);
            
            //if it's the end of the process
            if(x == pList.get(i).size){
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(pList.get(i).end), startX + x + 5,y + 15);
                i++;
                startX += pList.get(i-1).size;
                y += 30;
                x = 0;
            }
        }
        catch(Exception e){
            System.out.println(e);
            tm.stop();
        }
    }
    
    public void actionPerformed(ActionEvent e){
        x = x + velX;
        repaint();
    }
}
