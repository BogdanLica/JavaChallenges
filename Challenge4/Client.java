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
        int portNumber = Integer.parseInt(args[1]);
	String username=args[2];

        //int portNum = 20500;
	String host="localhost";
            try (Socket client = new Socket(host,portNum)) {
                try (PrintWriter writer = new PrintWriter(client.getOutputStream(),true)) {
                    try(BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
			System.out.println("Connection established");
                        String inputLine;

/*
			System.out.println("What is your name? ");
			Scanner textscan=new Scanner(System.in);
			username=textscan.nextLine();
			

			
*/
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

			while((inputLine = stdIn.readLine()) != null )
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
