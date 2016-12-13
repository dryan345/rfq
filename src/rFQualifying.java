import acm.graphics.*;
import acm.program.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;



public class rFQualifying extends Program
{
    JTextField inputRound;
    JLabel SeriesPrompt;
    JLabel Series;
    JLabel Round;
    JTextArea Qresults;
    JScrollPane scroll;
    JButton goButton;
    JToggleButton sx;
    JToggleButton sxl;
    JToggleButton supercross;
    String series;

    public rFQualifying()
    {
        start();
        setSize(800, 600);
    }

    public void init()
    {
        GCanvas canvas = new GCanvas();
        add(canvas);

        canvas.setBackground(Color.decode("#303030"));


        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 12);

        // Label for prompting the user
        SeriesPrompt = new JLabel("SELECT SERIES BELOW");
        SeriesPrompt.setForeground(Color.RED);
        canvas.add(SeriesPrompt, 320, 8);


        // Label for prompting the user
        Round = new JLabel("ROUND ( r1-r17 ):");
        Round.setForeground(Color.RED);
        canvas.add(Round, 200, 110);


        // TextField for user input
        inputRound = new JTextField();
        inputRound.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        canvas.add(inputRound, 300, 105);
        inputRound.setSize(150, 30);


        // Button for getting results
        goButton = new JButton("\u279c");
        canvas.add(goButton, 465, 107);


        // Label for prompting the user
        Qresults = new JTextArea();
        Qresults.setForeground(Color.BLACK);
        Qresults.setBackground(Color.WHITE);
        Qresults.setFont(font);

        scroll = new JScrollPane (Qresults);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 150, 682, 380);
        scroll.setVisible(false);

        canvas.add(scroll);



        sx = new JToggleButton("sxmadnessopen");
        canvas.add(sx, 250, 30);

        sxl = new JToggleButton("sxmadnesslites");
        canvas.add(sxl, 390, 30);

        supercross = new JToggleButton("supercross");
        canvas.add(supercross, 335, 60);


        addActionListeners();
    }

    public void actionPerformed(ActionEvent ae)
    {

        String action = ae.getActionCommand();

        if (action.equals("\u279c"))
        {

            //Sets link to correct series based on what button is selected.
            if(sx.getModel().isSelected())
            {
                series = "sxmadnessopen";

            }
            if (sxl.getModel().isSelected())
            {
                series = "sxmadnesslites";
            }

            if (supercross.getModel().isSelected())
            {
                series = "supercross";
            }


            Qualifying w = new Qualifying(series, inputRound.getText());
            scroll.setVisible(true);

            String times = w.fetchQualifying();
            Qresults.setText(times);
            Qresults.setSize(Qresults.getPreferredSize());

        }
    }

    public static void main(String[] args)
    {
        rFQualifying g = new rFQualifying();
    }
}