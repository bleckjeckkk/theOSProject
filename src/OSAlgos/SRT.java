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
    SRT(ArrayList<Process> arr, javax.swing.JTextArea ta){
        super(arr, ta);
    }
    
    public void go() throws InterruptedException{
        ArrayList<Process> pList = super.getList();
        
        System.out.println("SRT Algorithm");
        
        int time = 0;
        int cycles;
        String name;
        
        
        
        System.out.println("SRT done!\n" 
                + "Cycles elapsed: " + time);
    }
}
