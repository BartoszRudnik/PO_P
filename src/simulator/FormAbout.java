package simulator;

import javax.swing.*;

class FormAbout extends JFrame{


    private String time; // zmienna pomocnicza??????????? Co to zmienna pomocnicza????
    private JLabel labelTime;

    /** konstruktor  drugiego okna */
    FormAbout( int numberOfFloors, int numberOfElevators)
    {
        setSize(700,700);
        setTitle("Symulacja Windy");
        setLayout(null);

        labelTime = new JLabel("Czas: ");
        labelTime.setBounds(10,10,150,20);
        add(labelTime);

        Building building = new Building( numberOfFloors, numberOfElevators);
        ControlSystem control = new ControlSystem();


    }
}
