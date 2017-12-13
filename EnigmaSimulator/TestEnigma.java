
public class TestEnigma {
    private EnigmaMachine myEnigma = new EnigmaMachine();

    public String test1() throws Exception
    {
        myEnigma.clearPlugboard();
        myEnigma.addPlug('A','M');
        myEnigma.addPlug('G','L');
        myEnigma.addPlug('E','T');

        BasicRotor firstRotor = new BasicRotor("typeI");
        myEnigma.addRotor(firstRotor,0);
        myEnigma.setPosition(0,6);

        BasicRotor secondRotor = new BasicRotor("typeII");
        myEnigma.addRotor(secondRotor,1);
        myEnigma.setPosition(1,12);

        BasicRotor thirdRotor = new BasicRotor("typeIII");
        myEnigma.addRotor(thirdRotor,2);
        myEnigma.setPosition(2,5);

        Reflector myReflector = new Reflector("ReflectorI");
        myEnigma.addReflector(myReflector);


        return myEnigma.start("GFWIQH");
    }
    public String test2() throws Exception
    {
        myEnigma.clearPlugboard();
        myEnigma.addPlug('B','C');
        myEnigma.addPlug('R','I');
        myEnigma.addPlug('S','M');
        myEnigma.addPlug('A','F');

        BasicRotor firstRotor = new BasicRotor("typeIV");
        myEnigma.addRotor(firstRotor,0);
        myEnigma.setPosition(0,23);

        BasicRotor secondRotor = new BasicRotor("typeV");
        myEnigma.addRotor(secondRotor,1);
        myEnigma.setPosition(1,4);

        BasicRotor thirdRotor = new BasicRotor("typeII");
        myEnigma.addRotor(thirdRotor,2);
        myEnigma.setPosition(2,9);

        Reflector myReflector = new Reflector("ReflectorII");
        myEnigma.addReflector(myReflector);


        return myEnigma.start("GACIG");
    }

    public String test3() throws Exception {
        EnigmaFile file = new EnigmaFile();

        myEnigma.clearPlugboard();
        myEnigma.addPlug('Q','F');

        TurnonverRotor firstRotor = new TurnonverRotor("typeI");
        myEnigma.addRotor(firstRotor,0);
        myEnigma.setPosition(0,23);

        TurnonverRotor secondRotor = new TurnonverRotor("typeII");
        myEnigma.addRotor(secondRotor,1);
        myEnigma.setPosition(1,11);
        firstRotor.setNextRotor(secondRotor);


        TurnonverRotor thirdRotor = new TurnonverRotor("typeIII");
        myEnigma.addRotor(thirdRotor,2);
        myEnigma.setPosition(2,7);
        secondRotor.setNextRotor(thirdRotor);

        Reflector myReflector = new Reflector("ReflectorI");
        myEnigma.addReflector(myReflector);

        String outputEnigma = myEnigma.start(file.readFromFile());
        file.writeToFile(outputEnigma);
        file.closeFile();

        return "CHECK THE FILE 'fileout.txt'";
    }


}
