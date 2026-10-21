public class ElectricPiano extends StringedInstrument{

    //default constructor
    public ElectricPiano(){
        super();
    }

    //custom constructor
    public ElectricPiano(int numWires){
        super(numWires);
    }

    //override createWire
    @Override
    public Wire createWire(int wireNum){
        return new SimulatedWire(wireNum);
    }

}
