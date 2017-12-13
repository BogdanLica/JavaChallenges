/**
 @author Bogdan
 */
public class BasicRotor extends Rotor {
    protected int[] inverseMapping = new int[26];

    /**
     * Constructor
     * The type of the rotor is set and call {@link #initialise(String)}
     *
     * @param inputString the type of the rotor given as String
     * @throws Exception Invalid Rotor type
     */
    public BasicRotor(String inputString) throws Exception {

        this.name = inputString;
        this.initialise(this.name);

    }


    /**
     * Set the mapping of the rotor based on the parameter.
     * After the mapping is set, do the inverse mapping
     *
     * @param inputString the type of the rotor as String
     * @throws Exception Invalid Rotor type
     */
    @Override
    protected void initialise(String inputString) throws Exception
    {

        switch (inputString)
        {
            case "typeI":
                this.mapping = new int[]{4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9};
                break;

            case "typeII":
                this.mapping = new int[] { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4};
                break;

            case "typeIII":
                this.mapping = new int[]{1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14};
                break;

            case "typeIV":
                this.mapping = new int[] { 4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1};
                break;

            case "typeV":
                this.mapping = new int[] { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10};
                break;

            default:
                throw new Exception("Invalid rotor type");

        }



        for(int i=0;i<26;i++)
        {
            inverseMapping[mapping[i]] = i;
        }

    }

    /**
     * The number passed as parameter is swapped with a different number
     * by subtracting from it the current position of the rotor,checking
     * if the new number still lies between the range 0-25,using the mapping
     * at the new number, adding the position of the rotor back and checking
     * one more time that the number is in the range 0-25.
     *
     * @param inputNumber the character represented as an integer between 0-25
     * @return int the new character represented as int
     */
    @Override
    public int substitute(int inputNumber) {

        inputNumber = inputNumber - this.getPosition();

        if(inputNumber < 0)
        {
            inputNumber = inputNumber + ROTORSIZE;
        }

        inputNumber = this.mapping[inputNumber] + this.getPosition();

        if(inputNumber >= ROTORSIZE)
        {
            inputNumber = inputNumber - ROTORSIZE;
        }

        return inputNumber;
    }

    /**
     * The number passed as parameter is swapped with a different number
     * by subtracting from it the current position of the rotor,checking
     * if the new number still lies between the range 0-25,using the inverseMapping
     * at the new number, adding the position of the rotor back and checking
     * one more time that the number is in the range 0-25.
     *
     * @param passInteger the character represented as an integer between 0-25
     * @return the new character
     */
    public int substituteBack(int passInteger)
    {
        passInteger = passInteger - this.getPosition();

        if(passInteger < 0)
        {
            passInteger = passInteger + ROTORSIZE;
        }

        passInteger = this.inverseMapping[passInteger] + this.getPosition();

        if(passInteger >= ROTORSIZE)
        {
            passInteger = passInteger - ROTORSIZE;
        }

        return passInteger;

    }

    /**
     * Rotate the current Rotor.
     * The position of the Rotor is stored in a variable called 'position'
     * and if the value of it is less than 25, then just increment it,
     * otherwise set it to 0. At the end, set the new position of the Rotor
     */
    public void rotate()
    {
        int position = this.getPosition();
        int valueToWrite = 0;
        if(position < ROTORSIZE - 1)
        {
            position++;
            valueToWrite = position;
        }

        this.setPosition(valueToWrite);
    }


    /**
     * Create a reference for the next Rotor in the array, in this object
     * TO BE IMPLEMENTED IN SUBCLASSES
     *
     * @param inputRotor the next Rotor in the slot
     */
    public void setNextRotor(Rotor inputRotor){};
}
