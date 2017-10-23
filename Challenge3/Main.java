package com.company;

import java.util.Hashtable;

import java.io.*;

public class Main {

    public static void main(String[] args) throws  IOException {
        Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();



        int counter =0;
        FileRead myFile= new FileRead();
        myFile.FileRead("C:\\Users\\Bogdan\\IdeaProjects\\spaceCadetsWeek2\\src\\com\\company\\input.txt");
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

        int[] flag1_copy = new int[100];
        flag1_copy=flag.clone();


        for(int i=0;i<countLength;i++)
        {
            if(flag1_copy[i] == 0)
            {
                if(arrayOfLines[i].HasExtra()) {
                    numbers=maths(arrayOfLines,numbers,i);
                }

                else {
                    numbers = runLine(arrayOfLines, numbers, i);
                }
            }
            else
            {
                int x = numbers.get(arrayOfLines[i].getOperand());
                int positionWhile =i;
                int endWhile = findPair(flag1_copy,countLength,flag1_copy[i]);
                int compNum =arrayOfLines[i].getCompare();
                numbers = doWhile(arrayOfLines,numbers,flag1_copy,positionWhile,endWhile,x,countLength,compNum);
                 i = endWhile;
            }
        }


        //int x = numbers.get(arrayOfLines[index1].getOperand());




    }

    public static Hashtable<String, Integer> maths(Line[] arrayOfLines1,Hashtable<String, Integer> numbers1,int position)
    {
        int extraOperand = arrayOfLines1[position].getExtraOperand();
        String sign = arrayOfLines1[position].getSign();
        int valueOfOperand = numbers1.get(arrayOfLines1[position].getOperand());
        if (sign == "+") {
            valueOfOperand = valueOfOperand + extraOperand;
        } else if(sign == "-") {
            valueOfOperand = valueOfOperand - extraOperand;
        }
        else if(sign == "*")
        {
            int j=extraOperand;
            int initialOperand =valueOfOperand;
            int a=1;
            while(a<=j-1)
            {
                valueOfOperand = valueOfOperand + initialOperand;
                a++;
            }
            {

            }
        }
        else if(sign == "/")
        {
            valueOfOperand = valueOfOperand / extraOperand;

        }

        System.out.println(arrayOfLines1[position].nameOfoperand + ":" + valueOfOperand);
        numbers1.put(arrayOfLines1[position].getOperand(), valueOfOperand);
        return numbers1;


    }

    public static Hashtable<String, Integer> runLine(Line[] arrayOfLines1,Hashtable<String, Integer> numbers1,int position)
    {
        if(arrayOfLines1[position].type() != -2) {
            arrayOfLines1[position].performInstruction();
            int valueOfOperand = numbers1.get(arrayOfLines1[position].getOperand());
            valueOfOperand = valueOfOperand + arrayOfLines1[position].getOperandV();
            System.out.println(arrayOfLines1[position].nameOfoperand + ":" + valueOfOperand);
            numbers1.put(arrayOfLines1[position].getOperand(), valueOfOperand);

        }
        return numbers1;
    }
    public static Hashtable<String, Integer> doWhile(Line[] arrayOfLines1,Hashtable<String, Integer> numbers1, int[] flag,int start,int end,int x,int countLength1,int compNum1)
    {

            while(x != compNum1) {
                for(int q=start+1; q<end;q++)
                {
                if (flag[q] == 0) {
                    if(arrayOfLines1[q].HasExtra()) {
                        numbers1=maths(arrayOfLines1,numbers1,q);
                    }

                    else {
                        numbers1 = runLine(arrayOfLines1, numbers1, q);
                    }
                }
                else
                {
                    int newEnd=findPair(flag,countLength1,flag[q]);
                    int y = numbers1.get(arrayOfLines1[q].getOperand());
                    int compNum =arrayOfLines1[q].getCompare();
                    doWhile(arrayOfLines1,numbers1,flag,q,newEnd,y,countLength1,compNum);
                    q = newEnd;
                }
            }
            x = numbers1.get(arrayOfLines1[start].getOperand());
        }

        return numbers1;
    }

/*
    public static Hashtable<String, Integer> doIf(Line[] arrayOfLines1,Hashtable<String, Integer> numbers1, int[] flag,int start,int end,int x,int countLength1,int compNum1)
    {

        if(x != compNum1) {
            for(int q=start+1; q<end;q++)
            {
                if (flag[q] == 0) {
                    numbers1 = runLine(arrayOfLines1, numbers1, q);
                }
                else
                {
                    int newEnd=findPair(flag,countLength1,flag[q]);
                    int y = numbers1.get(arrayOfLines1[q].getOperand());
                    int compNum =arrayOfLines1[q].getCompare();
                    doIf(arrayOfLines1,numbers1,flag,q,newEnd,y,countLength1,compNum);
                    q = newEnd;
                }
            }
            x = numbers1.get(arrayOfLines1[start].getOperand());
        }

        return numbers1;
    }

*/
    public  static int findPair(int[] test,int lengthArr,int num)
    {
        int newNum =100;
        int value = num;

        for(int i = 0;i<lengthArr;i++)
        {
                if(value == test[i])
                {
                    newNum = i;
                }
            }

        return newNum;
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
