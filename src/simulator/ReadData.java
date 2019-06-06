package simulator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

/** Klasa wczytująca plik*/
class ReadData{
    /** Tablice dla danych opisujacych pasazera */
    private ArrayList<Integer>Time=new ArrayList<>() ;
    private ArrayList<Integer>StartFloor=new ArrayList<>();
    private ArrayList<Integer>TargetFloor=new ArrayList<>();
    private ArrayList<Integer>IsPrivileged=new ArrayList<>();

    /** Konstruktor klasy ReadData*/
    ReadData(){
        Read();
    }

    /** Metoda zwracajaca ilosc danych w tablicy */
    public int NumberOfPassangers(){
        return Time.size();
    }

    /** Metoda zwracajaca czas pasazera o indeksie 'index'
     * @param index
     * */
    public int  GetTime(int index){
        return Time.get(index);
    }

    /** Metoda zwracajaca pietro startowe pasazera o indeksie 'index'
     * @param index
     * */
    public int GetStartFloor(int index){
        return StartFloor.get(index);
    }

    /** Metoda zwracajaca pietro docelowe pasazera o indeksie 'index'
     * @param index
     * */
    public int GetTargetFloor(int index){
        return TargetFloor.get(index);
    }

    /** Metoda zwracajaca informacje o tym czy pasazer o indeksie 'index' jest uprzywilejowany
     * @param index
     * */
    public int GetIsPrivileged(int index){
        return IsPrivileged.get(index);
    }

    /** Metoda wczytujaca dane pasażerów z pilku */
    private void Read(){
        try{
            // Wczytujemy caly plik tekstowy do allLines */
            List<String>allLines = Files.readAllLines(Paths.get("Passengers.txt"));
            int j=0;
            // Dodajemy do tablic odpowiednie pola*/
            for(int i=0;i<allLines.size()/4;i++){
                Time.add(Integer.parseInt(allLines.get(j++)));
                StartFloor.add(Integer.parseInt(allLines.get(j++)));
                TargetFloor.add(Integer.parseInt(allLines.get(j++)));
                IsPrivileged.add(Integer.parseInt(allLines.get(j++)));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}