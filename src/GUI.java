/**
import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends Program
{
    JTextField inputSeries, inputRound;
    JLabel SeriesPrompt;
    JLabel Qresults;

    public GUI()
    {
        start();
        setSize(800, 600);
    }

    public void init()
    {
        GCanvas canvas = new GCanvas();
        add(canvas);
        canvas.setBackground(Color.GRAY);


        // Label for prompting the user
        SeriesPrompt = new JLabel("Info");
        SeriesPrompt.setForeground(Color.RED);
        canvas.add(SeriesPrompt, 310, 8);

        // TextField for user input
        inputSeries = new JTextField();
        inputSeries.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        canvas.add(inputSeries, 300, 30);
        inputSeries.setSize(150, 30);

        // TextField for user input
        inputRound = new JTextField();
        inputRound.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        canvas.add(inputRound, 300, 50);
        inputRound.setSize(150, 30);

        // Label for prompting the user
        Qresults = new JLabel();
        Qresults.setForeground(Color.BLACK);
        canvas.add(Qresults, 310, 100);


        // Button for entering zip code
        JButton goButton = new JButton("Go");
        canvas.add(goButton, 320, 85);

        addActionListeners();
    }

    public void actionPerformed(ActionEvent ae)
    {

        String action = ae.getActionCommand();

        if (action.equals("Go"))
        {

            Qualifying w = new Qualifying(inputSeries.getText(), inputRound.getText());

            String times = w.fetchQualifying();
            Qresults.setText(times);
            Qresults.setSize(Qresults.getPreferredSize());


        }
    }

    public static void main(String[] args)
    {
        GUI g = new GUI();
    }
}**/