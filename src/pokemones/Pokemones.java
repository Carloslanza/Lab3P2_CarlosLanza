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
public class Pokemones {

    static ArrayList<Pokemon> pokemonList = new ArrayList<>();
    static ArrayList<Pokeball> pokeballList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n----MENU----");
            System.out.println("1. Crear Pokemon");
            System.out.println("2. Crear Pokebola");
            System.out.println("3. Listar Pokemon");
            System.out.println("4. Eliminar Pokmon");
            System.out.println("5. Capturar Pokemon");
            System.out.println("6. Modificar Pokemon");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    crearPokemon();
                    break;
                case 2:
                    crearPokebola();
                    break;
                case 3:
                    listarPokemon();
                    break;
                case 4:
                    eliminarPokemon();
                    break;
                case 5:
                    capturarPokemon();
                    break;
                case 6:
                    modificarPokemon();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentelo de nuevo.");
                    break;
            }
        } while (opcion != 7);
    }

    private static void crearPokemon() {
        System.out.println("Elija el tipo de Pokemon (1. Fire-Type, 2. Water-Type, 3. Grass-Type): ");
        int tipoPokemon = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Nombre del Pokemon: ");
        String nombre = scanner.nextLine();
        System.out.print("Numero de Pokedex: ");
        int numeroPokedex = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Naturaleza del Pokemon: ");
        String naturaleza = scanner.nextLine();

        switch (tipoPokemon) {
            case 1:
                System.out.print("Potencia de Llamas: ");
                int potenciaLlamas = scanner.nextInt();
                pokemonList.add(new FireType(potenciaLlamas, nombre, potenciaLlamas, true));
                break;
            case 2:
                System.out.print("¿Puede vivir fuera del agua? (true/false): ");
                boolean puedeVivirFueraDelAgua = Boolean.parseBoolean(scanner.next());
                System.out.print("Rapidez al nadar: ");
                int rapidezNadar = scanner.nextInt();
                scanner.nextLine(); 
                pokemonList.add(new WaterType(puedeVivirFueraDelAgua, rapidezNadar, nombre, rapidezNadar, puedeVivirFueraDelAgua));
                break;
            case 3:
                System.out.println("Ingrese su habitat");
                String habitat = scanner.nextLine();
                System.out.println("Ingrese su dominio de plantas");
                int dominioPlantas = scanner.nextInt();
                int entrada=0;
                System.out.print("¿Puede vivir fuera del agua? (true/false): ");
                boolean VivirFueraDelAgua = Boolean.parseBoolean(scanner.next());
                pokemonList.add(new GrassType(habitat, dominioPlantas, nombre, entrada, VivirFueraDelAgua));
                break;
            default:
                System.out.println("Opcion no valida.");
        }
        System.out.println("Pokemon creado exitosamente.");
    }

    private static void crearPokebola() {
        System.out.print("Color de la Pokebola: ");
        String color = scanner.nextLine();
        System.out.print("Numero de serie: ");
        int numeroSerie = scanner.nextInt();
        System.out.print("Eficiencia de atrapado (1-3): ");
        int eficienciaAtrapado = scanner.nextInt();
        pokeballList.add(new Pokeball(color, numeroSerie, eficienciaAtrapado));
        System.out.println("Pokebola creada exitosamente.");
    }

    private static void listarPokemon() {
        System.out.println("\nListado de Pokemon:");
        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemon.nombre + " - " + pokemon.getClass().getSimpleName());
        }
    }

    private static void eliminarPokemon() {
        System.out.println("Elija el tipo de Pokemon a eliminar (1. Fire-Type, 2. Water-Type, 3. Grass-Type): ");
        int tipoPokemon = scanner.nextInt();
        scanner.nextLine(); 

        ArrayList<Pokemon> listaFiltrada = new ArrayList<>();

        switch (tipoPokemon) {
            case 1:
                listaFiltrada = filtrarListaPokemon(FireType.class);
                break;
            case 2:
                listaFiltrada = filtrarListaPokemon(WaterType.class);
                break;
            case 3:
                listaFiltrada = filtrarListaPokemon(GrassType.class);
                break;
            default:
                System.out.println("Opcion no valida.");
        }

        if (!listaFiltrada.isEmpty()) {
            System.out.println("Seleccione el indice del Pokemon a eliminar:");
            for (int i = 0; i < listaFiltrada.size(); i++) {
                System.out.println(i + ". " + listaFiltrada.get(i).nombre);
            }

            int indiceEliminar = scanner.nextInt();
            if (indiceEliminar >= 0 && indiceEliminar < listaFiltrada.size()) {
                pokemonList.remove(listaFiltrada.get(indiceEliminar));
                System.out.println("Pokemon eliminado exitosamente.");
            } else {
                System.out.println("Indice no valido.");
            }
        } else {
            System.out.println("No hay Pokemon de ese tipo para eliminar.");
        }
    }

    private static ArrayList<Pokemon> filtrarListaPokemon(Class tipo) {
        ArrayList<Pokemon> listaFiltrada = new ArrayList();
        for (Pokemon pokemon : pokemonList) {
            if (tipo.isInstance(pokemon)) {
                listaFiltrada.add(pokemon);
            }
        }
        return listaFiltrada;
    }

    private static void capturarPokemon() {
        if (pokemonList.isEmpty() || pokemonList.isEmpty()) {
            System.out.println("No hay suficientes Pokebolas o Pokemon para realizar la captura.");
            return;
        }

        System.out.println("Seleccione una Pokebola para utilizar:");
        for (int i = 0; i <=pokemonList.size(); i++) {
            System.out.println(i + ". " + pokeballList.get(i).color);
        }

        int indicePokebolaSeleccionada = scanner.nextInt();
        if (indicePokebolaSeleccionada < 0 || indicePokebolaSeleccionada >= pokemonList.size()) {
            System.out.println("Indice de Pokebola no valido.");
            return;
        }

        Pokeball pokebolaSeleccionada = pokeballList.get(indicePokebolaSeleccionada);

        ArrayList<Pokemon> pokemonesDisponibles = obtenerPokemonesDisponibles();
        if (pokemonesDisponibles.isEmpty()) {
            System.out.println("No hay Pokemon disponibles para capturar en este momento.");
            return;
        }

        Pokemon pokemonCapturado = pokemonesDisponibles.get(random.nextInt(pokemonesDisponibles.size()));
        System.out.println("¡El Pokémon " + pokemonCapturado.nombre + " ha aparecido!");

        System.out.println("¿Desea intentar capturarlo o huir? (1. Capturar, 2. Huir): ");
        int eleccionCaptura = scanner.nextInt();
        if (eleccionCaptura == 1) {
            intentoCaptura(pokebolaSeleccionada, pokemonCapturado);
        } else if (eleccionCaptura == 2) {
            System.out.println("Ha huido del encuentro.");
        } else {
            System.out.println("Opcion no válida.");
        }
    }

    private static ArrayList<Pokemon> obtenerPokemonesDisponibles() {
        ArrayList<Pokemon> pokemonesDisponibles = new ArrayList<>();
        for (Pokemon pokemon : pokemonList) {
            if (!pokemon.atrapado) {
                pokemonesDisponibles.add(pokemon);
            }
        }
        return pokemonesDisponibles;
    }

    private static void intentoCaptura(Pokeball pokebola, Pokemon pokemon) {
        double probabilidadCaptura = 0.0;

        switch (pokebola.eficienciaAtrapado) {
            case 1:
                probabilidadCaptura = 1.0 / 3.0;
                break;
            case 2:
                probabilidadCaptura = 2.0 / 3.0;
                break;
            case 3:
                probabilidadCaptura = 1.0;
                break;
        }

        if (random.nextDouble() <= probabilidadCaptura) {
            pokemon.atrapado = true;
            pokemon.pokebolaAtrapado = pokebola;
            pokeballList.remove(pokebola);
            System.out.println("¡Has capturado a " + pokemon.nombre + " con exito!");
        } else {
            pokemonList.remove(pokebola);
            System.out.println("No se pudo capturar a " + pokemon.nombre + ".");
        }
    }

    private static void modificarPokemon() {
        if (pokemonList.isEmpty()) {
            System.out.println("No hay Pokemon para modificar.");
            return;
        }

        System.out.println("Seleccione el tipo de Pokemon a modificar (1. Fire-Type, 2. Water-Type, 3. Grass-Type): ");
        int opcionTipo = scanner.nextInt();
        scanner.nextLine(); 

        ArrayList<Pokemon> listaFiltrada = new ArrayList<>();

        switch (opcionTipo) {
            case 1:
                listaFiltrada = filtrarListaPokemon(FireType.class);
                break;
            case 2:
                listaFiltrada = filtrarListaPokemon(WaterType.class);
                break;
            case 3:
                listaFiltrada = filtrarListaPokemon(GrassType.class);
                break;
            default:
                System.out.println("Opcion no valida.");
        }

        if (!listaFiltrada.isEmpty()) {
            System.out.println("Seleccione el indice del Pokemon a modificar:");
            for (int i = 0; i < listaFiltrada.size(); i++) {
                System.out.println(i + ". " + listaFiltrada.get(i).nombre);
            }

            int indiceModificar = scanner.nextInt();
            if (indiceModificar >= 0 && indiceModificar < listaFiltrada.size()) {
                modificarAtributosPokemon(listaFiltrada.get(indiceModificar));
            } else {
                System.out.println("Indice no valido.");
            }
        } else {
            System.out.println("No hay Pokemon de ese tipo para modificar.");
        }
    }

    private static void modificarAtributosPokemon(Pokemon pokemon) {
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Numero de Pokedex");
        System.out.println("3. Atributo especifico del tipo de Pokemon");

        int eleccionAtributo = scanner.nextInt();
        scanner.nextLine(); 

        switch (eleccionAtributo) {
            case 1:
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                pokemon.nombre = nuevoNombre;
                System.out.println("Nombre modificado exitosamente.");
                break;
            case 2:
                System.out.print("Nuevo numero de Pokedex: ");
                int nuevoNumeroPokedex = scanner.nextInt();
                pokemon.numeroPokedex = nuevoNumeroPokedex;
                System.out.println("Numero de Pokedex modificado exitosamente.");
                break;
            case 3:
                if (pokemon instanceof FireType) {
                    modificarAtributosFireType((FireType) pokemon);
                } else if (pokemon instanceof WaterType) {
                    modificarAtributosWaterType((WaterType) pokemon);
                } else if (pokemon instanceof GrassType) {
                    modificarAtributosGrassType((GrassType) pokemon);
                }
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }

    private static void modificarAtributosFireType(FireType fireType) {
        System.out.print("Nueva potencia de llamas: ");
        int nuevaPotenciaLlamas = scanner.nextInt();
        fireType.potenciaLlamas = nuevaPotenciaLlamas;
        System.out.println("Potencia de llamas modificada exitosamente.");
    }

    private static void modificarAtributosWaterType(WaterType waterType) {
        System.out.print("¿Puede vivir fuera del agua? (true/false): ");
        boolean nuevoPuedeVivirFueraDelAgua = Boolean.parseBoolean(scanner.next());
        System.out.print("Nueva rapidez al nadar: ");
        int nuevaRapidezNadar = scanner.nextInt();
        waterType.vivir = nuevoPuedeVivirFueraDelAgua;
        waterType.rapidez = nuevaRapidezNadar;
        System.out.println("Atributos modificados exitosamente.");
    }

    private static void modificarAtributosGrassType(GrassType grassType) {
        System.out.print("Nuevo habitat del Pokémon: ");
        String nuevoHabitat = scanner.nextLine();
        System.out.print("Nuevo dominio sobre las plantas (0 - 100): ");
        int nuevoDominioPlantas = scanner.nextInt();
        grassType.habitat = nuevoHabitat;
        grassType.dominioPlantas = nuevoDominioPlantas;
        System.out.println("Atributos modificados exitosamente.");
    }
}
