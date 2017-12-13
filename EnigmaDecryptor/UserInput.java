import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {

    /**
     * Return the String returned by {@link #getMessage()}
     *
     * @return String the encoded message
     */
    public String getMessage()
    {
        return this.readMessage();
    }

    /**
     * Return the Sockets in an ArrayList returned by {@link #readPlugs()}
     *
     * @return ArrayList The plugs
     * @throws Exception InvalidPlugs
     */
    public ArrayList<Character> getPlugs() throws Exception
    {
        return this.readPlugs();
    }
 
    /**
     * Read the input using the command line
     * and return the line read
     *
     * @return the message to decode
     */
    private String readMessage()
    {
        System.out.println("Enter you message(divide it using space):  ");
        System.out.println("e.g: THIS IS THE SECRET MESSAGE  ");
        System.out.println("Message: ");

        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }


    /**
     * Ask the user to enter the sockets.Check if the configuration is valid
     * by creating an Enigma Machine where a connection is made between the sockets
     * (a Plug is created).Return an error if the sockets cannot be connected or
     * add the valid sockets to the ArrayList and at the end, return the ArrayList.
     *
     * @return ArrayList<Character> Each socket inputted by the user
     * @throws Exception Invalid Input
     */
    private ArrayList<Character> readPlugs() throws Exception {
        EnigmaMachine myEnigma = new EnigmaMachine();
        ArrayList<Character> myArray = new ArrayList<Character>();

        Scanner inputUser = new Scanner(System.in);
        System.out.println("How many plugs do you  want to enter? ");
        int numberOfPlugs = inputUser.nextInt();
        System.out.println("Enter the connected plugs in the form: \nPLUG-PLUG");
        System.out.println("*****************USE CAPS LOCK*****************");

        while(numberOfPlugs > 0)
        {
            String bothPlugs = inputUser.next();

            char firstPlug = bothPlugs.substring(0,bothPlugs.indexOf("-")).charAt(0);
            char secondPlug = bothPlugs.substring(bothPlugs.indexOf("-") + 1).charAt(0);

            if(validChars(firstPlug) && validChars(secondPlug))
            {
                if(!myEnigma.addPlug(firstPlug,secondPlug))
                {
                    System.out.println("One of the sockets is already connected to a plug.Re-enter the plug:");
                    numberOfPlugs++;
                }
                else
                {
                    myArray.add(firstPlug);
                    myArray.add(secondPlug);
                }
            }
            else
            {
                System.out.println("Invalid plugs. Re-enter the plug:");
                numberOfPlugs++;
            }

            numberOfPlugs--;



        }
        return myArray;
    }

    /**
     * Check if the input character is a
     * valid character(in the range A-Z)
     *
     * @param inputUser the char to be checked
     * @return boolean Flase/True
     */
    private static boolean validChars(char inputUser)
    {
        if((int)inputUser < 65 ||(int) inputUser > 90)
        {
            return false;
        }

        return true;
    }
}
