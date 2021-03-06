package simulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa wizualizująca działanie wszystkich wind w budynku
 */
class FormAbout extends JFrame implements ActionListener{

    /** Lista Wind */
    private List <JTextField> listFieldsElevator = new ArrayList<>();
    /** Lista zawierajaca liczbe pasazerow */
    private List <JTextField> listFieldsNumberOfPassengers = new ArrayList<>();
    /** Lista zawierajaca "obecne pietra windy" */
    private List <JTextField> listFieldsCurrentFloor = new ArrayList<>();
    /** Lista zawierajac docelowe pietra windy */
    private List <JTextField> listFieldsTargetFloor = new ArrayList<>();
    /** Lista zawierajaca pietra */
    private List <JTextField> listFieldsFloors = new ArrayList<>();

    /** Etykieta czasu */
    private JLabel labelTime;

    /** Panel w ktorym umieszczone sa wszystkie elementy */
    private JPanel container;

    /** Przycisk rozpoczecia, stopu, wznowienia symulacji */
    JButton buttonSimulation;

    /** Przycisk zakonczenia symulacji */
    JButton buttonClose;

    /** Zmienna logiczna odpowiedzialna za zamiane stanu buttonSimulation */
    boolean check=false;

    private Simulator simulator;

    private Timer timer = new Timer(100, e -> getTimerAction());

    private int vspace = 10;
    private int hspace = 5;
    private int lastLine;

    /** Konstruktor
     * @param numberOfFloors liczba pięter budynku
     * @param numberOfElevators liczba wind budynku
     * */
    FormAbout( int numberOfFloors, int numberOfElevators)
    {
        // Ustawianie rozmiaru okna
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=689;
        int screenWidth=1000;
        setSize(screenWidth,screenHeight);

        container = new JPanel();
        container.setLayout(null);
        JScrollPane scrPane = new JScrollPane(container);
        getContentPane().add(scrPane);

        //Etykieta przycisku start
        buttonSimulation = new JButton("Start");
        buttonSimulation.setBounds(170,10,100,20);
        container.add(buttonSimulation);
        buttonSimulation.addActionListener(this);

        //Etykieta wylaczenie symulacji
        buttonClose = new JButton("Wylacz symulacje");
        buttonClose.setBounds(280,10,150,20);
        container.add(buttonClose);
        buttonClose.addActionListener(this);

        //Wyłączenie maksymalizacji okna
        setResizable(false);
        setLocationByPlatform(true);
        //Tytul okienka
        setTitle("Symulacja Windy");

        CreateElevatorFiled(numberOfElevators);
        CreateFloorFiled(numberOfFloors);

        // pole do ustawiania tła
        JLabel labelBackground = new JLabel(new ImageIcon("tlo2.jpg"));
        labelBackground.setOpaque(true);
        labelBackground.setBounds(0,0,screenWidth,screenHeight);
        container.add(labelBackground);

        simulator = new Simulator(numberOfFloors, numberOfElevators);

        //Etykieta czasu
        labelTime = new JLabel("Czas: " + simulator.getTime());
        labelTime.setBounds(10,10,150,20);
        labelTime.setOpaque(true);
        container.add(labelTime);
    }


    /** Metoda wykonująca akcję w zależności od wyboru użytkownika
     * */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        //Zamkniecie tego okna symulacji
        if(source== buttonClose) {
            dispose();
            timer.stop();
            simulator.stopTimer();
        }

        //Zamienienie przycisku start na pauza
        if(source == buttonSimulation && !check)
        {
            timer.start();
            simulator.startTimer();
            buttonSimulation.setText("Pauza");
            check=true;
        }

