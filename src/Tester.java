
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        GameRunning game = new GameRunning(args[0]);
        Screen screen = new Screen(game, 1600,900,1600,900);
        screen.createScreen();
        long timeStart = System.nanoTime();
        double ns = 1000000000.0/30.0;
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
            if(tick==15){
                game.tick();
                tick =0;
                screen.updateScreen();
                System.out.print(game.getMoney());
            }
        }
    }
}

