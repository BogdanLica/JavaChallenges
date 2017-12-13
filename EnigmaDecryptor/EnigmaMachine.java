import java.util.ArrayList;
/**
 @author Bogdan
 */
public class EnigmaMachine {

    private Plugboard myplugboard;
    private Reflector myReflector;
    private BasicRotor[] slot = new BasicRotor[3] ;

    /**
     * Constructor
     */
    public EnigmaMachine()
    {
        myplugboard = new Plugboard();
    }


    /**
     * Pass the 2 ends to the {@link #myplugboard}
     * and get a boolean representing whether the 2
     * sockets were connected successfully or whether
     * no Plug got created
     *
     * @param firstEnd the first socket as Char
     * @param secondEnd the second socket as Char
     * @return boolean The status of connecting the 2 ends
     */
    public boolean addPlug(char firstEnd,char secondEnd)
    {
        return myplugboard.addPlug(firstEnd,secondEnd);

    }

    /**
     * Remove all the Plugs already connected
     */
    public void clearPlugboard()
    {
        myplugboard.clear();
    }

    /**
     * Return the plugs connected to the Plugboard
     *
     * @return The Plugs connected in the current Plugboard
     */
    public ArrayList<Plug> getPlugboard()
    {
        return myplugboard.getPlugs();
    }

    /**
     * Set the Plugboard of the current object to the Plugboard
     * passed as parameter
     *
     * @param inputPlugboard passed Plugboard
     */
    public void setPlugboard(ArrayList<Plug> inputPlugboard)
    {
        myplugboard.setPlugboard(inputPlugboard);
    }


    /**
     * Adding the Rotor passed as parameter in {@link #slot}
     *
     * @param r1 the Rotor to be added to the array
     * @param positionInSlot the index in array where to be placed
     */
    public void addRotor(BasicRotor r1,int positionInSlot)
    {
        slot[positionInSlot] = r1;
    }

    /**
     * Return the Rotor at a specified index in {@link #slot}
     *
     * @param positionInSlot index in slot
     * @return Rotor the rotor at that index in array
     */
    public Rotor getRotor(int positionInSlot)
    {
        return slot[positionInSlot];
    }

    /**
     * Assigning the reference of the Reflector passed as parameter
     * to the Reflector in the EnigmaMachine
     *
     * @param inputReflector the Reflector to be added
     */
    public void addReflector(Reflector inputReflector)
    {
        this.myReflector = inputReflector;

    }

    /**
     * Return the Reflector contained in 'this'
     * @return Reflector the reference in the current object
     */
    public Reflector getReflector()
    {
        return this.myReflector;

    }

    /**
     * Setting the initial position of the Rotor at the
     * index specified as parameter in the array
     *
     * @param positionInSlot the place of the Rotor in the array
     * @param initialPosition the position of the Rotor
     */
    public void setPosition(int positionInSlot,int initialPosition)
    {
        slot[positionInSlot].setPosition(initialPosition);
    }


    /**
     * Take each character, swap with a different letter if there is a Plug
     * connected and convert it into an integer.Successively change it to a
     * different chacater by using the {@link BasicRotor#substitute(int)}
     * or {@link TurnonverRotor#substitute(int)} until the chacater gets
     * to the Reflector. There the specific {@link Reflector#substitute(int)}
     * is used and the character is send back to the third Rotor, then to the
     * second Rotor, then to the first Rotor. In all those cases, the
     * inverse mapping is used using {@link BasicRotor#substituteBack(int)}
     * or {@link TurnonverRotor#substituteBack(int)}.Change the integer back
     * to a char and swap it if there is a Plug connected.Rotate the first Rotor
     * to signal the end of a full operation.
     *
     * @param letterToEncode The character to encode/decode
     * @return char the character decoded/encoded
     * @throws Exception Character not valid
     */
    protected char encodeLetter(char letterToEncode) throws Exception {
        if( letterToEncode == ' ')
        {
            return letterToEncode;

        }
        else if((int) letterToEncode < 65 ||(int) letterToEncode > 90)
        {
            throw new Exception("Non alpha-numerical value");
        }

        else
        {
            char encodedChar = myplugboard.substitute(letterToEncode);
            int valueChar = (int) encodedChar - 65;

            for(int i=0;i<=2;i++)
            {
                valueChar = slot[i].substitute(valueChar);
            }

            valueChar = getReflector().substitute(valueChar);

            for(int i=2;i>=0;i--)
            {
                valueChar = slot[i].substituteBack(valueChar);
            }


            char finalChar = (char) (valueChar + 65);
            slot[0].rotate();
            return myplugboard.substitute(finalChar);
        }
    }

    /**
     * Split the String passed into an array of chars
     * Decode each char using {@link #encodeLetter(char)}
     * Add the decoded char to a StringBuilder
     * After all the letters have been decoded, change
     * the format of the result from StringBuilder to a String
     *
     * @param inputToDecode The encoded message
     * @return String The decoded message
     * @throws Exception Character not valid
     */
    public String start(String inputToDecode) throws Exception {


        StringBuilder sb = new StringBuilder();
        char[] stringToCharArray = inputToDecode.toCharArray();
        for(char output:stringToCharArray)
        {
            sb.append(encodeLetter(output));
        }

        return sb.toString();

    }


}

