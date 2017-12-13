import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Dictionary {

    Set<String> english;

    /**
     * Constructor
     * Locate the file from which each line is read, capitalised
     * and submitted to the HashSet as a new entry
     *
     * @throws FileNotFoundException File not found
     */
    public Dictionary() throws FileNotFoundException {
        File currentDirectory=new File(Main.class.getClassLoader().getResource("words.txt").getPath());
        Scanner file = new Scanner(currentDirectory);

         english = new HashSet<String>();

        while (file.hasNext()) {
            english.add(file.next().toUpperCase());

        }

    }

    /**
     * If there is an entry in the HashSet of the parameter
     * being passed then TRUE is returned, otherwise FALSE is returned
     *
     * @param checkWord the input word
     * @return boolean Valid word or not
     */
    public boolean checkIFExist(String checkWord)
    {
        if(this.english.contains(checkWord))
        {
            return true;
        }
        return false;
    }
}
