/**
 @author Bogdan
 */
public abstract class Rotor {
    protected String name;
    private int position;
    protected int[] mapping = new int[26];
    protected static final int ROTORSIZE = 26;

    public Rotor()
    {}

    public void setPosition(int newPosition)
    {
        this.position = newPosition;
    }


    public int getPosition()
    {
        return this.position;
    }

    abstract protected void initialise(String inputString) throws Exception;

    abstract int substitute(int inputNumber);

    abstract int substituteBack(int inputNumber);

    abstract void rotate();

    abstract void setNextRotor(Rotor inputRotor);

}
