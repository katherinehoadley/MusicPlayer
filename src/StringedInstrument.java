import java.util.ArrayList;
public class StringedInstrument {

    //field
    private ArrayList<Wire> wires;

    //getter
    public ArrayList<Wire> getWires(){
        return wires;
    }

    //methods
    public void addWire(Wire w){
        wires.add(w);
    }

    public Wire createWire(int wireNum){
        return new Wire(wireNum);
    }

    public void setWires(int numWires){
        wires = new ArrayList<>();
        for (int i = 0; i < numWires; i++) {
            addWire(createWire(i));
        }
    }

    public boolean strikeWire(int wireNum){
        if(wireNum >= 0 && wireNum < wires.size()){
            wires.get(wireNum).strike();
            return true;
        }
        else{
            return false;
        }
    }

    public double calculateSampleFromWires(){
        double sum = 0.0;
        for (Wire w : wires) {
            sum += w.sample();
        }
        return sum;
    }

    public void play(){
        double sample = calculateSampleFromWires();
        StdAudio.play(sample);
    }

    //default constructor
    public StringedInstrument(){
        wires = new ArrayList<>();
    }

    //custom constructor
    public StringedInstrument(int numWires){
        setWires(numWires);
    }

    //helper constructor
    public StringedInstrument(int numWires, int maxWires, int minWires, int defWires){
        if (numWires >= minWires && numWires <= maxWires) {
            setWires(numWires);
        } else {
            setWires(defWires);
        }
    }



}
