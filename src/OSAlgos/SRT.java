/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.util.ArrayList;

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
        
        System.out.println("SRT Algorithm");
        
        int time = 0;
        int cycles;
        String name;
        
        int i = 0;                  //iterator
        int ctrlTime = 1;           //quantum time
        
        Process p;
        Process prev;
        
        while(true){
            if(pList.size() > 0){
                //put processes to container
                for(Process temp : pList){
                    if(temp.getArrivalTime() == i){
                        container.add(temp);
                    }
                }
                p = getMin(container);
        
                name = p.getName();
                cycles = p.getCycles();
                
                System.out.println("Allocating Process : " + name + "...");
                System.out.println("Will take " + cycles + " cycles");
                time += ctrlTime;
                System.out.println("Done!");
                
                if(p.getCycles()-1 <= 0){
                    container.remove(p);
                    pList.remove(p);
                }
                else{
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
    }

    private Process getMin(ArrayList<Process> container) {
        Algo a = new Algo(container);
        a.sortByCycleTime();
        return a.getList().get(0);
    }
}
