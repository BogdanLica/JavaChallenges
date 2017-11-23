/**
 @author Bogdan
 */
public class EnigmaMachine {
    private Plugboard myplugboard;
    private Reflector myReflector;
    private Rotor[] slot = new Rotor[3] ;
    public EnigmaMachine()
    {
        myplugboard = new Plugboard();
    }

    public boolean addPlug(char firstEnd,char secondEnd)
    {
        boolean status = myplugboard.addPlug(firstEnd,secondEnd);
        return status;
        /*
        if(!status)
        {
            //throw new Exception("The socket is already connected to a different plug");

        }
        */
    }

    public void clearPlugboard()
    {
        myplugboard.clear();
    }

    public void addRotor(Rotor r1,int positionInSlot)
    {
        slot[positionInSlot] = r1;
    }

    public Rotor getRotor(int positionInSlot)
    {
        return slot[positionInSlot];
    }

    public void addReflector(Reflector inputReflector)
    {
        this.myReflector = inputReflector;

    }

    public Reflector getReflector()
    {
        return this.myReflector;

    }

    public void setPosition(int positionInSlot,int initialPosition)
    {
        slot[positionInSlot].setPosition(initialPosition);
    }


    public char encodeLetter(char letterToEncode) throws Exception {
        if((int) letterToEncode < 65 ||(int) letterToEncode > 90)
        {
            throw new Exception("Non alpha-numerical value");
        }
        else
        {
            char encodedChar = myplugboard.substitute(letterToEncode);
            int valueChar = (int) encodedChar - 65;
            int newValueChar = slot[0].substitute(valueChar);
            int newValueChar2 = slot[1].substitute(newValueChar);
            int newValueChar3 = slot[2].substitute(newValueChar2);
            int halfOperation = getReflector().substitute(newValueChar3);
            newValueChar3 = slot[2].substituteBack(halfOperation);
            newValueChar2 = slot[1].substituteBack(newValueChar3);
            newValueChar = slot[0].substituteBack(newValueChar2);

            char finalChar = (char) (newValueChar + 65);
            slot[0].rotate();
            return myplugboard.substitute(finalChar);
        }
    }

    public String start(String inputToDecode) throws Exception {
        this.addPlug('Q','F');
        this.addRotor(new TurnonverRotor("typeI",23),0);
        this.addRotor(new TurnonverRotor("typeII",11),1);
        slot[0].setNextRotor(slot[1]);
        this.addRotor(new TurnonverRotor("typeIII",7),2);
        slot[1].setNextRotor(slot[2]);
        this.addReflector(new Reflector("ReflectorI"));

        StringBuilder sb = new StringBuilder();
        char[] stringToCharArray = inputToDecode.toCharArray();
        for(char output:stringToCharArray)
        {
            sb.append(encodeLetter(output));
        }

        return sb.toString();

    }


}
