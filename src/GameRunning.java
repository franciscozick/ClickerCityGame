import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameRunning {
    //Needs tick stuff
    //How to run it
    MouseClicks jeff;
    HelperMoney josh;
    String name;
    long money;
public  long getMoney(){
    return money;
}
public void setMoney(long add){
    money+=add;
}
public void tick(){
    money+=josh.makeMoney();
    }
    private long checkMoney()
    {
    return 0;
    }
    public GameRunning(String fileInput) throws FileNotFoundException {
        File playerStats = new File(fileInput);
        Scanner statsReader = new Scanner(playerStats);
        name=statsReader.nextLine();
        money=statsReader.nextInt();
        System.out.println(name+" owns $"+money);
        jeff = new MouseClicks(5);
        josh= new HelperMoney(statsReader);

    }
    public HelperMoney getJosh() {
        return josh;
    }

}
