/**
 @author Bogdan
 */
public class Plug {
    private char end1,end2;

    // Constructor
    public Plug(char inputEnd1,char inputEnd2)
    {
        this.setEnd1(inputEnd1);
        this.setEnd2(inputEnd2);
    }

    /**
     * Get the first socket
     * @return char It return the first socket of the plug
     */
    public char getEnd1()
    {
        return this.end1;
    }

    /**
     * Get the second socket
     * @return char It return the second socket of the plug
     */
    public char getEnd2()
    {
        return this.end2;
    }

    /**
     * Set the second socket of the Plug
     * @param newEnd1 the socket to be connected
     * @return Nothing
     */
    public void setEnd1(char newEnd1)
    {
        this.end1 = newEnd1;
    }

    /**
     * Set the second socket of the Plug
     * @param newEnd2 the socket to be connected
     * @return no return
     */
    public void setEnd2(char newEnd2)
    {
        this.end2 = newEnd2;
    }

    /**
     * Returns the encoded letter
     * If the letter is not either end of the plug,the input letter is returned
     * Otherwise the other end of the Plug is returned
     * @param letterIn the letter to be changed
     * @return the encoded letter
     */
    public char encode(char letterIn)
    {
        if(letterIn == this.end1)
        {
            return this.end2;
        }

        else if(letterIn == this.end2)
        {
            return this.end1;
        }

        return letterIn;
    }

    /**
     * Check if the two Plugs have a socket in common
     * @param inputPlug the plug to be checked
     * @return FALSE if there is no clash
     */
    public boolean classesWith(Plug inputPlug)
    {
        if(this.end1 == inputPlug.end1 || this.end1 == inputPlug.end2 || this.end1 == this.end2)
        {
            return true;
        }
        else if(this.end2 == inputPlug.end1 || this.end2 == inputPlug.end2 || inputPlug.end1 == inputPlug.end2)
        {
            return true;
        }

        return false;
    }

}
