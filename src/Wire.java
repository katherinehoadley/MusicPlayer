import java.util.LinkedList;
import java.util.Queue;

public class Wire {

    //fields
    private double decayRate;
    private Queue<Double> noteQueue;
    private int wireNum;

    //getters
    public double getDecayRate() {
        return decayRate;
    }

    public Queue<Double> getNoteQueue() {
        return noteQueue;
    }

    public int getWireNum() {
        return wireNum;
    }


    //methods
    public int calculateWireLength(int wireNum){
        double wireLength = StdAudio.SAMPLE_RATE * Math.pow(2, (22.0 - wireNum) / 12.0) / 440.0;
        return (int) wireLength;
    }

    public void buildWire(int numZero){
        noteQueue = new LinkedList<>();
        while(numZero > 0){
            noteQueue.add(0.0);
            numZero--;
        }
    }

    //constructors
    //default
    public Wire(){
        int wireLength = calculateWireLength(0);
        buildWire(wireLength);
        decayRate = .995;
    }

    //convenience
    public Wire(int wireNum){
        this.wireNum = wireNum;
        int wireLength = calculateWireLength(wireNum);
        buildWire(wireLength);
        decayRate = .995;
    }

    //custom
    public Wire(int wireNum, double decayRate){
        this.wireNum = wireNum;
        int wireLength = calculateWireLength(wireNum);
        buildWire(wireLength);
        this.decayRate = decayRate;

    }

    public double generateValue(int index, int wireLength){
        double random = Math.random() -.5;
        return random;
    }

    public void strike(){
        int length = noteQueue.size();
        for (int i = 0; i < length; i++){
            noteQueue.remove();
            noteQueue.add(generateValue(i, length));

        }
    }

    public double sample(){
        double removed = noteQueue.remove();
        double avg = (removed + noteQueue.peek())/2;
        double timesDecay = avg * decayRate;
        noteQueue.add(timesDecay);
        return removed;
    }






}
