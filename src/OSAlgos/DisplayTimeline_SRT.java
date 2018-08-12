package OSAlgos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;


class DisplayTimeline_SRT extends JPanel implements ActionListener{
    Timer tm = new Timer(5,this);
    int startX = 100;
    int x = 0, y = 30, velX = 1;
    int i = 0;                      //to traverse
    ArrayList<Animatable> pList;
    
    DisplayTimeline_SRT(){
        
    }
    
    DisplayTimeline_SRT(ArrayList<Animatable> list){
        pList = list;
    }
    
    
    public void paintComponent(Graphics g){
        System.out.println("paintComponent");
        tm.start();
        
        g.setColor(Color.WHITE);
        g.fillRect(5,5,40,20);
        g.setColor(Color.BLACK);
        g.drawString("Process Name", 5, 20);
        
        try{
            if(pList.get(i).id == pList.get(i+1).id){       //if this and next process is the same
                i++;                    //increments index to go to the next process
                //writing the name
                g.setColor(Color.BLACK);
                g.drawString(pList.get(i).processName, 5,y + 15);
                
                //setting color and drawing rectangle
                if(!pList.get(i).isDone){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.GREEN);
                }
                g.fillRect(startX,y,x,20);
                
                //if process is done
                if(x == (pList.get(i).size + pList.get(i-1).size)){
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(pList.get(i).time), startX + x + 5,y + 15);
                    startX += (pList.get(i).size + pList.get(i-1).size);
                    i++;
                    y += 30;
                    x = 0;
                }
            }
            else{           //if this and next process is NOT the same
                //writing the name
                g.setColor(Color.BLACK);
                g.drawString(pList.get(i).processName, 5,y + 15);
                
                //setting color and drawing rectangle
                if(!pList.get(i).isDone){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.GREEN);
                }
                g.fillRect(startX,y,x,20);
                
                //if process is done
                if(x == pList.get(i).size){
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(pList.get(i).time), startX + x + 5,y + 15);
                    i++;
                    startX += pList.get(i).size;
                    y += 30;
                    x = 0;
                }     
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
