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
     * Returns the first socket of the Plug
     *
     * @return char the first socket of the Plug
     */
    public char getEnd1()
    {
        return this.end1;
    }

    /**
     * Returns the second socket of the Plug
     *
     * @return char the second socket of the Plug
     */
    public char getEnd2()
    {
        return this.end2;
    }

    /**
     * Set the first socket of the Plug to
     * the value of the parameter being passed
     *
     *
     * @param newEnd1 the socket to be connected
     */
    public void setEnd1(char newEnd1)
    {
        this.end1 = newEnd1;
    }

    /**
     * Set the second socket of the Plug to
     * the value of the parameter being passed
     *
     * @param newEnd2 the socket to be connected
     */
    public void setEnd2(char newEnd2)
    {
        this.end2 = newEnd2;
    }

    /**
     * Returns the encoded letter as char
     * If letterIn represents
     * a socket already connected to the Plug
     * the other socket of the Plug is returned
     * otherwise the original input letter is returned
     *
     * @param letterIn the letter to be changed
     * @return char the encoded letter
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
     * Checks if the Plugs inputPlug
     * and the current object try to connect
     * to a common socket.Each socket of a Plug is compared
     * with each of the sockets of the other Plug.
     *
     * @param inputPlug the plug to be checked
     * @return boolean TRUE if there is a common socket
     *                      between the two Plugs
     *                 FALSE otherwise
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
