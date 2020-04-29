import javax.swing.*;
import java.awt.*;

public class Screen {
    GameRunning game;
    Container contentPane;
    Graphics g;
    JFrame win;
    JLabel moneyShower= new JLabel();

    public Screen(GameRunning gameIn, int x, int y, int w, int h) {
        game = gameIn;
        win = new JFrame();
        win.setBounds(x, y, w, h);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        panel.setLocation(1400,600);
        win.add(panel);
        panel.add(moneyShower);
    }
    public void createScreen() {
        win.show();
    }

    public void updateScreen() {
        System.out.println("TEST");
        moneyShower.setText("You have $" + game.getMoney());
    }
}
