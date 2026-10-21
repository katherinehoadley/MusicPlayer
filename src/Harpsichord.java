public class Harpsichord extends StringedInstrument{

    //default constructor (48 wires)
    public Harpsichord(){
        super(48);
    }

    //custom constructor (0-60 wires)
    public Harpsichord(int numWires){
        super(numWires, 60, 0, 48);
    }

    //override createWire
    @Override
    public Wire createWire(int wireNum){
        return new HarpsichordWire(wireNum);
    }

}
