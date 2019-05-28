package simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Okno wejściowe
 * Zawiera zapytanie użytkownika o liczbę pięter i wind
 * Zawiera przyciski wyjścia i zamknięcia okna
 * */
public class FormMain extends JFrame implements ActionListener
{

    private JButton buttonStart,buttonClose;
    private JLabel  lLiczbaPieter,lLiczbaWind;
    private JTextField tLiczbaPieter,tLiczbaWind;

    public static void main(String[]args)
    {
        EventQueue.invokeLater(()->
        {
            int numberOfFloors;
            int numberOfElevators;
            FormMain okno = new FormMain();
        });

    }


    /** konstruktor pierwszego okna */
    public FormMain()
    {
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
        setTitle("Symulacja Windy");
        setLayout(null);

        /** przycisk wyjście */
        buttonClose = new JButton("Wyjście");
        buttonClose.setBounds(screenWidth/5-90,50,100,20);
        add(buttonClose);
        buttonClose.addActionListener(this);


        /** przycisk start */
        buttonStart = new JButton("Start");
        buttonStart.setBounds(screenWidth/5+90,50,100,20);
        add(buttonStart);
        buttonStart.addActionListener(this);

        /** etykieta */
        lLiczbaPieter = new JLabel("Podaj liczbę pięter: ");
        lLiczbaPieter.setBounds(40,130,150,20);
        add(lLiczbaPieter);

        /** etykieta */
        lLiczbaWind = new JLabel("Podaj liczbę wind: ");
        lLiczbaWind.setBounds(40,180,150,20);
        add(lLiczbaWind);

        /** pole do wpisania liczby pięter */
        tLiczbaPieter = new JTextField();
        tLiczbaPieter.setBounds(160,130,120,20);
        add(tLiczbaPieter);

        /** pole do wpisania liczby wind*/
        tLiczbaWind = new JTextField();
        tLiczbaWind.setBounds(160,180,120,20);
        add(tLiczbaWind);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object źródło = e.getSource();

        if(źródło == buttonClose)
            dispose();

        /** akcja po naciśnięciu start */
        else if(źródło == buttonStart)
        {
            int numberOfFloors = Integer.parseInt(tLiczbaPieter.getText());
            int numberOfElevators = Integer.parseInt(tLiczbaWind.getText());
            FormAbout okno2 = new FormAbout(numberOfFloors, numberOfElevators);
            okno2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno2.setVisible(true);
        }
    }

}
