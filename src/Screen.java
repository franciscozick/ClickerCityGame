import javax.swing.*;
import java.awt.*;

public class Screen {
    private GameRunning game;
    private JFrame win = new JFrame();;
    private TextField showTextMoney = new TextField();
    private Font customFontOne = new Font("customFontOne",Font.PLAIN,29);
    private Font customFontTwo= new Font("customFontTwo",Font.ITALIC,15);
    private TextField moneyPerSec = new TextField();


    public Screen(GameRunning gameIn, int x, int y, int w, int h) {
        game = gameIn;//game variable
        win.setBounds(x, y, w, h);//sets the size of the window
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes the program stop when you close it
        TextField nameText = new TextField(gameIn.getName());
        nameText.setFont(customFontOne);
        nameText.setBounds(20,10,400,50);
        nameText.setBackground(Color.gray);
        showTextMoney.setBackground(Color.blue);// sets the collor of the backgroud of the showmoney
        showTextMoney.setText("You have $" + game.getMoney());//sets the text as the inital money
        showTextMoney.setFont(customFontOne);//sets the font
        win.add(nameText);
        moneyPerSec.setFont(customFontTwo);
        moneyPerSec.setBackground(Color.green);
        moneyPerSec.setText(game.getJosh().moneyPerSecond()+"/sec");
        nameText.show();
        win.add(moneyPerSec);
        win.add(showTextMoney);//adds the text to the screen
        moneyPerSec.show();
    }
    public void createScreen() {
        win.show();
    }
    public void updateScreen() {
        showTextMoney.setBounds(20,100,400,80);
        moneyPerSec.setBounds(20,180,300,50);
        moneyPerSec.setText(game.getJosh().moneyPerSecond()*10+"/sec");
        showTextMoney.setText("You have $" + game.getMoney());
        showTextMoney.show();


    }

    public JFrame getWin() {
        return win;
    }
}
