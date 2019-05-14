package simulator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Klasa wczytująca plik*/
public class ReadData{
    /** Tablice dla danych opisujacych pasazera */
    private int[] time;
    private int[] StartFloor;
    private int[] TargetFloor;
    private int[] IsPrivileged;

    /** Metoda wczytujaca dane */
    public void Read(String filename) throws IOException{
        BufferedReader FileIn=null;
        try{
            FileIn=new BufferedReader(new FileReader(filename));
            /** Zmienna odpowiedzialna za indeksy tablic */
            int i=0;
            /** Odpowiedniki typu string dla pol opisujacych pasazera */
            String stime=FileIn.readLine();
            String sStartFloor=FileIn.readLine();
            String sTargetFloor=FileIn.readLine();
            String sIsPrivileged=FileIn.readLine();
            while(stime!=null){
                /** Zamienianie danych typu string i umieszczanie ich w tablicach */
                time[i]=Integer.parseInt(stime);
                StartFloor[i]=Integer.parseInt(sStartFloor);
                TargetFloor[i]=Integer.parseInt(sTargetFloor);
                IsPrivileged[i]=Integer.parseInt(sIsPrivileged);
                i++;
            }
        }
        finally{
            if(FileIn!=null)
                FileIn.close();
        }
    }

    /** Metoda zwracajaca ilosc danych w tablicy */
    public int NumberOfPassangers(){
        return time.length;
    }

    /** Metoda zwracajaca czas pasazera o indeksie 'index' */
    public int  GetTime(int index){
        return time[index];
    }

    /** Metoda zwracajaca pietro startowe pasazera o indeksie 'index' */
    public int GetStartFloor(int index){
        return StartFloor[index];
    }

    /** Metoda zwracajaca pietro docelowe pasazera o indeksie 'index' */
    public int GetTargetFloor(int index){
        return TargetFloor[index];
    }

    /** Metoda zwracajaca informacje o tym czy pasazer o indeksie 'index' jest uprzywilejowany */
    public int GetIsPrivileged(int index){
        return IsPrivileged[index];
    }
}