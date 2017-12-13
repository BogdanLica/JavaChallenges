import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 @author Bogdan
 */
public class Bombe implements Callable<ArrayList<String>> {

    private EnigmaMachine myEnigma;
    private String secretMesage;
    private int typeRotor1;
    private int typeRotor2;
    private int typeRotor3;
    private int typeReflector;


    /**
     * Constructor
     * Save the settings specified by the user
     *
     * @param messagetoDecode the encoded message
     * @param rotor1Type the integer representation of the type of the first Rotor
     * @param rotor2Type the integer representation of the type of the second Rotor
     * @param rotor3Type the integer representation of the type of the third Rotor
     * @param reflectorInput the Reflected selected by the user
     * @param plugs the sockets inputted by the user
     * @throws Exception InvalidRotorType,InvalidReflectorType,InvalidPlugs
     */
    public Bombe(String messagetoDecode,int rotor1Type,int rotor2Type, int rotor3Type,int reflectorType, ArrayList<Character> plugs) throws Exception
    {
        this.myEnigma = new EnigmaMachine();
        this.secretMesage = messagetoDecode;
        this.typeRotor1 = rotor1Type;
        this.typeRotor2 = rotor2Type;
        this.typeRotor3 = rotor3Type;
        this.typeReflector = reflectorType;
        this.initialise(plugs);

    }


    /**
     * Process all the possible decoded messages by calling
     * {@link #addTheRotorsPositions(EnigmaMachine)} and return
     * the result.(This was made to be run by many threads concurrently)
     *
     * @return ArrayList all decoded messages
     * @throws Exception InvalidRotorsTypes
     */
    @Override
    public ArrayList<String> call() throws Exception {


        // Pass all the plugs
        EnigmaMachine tempEnigma = new EnigmaMachine();
        tempEnigma.setPlugboard(myEnigma.getPlugboard());
        ArrayList<String> decodedMessages = null;

        try
        {
            decodedMessages = this.addTheRotorsPositions(tempEnigma);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return decodedMessages;
    }


    /**
     * Convert the type of the Rotor to the format used by the EnigmaMachine.
     * Go through all the possible combinations of positions for the 3 Rotors
     * and add the message decoded to an ArrayList.
     *
     * @param enigma the EnigmaMachine with all the settings specified by the user
     * @return ArrayList all the decoded messages
     * @throws Exception InvalidRotorTypes
     */
    private ArrayList<String> addTheRotorsPositions(EnigmaMachine enigma) throws Exception
    {
        String rotor1 = this.checkType(this.typeRotor1);
        String rotor2 = this.checkType(this.typeRotor2);
        String rotor3 = this.checkType(this.typeRotor3);
        String reflector = this.checkReflector(this.typeReflector);
        String outputMessage;

        ArrayList<String> allMessages = new ArrayList<String>();
        for(int i=0;i<25;i++)
        {
            for(int j=0;j<25;j++)
            {
                for(int k=0;k<25;k++)
                {
                    BasicRotor firstRotor = new BasicRotor(rotor1);
                    firstRotor.setPosition(i);
                    enigma.addRotor(firstRotor,0);

                    BasicRotor secondRotor = new BasicRotor(rotor2);
                    secondRotor.setPosition(j);
                    enigma.addRotor(secondRotor,1);

                    BasicRotor thirdRotor = new BasicRotor(rotor3);
                    thirdRotor.setPosition(k);
                    enigma.addRotor(thirdRotor,2);

                    Reflector myReflector = new Reflector(reflector);
                    enigma.addReflector(myReflector);

                    outputMessage = enigma.start(this.secretMesage);

                    allMessages.add(outputMessage);



                }

            }
        }

        return allMessages;
    }

    /**
     * Get the sockets from the ArrayList and
     * create Plugs from them.
     *
     * @param inputPlugs the sockets inputted by the user
     * @throws Exception InvalidPlugs
     */
    private void initialise(ArrayList<Character> inputPlugs) throws Exception
    {


        int count = 0;
        while (inputPlugs.size() > count)
        {
            char first = inputPlugs.get(count);
            count++;
            char second =inputPlugs.get(count);
            count++;
            myEnigma.addPlug(first,second);
        }

    }


    /**
     * Convert the integer representation of the type
     * of the Rotor to the equivalent String
     *
     * @param i the integer representation of the type of the Rotor
     * @return the String representation of the type of the Rotor
     */
    private String checkType(int i)
    {
        switch (i)
        {
            case 1:
                return "typeI";
            case 2:
                return "typeII";
            case 3:
                return "typeIII";
            case 4:
                return "typeIV";
            case 5:
                return "typeV";
            default:
                return "";
        }
    }

    private String checkReflector(int i)
    {
        switch (i)
        {
            case 1:
                return "ReflectorI";
            case 2:
                return "ReflectorII";
            default:
                return "";
        }
    }





}
