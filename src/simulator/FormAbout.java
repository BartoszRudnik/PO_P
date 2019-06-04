package simulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FormAbout extends JFrame implements ActionListener{

    private List <JTextField> listFieldsElevator = new ArrayList<>();
    private List <JTextField> listFieldsNumberOfPassengers = new ArrayList<>();
    private List <JTextField> listFieldsCurrentFloor = new ArrayList<>();
    private List <JTextField> listFieldsTargetFloor = new ArrayList<>();
    private List <JTextField> listFieldsFloors = new ArrayList<>();

    private JLabel labelInformation;
    private JLabel labelPassengers;
    private JLabel labelCurrentFloor;
    private JLabel labelTargetFloor;
    private JLabel labelBackground;
    private JLabel labelTime;

    JButton buttonStart;

    private Simulator simulator;

    private Timer timer = new Timer(100, new ActionListener() {
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

        CreateElevatorFiled(numberOfElevators);
        CreateFloorFiled(numberOfFloors);

        /** pole do ustawiania tła */
        labelBackground=new JLabel(new ImageIcon("tlo2.jpg"));
        labelBackground.setOpaque(true);
        labelBackground.setBounds(0,0,screenWidth,screenHeight);
        add(labelBackground);

        setResizable(false);
        simulator = new Simulator(numberOfFloors, numberOfElevators);

        labelTime = new JLabel("Czas: " + Integer.toString(simulator.getTime()));
        labelTime.setBounds(10,10,150,20);
        labelTime.setOpaque(true);
        add(labelTime);

        buttonStart = new JButton("Start");
        buttonStart.setBounds(170,10,100,20);
        add(buttonStart);
        buttonStart.addActionListener(this);
    }

    /** Metoda tworząca tabelę textfiledów wind*/
    private void CreateElevatorFiled(int numberOfElevators){
        /** Szerokość pola tekstowego */
        int width = 120;
        /** Wysokość pola tekstowego */
        int height  = 20;


        labelPassengers = new JLabel("Liczba pasażerów");
        labelPassengers.setBounds(width,30,width,height);
        add(labelPassengers);

        labelCurrentFloor= new JLabel(("Obecne piętro"));
        labelCurrentFloor.setBounds(width+(width+vspace),30,width,height);
        add(labelCurrentFloor);

        labelTargetFloor = new JLabel("Docelowe piętro");
        labelTargetFloor.setBounds(width+(width+vspace)*2,30,width,height);
        add(labelTargetFloor);

        labelInformation = new JLabel("Informacje");
        labelInformation.setBounds(width+(width+vspace)*3,30,width,height);
        add(labelInformation);

        for(int i = 0; i < numberOfElevators; i++) {

            JLabel labelNumber = new JLabel("Winda nr " + Integer.toString(i+1) + ":" );
            labelNumber.setBounds(10,60 + i*(hspace+height),80,height);
            add(labelNumber);


            /** Pole tekstowe informacji o liczbie pasażerów windy */
            listFieldsNumberOfPassengers.add(new JTextField());
            listFieldsNumberOfPassengers.get(i).setBounds(width,60+i*(hspace+height),width,height);
            listFieldsNumberOfPassengers.get(i).setEditable(false);
            add(listFieldsNumberOfPassengers.get(i));

            /** Pole tekstowe informacji o obecnym piętrze windy */
            listFieldsCurrentFloor.add(new JTextField());
            listFieldsCurrentFloor.get(i).setBounds(width+(width+vspace),60+i*(hspace+height),width,height);
            listFieldsCurrentFloor.get(i).setEditable(false);
            add(listFieldsCurrentFloor.get(i));

            /** Pole tekstowe informacji o docelowym piętrze windy */
            listFieldsTargetFloor.add(new JTextField());
            listFieldsTargetFloor.get(i).setBounds(width+(width+vspace)*2,60+i*(hspace+height),width,height);
            listFieldsTargetFloor.get(i).setEditable(false);
            add(listFieldsTargetFloor.get(i));

            /** Pole tekstowe informacji o windzie */
            listFieldsElevator.add(new JTextField());
            listFieldsElevator.get(i).setBounds(width+(width+vspace)*3,60+i*(hspace+height),width*3,height);
            listFieldsElevator.get(i).setEditable(false);
            add(listFieldsElevator.get(i));
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
            listFieldsNumberOfPassengers.get(i).setText(Integer.toString(simulator.getBuilding().GetElevator(i).getNumberOfPassanger()));
            listFieldsTargetFloor.get(i).setText(Integer.toString(elevator.getTargetFloor()));
            listFieldsCurrentFloor.get(i).setText(Integer.toString(elevator.GetCurrentFloor()));
        }
        // Aktualizacja pól pięter
        for(int i = 0; i < listFieldsFloors.size(); i++){
            Floor floor = simulator.getBuilding().GetFloor(i);
            listFieldsFloors.get(i).setText(Integer.toString(floor.GetQueueLength()));
        }
        labelTime.setText("Czas: " + Integer.toString(simulator.getTime()));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object źródło = e.getSource();

        if(źródło == buttonStart) {
            timer.start();
            simulator.startTimer();
        }
    }
}
