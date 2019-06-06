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
    // zmienna wyznaczająca obence piętro
    private static int currentFloor;
    // zmienna wyznaczająca docelowe piętro
    private static int targetFloor;
    // zmienna informująca czy pasażer jest uprzywilejowany
    private static int isPrivileged;
    // zmienna czasu pojawienia się pasażera na piętrze
    private static int timepassenger;
    // zmienna liczby pięter w budynku
    private static int numberOfFloors;


/** metoda losowania czasów pasażera i sortowania rosnącego
    @param czasy
    @param set
 */
    public  void time (int set,ArrayList czasy)
    {

        Random random = new Random();

        /** wypełnienie listy */

        for (int i=0;i<set;i++)
        {
            czasy.add(random.nextInt(1000));
        }

        /** sortowanie list */

        Collections.sort(czasy);

    }



    public static void main(String[] args) throws IOException
    {
        /** tworzenie pliku */
        PrintWriter writer = new PrintWriter("Passengers.txt");
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
            writer.print(timepassenger);
            writer.println();

            /** obecne piętre */
        currentFloor = random.nextInt(numberOfFloors);
            /** zapis */
        writer.print(currentFloor);
            writer.println();

            /** docelowe piętro */
        targetFloor = random.nextInt(numberOfFloors);
            /** zapis */
        writer.print(targetFloor);
            writer.println();

            /** czy uprzywilejowany? */
        if(i%10==0)
            isPrivileged = 1;
        else
            isPrivileged = 0;
            /** Zapis */
        writer.print(isPrivileged);
            writer.println();


        }


        writer.close();
    }

}
