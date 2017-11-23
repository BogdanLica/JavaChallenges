/**
 @author Bogdan
 */
public class Bombe {

    public static void main(String[] args) throws Exception {
        EnigmaMachine myEnigma = new EnigmaMachine();

        // Challenge 1
        /*
        char charA ='D';
        char charB = 'S';
        for(int i=0;i<26;i++)
        {
            char end2 = (char)(i+ 65);
            for(int j=0;j<26;j++)
            {
                char end2_2 = (char) (j + 65);
               if(myEnigma.addPlug(charA,end2))
               {
                   if(myEnigma.addPlug(charB,end2_2))
                   {
                       myEnigma.addRotor(new BasicRotor("typeIV",8),0);
                       myEnigma.addRotor(new BasicRotor("typeIII",4),1);
                       myEnigma.addRotor(new BasicRotor("typeII",21),2);

                       myEnigma.addReflector(new Reflector("ReflectorI"));
                       String inputToDecode = "JBZAQVEBRPEVPUOBXFLCPJQSYFJI";
                       StringBuilder sb = new StringBuilder();
                       char[] stringToCharArray = inputToDecode.toCharArray();

                       for(char output:stringToCharArray)
                       {
                           sb.append(myEnigma.encodeLetter(output));
                       }
                       if(sb.toString().contains("GIVEMEYOURANSWERDO"))
                       {
                           System.out.println(end2);
                           System.out.println(end2_2);
                           System.out.println(sb.toString());
                           System.out.println("****************");
                       }
                       myEnigma.clearPlugboard();
                   }

               }

                myEnigma.clearPlugboard();


            }
        }
        */
        // END CHALLENGE 1

        // CHALLENGE 2
        /*
        if(myEnigma.addPlug('H','L'))
        {
            if (myEnigma.addPlug('G', 'P'))
            {
                for(int i=0;i<25;i++)
                {
                    for(int j=0;j<25;j++)
                    {
                        for(int k=0;k<25;k++)
                        {
                            myEnigma.addRotor(new BasicRotor("typeV",i),0);
                            myEnigma.addRotor(new BasicRotor("typeIII",j),1);
                            myEnigma.addRotor(new BasicRotor("typeII",k),2);

                            myEnigma.addReflector(new Reflector("ReflectorI"));
                            String inputToDecode = "AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD";
                            StringBuilder sb = new StringBuilder();
                            char[] stringToCharArray = inputToDecode.toCharArray();

                            for(char output:stringToCharArray)
                            {
                                sb.append(myEnigma.encodeLetter(output));
                            }

                            if(sb.toString().contains("ELECTRIC"))
                            {
                                System.out.println("Position of the first rotor: " + i);
                                System.out.println("Position of the second rotor: " + j);
                                System.out.println("Position of the third rotor: " + k);
                            }

                        }

                    }                }

            }
        }
        */
        // END CHALLENGE 2

        // CHALLENGE 3
        /*
        if(myEnigma.addPlug('M','F'))
        {
            if (myEnigma.addPlug('O', 'I'))
            {
                for(int i=1;i<=5;i++)
                {
                    for(int j=1;j<=5;j++)
                    {
                        for(int k=1;k<=5;k++)
                        {
                            String firstRotorType,secondRotorType,thirdRotorType;
                            firstRotorType = checkType(i);
                            secondRotorType = checkType(j);
                            thirdRotorType = checkType(k);

                            myEnigma.addRotor(new BasicRotor(firstRotorType,22),0);
                            myEnigma.addRotor(new BasicRotor(secondRotorType,24),1);
                            myEnigma.addRotor(new BasicRotor(thirdRotorType,23),2);

                            myEnigma.addReflector(new Reflector("ReflectorI"));
                            String inputToDecode = "WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW";
                            StringBuilder sb = new StringBuilder();
                            char[] stringToCharArray = inputToDecode.toCharArray();

                            for(char output:stringToCharArray)
                            {
                                sb.append(myEnigma.encodeLetter(output));
                            }

                            if(sb.toString().contains("JAVA"))
                            {

                                System.out.println("First rotor: " + firstRotorType);
                                System.out.println("Second rotor: " + secondRotorType);
                                System.out.println("Third rotor: " + thirdRotorType);

                            }
                        }
                    }
                }
            }
        }
        */
        // END CHALLENGE 3


    }
    public static String checkType(int i)
    {
        switch (i){
            case 1:
                return "typeI";
            case 2:
                return "typeII";
            case 3:
                return "typeIII";
            case 4:
                return "typeIV";
            case 5:
                return "typeV";
            default:
                return "";
        }
    }
}
