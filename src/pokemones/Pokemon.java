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
public class Pokemon {

    String nombre;
    int entrada;
    boolean atrapado;
    Pokeball pokebolaAtrapado;
    int numeroPokedex;

    public Pokemon(String nombre, int entrada, boolean atrapado) {
        this.nombre = nombre;
        this.entrada = entrada;
        this.atrapado = atrapado;
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
        return "Pokemon{" + "nombre=" + nombre + ", entrada=" + entrada + ", atrapado=" + atrapado + '}';
    }

}
