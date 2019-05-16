package simulator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/** Klasa wczytująca plik*/
public class ReadData {
    /** Tablice dla danych opisujacych pasazera */
    private int[] time;
    private int[] StartFloor;
    private int[] TargetFloor;
    private int[] IsPrivileged;

    ReadData() {
        Read("Data Base.txt");
    }

    /** Metoda wczytujaca dane pasażerów z pilku */
    public void Read(String filename)
    {
                try
                {
                    List<String> allLines = Files.readAllLines(Paths.get(filename));
                    int j=0;
                    for(int i=0;i<allLines.size()/4;i++)
                    {
                        time[i]=Integer.parseInt(allLines.get(j));
                        j++;
                        StartFloor[i]=Integer.parseInt(allLines.get(j));
                        j++;
                        TargetFloor[i]=Integer.parseInt(allLines.get(j));
                        j++;
                        IsPrivileged[i]=Integer.parseInt(allLines.get(j));
                        j++;
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
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