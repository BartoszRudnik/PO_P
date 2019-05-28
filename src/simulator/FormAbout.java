package simulator;

import javax.swing.*;
import java.awt.*;

class FormAbout extends JFrame{


    private String time; // zmienna pomocnicza??????????? Co to zmienna pomocnicza????
    private JLabel labelTime;

    /** konstruktor  drugiego okna */
    FormAbout( int numberOfFloors, int numberOfElevators)
    {
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        setSize(screenWidth/2,screenHeight*2/3);
        setLocationByPlatform(true);
        setTitle("Symulacja Windy");
        setLayout(null);

        labelTime = new JLabel("Czas: ");
        labelTime.setBounds(10,10,150,20);
        add(labelTime);

        Simulator simulator = new Simulator(numberOfFloors, numberOfElevators);
    }
}
