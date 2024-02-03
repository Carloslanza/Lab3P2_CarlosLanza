/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemones;

/**
 *
 * @author carloslanza
 */
public class WaterType extends Pokemon {

    boolean vivir;
    int rapidez;

    public WaterType(boolean vivir, int rapidez, String nombre, int entrada, boolean atrapado) {
        super(nombre, entrada, atrapado);
        this.vivir = vivir;
        this.rapidez = rapidez;
    }

    public boolean isVivir() {
        return vivir;
    }

    public void setVivir(boolean vivir) {
        this.vivir = vivir;
    }

    public int getRapidez() {
        return rapidez;
    }

    public void setRapidez(int rapidez) {
        this.rapidez = rapidez;
    }

    @Override
    public String toString() {
        return super.toString() + "WaterType{" + "vivir=" + vivir + ", rapidez=" + rapidez + '}';
    }

}
