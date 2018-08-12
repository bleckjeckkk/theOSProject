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
class DisplayTimeline_PSched extends JPanel implements ActionListener{
    Timer tm = new Timer(5,this);
    int startX = 100;
    int x = 0, y = 30, velX = 1;
    Boolean cleared = false;
    int i = 0;
    ArrayList<Animatable> pList;                //to use for the logics of the animations
    
    DisplayTimeline_PSched(){
        
    }
    
    DisplayTimeline_PSched(ArrayList<Animatable> list){
        pList = list;
    }
    
    
    public void paintComponent(Graphics g){
        tm.start();
        
        g.setColor(Color.WHITE);
        g.fillRect(5,5,40,20);
        g.setColor(Color.BLACK);
        g.drawString("Process Name", 5, 20);
        
        try{
            if(pList.get(i).id == pList.get(i+1).id){       //if this and the same
                i++;                                        //goes to the next entry
                
                //prints the name
                g.setColor(Color.BLACK);
                g.drawString(pList.get(i).processName, 5,y + 15);
                
                //color selection and drawing of rectangle
                if(!pList.get(i).isDone){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.GREEN);
                }
                g.fillRect(startX,y,x,20);
                
                //if process is done
                if(x == (pList.get(i).size + pList.get(i-1).size)){
                    //prints the finish time
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(pList.get(i).time), startX + x + 5,y + 15);
                    startX += (pList.get(i).size + pList.get(i-1).size);
                    i++;
                    y += 30;
                    x = 0;
                }
            }
            else{                                           //if NOT the same as the next entry
                //prints the name
                g.setColor(Color.BLACK);
                g.drawString(pList.get(i).processName, 5,y + 15);
                
                //color selection and rectangle drawing
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
