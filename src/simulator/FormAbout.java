package simulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class FormAbout extends JFrame{

    private List <JTextField> listFiledsElevator = new ArrayList<>();
    private List <JTextField> listFiledsNumberOfPassengers = new ArrayList<>();
    private List <JTextField> listFiledsTargetFloor = new ArrayList<>();
    private List <JTextField> getListFiledsFloors = new ArrayList<>();

    private JLabel labelInformation;
    private JLabel labelPassengers;
    private JLabel labelTargetFloor;

    private JLabel labelTime;
    private int vspace = 10;
    private int hspace = 5;


    /** Konstruktor
     * @param numberOfFloors
     * @param numberOfElevators
     * */
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

        CreateElevatorFiled(numberOfElevators);

        Simulator simulator = new Simulator(numberOfFloors, numberOfElevators);
    }

    /** Metoda tworząca tabelę textfiledów wind*/
    private void CreateElevatorFiled(int numberOfElevators){
        // Szerokość pola tekstowego
        int width = 120;
        // Wysokość pola tekstowego
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

            labelTime = new JLabel("Winda nr " + Integer.toString(i+1) + ":" );
            labelTime.setBounds(10,60 + i*(hspace+height),80,height);
            add(labelTime);

            // Pole tekstowe informacji o windzie
            listFiledsElevator.add(new JTextField());
            listFiledsElevator.get(i).setBounds(width,60+i*(hspace+height),width,height);
            listFiledsElevator.get(i).setEditable(false);
            add(listFiledsElevator.get(i));

            // Pole tekstowe informacji o liczbie pasażerów windy
            listFiledsNumberOfPassengers.add(new JTextField());
            listFiledsNumberOfPassengers.get(i).setBounds(width+(width+vspace),60+i*(hspace+height),width,height);
            listFiledsNumberOfPassengers.get(i).setEditable(false);
            add(listFiledsNumberOfPassengers.get(i));

            // Pole tekstowe informacji o docelowym piętrze windy
            listFiledsTargetFloor.add(new JTextField());
            listFiledsTargetFloor.get(i).setBounds(width+(width+vspace)*2,60+i*(hspace+height),width,height);
            listFiledsTargetFloor.get(i).setEditable(false);
            add(listFiledsTargetFloor.get(i));
        }
    }
}
