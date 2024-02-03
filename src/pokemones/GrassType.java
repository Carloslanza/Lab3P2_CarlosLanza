/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemones;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author carloslanza
 */
public class GrassType extends Pokemon {

    String habitat;
    int dominioPlantas;

    public GrassType(String habitat, int dominioPlantas, String nombre, int entrada, boolean atrapado) {
        super(nombre, entrada, atrapado);
        this.habitat = habitat;
        this.dominioPlantas = dominioPlantas;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getDominioPlantas() {
        return dominioPlantas;
    }

    public void setDominioPlantas(int dominioPlantas) {
        this.dominioPlantas = dominioPlantas;
    }

    @Override
    public String toString() {
        return "GrassType{" + "habitat=" + habitat + ", dominioPlantas=" + dominioPlantas + '}';
    }

}
