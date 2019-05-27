package simulator;

import javax.swing.*;
import java.awt.event.ActionListener;

class FormAbout extends JFrame{


    private String time; // zmienna pomocnicza??????????? Co to zmienna pomocnicza????
    private JLabel labelTime;

    /** konstruktor  drugiego okna */
    FormAbout ()
    {
        setSize(1000,700);
        setTitle("Symulacja Windy");
        setLayout(null);

        labelTime = new JLabel("Czas: ");
        labelTime.setBounds(40,50,150,20);
        add(labelTime);




    }
}
