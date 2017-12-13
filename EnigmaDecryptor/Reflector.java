/**
 @author Bogdan
 */
public class Reflector extends Rotor {


    /**
     * Constructor
     * The type of the rotor is set and call {@link #initialise(String)}
     *
     * @param nameInput the type of the reflector passed
     * @throws Exception InvalidReflector
     */
    public Reflector(String nameInput) throws Exception {
        this.name = nameInput;
        this.initialise(nameInput);
    }

    /**
     * Set the mapping of the rotor based on the parameter.
     * After the mapping is set, do the inverse mapping
     *
     * @param inputString the type of the rotor as String
     * @throws Exception InvalidReflector
     */
    @Override
    protected void initialise(String inputString) throws Exception
    {
        switch (inputString)
        {
            case "ReflectorI":
                this.mapping = new int[]{24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19};
                break;
            case "ReflectorII":
                this.mapping = new int[]{ 5, 21, 15, 9, 8, 0, 14, 24, 4, 3, 17, 25, 23, 22, 6, 2, 19, 10, 20, 16, 18, 1, 13, 12, 7, 11 };
                break;
            default:
                throw new Exception("Wrong Rotor type");
        }
    }

    /**
     * The number passed as parameter is swapped with a different number
     * by using the mapping at that index
     *
     * @param inputNumber the character represented as an integer between 0-25
     * @return int the new chacater represented as int
     */
    @Override
    public int substitute(int inputNumber)
    {
        return this.mapping[inputNumber];
    }



}



