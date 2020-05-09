package com.cityheist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // #includes action listener

/**
 * This class represents a 6-sided dice.
 */
public class Dice implements ActionListener
{
    private JFrame frame = new JFrame("Dice");                  // frame
    private JPanel panel = new JPanel();                        // panel
    private GridLayout layout = new GridLayout(1,0);
    private JButton b = new JButton(new ImageIcon("art/dice.png"));
    private ImageIcon copTurn = new ImageIcon("art/cop.png");
    private ImageIcon robberTurn = new ImageIcon("art/robber.png");
    
    private GameRules gr;
    private Board board;
    private boolean diceMode = true;
    private int rollValue;

    /**
     * Constructor. Opens the Dice window when called.
     * @param board The Board class containing the game that the dice will be used for.
     * @param gr The Game Rule class representing the game logic.
     */
    public Dice(Board board,GameRules gr)
    {
        this.board = board;
        this.gr = gr;
        this.rollValue = 0;
        this.open();
    }
    
    private void open()
    {
        //FRAME
        frame.setSize(100,125);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // frame closes when close
        
        //PANEL
        frame.setContentPane(panel);                            // connects frame and panel
        panel.setLayout(layout);                                // connects the panel and the layout
        panel.add(b);
        b.addActionListener(this);
        frame.setVisible(true);                                 // makes frame visible
    }
    
    /**
     * Depending on the current mode of the dice, this method either "rolls" the dice by changing
     * the dice number variable (the value of the roll) or shows a graphic
     * representing whose turn it is. If the dice is in diceMode and this method is called, it will
     * no longer be in dice mode.
     */
    public void roll()
    {
        if(diceMode)
        {
            rollValue = (int)(Math.random() * 6 + 1);
            b.setIcon(new ImageIcon("art/" + rollValue + "-dice.png"));
            diceMode = false;
        }
        else
        {
            if(gr.getCurrentTurn() == TurnMode.ROBBERTURN)
            {
                b.setIcon(robberTurn);
            }
            else
            {
                b.setIcon(copTurn);
            }
        }
    }
    
    /**
     * This method sets diceMode to true.
     */
    public void setDiceModeTrue()
    {
        diceMode = true;
    }
    
    /**
     * A method returning the diceMode.
     * @return True or false depending on whether this dice is in diceMode.
     */
    public boolean getDiceMode()
    {
        return diceMode;
    }
    
    /**
     * A method that returns the value of the roll.
     * @return An integer value frorm 1-6 representing on the value of the roll.
     */
    public int getRollValue()
    {
        return rollValue;
    }
    
    /**
     * This method is called whenever the dice is pressed.
     * @param action The action that called this method.
     */
    public void actionPerformed(ActionEvent action)
    {
        roll();
    }
}
