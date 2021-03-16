package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog{
    /*

Ha meghívod a Husky feed() metódusát, akkor a boldágságértéke néggyel nőjjön!
Ha a play() metódusát, akkor a paraméterként átadott órák száma szorozva hárommal nőjjön a boldogságértéke!
     */

    public Husky(String name) {
        super(name);
    }

    @Override
    void feed() {
        happiness+= 4;
    }

    @Override
    void play(int hours) {
        happiness+= (hours* 3);

    }
}
