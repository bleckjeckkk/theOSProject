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
public class SJN extends Algo{
    SJN(ArrayList<Process> arr){
        super(arr);
    }
    
    public void go() throws InterruptedException{
        ArrayList<Process> pList = super.getList();
        
        System.out.println("SJN/SJF Algorithm");
        
        int time = 0;
        int cycles;
        String name;
        
        
        
        System.out.println("SJN/SJF done!\n" 
                + "Cycles elapsed: " + time);
    }
    
}
