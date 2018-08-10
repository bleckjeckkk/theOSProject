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
    int id;
    int size;
    Boolean isDone;
    private static int order = 0;
    int sequence;
    int priority;
    int end;
    int time;
    
    //for FCFS
    Animatable(String name, int size, int end){
        processName = name;
        this.size = size;
        sequence = order++;
        this.end = end;
    }
    
    //for RoundRobin and SRT
    Animatable(String name, int size, Boolean isDone){
        processName = name;
        this.size = size;
        this.isDone = isDone;
        sequence = order++;
    }    
    
    //for Priority && SJN/SJF
    Animatable(String name, int size, Boolean isDone,int priority,int time){
        processName = name;
        this.size = size;
        this.isDone = isDone;
        sequence = order++;
        this.priority = priority;
        this.time = time;
    }
    
    //for Priority && SJN/SJF
    Animatable(int id,String name, int size, Boolean isDone,int priority,int time){
        this.id = id;
        processName = name;
        this.size = size;
        this.isDone = isDone;
        sequence = order++;
        this.priority = priority;
        this.time = time;
    }
}
