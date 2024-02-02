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
    int eficiencia;
    int eficienciaAtrapado;

    public Pokeball(String color, int numeroSerie, int eficiencia) {
        this.color = color;
        this.numeroSerie = numeroSerie;
        this.eficiencia = eficiencia;
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
        return eficiencia;
    }

    public void setEficiencia(int eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public String toString() {
        return "Pokeball{" + "color=" + color + ", numeroSerie=" + numeroSerie + ", eficiencia=" + eficiencia + '}';
    }

}
