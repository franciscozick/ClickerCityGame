import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HelperMoney {
    private long initialMoney;
    private int numHelper1;
    private int numHelper2;
    private double help1Rate = 0.054;
    private double help2Rate = 0.13;
    private long moneyMade;
    int tracker = 0;

    public HelperMoney(Scanner statsReader) {
        while (statsReader.hasNext()) {
            statsReader.nextLine();
            numHelper1 = statsReader.nextInt();
            numHelper2 = statsReader.nextInt();
            System.out.println(numHelper1+"   "+numHelper2);
        }
    }
    public double makeMoney() {
        return ((numHelper1 * help1Rate) + (numHelper2 * help2Rate))/10;
    }
}


