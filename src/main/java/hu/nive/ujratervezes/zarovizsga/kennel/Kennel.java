package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    /*
    Legyen egy Kennel osztály, mely nyilvántartja a kutyákat. A következő metódusokat implementáld:

    void addDog(Dog dog) - hozzáaad egy kutyát
    feedAll() - összes kutya feed() metódusát meghívja
     */

    List<Dog> dogs= new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog){
        dogs.add(dog);
    }
    public void feedAll(){
        for(Dog dog: dogs){
            dog.feed();
        }
    }
}
