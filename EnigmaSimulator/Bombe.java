/**
 @author Bogdan
 */
public class Bombe {

    private EnigmaMachine myEnigma = new EnigmaMachine();

    /**
     * CHALLENGE 1
     *
     * Given the Rotor type of all 3 rotors, their position
     * and 2 Plugs, but with one one socket for each.
     * Two loops are used to go through all possible combinations
     * of characters(25 x 25 = 625) by taking an integer from 0 to 25,
     * adding 65 to convert it into a char.After that,an Enigma with the
     * specified settings is created and the decoded message,along with
     * the missing plugs are outputted only if the message contains a
     * sequence of characters pre-defined.
     *
     * @param messageToDecode the encoded message
     * @throws Exception InvalidRotorType,InvalidReflectorType
     */
    public void findPlugs(String messageToDecode) throws Exception {

        myEnigma.clearPlugboard();
        char fPlugEnd1 ='D';
        char sPlugEnd1 = 'S';

        for(int i=0;i<26;i++)
        {
            char fPlugEnd2 = (char)(i+ 65);
            for(int j=0;j<26;j++)
            {
                char sPlugEnd2 = (char) (j + 65);
                if(myEnigma.addPlug(fPlugEnd1,fPlugEnd2))
                {
                    if(myEnigma.addPlug(sPlugEnd1,sPlugEnd2))
                    {
                        BasicRotor firstRotor = new BasicRotor("typeIV");
                        firstRotor.setPosition(8);
                        myEnigma.addRotor(firstRotor,0);

                        BasicRotor secondRotor = new BasicRotor("typeIII");
                        secondRotor.setPosition(4);
                        myEnigma.addRotor(secondRotor,1);

                        BasicRotor thirdRotor = new BasicRotor("typeII");
                        thirdRotor.setPosition(21);
                        myEnigma.addRotor(thirdRotor,2);

                        Reflector myReflector = new Reflector("ReflectorI");
                        myEnigma.addReflector(myReflector);

                        String outputEnigma = myEnigma.start(messageToDecode);

                        if(outputEnigma.contains("GIVEMEYOURANSWERDO"))
                        {
                            System.out.println(fPlugEnd1 + " - " + fPlugEnd2);
                            System.out.println(sPlugEnd1 + " - " + sPlugEnd2);
                            System.out.println("Message: " + outputEnigma);
                        }

                        myEnigma.clearPlugboard();
                    }

                }

                myEnigma.clearPlugboard();


            }
        }

    }


    /**
     * CHALLENGE 2
     *
     * Given the Rotor type of all 3 rotors and 2 Plugs.
     * Three loops are used to go through all possible combinations
     * of positions(25 x 25 x 25 = 15625) by taking an integer from 0 to 25,
     * representing that position for each Rotor.After that,an Enigma with the
     * specified settings is created and the decoded message,along with
     * the unknown positions are outputted only if the message contains a
     * sequence of characters pre-defined.
     *
     * @param messageToDecode the encoded message
     * @throws Exception InvalidRotorType,InvalidReflectorType
     */
    public void findPosition(String messageToDecode) throws Exception
    {
        myEnigma.clearPlugboard();
        myEnigma.addPlug('H','L');
        myEnigma.addPlug('G','P');

        for(int i=0;i<25;i++)
        {
            for(int j=0;j<25;j++)
            {
                for(int k=0;k<25;k++)
                {
                    BasicRotor firstRotor = new BasicRotor("typeV");
                    firstRotor.setPosition(i);
                    myEnigma.addRotor(firstRotor,0);

                    BasicRotor secondRotor = new BasicRotor("typeIII");
                    secondRotor.setPosition(j);
                    myEnigma.addRotor(secondRotor,1);

                    BasicRotor thirdRotor = new BasicRotor("typeII");
                    thirdRotor.setPosition(k);
                    myEnigma.addRotor(thirdRotor,2);

                    Reflector myReflector = new Reflector("ReflectorI");
                    myEnigma.addReflector(myReflector);

                    String outputEnigma = myEnigma.start(messageToDecode);

                    if(outputEnigma.contains("ELECTRIC"))
                    {
                        System.out.println("Position of the first rotor: " + i);
                        System.out.println("Position of the second rotor: " + j);
                        System.out.println("Position of the third rotor: " + k);
                        System.out.println("Message: " + outputEnigma);
                    }

                }

            }
        }


    }


    /**
     * CHALLENGE 3
     *
     * Given the Rotor positions of all 3 rotors and 2 Plugs.
     * Three loops are used to go through all possible combinations
     * of types(5 x 5 x 5 = 125) by taking an integer from 0 to 5,
     * representing that type of each Rotor.To change the integer
     * representation into a String , a call to {@link #checkType(int)}
     * it made.After that,an Enigma with the specified settings is created
     * and the decoded message,along with the unknown types are outputted
     * only if the message contains a sequence of characters pre-defined.
     *
     * @param messageToDecode the encoded message
     * @throws Exception InvalidRotorType,InvalidReflectorType
     */
    public void findTypes(String messageToDecode) throws Exception
    {
        myEnigma.clearPlugboard();
        myEnigma.addPlug('M','F');
        myEnigma.addPlug('O','I');

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

                    BasicRotor firstRotor = new BasicRotor(firstRotorType);
                    firstRotor.setPosition(22);
                    myEnigma.addRotor(firstRotor,0);

                    BasicRotor secondRotor = new BasicRotor(secondRotorType);
                    secondRotor.setPosition(24);
                    myEnigma.addRotor(secondRotor,1);

                    BasicRotor thirdRotor = new BasicRotor(thirdRotorType);
                    thirdRotor.setPosition(23);
                    myEnigma.addRotor(thirdRotor,2);

                    Reflector myReflector = new Reflector("ReflectorI");
                    myEnigma.addReflector(myReflector);

                    String outputEnigma = myEnigma.start(messageToDecode);


                    if(outputEnigma.contains("JAVA"))
                    {

                        System.out.println("First rotor: " + firstRotorType);
                        System.out.println("Second rotor: " + secondRotorType);
                        System.out.println("Third rotor: " + thirdRotorType);
                        System.out.println("Message: " + outputEnigma);
                    }

                }
            }
        }


    }


    /**
     * Swap from an integer representing the type to the String representation
     * @param i the type as Integer
     * @return the type as String
     */
    private static String checkType(int i)
    {
        switch (i)
        {
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
