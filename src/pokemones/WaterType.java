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
    boolean puedeVivirFueraDelAgua;
    int rapidezNadar;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public boolean isAtrapado() {
        return atrapado;
    }

    public void setAtrapado(boolean atrapado) {
        this.atrapado = atrapado;
    }

    @Override
    public String toString() {
        return "WaterType{" + "vivir=" + vivir + ", rapidez=" + rapidez + '}';
    }

}
