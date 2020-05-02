import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.*;
public class Screen {

    NumberFormat nf = NumberFormat.getInstance();
    private GameRunning game;
    private JFrame win = new JFrame();;
    private TextField showTextMoney = new TextField();
    static final Font CUSTOM_FONT_ONE = new Font("customFontOne",Font.PLAIN,29);
    static final Font CUSTOM_FONT_TWO = new Font("customFontTwo",Font.ITALIC,15);
    private TextField moneyPerSec = new TextField();
    public Screen(GameRunning gameIn, int x, int y, int w, int h) {
        nf.setMaximumFractionDigits(6);
        game = gameIn;//game variable

        win.setBounds(x, y, w, h);//sets the size of the window
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes the program stop when you close it

        TextField nameText = new TextField(gameIn.getName());
        nameText.setFont(CUSTOM_FONT_ONE);
        nameText.setBounds(20,10,400,50);
        nameText.setBackground(Color.gray);


        showTextMoney.setBackground(Color.blue);// sets the collor of the backgroud of the showmoney
        showTextMoney.setText("You have $" + game.getMoney());//sets the text as the inital money
        showTextMoney.setFont(CUSTOM_FONT_ONE);//sets the font

        moneyPerSec.setFont(CUSTOM_FONT_TWO);
        moneyPerSec.setBackground(Color.green);
        moneyPerSec.setText(game.getJosh().moneyPerSecond()+"/sec");

        win.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getX()<300&&e.getY()>300){
                    game.setMoney(1.0);
                }
                if(e.getX()>1200){
                    System.out.print("it works");
                    if(e.getY()>20&&e.getY()<120){
                        System.out.println("this too");

                        if(game.getMoney()>game.getJosh().getHelperCost(0))
                        {
                            System.out.println("the price is "+game.getJosh().getHelperCost(0));
                            System.out.print("not this");
                            game.getJosh().setAmountOfHelpers(0);
                            game.getJosh().setHelperCost(0, game.getJosh().getHelperCost(0)*1.1);
                            game.setMoney(-game.getJosh().getHelperCost(0));
                        }
                    }
                }

                System.out.println(e.getX()+" "+e.getY());
            }
        });

        win.add(nameText);
        win.add(game.getJosh().returnButton());
        win.add(moneyPerSec);
        win.add(showTextMoney);//adds the text to the screen
    }
    public void createScreen() {
        win.show();
    }
    public void updateScreen() {
        game.getJosh().returnButton().setBounds(800,20,100,50);
        showTextMoney.setBounds(20,100,400,80);
        moneyPerSec.setBounds(20,180,300,50);
        Double moneyPer = game.getJosh().moneyPerSecond();

        moneyPerSec.setText(nf.format(moneyPer)+"/s");
        String moneyAmount = ""+game.getMoney();
        showTextMoney.setText("You have $" + nf.format(game.getMoney()));
        showTextMoney.show();


    }

    public JFrame getWin() {
        return win;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="1"){
            System.out.println("JEEEFFF");
        }
    }
}
