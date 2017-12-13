import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Matches implements Callable<ArrayList<String>> {
    private ArrayList<String> currentOutput = new ArrayList<String>();
    private ArrayList<String> humanWords = new ArrayList<String>();
    private Dictionary englishDict;


    /**
     * Constructor
     * Make a local copy of the decodedMessages
     * Create a new Dictionary
     *
     * @param decodedMessages the decoded message
     * @throws FileNotFoundException File not found
     */
    public Matches(ArrayList<String> decodedMessages) throws FileNotFoundException
    {
        this.currentOutput = decodedMessages;
        this.englishDict = new Dictionary();
    }


    /**
     * Take each String from the ArrayList and store it in a String
     * representing the full message. Divide it into smaller Strings
     * and check if they are valid according to the Dictionary.
     * If all the words are valid, then add the message to the
     * {@link #humanWords} which contains all the valid messages
     *
     * @return ArrayList valid messages
     * @throws Exception File not Found
     */
    @Override
    public ArrayList<String> call() throws Exception
    {
        for(String currentMessage : this.currentOutput)
        {
            String[] temp = currentMessage.split(" ");

            int counter=0;
            for(int i=0;i<temp.length;i++)
            {
                if(this.englishDict.checkIFExist(temp[i]))
                {
                    counter++;
                }
            }

            if(temp.length == counter )
            {
                this.humanWords.add(currentMessage);
            }

        }
        return humanWords;
    }


}
