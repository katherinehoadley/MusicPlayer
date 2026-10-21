public class PianoWire extends Wire{


    //convenience constructor
    public PianoWire(int wireNum){
        super(wireNum,.996);
    }

    @Override
    public double generateValue(int index, int wireLength){
        double random = Math.sin(index / (Math.PI * wireLength / 2)) - 0.5;

        return random;
    }



}
