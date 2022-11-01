import java.util.Random;

public class Dice//分为状态(属性)和行为(方法)
{
    public static final int MAX=6;//通过“static”进行共享
    private int number;
    Random r=new Random();
    public Dice()
    {
        number=r.nextInt(5)+1;
    }
    int getNumber()
    {
        return number;
    }
    void reset()
    {
        number=r.nextInt(5)+1;
    }
}
