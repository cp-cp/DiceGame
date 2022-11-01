public class Player
{
    private Dice dice=new Dice();
    public String name=new String();
    private int winsum=0;
    void reBegin()
    {
        dice.reset();
    }
    int getDice()
    {
        return dice.getNumber();
    }
    int getWinSum()
    {
        return winsum;
    }
    void setName(String name)
    {
        this.name=name;
    }
    void addWin()
    {
        winsum++;
    }
}
