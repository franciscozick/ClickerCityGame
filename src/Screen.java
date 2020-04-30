import javax.swing.*;
import java.awt.*;

public class Screen {
    private GameRunning game;
    private JFrame win = new JFrame();;
    private TextField showTextMoney = new TextField();
    private Font customFontOne = new Font("customFontOne",Font.PLAIN,29);
    public Screen(GameRunning gameIn, int x, int y, int w, int h) {
        game = gameIn;//game variable
        win.setBounds(x, y, w, h);//sets the size of the window
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes the program stop when you close it
        showTextMoney.setBackground(Color.blue);// sets the collor of the backgroud of the showmoney
        showTextMoney.setText("You have $" + game.getMoney());//sets the text as the inital money
        showTextMoney.setFont(customFontOne);//sets the font
        win.add(showTextMoney);//adds the text to the screen

    }
    public void createScreen() {
        win.show();
    }
    public void updateScreen() {
        showTextMoney.setBounds(20,100,400,80);
        showTextMoney.setText("You have " + game.getMoney()+"sheeps");
        showTextMoney.show();


    }

    public JFrame getWin() {
        return win;
    }
}
