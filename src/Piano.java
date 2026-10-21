public class Piano extends StringedInstrument{

    //default constructor (36 wires)
    public Piano(){
        super(36);
    }
    //custom constructor (0-88 wires)
    public Piano(int numWires){
        super(numWires, 88, 0, 36);
    }
    //override createWire
    @Override
    public Wire createWire(int wireNum){
        return new PianoWire(wireNum);
    }

}
