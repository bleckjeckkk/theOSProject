/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Dan
 * this is basically a container for processes...
 * and a sorter
 */
public class Algo{
    private int totalTime = 0;
    private final ArrayList<Process> processList;
    
    Algo(ArrayList<Process> newList){
        processList = newList;
    }
    
    public void setTime(int newTime){totalTime = newTime;}
    public int getTime(){return totalTime;}
    
    public int getTotalCycles(){
        int cycles = 0;
        for(Process p : processList){
            cycles = cycles + p.getCycles();
        }
        return cycles;
    }
    
    public ArrayList<Process> getList(){
        ArrayList<Process> newList = new ArrayList<>();
        processList.forEach((p) ->{
            newList.add(p);
        });
        return newList;
    }
    
    public void sortByArrivalTime(){
        Collections.sort(processList,new ArrivalTimeComparator());
    }
    
    public void sortByArrivalTimePrio(){
        Collections.sort(processList,new ArrivalTimePrioComparator());
    }
    
    public void sortByCycleTime(){
        Collections.sort(processList,new CycleComparator());
    }
}
