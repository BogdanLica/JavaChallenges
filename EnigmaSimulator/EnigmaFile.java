import java.io.*;

public class EnigmaFile
{
    FileInputStream finstream;
    BufferedReader br;
    BufferedWriter writer;

    /**
     * Find the path of the file from which to read each line
     * Find the path of the directory and so create the path
     * of the FileWriter.
     *
     * @throws Exception File not found
     */
    public EnigmaFile() throws Exception
    {

        String path = Main.class.getClassLoader().getResource("filein.txt").getPath();
        File currentDirectory=new File(path);
        finstream = new FileInputStream(currentDirectory);


        String pathToWrite = path.replaceFirst("filein.txt","fileout.txt");
        File outputFile = new File(pathToWrite);
        br = new BufferedReader(new InputStreamReader(finstream));
        outputFile.createNewFile();
        FileWriter  fileWrite = new FileWriter(outputFile.getAbsoluteFile());
        writer = new BufferedWriter(fileWrite);


    }

    /**
     * Read the next line from the file
     *
     * @return String the next line from file
     * @throws IOException File not found
     */
    public String readFromFile() throws IOException {
        return br.readLine();
    }

    /**
     * Close both the file that you write into and
     * the file that you reed from
     *
     * @throws IOException File not found
     */
    public void closeFile() throws IOException {
        finstream.close();
        writer.close();
    }

    /**
     * Write the given String into the file specified in FileWriter
     *
     * @param messageToWrite String to be written to the file
     * @throws IOException File not found
     */
    public void writeToFile(String messageToWrite) throws IOException {
        writer.write(messageToWrite);
    }
}


