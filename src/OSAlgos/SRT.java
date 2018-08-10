/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Dan
 */
public class SRT extends Algo{
    SRT(ArrayList<Process> arr){
        super(arr);
    }
    
    public void go() throws InterruptedException{
        sortByArrivalTime();
        ArrayList<Process> pList = super.getList();
        ArrayList<Process> container = new ArrayList();
        
        ArrayList<Animatable> animateMe = new ArrayList();
        
        System.out.println("SRT Algorithm");
        
        int time = 0;
        int cycles;
        String name;
        
        int i = 0;                  //iterator
        int ctrlTime = 1;           //quantum time
        
        Process p = null;
        Process prev = null;
        
        int aniCycles = 0;          //to hold cycles for animation
        
        while(true){
            System.out.println("-----Cycle Time : " + time + "-----");
            if(pList.size() > 0){
                //put processes arriving at i to container
                for(Process temp : pList){
                    if(temp.getArrivalTime() == i){
                        container.add(temp);
                    }
                }
                
                prev = p;
                    
                p = getMin(container);
        
                name = p.getName();
                cycles = p.getCycles();
                
                System.out.println("Allocating Process : " + name + "...");
                System.out.println("Will take " + cycles + " cycles");
                time += ctrlTime;
                System.out.println("Done!");
                
                if(p.getCycles()-1 <= 0){       //if done
                    if(prev != null){           //and is not the first process
                        aniCycles += ctrlTime;
                        if(prev == p){          //and the same process as the previous
                            System.out.println("Done, same as previous");
                            animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,true,0,time));
                        }else{                  //and not the same process as previous
                            System.out.println("Done, not same as previous");
                            animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,true,0,time));
                            aniCycles = 0;
                        }
                    }else{                      //and is the first process
                        animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,true,0,time));
                        aniCycles = 0;
                    }
                    container.remove(p);
                    pList.remove(p);
                }
                else{                           //if not done
                    aniCycles += ctrlTime;
                    if(prev != null){           //is not the first process
                        if(prev != p){          //change process
                            System.out.println("NOT Done, not same as previous");
                            animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,false,0,time));
                            aniCycles = 0;
                        }else{                  //
                            System.out.println("NOT Done, same as previous");
                        }
                    }
                    else{                       //is the first process
                        aniCycles += ctrlTime;
                        System.out.println("NOT Done, FIRST PROCESS");
                        animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,false,0,time));
                        aniCycles=0;
                    }
                    int index = container.indexOf(p);
                    p.setCycles(p.getCycles() - ctrlTime);
                    container.set(index, p);
                }
                i++;
            }
            else
                break;
        }
        
        System.out.println("SRT done!\n" 
                + "Cycles elapsed: " + time);
        animateMe.add(new Animatable(999999999,"",0,false,0,0));
        
        //DISPLAY
        DisplayTimeline_SRT d = new DisplayTimeline_SRT(animateMe);
        
        JFrame jf = new JFrame();
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.add(d);
        jf.setVisible(true);
    }

    private Process getMin(ArrayList<Process> container) {
        Algo a = new Algo(container);
        a.sortByCycleTime();
        return a.getList().get(0);
    }
}