        //Zamienienie przycisku pauza na wznow
        else if(source== buttonSimulation && check)
        {
            timer.stop();
            simulator.stopTimer();
            buttonSimulation.setText("Wznów");
            check=false;
        }
    }



    /** Metoda tworząca tabelę textfiledów wind
     * @param numberOfElevators liczba wind
     * */
    private void CreateElevatorFiled(int numberOfElevators){
        // Szerokość pola tekstowego
        int width = 120;
        // Wysokość pola tekstowego
        int height  = 20;

        // Etykieta liczba pasażerów
        JLabel labelPassengers = new JLabel("Liczba pasażerów");
        labelPassengers.setBounds(width,30,width,height);
        container.add(labelPassengers);

        // Etykieta obecne piętro
        JLabel labelCurrentFloor = new JLabel(("Obecne piętro"));
        labelCurrentFloor.setBounds(width+(width+vspace),30,width,height);
        container.add(labelCurrentFloor);

        // Etykieta docelowe piętro
        JLabel labelTargetFloor = new JLabel("Docelowe piętro");
        labelTargetFloor.setBounds(width+(width+vspace)*2,30,width,height);
        container.add(labelTargetFloor);

        // Etykieta informacje
        JLabel labelInformation = new JLabel("Informacje");
        labelInformation.setBounds(width+(width+vspace)*3,30,width,height);
        container.add(labelInformation);

        List<List<JTextField>> textFileds = new ArrayList<>();
        textFileds.add(listFieldsNumberOfPassengers);
        textFileds.add(listFieldsCurrentFloor);
        textFileds.add(listFieldsTargetFloor);
        textFileds.add(listFieldsElevator);

        for(int i = 0; i < numberOfElevators; i++) {

            JLabel labelNumber = new JLabel("Winda nr " + (i+1) + ":" );
            labelNumber.setBounds(10,60 + i*(hspace+height),80,height);
            container.add(labelNumber);

            /*
             * Dla każdej listy textFiledow zwiazanej z windami tworzone jest nowe pole
             */
            for (List<JTextField> textFiled : textFileds){
                // Tworzenie nowego pola
                textFiled.add(new JTextField());
                // wyłączenie możliwości edycji
                textFiled.get(i).setEditable(false);
                // Dodanie pola do kontenera
                container.add(textFiled.get(i));
            }

            // Pole tekstowe informacji o liczbie pasażerów windy
            listFieldsNumberOfPassengers.get(i).setBounds(width,60+i*(hspace+height),width,height);

            // Pole tekstowe informacji o obecnym piętrze windy
            listFieldsCurrentFloor.get(i).setBounds(width+(width+vspace),60+i*(hspace+height),width,height);

            // Pole tekstowe informacji o docelowym piętrze windy
            listFieldsTargetFloor.get(i).setBounds(width+(width+vspace)*2,60+i*(hspace+height),width,height);

            // Pole tekstowe informacji o windzie
            listFieldsElevator.get(i).setBounds(width+(width+vspace)*3,60+i*(hspace+height),width*3,height);
        }
        lastLine = listFieldsTargetFloor.get(numberOfElevators-1).getY()+height*2;
    }

    /** Metoda tworząca Tabele pięter
     * @param numberOfFloors   liczba pięter
     * */
    private void CreateFloorFiled(int numberOfFloors){
        for(int i = 0; i < numberOfFloors; i++){
            int ddd = (i - i%10)/10;
            // Szerokość pola tekstowego
            int width = 120;
            // Wysokość pola tekstowego
            int height  = 20;
            JLabel numberFloor = new JLabel("Piętro nr " + (i + 1) + ":");
            numberFloor.setBounds(10 + 2*width*(ddd),lastLine+i%10*(hspace+height),width,height);
            container.add(numberFloor);

            // Pole tekstowe informacji o liczbie pasażerów w kolejce
            listFieldsFloors.add(new JTextField());
            listFieldsFloors.get(i).setBounds(width+ 2*width*(ddd),lastLine+i%10*(hspace+height),width,height);
            listFieldsFloors.get(i).setEditable(false);
            container.add(listFieldsFloors.get(i));
        }
    }

    /** Metoda timera
     * Aktualizuje wszystkie pola symulacji*/
    private void getTimerAction(){

        // Aktualizacja pól wind
        for(int i = 0; i < listFieldsElevator.size(); i++){
            listFieldsElevator.get(i).setText(simulator.GetInformation(i));
            listFieldsNumberOfPassengers.get(i).setText(Integer.toString(simulator.GetNumberofPassanger(i)));
            listFieldsTargetFloor.get(i).setText(Integer.toString(simulator.GetTargetFloorElevator(i)));
            listFieldsCurrentFloor.get(i).setText(Integer.toString(simulator.GetCurrentFloorElevator(i)));
        }

        // Aktualizacja pól pięter
        for(int i = 0; i < listFieldsFloors.size(); i++){
            listFieldsFloors.get(i).setText(Integer.toString(simulator.GetQueueLengthFloor(i)));
        }
        labelTime.setText("Czas: " + simulator.getTime());
    }
}

