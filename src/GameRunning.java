import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameRunning {

    private HelperMoney josh;
    private String name;
    private double money;


    public void setMoney(double input) {
        money+=input;
    }

    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }
    public void tick() {
        money += josh.makeMoney();
    }

    public HelperMoney getJosh() {
        return josh;
    }

    public GameRunning(File fileInput) throws FileNotFoundException {
        Scanner statsReader = new Scanner(fileInput);
        name = statsReader.nextLine();
        money = statsReader.nextDouble();
        TextField nameText = new TextField(name);
        nameText.setBounds(20,10,100,40);
        System.out.println(name + " owns $" + money);

        josh = new HelperMoney(statsReader,this); }
}
