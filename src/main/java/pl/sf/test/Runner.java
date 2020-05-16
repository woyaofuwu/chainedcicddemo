package pl.sf.test;


public class Runner {

    static private String secretstr = "ocp";

    public String getSecret(){
        return secretstr;
    }

    public static void main(String[] args) {
        System.out.printf("hello " + new Runner().getSecret());
    }

}

