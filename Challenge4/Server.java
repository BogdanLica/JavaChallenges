import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.lang.System.in;

public class Server {
    public static void main(String args[])
    {

        
        if (args.length != 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);
        Process theProcess1 = null;
        Process theProcess2 = null;

        
        try (ServerSocket myServer = new ServerSocket(portNumber)) {
            try (Socket client = myServer.accept()) {
                try (PrintWriter writer = new PrintWriter(client.getOutputStream(),true)) {
                    try(BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
			            
                        System.out.println("Port " + portNumber + " open for connection");
			            StringBuilder sb = new StringBuilder();
                        String inputLine;
                        BufferedWriter outFile= null;

                        try
                        {
                            outFile = new BufferedWriter(new FileWriter("test.txt"));
                            

                        }
                        catch(IOException e)
                        {
                            System.out.println("Cannot create the file ");
                        }


                        while((inputLine = read.readLine()) != null )
                        {
			    
                            //sb.append(inputLine + "\n");
                            outFile.write(inputLine);
                            outFile.newLine();
                            System.out.println(inputLine);

                        }
			            //String final1 = sb.toString();
			            //System.out.println(final1);
                        try
                        {
                            theProcess1 = Runtime.getRuntime().exec("javac Main.java ");
                            theProcess2 = Runtime.getRuntime().exec("java Main ");
                            outFile.close();

                        }
                        catch(IOException e)
                        {
                            System.err.println("Error on exec() method");
                            e.printStackTrace();  
                        }
                        BufferedReader reader = new BufferedReader(new InputStreamReader(theProcess2.getInputStream()));
                        String printOutput;
                        while ((printOutput = reader.readLine()) != null) 
                        {
                            sb.append(printOutput);
                            
                        }
                        reader.close();
                        String showClient = sb.toString();
                        showClient = showClient.substring(showClient.indexOf("{")+1,showClient.indexOf("}"));

                        System.out.println();
                        System.out.println("***********************************************");
                        System.out.println("******************RESULTS**********************");
                        System.out.println("***********************************************");

                        showClient=showClient.replace(" =0,","");
                        System.out.println(showClient);
                        File oldFile = new File("test.txt");
                        oldFile.deleteOnExit();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
