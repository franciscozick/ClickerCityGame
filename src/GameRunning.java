import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameRunning {
    private MouseClicks jeff;
    private HelperMoney josh;
    private String name;
    private long money;

    public long getMoney() {
        return money;
    }

    public void setMoney(long add) {
        money += add;
    }

    public void tick() {
        money += josh.makeMoney();
    }

    private long checkMoney() {
        return money;
    }

    public GameRunning(File fileInput) throws FileNotFoundException {

        Scanner statsReader = new Scanner(fileInput);
        name = statsReader.nextLine();
        money = statsReader.nextInt();
        System.out.println(name + " owns $" + money);
        jeff = new MouseClicks(5);
        josh = new HelperMoney(statsReader);

    }
}
