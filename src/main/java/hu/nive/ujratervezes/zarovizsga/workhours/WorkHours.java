package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {
    /*
    A WorkHours osztályban implementáld a String minWork(String file) metódust!
    A metódus paraméterként megkapja egy fájl elérési útvonalát.
    A tesztesetben ez a src/test/resources/hu/nive/ujratervezes/zarovizsga/workhours/workhours.txt,
    így ebbe a könyvtárba tedd a fájlt!

A dolgozó neve, mennyi órát dolgozott egy nap, és a nap.
Azt kell visszaadni, hogy ki melyik nap dolgozott a legkevesebbet.
 A fenti fájl alapján John Doe 2021-01-04-én csak 2 órát dolgozott,
így a következő Stringet kell visszaadni: John Doe: 2021-01-04.
Egy napra, egy alkalmazotthoz mindig csak egy sor van.
     */
    public String minWork(String file) {
        String result = "";
        List<DailyData> dataList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");
                dataList.add(new DailyData(parts[0], Integer.parseInt(parts[1]), parts[2]));

            }
            result = getString(result, dataList);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }

    private String getString(String result, List<DailyData> dataList) {
        int min= dataList.get(0).getHours();
        for(DailyData dd: dataList){
            if(dd.getHours()< min){
                min= dd.getHours();
                result = String.format("%s: %s", dd.getName(), dd.getDate());
            }
        }
        return result;
    }
}
