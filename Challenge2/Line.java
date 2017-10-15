package com.company;


public class Line {
   private int index=-1;
   private String opcodeAndOperand = "";
   private String opcode= "";
   public String nameOfoperand = "";
   private int valueOfoperand = 0;

   private int test = 0;

   
	
	public void setInstruction(String a,int indexInArray)
	{
		opcodeAndOperand = a;
        index = indexInArray;		
		this.checkSemicolon();
		this.setOpcode();
		this.setOperand();
		this.setType();

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

    public void setOperand()
    {
        
    	String copy = opcodeAndOperand.replaceAll("\\b( ?'s|while|not|0|do|end|incr|decr|clear| |)\\b", "");
    	copy=copy.substring(0,copy.length()-1);

    	if(copy.length() != 0)
        {
            nameOfoperand = copy;
        }
    }
    public String getOperand()
    {
        return this.nameOfoperand;
    }
    public int getOperandV()
    {
        return this.valueOfoperand;
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

            default:
                System.out.println("Wrong syntax at line " + index);
                System.exit(0);

        }


    }


	
	
	
	
	


}
