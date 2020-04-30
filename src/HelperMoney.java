import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class HelperMoney {
    private long initialMoney;
    double[] helperRates= new double[2];
    double[] amountOfHelpers= new double[2];

    public HelperMoney(Scanner statsReader) {
        while (statsReader.hasNext()) {
            statsReader.nextLine();
            for(int i =0;i<amountOfHelpers.length;i++){
                amountOfHelpers[i]=statsReader.nextDouble();
                System.out.println(amountOfHelpers[i]);
            }
            helperRates[0]=0.01;
            helperRates[1]=0.1;
        }
    }
    public double makeMoney() {
        double money=0;
        for(int i =0;i<amountOfHelpers.length;i++){
            money+= amountOfHelpers[i]*helperRates[i];
        }
        return money;
    }
}


