/**
 @author Bogdan
 */
public class BasicRotor extends Rotor {
    protected int[] inverseMapping = new int[26];

    public BasicRotor(String inputString,int inputPosition) throws Exception {
        this.name = inputString;
        this.setPosition(inputPosition);
        this.initialise(this.name);
    }


    @Override
    protected void initialise(String inputString) throws Exception
    {


        if(inputString.equals("typeI"))
        {
            this.mapping = new int[]{4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9};
        }

        else if(inputString.equals("typeII"))
        {
            this.mapping = new int[] { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4};
        }

        else if(inputString.equals("typeIII"))
        {
            this.mapping = new int[]{1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14};
        }

        else if(inputString.equals("typeIV"))
        {
            this.mapping = new int[] { 4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1};
        }

        else if(inputString.equals("typeV"))
        {
            this.mapping = new int[] { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10};
        }

        for(int i=0;i<26;i++)
        {
            inverseMapping[mapping[i]] = i;
        }

    }

    @Override
    public int substitute(int inputNumber) {

        inputNumber = inputNumber - this.getPosition();

        if(inputNumber < 0)
        {
            inputNumber = inputNumber + 26;
        }

        inputNumber = this.mapping[inputNumber] + this.getPosition();

        if(inputNumber >= 26)
        {
            inputNumber = inputNumber - 26;
        }

        return inputNumber;
    }

    public int substituteBack(int passInteger)
    {
            passInteger = passInteger - this.getPosition();

        if(passInteger < 0)
        {
            passInteger = passInteger + 26;
        }

        passInteger = this.inverseMapping[passInteger] + this.getPosition();

        if(passInteger >= 26)
        {
            passInteger = passInteger - 26;
        }

        return passInteger;

    }

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


    public void setNextRotor(Rotor inputRotor){};
}
