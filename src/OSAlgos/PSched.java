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
 * Priority Scheduling
 */
public class PSched extends Algo{
    PSched(ArrayList<Process> arr){
        super(arr);
    }
    
    public void go() throws InterruptedException{
        sortByArrivalTime();                                        //sorts the arrayList in the Algo superclass
        ArrayList<Process> pList = super.getList();                 //gets the list from the Algo superclass
        ArrayList<Process> container = new ArrayList<>();           //contains the READY queue
        ArrayList<Animatable> animateMe = new ArrayList<>();        //contains the elements for animation
        
        int time = 0;
        int cycles;
        String name;
        
        int i = 0;
        int ctrlTime = 1;
        
        Process p = null;
        Process prev = null;
        
        int aniCycles = 0;

        while(true){
            if (pList.size() > 0){
                //put processes arriving at i to container
                for (Process temp: pList){
                    if (temp.getArrivalTime() == i){
                        container.add(temp);
                    }
                }
                prev = p;
                
                p = getNext(container);
                
                name = p.getName();
                cycles = p.getCycles();

                time = time + ctrlTime;
                
                if (p.getCycles()-1 <= 0){       //if done
                    if(prev != null){           //and is not the first process
                        aniCycles += ctrlTime;
                        if(prev == p){          //and the same process as the previous
                            animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,true,0,time));
                        }else{                  //and not the same process as previous
                            animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,true,0,time));
                            aniCycles = 0;
                        }
                    }else{                      //and is the first process
                        animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,true,0,time));
                        aniCycles = 0;
                    }
                    pList.remove(p);
                    container.remove(p);
                }
                else{                           //if not done
                    aniCycles += ctrlTime;
                    if(prev != null){           //is not the first process
                        if(prev != p){          //change process
                            animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,false,0,time));
                            aniCycles = 0;
                        }
                    }
                    else{                       //is the first process
                        aniCycles += ctrlTime;
                        animateMe.add(new Animatable(p.getId(),p.getName(),aniCycles,false,0,time));
                        aniCycles=0;
                    }
                    int index = container.indexOf(p);
                    p.setCycles(p.getCycles() - ctrlTime);
                    container.set(index, p);
                }
                i++;
            }
            else{
                break;
            }

        }
        //when done
        animateMe.add(new Animatable(999999999,"",0,false,0,0));
        
        //DISPLAY
        DisplayTimeline_PSched d = new DisplayTimeline_PSched(animateMe);
        
        JFrame jf = new JFrame();
        
        jf.setTitle("DisplayTimeline");
        jf.setSize(1280,720);
        jf.add(d);
        jf.setVisible(true);
    }

    private Process getNext(ArrayList<Process> container) {
        Algo algo = new Algo(container);
        algo.sortByArrivalTimePrio();        
        return algo.getList().get(0);
    }
    
}
