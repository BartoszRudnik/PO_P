package simulator;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Okno wejściowe
 * Zawiera zapytanie użytkownika o liczbę pięter i wind
 * Zawiera przyciski wyjścia i zamknięcia okna
 * */
public class FormMain extends JFrame implements ActionListener
{
    private JButton buttonStart,buttonClose;
    private JLabel labelNumberOfFloors, labelNumberOfElevators,labelBackground;
    private JTextField textBoxFloors, textBoxElevators;

    public static void main(String[]args)
    {
        EventQueue.invokeLater(()->{
            int numberOfFloors;
            int numberOfElevators;
            FormMain okno = new FormMain();
        });
    }


    /** konstruktor pierwszego okna */
    public FormMain()
    {
        /** Ustawianie rozmiaru okna */
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=689;
        int screenWidth=1000;
        setSize(screenWidth,screenHeight);
        setLocationByPlatform(true);
        setTitle("Symulacja Windy");
        setLayout(null);

        /** przycisk wyjście */
        buttonClose = new JButton("Wyjście");
        buttonClose.setBounds(screenWidth/5+90,50,100,20);
        add(buttonClose);
        buttonClose.addActionListener(this);


        /** przycisk start */
        buttonStart = new JButton("Start");
        buttonStart.setBounds(screenWidth/5-90,50,100,20);
        add(buttonStart);
        buttonStart.addActionListener(this);

        /** etykieta */
        labelNumberOfFloors = new JLabel("Podaj liczbę pięter: ");
        labelNumberOfFloors.setBounds(40,130,150,20);
        add(labelNumberOfFloors);

        /** etykieta */
        labelNumberOfElevators = new JLabel("Podaj liczbę wind: ");
        labelNumberOfElevators.setBounds(40,180,150,20);
        add(labelNumberOfElevators);

        /** pole do wpisania liczby pięter */
        textBoxFloors = new JTextField("5");
        textBoxFloors.setBounds(160,130,120,20);
        add(textBoxFloors);

        /** pole do wpisania liczby wind*/
        textBoxElevators = new JTextField("1");
        textBoxElevators.setBounds(160,180,120,20);
        add(textBoxElevators);

        /** pole do ustawiania tła */
        labelBackground=new JLabel(new ImageIcon("tlo2.jpg"));
        labelBackground.setOpaque(true);
        labelBackground.setBounds(0,0,screenWidth,screenHeight);
        add(labelBackground);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
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
            int numberOfFloors = Integer.parseInt(textBoxFloors.getText());
            int numberOfElevators = Integer.parseInt(textBoxElevators.getText());
            FormAbout okno2 = new FormAbout(numberOfFloors, numberOfElevators);
            okno2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno2.setVisible(true);
        }
    }
}
