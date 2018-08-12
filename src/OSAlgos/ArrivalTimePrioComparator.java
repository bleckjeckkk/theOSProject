/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import java.util.Comparator;

/**
 *
 * @author Dan
 * comparator for grouping by arrival time, sorting by priority
 */
public class ArrivalTimePrioComparator implements Comparator<Process>{
    @Override
    public int compare(Process p1, Process p2) {
        int result;
        result =  p1.getArrivalTime() <  p2.getArrivalTime() ? -1 : p1.getArrivalTime() == p2.getArrivalTime() ? 0 : 1 ;
        if(result==0){
            result =  p1.getPriority() <  p2.getPriority() ? -1 : p1.getPriority() == p2.getPriority() ? 0 : 1;
        }
       return result;
    }
}