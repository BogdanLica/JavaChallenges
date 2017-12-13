/**
 @author Bogdan
 */
public class TurnonverRotor extends BasicRotor {

    private int turnoverPosition ;
    private BasicRotor nextRotor;

    /**
     * Constructor
     * The type of the Rotor and the mapping are initialised
     * using the constructor of the parent class({@link BasicRotor})
     * The method of the TurnoverRotor 'initialise' is called
     * in 'super(inputString)' as BasicRotor uses 'this.initialise(this.name)',
     * where 'this.' refers to the TurnoverRotor
     *
     * @param inputString the type of the TurnoverRotor
     * @throws Exception InvalidRotorType
     */
    public TurnonverRotor(String inputString) throws Exception {

        super(inputString);
        super.initialise(inputString);

    }

    /**
     * Set the mapping of the rotor based on the parameter.
     * After the mapping is set, do the inverse mapping
     *
     * @param inputString the type of the rotor as String
     * @throws Exception InvalidRotorType
     */
    @Override
    protected void initialise(String inputString) throws Exception
    {

        switch (inputString){
            case "typeI":
                this.turnoverPosition = 24;
                break;

            case "typeII":
                this.turnoverPosition = 12;
                break;

            case "typeIII":
                this.turnoverPosition = 3;
                break;

            case "typeIV":
                this.turnoverPosition = 17;
                break;

            case "typeV":
                this.turnoverPosition = 7;
                break;

            default:
                throw new Exception("Wrong Rotor type");
        }

    }

    /**
     * Copy the reference to the next Rotor in the array in this object
     * @param nextRotor the next Rotor in the slot
     */
    public void setNextRotor(BasicRotor nextRotor)
    {
        this.nextRotor = nextRotor;
    }


    /**
     * Rotate the current Rotor.
     * The position of the current Rotor is increased using a call to the
     * {@link BasicRotor#rotate()}
     * If the new position is the turnoverPosition the next Rotor is rotated,
     * unless there is no reference to a next Rotor, so it is the Reflector.
     * (this happens recursively)
     */
    @Override
    public void rotate()
    {
        super.rotate();
        if(this.getPosition() == turnoverPosition)
        {
            if(this.nextRotor != null)
            {
                this.nextRotor.rotate();
            }
        }


    }
}
