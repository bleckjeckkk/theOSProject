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
public class Algo{
    private int totalTime = 0;
    private final ArrayList<Process> processList;
    private final javax.swing.JTextArea textArea;
    
    Algo(ArrayList<Process> newList, javax.swing.JTextArea ta){
        processList = newList;
        textArea = ta;
    }
    
    public void append(String s){
        String currentText = textArea.getText();
        if(currentText.equals(""))
            textArea.setText(s); 
        else
            textArea.setText(currentText + "\n" + s);
    }
    
    public void clearConsole(){
        textArea.setText("");
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
}
