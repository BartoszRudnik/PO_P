import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class windaGuI extends JFrame implements ActionListener
{

    private JButton bStart,bWyjście;
    private JLabel  lLiczbaPieter,lLiczbaWind,lczas;
    private JTextField tLiczbaPieter,tLiczbaWind;
    private String czas; // zmienna pomocnicza


    /** konstruktor pierwszego okna */
    public windaGuI()
    {
        setSize(400,300);
        setTitle("Symulacja Windy");
        setLayout(null);

/** przycisk wyjście */
        bWyjście = new JButton("Wyjście");
        bWyjście.setBounds(220,50,100,20);
        add(bWyjście);
        bWyjście.addActionListener(this);


/** przycisk start */
        bStart = new JButton("Start");
        bStart.setBounds(70,50,100,20);
        add(bStart);
        bStart.addActionListener(this);

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
    }
/** konstruktor  drugiego okna */
    public windaGuI(String czas)
    {
        setSize(1000,700);
        setTitle("Symulacja Windy");
        setLayout(null);

        lczas = new JLabel("Czas: ");
        lczas.setBounds(40,50,150,20);
        add(lczas);




    }


    public static void main(String[] args)
    {

        windaGuI okno = new windaGuI();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object źródło = e.getSource();

        if(źródło == bWyjście)
            dispose();

/** akcja po naciśnięciu start */
        else if(źródło == bStart)
        {
            windaGuI okno2 = new windaGuI(czas);
            okno2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno2.setVisible(true);



        }
    }
}
