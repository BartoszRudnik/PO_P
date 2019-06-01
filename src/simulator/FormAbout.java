package simulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FormAbout extends JFrame{

    private List <JTextField> listFieldsElevator = new ArrayList<>();
    private List <JTextField> listFieldsNumberOfPassengers = new ArrayList<>();
    private List <JTextField> listFieldsTargetFloor = new ArrayList<>();
    private List <JTextField> listFieldsFloors = new ArrayList<>();

    private JLabel labelInformation;
    private JLabel labelPassengers;
    private JLabel labelTargetFloor;
    private JLabel labelBackground;
    private JLabel labelTime;

    private Simulator simulator;

    private Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            getTimerAction();
        }
    });

    private int vspace = 10;
    private int hspace = 5;
    private int lastLine;

    /** Konstruktor
     * @param numberOfFloors liczba pięter budynku
     * @param numberOfElevators liczba wind budynku
     * */
    FormAbout( int numberOfFloors, int numberOfElevators)
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

        labelTime = new JLabel("Czas: ");
        labelTime.setBounds(10,10,150,20);
        add(labelTime);

        CreateElevatorFiled(numberOfElevators);
        CreateFloorFiled(numberOfFloors);

        /** pole do ustawiania tła */
        labelBackground=new JLabel(new ImageIcon("tlo2.jpg"));
        labelBackground.setOpaque(true);
        labelBackground.setBounds(0,0,screenWidth,screenHeight);
        add(labelBackground);

        setResizable(false);
        simulator = new Simulator(numberOfFloors, numberOfElevators);
    }

    /** Metoda tworząca tabelę textfiledów wind*/
    private void CreateElevatorFiled(int numberOfElevators){
        /** Szerokość pola tekstowego */
        int width = 120;
        /** Wysokość pola tekstowego */
        int height  = 20;

        labelInformation = new JLabel("Informacje");
        labelInformation.setBounds(width,30,width,height);
        add(labelInformation);

        labelPassengers = new JLabel("Liczba pasażerów");
        labelPassengers.setBounds(width+(width+vspace),30,width,height);
        add(labelPassengers);

        labelTargetFloor = new JLabel("Docelowe piętro");
        labelTargetFloor.setBounds(width+(width+vspace)*2,30,width,height);
        add(labelTargetFloor);

        for(int i = 0; i < numberOfElevators; i++) {

            JLabel labelNumber = new JLabel("Winda nr " + Integer.toString(i+1) + ":" );
            labelNumber.setBounds(10,60 + i*(hspace+height),80,height);
            add(labelNumber);

            /** Pole tekstowe informacji o windzie */
            listFieldsElevator.add(new JTextField());
            listFieldsElevator.get(i).setBounds(width,60+i*(hspace+height),width,height);
            listFieldsElevator.get(i).setEditable(false);
            add(listFieldsElevator.get(i));

            /** Pole tekstowe informacji o liczbie pasażerów windy */
            listFieldsNumberOfPassengers.add(new JTextField());
            listFieldsNumberOfPassengers.get(i).setBounds(width+(width+vspace),60+i*(hspace+height),width,height);
            listFieldsNumberOfPassengers.get(i).setEditable(false);
            add(listFieldsNumberOfPassengers.get(i));

            /** Pole tekstowe informacji o docelowym piętrze windy */
            listFieldsTargetFloor.add(new JTextField());
            listFieldsTargetFloor.get(i).setBounds(width+(width+vspace)*2,60+i*(hspace+height),width,height);
            listFieldsTargetFloor.get(i).setEditable(false);
            add(listFieldsTargetFloor.get(i));
        }
        lastLine = listFieldsTargetFloor.get(numberOfElevators-1).getY()+height*2;
    }

    /** Metoda tworząca Tabele pięter*/
    private void CreateFloorFiled(int numberOfFloors){
        for(int i = 0; i < numberOfFloors; i++){
            /** Szerokość pola tekstowego */
            int width = 120;
            /** Wysokość pola tekstowego */
            int height  = 20;
            JLabel numberFloor = new JLabel("Piętro nr " + (i + 1) + ":");
            numberFloor.setBounds(10,lastLine+i*(hspace+height),width,height);
            add(numberFloor);

            /** Pole tekstowe informacji o liczbie pasażerów w kolejce */
            listFieldsFloors.add(new JTextField());
            listFieldsFloors.get(i).setBounds(width,lastLine+i*(hspace+height),width,height);
            listFieldsFloors.get(i).setEditable(false);
            add(listFieldsFloors.get(i));
        }
    }

    /** Metoda timera
     * Aktualizuje wszystkie pola symulacji*/
    private void getTimerAction(){
        // Aktualizacja pól wind
        for(int i = 0; i < listFieldsElevator.size(); i++){
            Elevator elevator = simulator.getBuilding().GetElevator(i);
            listFieldsElevator.get(i).setText(elevator.information);
            listFieldsNumberOfPassengers.get(i).setText(Integer.toString(elevator.MaxNumberPassangers()-elevator.GetNumberOfFreePlaces()));
            listFieldsTargetFloor.get(i).setText(Integer.toString(elevator.getTargetFloor()));
        }
        // Aktualizacja pól pięter
        for(int i = 0; i < listFieldsFloors.size(); i++){
            Floor floor = simulator.getBuilding().GetFloor(i);
            listFieldsFloors.get(i).setText(Integer.toString(floor.GetQueueLength()));
        }
    }
}
