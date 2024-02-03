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
public class Pokeball {

    String color;
    int numeroSerie;
    int eficienciaAtrapado;

    public Pokeball(String color, int numeroSerie, int eficiencia) {
        this.color = color;
        this.numeroSerie = numeroSerie;
        this.eficienciaAtrapado = eficiencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getEficiencia() {
        return eficienciaAtrapado;
    }

    public void setEficiencia(int eficiencia) {
        this.eficienciaAtrapado = eficiencia;
    }

}
