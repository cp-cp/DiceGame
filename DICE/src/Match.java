import java.util.Scanner;

public class Match
{
    public int order=1;
    private int allnamber;
    private Player player1=new Player();
    private Player player2=new Player();
    private Scanner scan=new Scanner(System.in);
    public Match()
    {
        System.out.println("Please submit two player here:");
        player1.setName(scan.next());
        player2.setName(scan.next());
        System.out.println(player1.name+" "+player2.name);
    }
    void begin()
    {
        System.out.println("How many match do you want to play");
        allnamber= scan.nextInt();
        System.out.println("Are you ready?Y/N");
        char tage=scan.next().charAt(0);
        if(tage=='Y')
        {
            for(int i=1;i<=allnamber;i++)
            {
                gameset();
                System.out.println("This is "+order+" game :");
                System.out.println(player1.name+": "+player1.getDice()+" \n"+player2.name+": "+player2.getDice());
                whichWin();
            }
            finalWin();
        }
    }
    void whichWin()
    {
        if(player2.getDice()>player1.getDice())
        {
            System.out.println(player2.name+" Win!!!");
            player2.addWin();
        }
        else if(player2.getDice()<player1.getDice())
        {
            System.out.println(player1.name+" Win!!!");
            player1.addWin();
        }
        else
        {
            System.out.println("oh! Both of you are winners!!Please play again");
        }
        order++;
    }
    void gameset()
    {
        player1.reBegin();
        player2.reBegin();
    }
    void finalWin()
    {
        System.out.println(player1.name+" win: "+player1.getWinSum()+" "+player2.name+" win: "+player2.getWinSum());
        if(player1.getWinSum()>player2.getWinSum())
        {
            System.out.println("The winner is "+player1.name);
        }
        else if(player1.getWinSum()<player2.getWinSum())
        {
            System.out.println("The winner is "+player2.name);
        }
        else
        {
            System.out.println("You are both the winner!Congratulations!!!");
        }
    }
}
