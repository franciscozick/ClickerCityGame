import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Scanner;

public class HelperMoney {
    private double[] helperRates = new double[10];
    private int[] amountOfHelpers = new int[10];
    private double[] helperCosts = new double[10];
    JButton help1 = new JButton();
    GameRunning game;

    public void setAmountOfHelpers(int index) {
        amountOfHelpers[index] += 1;
    }

    public HelperMoney(Scanner statsReader, GameRunning gameIN) {
        game = gameIN;
        while (statsReader.hasNext()) {
            statsReader.nextLine();
            /*
            for (int i = 0; i < amountOfHelpers.length * 3 - 1; i++) {
                if (i <= 9) {
                    amountOfHelpers[i] = statsReader.nextInt();
                    System.out.println(amountOfHelpers[i]);
                } else if (i <= 19) {
                    helperRates[i-10] = statsReader.nextDouble();

                } else if (i < 29) {
                    helperCosts[i-20] = statsReader.nextDouble();
                    System.out.println(helperCosts[i-20]);
                }

            }

             */
            for(int i =0;i<amountOfHelpers.length;i++){
                amountOfHelpers[i]=statsReader.nextInt();
            }
            for(int i =0;i<helperRates.length;i++){
                helperRates[i]=statsReader.nextDouble();
            }
            for(int i =0;i<helperCosts.length;i++){
                helperCosts[i]=statsReader.nextDouble();
            }
            help1.setActionCommand("1");
            help1.setText("Helper 1");
            help1.setFont(Screen.CUSTOM_FONT_TWO);
            help1.setBounds(800, 20, 100, 10);
            help1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setAmountOfHelpers(0);
                    if (game.getMoney() > 10) {
                        game.setMoney(-10);
                    }
                    help1.setBounds(800, 20, 100, 50);
                }
            });

        }
    }
        public int[] getAmountOfHelpers () {
            return amountOfHelpers;
        }
        public double getHelperCost ( int index){
            return helperCosts[index];
        }
        public void setHelperCost ( int index, double price){
            helperCosts[index] = price;
        }
        public JButton returnButton ()
        {
            return help1;
        }

        public double makeMoney ()
        {
            double money = 0;
            for (int i = 0; i < amountOfHelpers.length; i++) {
                money += amountOfHelpers[i] * helperRates[i];
            }
            return money;
        }
        public double moneyPerSecond ()
        {
            Double moneyPer = 0.0;
            for (int i = 0; i < amountOfHelpers.length; i++) {
                moneyPer += amountOfHelpers[i] * helperRates[i];
            }
            return moneyPer;
        }
    }


