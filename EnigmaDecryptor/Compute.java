import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Compute {
    private ArrayList<String> database;
    private ArrayList<Character> plugs ;
    private String message;

    /**
     * Constructor
     * Save the message and the sockets inputted by the user
     *
     * @param messageToDecode the secret message inputted by the user
     * @param inputPlugs thesockets inputted by the user
     */
    public Compute(String messageToDecode,ArrayList<Character> inputPlugs)
    {
        this.message = messageToDecode;
        this.plugs = inputPlugs;
        this.database = new ArrayList<String>();
    }

    /**
     * Compute all the possible messages
     * Find any possible matches
     * Return the result
     * @throws Exception FileNotFound,InvalidRotorType
     */
    public void start() throws Exception {
        this.database =decodeMessage(message,plugs);
        this.database = findMatches(this.database);
        this.computeResult();

    }

    /**
     * If after all the decoding and then matching,
     * no sentences makes sense in English, return a message
     * otherwise return the Strings that are valid
     */
    public void computeResult()
    {
        
        if(this.database.size() == 0)
        {
            System.out.println("Sorry, I could not find any matches......");
        }
        else
        {
            for(String currentMessage:this.database)
            {
                System.out.println(currentMessage);

            }
        }
        

    }

    /**
     * Get the Reflector type by input from the user .
     * Create an ExecutorService which handles
     * the 25 Threads that are running.Each Thread will create
     * a Bombe object that will compute all the possible decoded messages.
     * The results from each Thread is stored in a an ArrayList called 'set'
     * and each message is added to an ArrayList which will ultimately contain
     * all the computed possible decoded messages
     *
     *
     * @param secretMessage The message to be decoded
     * @param inputPlugs The Plugs inputted by the user
     * @return ArrayList with all the possible decoded messages
     */
    private ArrayList<String> decodeMessage(String secretMessage,ArrayList<Character> inputPlugs) throws Exception
    {
        
        ExecutorService poolOfThreads = Executors.newFixedThreadPool(25);
        ArrayList<String> currentdatabase = new ArrayList<String>();
        System.out.println("DECODING THE SECRET MESSAGE.......");
        ArrayList<Future<ArrayList<String>>> set = new ArrayList<Future<ArrayList<String>>>();
        for(int q=1;q<3;q++)
        {
            for(int i=1;i<=5;i++) 
            {
                for (int j = 1; j <= 5; j++)
                {
                    for (int k = 1; k <= 5; k++)
                    {
                    Future<ArrayList<String>> result = poolOfThreads.submit(new Bombe(secretMessage,i,j,k,q,inputPlugs));
                    set.add(result);
                    }
                }
            }
        }
        
        for(Future<ArrayList<String>> currentResultThread : set)
        {
            ArrayList<String> current = currentResultThread.get();

            for(String message : current)
            {
                currentdatabase.add(message);
            }


        }

        poolOfThreads.shutdown();
        return currentdatabase;

    }


    /**
     * There are 3,906,250 messages, so dividing it into 50 different pieces means
     * that the size of each is 78125.Create an ExecutorService which handles
     * the 25 Threads that are running.Each Thread will create
     * a Matches object that will compute all the valid decoded messages.
     * The results from each Thread is stored in a an ArrayList called 'set'
     * and each message is added to an ArrayList which will ultimately contain
     * all the computed possible valid decoded messages
     *
     * @param database ArrayList with all the possible decoded messages
     * @return ArrayList with all the valid messages
     * @throws FileNotFoundException File not found
     * @throws ExecutionException Concurrency error
     * @throws InterruptedException Concurrency error
     */
    public ArrayList<String> findMatches(ArrayList<String> database) throws FileNotFoundException, ExecutionException, InterruptedException
    {
        int size = 78125;
        int i = 0;
        ExecutorService poolOfThreads = Executors.newFixedThreadPool(25);
        ArrayList<String> currentdatabase = new ArrayList<String>();
        System.out.println("FINDING MATCHES.......");


        ArrayList<Future<ArrayList<String>>> set = new ArrayList<Future<ArrayList<String>>>();

        Future<ArrayList<String>> result;
        while (i + size <= database.size())
        {
                ArrayList<String> temp = new ArrayList<String>(database.subList(i,i+ size));
                result = poolOfThreads.submit(new Matches(temp));
                i = i + size + 1;
                set.add(result);


        }


        if(database.size() - i < size)
        {
            ArrayList<String> temp = new ArrayList<String>(database.subList(i,database.size()));

            result = poolOfThreads.submit(new Matches(temp));
            set.add(result);


        }

        for(Future<ArrayList<String>> currentResultThread : set)
        {
            ArrayList<String> current = currentResultThread.get();

            for(String message : current)
            {
                currentdatabase.add(message);
            }

        }

        System.out.println("FINDING A GOOD DICTIONARY......");
        TimeUnit.SECONDS.sleep(1);

        poolOfThreads.shutdown();
        return currentdatabase;
    }


}
