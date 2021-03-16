package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {
    /*
    A DigitsCounter osztálynak legyen egy int getCountOfDigits(String s) metódusa,
    mely megszámolja, hogy hány különböző számjegy van a bemeneti Stringben.
     */

    public int getCountOfDigits(String s){

        Set<Character> digits= new HashSet<>();
        if(s!= null){
            for(Character ch: s.toCharArray()){
                if(Character.isDigit(ch)){
                    digits.add(ch);
                }
            }

        }

        return digits.size();
    }
}
