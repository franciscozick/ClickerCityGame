public class MouseClicks {
    private int earnPerClick=1;
    private int numsOfClick;

    public  void setNumsOfClick(int add) {
        numsOfClick +=add;
    }

    public MouseClicks(int i){
        numsOfClick=i;
        //earnPerClick file
        //initialMoney file
    }
    //when a click runs return this and add to ammount of money you have
    public  void clickAction(){
        setNumsOfClick(1);
    }
    public long calculateMoney(){
        long value= numsOfClick*earnPerClick;
        numsOfClick=0;
        return value;
    }
}
