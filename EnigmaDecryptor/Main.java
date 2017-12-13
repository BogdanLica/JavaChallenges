
public class Main {

    public static void main(String[] args) throws Exception {

        UserInput handleInput = new UserInput();
        Compute find = new Compute(handleInput.getMessage(),handleInput.getPlugs());
        find.start();

    }



}
