import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HelperMoney {
    private double[] helperRates= new double[10];
    private double[] amountOfHelpers= new double[10];

    public void setAmountOfHelpers(int index) {
        amountOfHelpers[index]+=1;
    }

    public HelperMoney(Scanner statsReader) {
        while (statsReader.hasNext()) {
            statsReader.nextLine();
            for(int i =0;i<amountOfHelpers.length;i++){
                amountOfHelpers[i]=statsReader.nextDouble();
                System.out.println(amountOfHelpers[i]);
            }
            for(int i =0;i<helperRates.length;i++){
                helperRates[i]=statsReader.nextDouble();
                System.out.println(helperRates[i]);
            }
        }
    }
    public double makeMoney() {
        double money=0;
        for(int i =0;i<amountOfHelpers.length;i++){
            money+= amountOfHelpers[i]*helperRates[i];
        }
        return money+1;
    }
    public double moneyPerSecond(){
        Double moneyPer=0.0;
        for(int i =0;i<amountOfHelpers.length;i++){
            moneyPer+= amountOfHelpers[i]*helperRates[i];
        }
        //moneyPer.toFixed(2);
        return moneyPer;
    }
}


