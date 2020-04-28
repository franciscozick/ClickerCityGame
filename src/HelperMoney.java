import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HelperMoney{
    private long initialMoney;
    private  int numHelper1;
    private int numHelper2;
    private double help1Rate=0.05;
    private double help2Rate=0;
    private long moneyMade;
    int tracker = 0;

    public HelperMoney(Scanner statsReader) throws FileNotFoundException {

        while (statsReader.hasNext()) {
            statsReader.nextLine();
            numHelper1 = statsReader.nextInt();
            numHelper2 = statsReader.nextInt();
            //help1Rate = inRate1;
            //help2Rate = inRate2;

        }
    }

    public long calculateMoney(){

        return moneyMade;

    }
    public void makeMoney(){
        moneyMade+=(numHelper1*help1Rate)+(numHelper2*help2Rate);
    }
}


