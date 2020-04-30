
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        GameRunning game = new GameRunning(args[0]);
        Screen screen = new Screen(game, 1600,900,1600,900);

        screen.createScreen(); // wee woo chris was here lul
        long timeStart = System.nanoTime();
        double ns = 1000000000.0/50.0;
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
            if(tick==5){
                Toolkit.getDefaultToolkit().sync();
                game.tick();
                screen.updateScreen();
                tick =0;
                System.out.println(game.getMoney());
            }
        }
    }
}

