/**
 @author Bogdan
 */
public class TurnonverRotor extends BasicRotor {

    private int turnoverPosition ;
    private Rotor nextRotor;

    public TurnonverRotor(String inputString, int inputPosition) throws Exception {
        super(inputString, inputPosition);
    }

    @Override
    protected void initialise(String inputString) throws Exception
    {
        super.initialise(inputString);

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

    public void setNextRotor(Rotor r1)
    {
        this.nextRotor = r1;
    }


    public void rotate()
    {
        super.rotate();
            if(this.getPosition() == turnoverPosition) {
                if(this.nextRotor != null) {
                   this.nextRotor.rotate();
                }
            }


    }
}
