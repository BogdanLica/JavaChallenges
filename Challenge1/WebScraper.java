package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";

        try {
            System.out.println("Enter an email id:");
            userInput = buffer.readLine();
        } catch (IOException e)

        {
            e.printStackTrace();
        }


        String finalUrl = setUrl(userInput);
       // System.out.println(finalUrl);

        // create an URL object out of the input
        URL website = null;
        try {
            website = new URL(finalUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


            BufferedReader inHTML = new BufferedReader(new InputStreamReader(website.openStream()));



        String line="";
        StringBuilder sb = new StringBuilder();

        while(((line = inHTML.readLine()) != null))
        {
            sb.append(line);

        }
        inHTML.close();

        String content = sb.toString();


        int startPosition = sb.indexOf("property=\"name\">") + 16;
        //there are 16 characters from the index to the end of the property="name">
        //System.out.println(startPosition);

        String startString = sb.substring(startPosition);

        //System.out.println(startString);
        int endPosition = startString.indexOf("<");
        String name = startString.substring(0,endPosition);



        System.out.println(name);



    }
    public static String setUrl(String userInput)
    {	String url = "http://www.ecs.soton.ac.uk/people/";
        int index = userInput.indexOf("@");

        url = url + userInput.substring(0,index);

        return url;
    }
}














