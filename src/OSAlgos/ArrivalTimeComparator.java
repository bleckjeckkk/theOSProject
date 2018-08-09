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
 */
public class ArrivalTimeComparator implements Comparator<Process>{
    @Override
    public int compare(Process p1, Process p2) {
        int result;
        result =  p1.getArrivalTime() <  p2.getArrivalTime() ? -1 : p1.getArrivalTime() == p2.getArrivalTime() ? 0 : 1 ;
       return result;
    }
}