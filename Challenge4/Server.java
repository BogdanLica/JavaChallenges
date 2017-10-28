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

        int portNum = Integer.parseInt(args[0]);
     

        //int portNum = 20500;
        try (ServerSocket myServer = new ServerSocket(portNum)) {
            try (Socket client = myServer.accept()) {
                try (PrintWriter writer = new PrintWriter(client.getOutputStream(),true)) {
                    try(BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
			System.out.println("Port " + portNum + " open for connection");
			//StringBuilder sb = new StringBuilder();
                        String inputLine;
/*
			String username1="";
			username1=read.readLine();
			
*/
                        while((inputLine = read.readLine()) != null )
                        {
			    
                            //sb.append(inputLine + "\n");
			    System.out.println(inputLine);

                        }
			//String final1 = sb.toString();
			//System.out.println(final1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
    https://docs.oracle.com/javase/tutorial/networking/sockets/examples/KnockKnockClient.java
    http://www.oracle.com/technetwork/java/socket-140484.html
    http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html
    https://secure.ecs.soton.ac.uk/student/wiki/w/COMP1202/Space_Cadets/SCChallengeNetworking

     */


}
