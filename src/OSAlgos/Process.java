package OSAlgos;
public class Process {

    private static int num = 0;
    private int id;
    private String name;
    private int cycles;
    private final int arrivalTime;
    private int priority;

    Process(String name, int cycles, int arrivalTime,int priority){
        this.id = num++;
        this.name = name;
        this.cycles= cycles;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        System.out.println("\nProcess " + name + " created!");
        System.out.println("Process has " + cycles + " cycles");
        System.out.println("Arrival Time: " + arrivalTime );
        System.out.println("Priority: " + priority);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void getInfo(){
        System.out.println("----- INFO -----");
        System.out.println("Process #" + this.arrivalTime);
        System.out.println("Name: " + this.getName());
        System.out.println("Cycles: " + this.getCycles());
        System.out.println("Arrival Time: " + this.getArrivalTime());
    }
}
