package com.company;


public class Line {
   private int index=-1;
   private String opcodeAndOperand = "";
   private String opcode= "";
   public String nameOfoperand = "";
   private int valueOfoperand = 0;
   private int compare = 0;
   private int test = 0;


   private int extraOperand = -1;
   private String sign = "";

   
	
	public void setInstruction(String a,int indexInArray)
	{
		opcodeAndOperand = a;
        index = indexInArray;
        this.setOpcode();
        this.setType();
        if(test != -2) {
            this.checkSemicolon();

            this.setOperand();
        }


	}

	public void setType()
    {
        if(opcode.equals("while"))
        {
            test=-1;
        }
        else if(opcode.equals("end"))
        {
            test = 1;
        }

        else if(opcode.equals("**"))
        {
            test = -2;
        }

    }

    public void setExtraOperand(int inputU)
    {
        this.extraOperand = inputU;
    }
    public int getExtraOperand()
    {
       return  this.extraOperand;
    }
	
	public void checkSemicolon()
	{
		if (opcodeAndOperand.lastIndexOf(";") != opcodeAndOperand.length() - 1) {
				
                System.out.println("; missing at line  " + index);
				System.exit(0);
            }

            else if(opcodeAndOperand.lastIndexOf(";") != opcodeAndOperand.indexOf(";"))
            {
                System.out.println("; can only be put at the end of the instruction at line   " + index);
				System.exit(0);

            }
		
	}
	
	public void setOpcode()
    {
        opcodeAndOperand=opcodeAndOperand.trim();
        int semicolon = opcodeAndOperand.indexOf(";");
        int spaceIndex =opcodeAndOperand.indexOf(" ");
        if(spaceIndex != -1) {
            String check = opcodeAndOperand.substring(0, spaceIndex);
            opcode = check;

        }
        else
        {
            if(semicolon != -1)
            {
                opcode=opcodeAndOperand.substring(0,semicolon);
            }
        }

    }
    public String getSign()
    {

        return this.sign;
    }

    public boolean HasExtra()
    {
        if(this.extraOperand != -1)
        {
            return true;
        }
        return false;
    }


    public void setOperand() {

            if (this.test == -1) //|| this.test == -5
            {
                String copy = "";
                copy = opcodeAndOperand.replaceAll("[^-?0-9]+", "");
                copy = copy.substring(0, copy.length());
                this.compare = Integer.parseInt(copy);

            } else if (this.test == 10) {
                String copy = "";
                copy = opcodeAndOperand.replaceAll("[^-?0-9]+", "");
                copy = copy.substring(0, copy.length());
                this.compare = Integer.parseInt(copy);
            }
            if(opcodeAndOperand.contains("add"))
            {
                sign = "+";
                String copy = "";
                copy = opcodeAndOperand.replaceAll("[^-?0-9]+", "");
                copy = copy.substring(0, copy.length());
                this.extraOperand = Integer.parseInt(copy);
            }
            else if(opcodeAndOperand.contains("sub"))
            {
                sign = "-";
                String copy = "";
                copy = opcodeAndOperand.replaceAll("[^-?0-9]+", "");
                copy = copy.substring(0, copy.length());
                this.extraOperand = Integer.parseInt(copy);
            }
            else if(opcodeAndOperand.contains("mult"))
            {
                sign = "*";
                String copy = "";
                copy = opcodeAndOperand.replaceAll("[^-?0-9]+", "");
                copy = copy.substring(0, copy.length());
                this.extraOperand = Integer.parseInt(copy);
            }

            else if(opcodeAndOperand.contains("div"))
            {
                sign = "/";
                String copy = "";
                copy = opcodeAndOperand.replaceAll("[^-?0-9]+", "");
                copy = copy.substring(0, copy.length());
                this.extraOperand = Integer.parseInt(copy);
            }


            String copy = opcodeAndOperand.replaceAll("\\b( ?'s|while|not|0|do|end|incr|decr|clear|add|sub|mult|div|0|1|2|3|4|5|6|7|8|9|,| )\\b", "");
            copy = copy.substring(0, copy.length() - 1);
            if (copy.length() != 0) {
                nameOfoperand = copy;
            }


    }
        //this.compare = Integer.parseInt(copy);

    /*

    //String copy = opcodeAndOperand.replaceAll("\\b( ?'s|while|not|0|do|end|incr|decr|clear| |)\\b", "");
    	//String copy=opcodeAndOperand.substring(0,copy.length()-1);
        String copy="";
        copy = opcodeAndOperand.replaceAll("[^-?0-9]+", " ");
        copy = copy.substring(0,copy.length());
    	if(copy.length() != 0)
        {
            nameOfoperand = copy;
        }
        this.compare = Integer.parseInt(copy);
     */
    public String getOperand()
    {
        return this.nameOfoperand;
    }
    public int getOperandV()
    {
        return this.valueOfoperand;
    }
    public int getCompare()
    {
        return this.compare;
    }

    public int type()
    {
        return test;

    }
    public void performInstruction()
    {


        Commands myCommand = new Commands();

        switch (opcode)
        {
            case "clear":
                valueOfoperand = myCommand.clear(valueOfoperand);
                // add both the value and the name into a 2-d list
                break;

            case "incr":
                valueOfoperand = myCommand.incr(valueOfoperand);
                //update the value into the 2-d list
                break;

            case "decr":
                valueOfoperand = myCommand.decr(valueOfoperand);

                break;

            case "while":
                test = -1;

                break;

            case "end":
                test = 1;

                break;
            /*
                case "add":
                valueOfoperand = myCommand.num(compare);
                break;
*/
            default:
                System.out.println("Wrong syntax at line " + index);
                System.exit(0);

        }


    }


	
	
	
	
	


}
