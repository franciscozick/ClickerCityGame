import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameRunning {
    //Needs tick stuff
    //How to run it
    MouseClicks jeff;
    HelperMoney josh;
    Screen win;


    public  long tick(){
        return jeff.calculateMoney()+josh.calculateMoney();
    }
    private long checkMoney(){
    return 0;
    }
    public GameRunning(Screen screenInput,String fileInput) throws FileNotFoundException {
        win = screenInput;
        File playerStats = new File(fileInput);
        Scanner statsReader = new Scanner(playerStats);
        jeff = new MouseClicks(5);

        josh= new HelperMoney(statsReader);
    }

    public HelperMoney getJosh() {
        return josh;
    }
}
