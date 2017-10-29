import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)
    {

        if (args.length != 1) {
            System.err.println("Usage: java Client <port number>");
            System.exit(1);
        }


        int portNumber = Integer.parseInt(args[0]);
 
        String host="localhost";
        try (Socket client = new Socket(host,portNumber)) {
            try (PrintWriter writer = new PrintWriter(client.getOutputStream(),true)) {
                try(BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                    System.out.println("Connection established");
                    String inputLine;

                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

                    while(!((inputLine = stdIn.readLine()).equals("EXIT")))
                        {
                            writer.println(inputLine);
                
                        }                  
                    
                      
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
