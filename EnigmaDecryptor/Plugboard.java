/**
 @author Bogdan
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Plugboard {

    private ArrayList<Plug> myPlugboard = new ArrayList<Plug>();

    /**
     * Add the new Plug to the ArrayList{@link #myPlugboard}.
     * Each element from the ArrayList is selected using
     * an Iterator{@link #returnIterator()} and clashes
     * {@link Plug#classesWith} are checked against
     * the new Plug(created using the two sockets passed
     * as parameters: end1, end2
     *
     *
     * @param end1 First Socket of the Plug
     * @param end2 Second Socket of the Plug
     * @return boolean FALSE if there is a clash with
     *                       an already existing Plug
     *                 TRUE  if there is no clash
     */
    public boolean addPlug(char end1, char end2)
    {
        Plug newPlug = new Plug(end1,end2);
        Iterator<Plug> it = returnIterator();
        Plug plugInsideArray = null;

        while(it.hasNext())
        {

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
     * Return the plugs connected to the Plugboard
     *
     * @return The Plugs connected in the current Plugboard
     */
    public ArrayList<Plug> getPlugs()
    {
        return this.myPlugboard;
    }


    /**
     * Set the Plugboard of the current object to the Plugboard
     * passed as parameter
     *
     * @param inputPlugs passed Plugboard
     */
    public void setPlugboard(ArrayList<Plug> inputPlugs)
    {
        this.myPlugboard = inputPlugs;
    }


    /**
     * Get the total number of Plugs in the ArrayList
     *
     * @return int the number of Plugs already connected
     */
    public int getNumPlugs()
    {
        return myPlugboard.size();
    }


    /**
     * Remove all the Plugs from the ArrayList
     */
    public void clear()
    {
        myPlugboard.clear();

    }


    /**
     * Return an Iterator without exposing the list
     * @return Iterator
     */
    public Iterator returnIterator()
    {
        return myPlugboard.iterator();
    }


    /**
     * Each element from the ArrayList is selected using
     * an Iterator{@link #returnIterator()}.Each of the
     * sockets of the Plug is compared with the input
     * char newChar and if there is a match
     * the corresponding end is returned using
     * {@link Plug#encode(char)}, otherwise the
     * input char is returned
     *
     * @param newChar the letter to be substituted
     * @return char the encoded letter
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
