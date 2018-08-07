/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OSAlgos;

/**
 *
 * @author Dan
 */
public class Animatable {
    String processName;
    int size;
    Boolean isDone;
    private static int order = 0;
    int sequence;
    int priority;
    
    Animatable(String name, int size, Boolean isDone){
        processName = name;
        this.size = size;
        this.isDone = isDone;
        sequence = order++;
    }
    
    Animatable(String name, int size, Boolean isDone,int priority){
        processName = name;
        this.size = size;
        this.isDone = isDone;
        sequence = order++;
        this.priority = priority;
    }
}
