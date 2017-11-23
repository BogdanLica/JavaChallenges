/**
 @author Bogdan
 */
public class Reflector extends Rotor {

    // Constructor
    public Reflector(String nameInput) throws Exception {
        this.name = nameInput;
        this.initialise(nameInput);
    }

    @Override
    protected void initialise(String inputString) throws Exception
    {
        switch (inputString)
        {
            case "ReflectorI":
                this.mapping = new int[]{24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19};
                break;
            case "ReflectorII":
                this.mapping = new int[]{24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19};
                break;
            default:
                throw new Exception("Wrong Rotor type");
        }
    }

    @Override
    public int substitute(int inputNumber)
    {
        return super.mapping[inputNumber];
    }

    @Override
    int substituteBack(int inputNumber) {
        return 0;
    }

    @Override
    void rotate() {

    }

    @Override
    void setNextRotor(Rotor inputRotor) {

    }

}



