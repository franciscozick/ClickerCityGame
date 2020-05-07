import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.*;
import java.util.ArrayList;

public class Screen {
    Container contentPane;
    Graphics g;

    NumberFormat nf = NumberFormat.getInstance();
    private GameRunning game;
    private JFrame win = new JFrame();
    ;
    private TextField showTextMoney = new TextField();
    private static final Font CUSTOM_FONT_ONE = new Font("customFontOne", Font.PLAIN, 29);
    static final Font CUSTOM_FONT_TWO = new Font("customFontTwo", Font.ITALIC, 15);
    private TextField moneyPerSec = new TextField();
    private Object ImageObserver;
    private JPanel panel;
    private TextField nameText;
    private ArrayList<TextField> priceOfHelpers;

    public Screen(GameRunning gameIn, int x, int y, int w, int h) {
        nf.setMaximumFractionDigits(2);
        game = gameIn;
        win.setBounds(x, y, w, h);//sets the size of the window
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes the program stop when you close
        priceOfHelpers = new ArrayList<TextField>(game.getJosh().getAmountOfHelpers().length);
        Toolkit.getDefaultToolkit().sync();
        win.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getX() < 300 && e.getY() > 300) {
                    game.setMoney(1.0);
                }
                if (e.getX() > 1200) {
                    System.out.print("it works");
                    for (int i = 0; i < game.getJosh().getAmountOfHelpers().length; i++)
                        if (e.getY() >= i * 100 && e.getY() < 100 + 100 * i) {
                            System.out.println("this too");
                            if (game.getMoney() > game.getJosh().getHelperCost(i)) {
                                nf.setMaximumFractionDigits(2);
                                System.out.println("the price is " + game.getJosh().getHelperCost(i));
                                System.out.print("not this");
                                game.getJosh().setAmountOfHelpers(i);
                                game.setMoney(-game.getJosh().getHelperCost(i));
                                game.getJosh().setHelperCost(i, game.getJosh().getHelperCost(i) * (1.1 + ((double) i / 10)));
                                String priceDouble = nf.format(game.getJosh().getHelperCost(i));
                                priceOfHelpers.get(i).setText(priceDouble);
                                System.out.println(game.getJosh().getHelperCost(i));
                            }
                            break;
                        }
                }
            }
        });


    }

    public void createScreen() {
        nf.setMaximumFractionDigits(2);
        Image img = Toolkit.getDefaultToolkit().getImage("../FinalClickerGame/src/GameBackgroud2.jpg");
        nameText = new TextField(game.getName());
        nameText.setFont(CUSTOM_FONT_ONE);
        nameText.setBackground(Color.gray);
        win.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });
        nameText.setBounds(0, 0, 100, 100);
        showTextMoney.setBackground(Color.blue);// sets the collor of the backgroud of the showmoney
        showTextMoney.setText("You have $" + game.getMoney());//sets the text as the inital money
        showTextMoney.setFont(CUSTOM_FONT_ONE);//sets the font

        moneyPerSec.setFont(CUSTOM_FONT_TWO);
        moneyPerSec.setBackground(Color.green);
        moneyPerSec.setText(game.getJosh().moneyPerSecond() + "/sec");
        for (int i = 0; i < game.getJosh().getAmountOfHelpers().length; i++)
        {
            priceOfHelpers.add(new TextField("" + game.getJosh().getHelperCost(i)));
            priceOfHelpers.get(i).setFont(CUSTOM_FONT_TWO);
            priceOfHelpers.get(i).setText("" + game.getJosh().getHelperCost(i));
            priceOfHelpers.get(i).show();
            win.add(priceOfHelpers.get(i));
            System.out.println(priceOfHelpers.get(i).getText());
        }
        win.add(nameText);
        win.add(moneyPerSec);
        win.add(showTextMoney);//adds the text to the screen
        win.show();
    }

    public void updateScreen() {
        for(int i =0;i<priceOfHelpers.size();i++){
            priceOfHelpers.get(i).setBounds(1380,60*i,100,20);
        }
        nameText.setBounds(0, 0, 400, 50);
        showTextMoney.setBounds(750, 40, 400, 80);
        moneyPerSec.setBounds(750, 120, 300, 50);
        Double moneyPer = game.getJosh().moneyPerSecond();
        moneyPerSec.setText(nf.format(moneyPer) + "/s");
        String[] prefix = {"K","M","B","T"};

        String usePrefix="";
        int divideBy=1;
        int index=0;
        for(int i =1000;i<Math.pow(i,9);i*=1000){
            if(game.getMoney()>i)
            {
                divideBy=i;
                usePrefix=prefix[index];
                index++;
            }
        }
        showTextMoney.setText("You have $" + nf.format(game.getMoney()/divideBy)+usePrefix);
        showTextMoney.show();
    }
}

