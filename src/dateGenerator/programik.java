package dateGenerator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;



public class programik
{
    private static int currentFloor;
    private static int targetFloor;
    private static int isPrivileged;
    private static int timepassenger;
    private static int numberOfFloors;


/** metoda losowania czasów pasażera i sortowania rosnącego */
    public  void time (int set,ArrayList czasy)
    {

        /** tworzenie tablicy na czasy */
        Random random = new Random();

        /** wypełnienie listy */

        for (int i=0;i<set;i++)
        {
            czasy.add(random.nextInt(1000));
        }

        /** Sortowanie list */

        Collections.sort(czasy);

    }



    public static void main(String[] args) throws IOException
    {
        /** tworzenie pliku */
        File file = new File("plik.txt");
        file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
        /** tworzenie funkcji losowej */
        Random random = new Random();
        /**  Tworzenie obiektu scan do pobrania zadanej wartości */
        Scanner scan = new Scanner(System.in);

        /**  Pytanie do użytkownika  ile zestawów utworzyć ? */
        System.out.println("Ile pasażerów  utworzyć ?");
        /** zmienna set(zestaw), która przechowuje ilość zadanych zestawów */
        int set = scan.nextInt();


        /**  Pytanie do użytkownika  ile pięter utworzyć ? */
        System.out.println("Ile pięter chcesz utworzyć ?");
        /** zmienna nuberOfFloors przechowuje zadaną ilość pięter */
        numberOfFloors = scan.nextInt();


        /** tworzenie listy czasów */
        ArrayList<Integer> czasy = new ArrayList<>();

        /** utworzenie obiektu k klasy programik */
        programik k = new programik();
        /** wywołanie funkcji time  */
        k.time(set,czasy);





/** zapisywanie do pliku txt w kolejności : czas pojawienia się --> obecne piętre --> docelowe piętro  --> czy uprzywilejowany? */

        for(int i=0;i<set;i++)
        {
            /** czas pojawienia się pobierany z list czasy */
            timepassenger = czasy.get(i);
            /** zapis */
            writer.println(timepassenger);


            /** obecne piętre */
        currentFloor = random.nextInt(numberOfFloors);
            /** zapis */
        writer.println(currentFloor);


            /** docelowe piętro */
        targetFloor = random.nextInt(numberOfFloors);
            /** zapis */
        writer.println(targetFloor);


            /** czy uprzywilejowany? */
        if(i%10==0)
            isPrivileged = 1;
        else
            isPrivileged = 0;
            /** zapis */
        writer.println(isPrivileged);

        }
        writer.close();
    }

}
