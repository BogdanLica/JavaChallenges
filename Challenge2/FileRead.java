package com.company;

import java.io.*;
import java.io.BufferedReader.*;
import java.io.InputStream.*;
import java.io.File.*;

public class FileRead{
	
	private String filePath="";
	private String StringInstructions="";
	
	public void FileRead(String pathInput) throws IOException
	{	
		FileInputStream txt = null;
        try
        {
             txt = new FileInputStream(pathInput);
        }
        catch (Exception e)
        {

            System.out.println("File not found");
        }


        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(txt));
        } catch (Exception e) {
            System.out.println("Reader error");
        }


        String text = "";
        StringBuilder line = new StringBuilder();


        while((text = br.readLine()) != null)
        {
            line.append(text);
            line.append("/");
        }
		
			br.close();
			txt.close();
        
        text=line.toString();
		
		this.setString(text);		
	}
	public void setString(String setS)
	{
		StringInstructions = setS;
			
	}
	public String getString()
	{
		
		return StringInstructions;
	}
	
	
	
}