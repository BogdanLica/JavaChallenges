/**
 @author Bogdan
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Plugboard {

    ArrayList<Plug> myPlugboard = new ArrayList<Plug>();

    /**
     * Add the new Plug to the ArrayList myPlugboard
     * @param end1 First Socket of the Plug
     * @param end2 Second Socket of the Plug
     * @return boolean FALSE if there is a clash with an already existing Plug
     * @return boolean TRUE if there is no clash
     */
    public boolean addPlug(char end1, char end2)
    {
        Plug newPlug = new Plug(end1,end2);
        Iterator<Plug> it = returnIterator();

        while(it.hasNext())
        {
            Plug plugInsideArray =null;
            plugInsideArray= it.next();

            if(plugInsideArray.classesWith(newPlug))
            {
                return false;
            }

        }

        myPlugboard.add(newPlug);
        return true;
    }

    /**
     * Get the number of Plugs
     * @return int The total number of Plugs already connected
     */
    public int getNumPlugs()
    {
        return myPlugboard.size();
    }


    /**
     * Remove all the Plugs
     * @return Nothing
     */
    public void clear()
    {
        myPlugboard.clear();

    }


    /**
     * TO-DO
     * @return An iterator
     */
    public Iterator returnIterator()
    {
        return myPlugboard.iterator();
    }


    /**
     * Substitute the input char with the other end of the Socket
     * If the input char is not connected to a
     * @return char The other end of the Plug if there is a Socket connected
     * @return char The input char if there is no Socket connected
     */
    public char substitute(char newChar)
    {

        Iterator<Plug> it = returnIterator();

        while(it.hasNext())
        {
            Plug newPlug = it.next();

            if(newPlug.getEnd1() == newChar || newPlug.getEnd2() == newChar)
            {
                return newPlug.encode(newChar);

            }

        }

        return newChar;
    }

}
