package com.company;

import java.util.Hashtable;

import java.io.*;

public class Main {

    public static void main(String[] args) throws  IOException {
        Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();

		int counter =0;
		FileRead myFile= new FileRead();
		myFile.FileRead("path\\input.txt");
		String wholeInstructions = "";
		wholeInstructions=myFile.getString();
		
		Line[] arrayOfLines = new Line[100];
		int countLength=0;
		 countLength = wholeInstructions.length() - wholeInstructions.replaceAll("/","").length();

		for(int i=0;i<countLength;i++)
		{
			arrayOfLines[i] = new Line();
		}


		int[] flag = new int[100];


		do {
			String currentLine = wholeInstructions.substring(0, wholeInstructions.indexOf("/"));
			wholeInstructions = wholeInstructions.substring(wholeInstructions.indexOf("/") + 1);
			arrayOfLines[counter].setInstruction(currentLine,counter);
			flag[counter] = arrayOfLines[counter].type();
			numbers.put(arrayOfLines[counter].getOperand(),0);
			counter++;
		}
		while(wholeInstructions.length() != 0) ;



		///WORKS Map the while-end pairs
        int counter2 = 11;
        for(int i =0;i <counter;i++)
        {
            if(flag[i] == 1)
            {
                flag[i] = counter2;
                for(int j = i;j>=0;j--)
                {

                    if(flag[j] == -1)
                    {
                        flag[j] = counter2;
                        break;
                    }


                }
                counter2++;
            }


        }
        for(int i = 0; i < counter; i++)
        {
            if(flag[i] == -1 || flag[i] == 1)
            {
                System.out.println("Syntax error");
                System.exit(0);

            }
        }
        for(int i = 0; i < counter; i++)
        {
            if(flag[i] != 0) {
                flag[i] = flag[i] - 10;
            }
        }


		// Check from here
		//boolean[] flag2 = new boolean[100];
        int[] flag1_copy = new int[100];
        flag1_copy=flag.clone();
        //System.arraycopy(flag,0,flag1_copy,0,flag.length),0;

		int inde=0;
		int index1 = 0,index2 = 0;
        index1=findNext1(flag1_copy,countLength);
        index2=findNext2(flag1_copy,countLength);

		int prev1=0,prev2 = 0;

        int positionWhile =findMax(flag1_copy,countLength);
        while(inde < positionWhile) {
                    arrayOfLines[inde].performInstruction();
                    int valueOfOperand = numbers.get(arrayOfLines[inde].getOperand());
                    valueOfOperand = valueOfOperand + arrayOfLines[inde].getOperandV();
                    System.out.println(arrayOfLines[inde].nameOfoperand + ":" + valueOfOperand);
                    numbers.put(arrayOfLines[inde].getOperand(), valueOfOperand);
                    //flag2[inde] = true;
                    inde++;
                }
        inde++;

		while(flag1_copy[index1] != 100)
		{

            while(inde < index1) {
                arrayOfLines[inde].performInstruction();
                int valueOfOperand = numbers.get(arrayOfLines[inde].getOperand());
                valueOfOperand = valueOfOperand +arrayOfLines[inde].getOperandV();
                System.out.println(arrayOfLines[inde].nameOfoperand + ":" + valueOfOperand);
                numbers.put(arrayOfLines[inde].getOperand(), valueOfOperand);
                inde++;
            }

			int x = numbers.get(arrayOfLines[index1].getOperand());
			while(x != 0)
			{
                int k =index1 + 1;
                    while (k < index2) {

                        //if(flag2[k] == false) {

                            arrayOfLines[k].performInstruction();
                            int valueOfOperand = numbers.get(arrayOfLines[k].getOperand());
                            valueOfOperand = valueOfOperand +arrayOfLines[k].getOperandV();
                            System.out.println(arrayOfLines[k].nameOfoperand + ":" + valueOfOperand);
                            numbers.put(arrayOfLines[k].getOperand(), valueOfOperand);

                        //}
                        k++;

                    }
                x = numbers.get(arrayOfLines[index1].getOperand());


			}
			/*for(int t=index1;t<=index2;t++)
            {
                flag2[t] = true;
            }
*/
			prev1=index1;
			prev2 = index2;
            if(prev1 !=0 && prev2 != 0 ) {
                flag1_copy[prev1] = 100;
                flag1_copy[prev2] = 100;

            }
/*
            if(prev1 == 100 && prev2 == 100)
            {
                for(int t=prev1;t<=prev2;t++)
                {
                    flag2[t] = false;
                }

            }
            */
            index1=findNext1(flag1_copy,countLength);
            index2=findNext2(flag1_copy,countLength);
            inde=index1;
            if(inde < prev1)
            {
                flag1_copy=flag.clone();
            }

		}



        }



	public static int findNext1(int[] test,int lengthArr)
	{
		int last = 100;
		int first =100;
		int min=999;

		for(int i = 0;i<lengthArr;i++)
		{
			if(test[i] != 0)
            {
                if(min > test[i])
                {
                    min=test[i];
                    first=i;
                }
            }


		}

        return first;

	}



    public static int findNext2(int[] test,int lengthArr)
    {
        int last = 100;
        int min =999;

        for(int i = 0;i<lengthArr;i++)
        {
            if(test[i] != 0) {
                if (min >= test[i]) {
                    min = test[i];
                    last = i;
                }
            }

        }

        return last;


    }
    public static int findMax(int[] test,int lengthArr)
    {
        int find = 100;
        int max =-999;

        for(int i = 0;i<lengthArr;i++)
        {
            if((test[i] != 0)&&(test[i] != 100)) {
                if (max <= test[i]) {
                    max = test[i];
                    find = i;
                    return find;
                }
            }

        }

        return 0;

    }



}
