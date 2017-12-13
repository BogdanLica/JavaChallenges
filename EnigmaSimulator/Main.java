public class Main {

    public static void main(String[] args) throws Exception {
        TestEnigma myTest = new TestEnigma();

        System.out.println("***********TEST 1***********");
        System.out.println(myTest.test1());

        System.out.println("***********TEST 2***********");
        System.out.println(myTest.test2());

        System.out.println("***********TEST 3***********");
        System.out.println(myTest.test3());



        Bombe myBombe = new Bombe();
        System.out.println("***********Challenge 1***********");
        myBombe.findPlugs("JBZAQVEBRPEVPUOBXFLCPJQSYFJI");

        System.out.println("***********Challenge 2***********");
        myBombe.findPosition("AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD");

        System.out.println("***********Challenge 3***********");
        myBombe.findTypes("WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW");
    }


}
