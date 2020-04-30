import javax.swing.*;
import java.awt.*;

public class Screen {
    GameRunning game;
    JFrame win = new JFrame();;
    JLabel moneyShower= new JLabel();
    JPanel panel=new JPanel();
    TextField showText= new TextField();
    Font jefferson = new Font("Otaku",Font.PLAIN,50);


    public Screen(GameRunning gameIn, int x, int y, int w, int h) {

        game = gameIn;

        win.setBounds(x, y, w, h);

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLocation(1400,600);
        win.add(panel);
        panel.add(moneyShower);
        showText.setLocation(1000,600);
        showText.setText("You have $" + game.getMoney());

        showText.setFont(jefferson);
        ;
        win.add(showText);
    }
    public void createScreen() {
        win.show();
    }
    public void updateScreen() {
        showText.setText("You have " + game.getMoney()+"sheeps");
        showText.show();
    }

    public JFrame getWin() {
        return win;
    }
}
