/**
 @author Bogdan
 */
public abstract class Rotor {
    protected String name;
    private int position;
    protected int[] mapping = new int[26];
    protected static final int ROTORSIZE = 26;


    /**
     * Set the position of the Rotor to the new position passed as parameter
     *
     * @param newPosition the new position of the Rotor
     */
    public void setPosition(int newPosition)
    {
        this.position = newPosition;
    }


    /**
     * Return the position of the Rotor
     *
     * @return the current position of the Rotor
     */
    public int getPosition()
    {
        return this.position;
    }

    /**
     * The mapping is set based on the type of Rotor
     * TO BE IMPLEMENTED IN SUBCLASSES
     *
     * @param inputString the type of the Rotor
     * @throws Exception InvalidRotorType
     */
    abstract protected void initialise(String inputString) throws Exception;

    /**
     * Swap the int passed as parameter to a different int
     * based on the mapping of the Rotor.
     * TO BE IMPLEMENTED IN SUBCLASSES
     *
     * @param inputNumber the character to be swapped represented as int
     * @return the new character
     */
    abstract int substitute(int inputNumber);


}
