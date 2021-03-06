package simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Okno wejściowe
 * Zawiera zapytanie użytkownika o liczbę pięter i wind
 * Zawiera przyciski wyjścia i zamknięcia okna
 * @author Stanisław Franczyk
 * @author Bartosz Rudnik
 * @author Michał Grabek
 * */
public class FormMain extends JFrame implements ActionListener, KeyListener {
    /** Utworzenie przycisku start i close */
    private JButton buttonStart,buttonClose;
    /** Utworzenie pola tekstowego liczby pięter i wind */
    private JTextField textBoxFloors, textBoxElevators;

    /** konstruktor pierwszego okna */
    public FormMain()
    {
        // Ustawianie rozmiaru okna
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        // zmienna wyskokości ekranu
        int screenHeight=screenSize.height;
        //zmienna szerokości ekranu
        int screenWidth=screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
        setTitle("Symulacja Windy");
        setLayout(null);

        // przycisk wyjście
        buttonClose = new JButton("Wyjście");
        buttonClose.setBounds(screenWidth/5+90,50,100,20);
        add(buttonClose);
        buttonClose.addActionListener(this);


        // przycisk start
        buttonStart = new JButton("Start");
        buttonStart.setBounds(screenWidth/5-90,50,100,20);
        add(buttonStart);
        buttonStart.addActionListener(this);

        // etykieta
        JLabel labelNumberOfFloors = new JLabel("Podaj liczbę pięter: ");
        labelNumberOfFloors.setBounds(40,130,150,20);
        add(labelNumberOfFloors);

        // etykieta
        JLabel labelNumberOfElevators = new JLabel("Podaj liczbę wind: ");
        labelNumberOfElevators.setBounds(40,180,150,20);
        add(labelNumberOfElevators);

        // pole do wpisania liczby pięter
        textBoxFloors = new JTextField("20");
        textBoxFloors.setBounds(160,130,120,20);
        add(textBoxFloors);
        textBoxFloors.addKeyListener(this);

        // pole do wpisania liczby wind
        textBoxElevators = new JTextField("5");
        textBoxElevators.setBounds(160,180,120,20);
        add(textBoxElevators);
        textBoxElevators.addKeyListener(this);

        // Uwidocznienie pierwszego okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    /** Metoda statyczna */
    public static void main(String[]args)
    {
        EventQueue.invokeLater(()->{
            FormMain main = new FormMain();
        });
    }

    /** Metoda wykonująca akcję w zależności od wyboru użytkownika */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        // wyjście
        if(source == buttonClose)
            System.exit(0);

        // konwersja zmiennych na typ int
        int numberOfFloors = Integer.parseInt(textBoxFloors.getText());
        int numberOfElevators = Integer.parseInt(textBoxElevators.getText());

            // Wyświetlenie wiadomości z informacją o błędzie
            if((numberOfElevators == 0 || numberOfFloors ==0) && (source == buttonStart))
            {
                JOptionPane.showMessageDialog(this,"Liczba pięter i wind nie może być równa 0 !");
            }

            // akcja po naciśnięciu start
           else if (source == buttonStart)
        {
            FormAbout window = new FormAbout(numberOfFloors, numberOfElevators);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
        }

    }

    /** Metoda blokująca wpisywanie innych znaków niż cyfr
     * @param e 
     */
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



