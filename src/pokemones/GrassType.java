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
public class GrassType extends Pokemones {
String habitat;
int dominino;

    public GrassType(String habitat, int dominino) {
        this.habitat = habitat;
        this.dominino = dominino;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getDominino() {
        return dominino;
    }

    public void setDominino(int dominino) {
        this.dominino = dominino;
    }

    public static ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public static void setPokemonList(ArrayList<Pokemon> pokemonList) {
        Pokemones.pokemonList = pokemonList;
    }

    public static ArrayList<Pokeball> getPokeballList() {
        return pokeballList;
    }

    public static void setPokeballList(ArrayList<Pokeball> pokeballList) {
        Pokemones.pokeballList = pokeballList;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Pokemones.scanner = scanner;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Pokemones.random = random;
    }

    @Override
    public String toString() {
        return "GrassType{" + "habitat=" + habitat + ", dominino=" + dominino + '}';
    }

}
