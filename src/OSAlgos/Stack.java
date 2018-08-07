/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

import OSAlgos.Process;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class Stack {
    private ArrayList<Process> stack;
    private int topOfStack = -1;
    
    Stack(){
        stack = new ArrayList<>();
        
    }
    
    Stack(ArrayList<Process> newList){
        stack = newList;
        topOfStack = newList.size();
    }
    
    public void push(Process p){
        System.out.println(p);
        stack.add(p);
        topOfStack++;
        
    }
    
    public Process pop(){
        if(topOfStack >= 0){
            Process p;
            p = stack.remove(topOfStack);
            topOfStack--;
            return p;
        }else{
            System.out.println("Nothing to pop");
            return null;
        }
    }
}
