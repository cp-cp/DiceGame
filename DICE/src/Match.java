import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.*;
public class Match
{
    public int order=1;
    private int allnamber;
    private Player player1=new Player();
    private Player player2=new Player();
    private Scanner scan=new Scanner(System.in);
    JLabel label1,gametimes,time,result;
    JButton submit,next;
    JTextField player1name,player2name,gametime;
    JPanel primary,begin;
    JFrame frame;
    public Match()
    {
        frame=new JFrame("Dice Match");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        primary=new JPanel();
        label1=new JLabel("Please submit two player here:");
            label1.setBounds(650,10,2000,200);
        gametimes=new JLabel("How many match do you want to play");
            gametimes.setBounds(650,400,2000,200);
        player1name=new JTextField(5);
            player1name.setBounds(400,200,200,20);
        player2name=new JTextField(5);
            player2name.setBounds(850,200,200,20);
        gametime=new JTextField(10);
            gametime.setBounds(650,600,200,20);
        submit=new JButton("Begin Game");
            submit.setBounds(650,800,200,20);
        submit.addActionListener(new ButtonListener());
        primary.setLayout(null);
        primary.add(label1);
        primary.add(player1name);
        primary.add(player2name);
        primary.add(gametimes);
        primary.add(gametime);
        primary.add(submit);
        frame.getContentPane().add(primary);
        primary.setVisible(true);


        begin=new JPanel();
        begin.setLayout(null);
        time=new JLabel();
            time.setBounds(650,400,200,20);
        result=new JLabel();
            result.setBounds(650,500,2000,20);
        next=new JButton("Next Game!!!");
            next.setBounds(650,600,200,20);
        begin.add(time);
        begin.add(result);
        begin.add(next);
        next.addActionListener(e -> {
            if(order<allnamber)begin();
            else finalWin();
        });
        //frame.getContentPane().add(begin);
        //begin.setVisible(false);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            player1.setName(player1name.getText());
            player2.setName(player2name.getText());
            allnamber=Integer.parseInt(gametime.getText());
            primary.setVisible(false);
            System.out.println(player1.name+" "+player2.name);
            frame.getContentPane().add(begin);
            begin.setVisible(true);
            begin();
            //frame.remove(primary);
        }
    }
    void begin()
    {
        gameset();
        System.out.println(order+" ");
        //time.setText(player1.name+"骰子:   "+player1.getDice()+"\n"+player2.name+"骰子:   "+player2.getDice()+"\n"+"This is "+order+" game");
       time.setText("This is "+order+" game");
        whichWin();
    }
    void whichWin()
    {
        if(player2.getDice()>player1.getDice())
        {
            result.setText(player2.name+" Win!!!");
            player2.addWin();
        }
        else if(player2.getDice()<player1.getDice())
        {
            result.setText(player1.name+" Win!!!");
            player1.addWin();
        }
        else
        {
            result.setText("oh! Both of you are winners!!Please play again");
        }
        begin.add(result);
        order++;
    }
    void gameset()
    {
        player1.reBegin();
        player2.reBegin();
    }
    void finalWin()
    {
        JDialog dialog=new JDialog(frame,"Final Winner");
        dialog.setSize(1000,1000);
        dialog.setLayout(null);
        //dialog.setLocation(400, 300);
        JLabel end=new JLabel();
            end.setBounds(650,200,1000,20);
        end.setText(player1.name+" win: "+player1.getWinSum()+" "+player2.name+" win: "+player2.getWinSum());
        if(player1.getWinSum()>player2.getWinSum())
        {
            end.setText("The winner is "+player1.name);
        }
        else if(player1.getWinSum()<player2.getWinSum())
        {
            end.setText("The winner is "+player2.name);
        }
        else
        {
            end.setText("You are both the winner!Congratulations!!!");
        }
        JButton a=new JButton("确认");
            a.setBounds(650,300,100,20);
        a.addActionListener(e -> {dialog.dispose();});
        dialog.add(end);
        dialog.add(a);
        dialog.setVisible(true);
    }
}
