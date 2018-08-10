package OSAlgos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;


class DisplayTimeline_SJN extends JPanel implements ActionListener{
    Timer tm = new Timer(5,this);
    int startX = 100;
    int x = 0, y = 30, velX = 1;
    Boolean cleared = false;
    int i = 0;
    ArrayList<Animatable> pList;
    
    DisplayTimeline_SJN(){
        
    }
    
    DisplayTimeline_SJN(ArrayList<Animatable> list){
        pList = list;
        for(Animatable a : pList){
            a.sequence = a.sequence * 100;
        }
    }
    
    
    public void paintComponent(Graphics g){
        System.out.println("paintComponent");
        tm.start();
        
        g.setColor(Color.WHITE);
        g.fillRect(5,5,40,20);
        g.setColor(Color.BLACK);
        g.drawString("Priority-Name", 5, 20);
        
        try{
            g.setColor(Color.BLACK);
            g.drawString(pList.get(i).processName, 5,y + 15);
            if(!pList.get(i).isDone){
                g.setColor(Color.RED);
            }else{
                g.setColor(Color.GREEN);
            }
            g.fillRect(startX,y,x,20);
            if(x == pList.get(i).size){
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(pList.get(i).time), startX + x + 5,y + 15);
                i++;
                startX += pList.get(i).size;
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
