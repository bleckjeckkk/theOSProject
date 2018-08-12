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
 * comparator for sorting by cycles
 */
public class CycleComparator implements Comparator<Process>{
    @Override
    public int compare(Process p1, Process p2) {
        int result;
        result =  p1.getCycles() <  p2.getCycles() ? -1 : p1.getCycles() == p2.getCycles() ? 0 : 1 ;
       return result;
    }
}