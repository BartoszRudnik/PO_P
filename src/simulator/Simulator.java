package simulator;
import java.util.Scanner;
import java.io.*;

/* Klasa symulacji
 * Główna klasa pliku, zawiera funkcją main
  * */
public class Simulator{

    public static void main(String[]args){
        int numberOfFloors;
        int numberOfElevators;
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbę pięter: ");
        numberOfFloors = scan.nextInt();
        System.out.println("Podaj liczbę wind: ");
        numberOfElevators = scan.nextInt();

        Building building = new Building( numberOfFloors, numberOfElevators);
        Control control = new Control();
    }
}
