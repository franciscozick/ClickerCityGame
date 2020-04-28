
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        Screen jeff = new Screen();
        //jeff.createScreen();
        GameRunning game = new GameRunning(jeff,args[0]);//add file here later
        long timeStart = System.nanoTime();
        double ns = 1000000000.0/120.0;
        double delta=0;

        int tick=0;
        while (true){
            long now=System.nanoTime();
            delta+= ((now - timeStart) / ns);
            timeStart=now;

            while(delta>=1)
            {
                tick++;
                delta--;
            }
            if(tick==120){
                game.getJosh().makeMoney();
                tick =0;
                System.out.println(game.tick());
            }

            //counter++;
        }


    }
}

