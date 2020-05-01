import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseClicks {
    private int earnPerClick=1;
    private int numsOfClick;
    JButton help1 = new JButton();
    public  void setNumsOfClick(int add,Screen josh) {
        numsOfClick +=add;
    }

    public MouseClicks(GameRunning game){
        help1.setActionCommand("1");
        help1.setText("Helper 1");
        help1.setFont(Screen.CUSTOM_FONT_TWO);
        help1.setBounds(800,20,100,10);
        help1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.getJosh().setAmountOfHelpers(0);
                game.setMoney(-10);
                System.out.println("hello");
                help1.setBounds(800,20,100,50);
            }
        });
    }
    //when a click runs return this and add to ammount of money you have
    public JButton returnButton(){
        return help1;
    }
    public long calculateMoney(){
        long value= numsOfClick*earnPerClick;
        numsOfClick=0;
        return value;
    }
}
