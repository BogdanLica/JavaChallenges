import java.io.*;

public class EnigmaFile {
    public static void main(String[] args)
    {
        EnigmaMachine myEnigma = new EnigmaMachine();


        try
        {
            FileInputStream finstream = new FileInputStream("C:\\Users\\Bogdan\\IdeaProjects\\enigma\\src\\filein.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(finstream));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Bogdan\\IdeaProjects\\enigma\\src\\fileout.txt"));
            String currentLine;


            while((currentLine= br.readLine()) != null)
            {
                String encodedLine = myEnigma.start(currentLine);

                writer.write(encodedLine);
            }

            finstream.close();
            writer.close();


        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}
