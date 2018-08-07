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
public class PSched extends Algo{
    PSched(ArrayList<Process> arr, javax.swing.JTextArea ta){
        super(arr, ta);
    }
    
    public void go() throws InterruptedException{
        ArrayList<Process> pList = super.getList();
        
        System.out.println("Priority Scheduling Algorithm");
        
        int time = 0;
        int cycles;
        String name;
        
        
        
        System.out.println("Priority Scheduling done!\n" 
                + "Cycles elapsed: " + time);
    }
    
}
