package simulator;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Okno wejściowe
 * Zawiera zapytanie użytkownika o liczbę pięter i wind
 * Zawiera przyciski wyjścia i zamknięcia okna
 * */
public class FormMain extends JFrame implements ActionListener, KeyListener {
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
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
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
        textBoxFloors.addKeyListener(this);

        /** pole do wpisania liczby wind*/
        textBoxElevators = new JTextField("2");
        textBoxElevators.setBounds(160,180,120,20);
        add(textBoxElevators);
        textBoxElevators.addKeyListener(this);

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
            System.exit(0);

        /** konwersja */
        int numberOfFloors = Integer.parseInt(textBoxFloors.getText());
        int numberOfElevators = Integer.parseInt(textBoxElevators.getText());

            /** oknienko */
            if((numberOfElevators == 0 || numberOfFloors ==0) && (źródło == buttonStart))
            {
                JOptionPane.showMessageDialog(this,"Liczba pięter i wind nie może być równa 0 !");
            }

            /** akcja po naciśnięciu start */
           else if (źródło == buttonStart)
        {
            FormAbout okno2 = new FormAbout(numberOfFloors, numberOfElevators);
            okno2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno2.setVisible(true);
        }

    }


    @Override
    public void keyTyped(KeyEvent e)
    {
        char caracter = e.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b'))
        {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }


}



