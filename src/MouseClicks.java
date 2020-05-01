import javax.swing.*;
import java.awt.event.*;

public class MouseClicks extends MouseAdapter {
    private int earnPerClick=1;
    private int numsOfClick;
    GameRunning gameVar;
    HelperMoney helperVar;
    JButton help1 = new JButton();
    public MouseClicks(HelperMoney helper){
        helperVar=helper;
        help1.setActionCommand("1");
        help1.setText("Helper 1");
        help1.setFont(Screen.CUSTOM_FONT_TWO);
        help1.setBounds(800,20,100,10);
        help1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                System.out.println("hello");
                help1.setBounds(800,20,100,50);
            }
        });
    }
    //when a click runs return this and add to ammount of money you have
    public JButton returnButton(){
        return help1;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    if(e.getX()>400&&e.getY()>400){
        helperVar.setAmountOfHelpers(0);
        gameVar.setMoney(-10);
        System.out.println("hello");
    }
    }
}
