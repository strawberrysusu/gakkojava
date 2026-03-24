package daelim.java_ch02;

public class MyCalculator {

    public void calculator(int fNum, int sNum, ICalculator calculator) {
        int value = calculator.doOperation(fNum, sNum);
        System.out.println("result : " + value);
    }
}
