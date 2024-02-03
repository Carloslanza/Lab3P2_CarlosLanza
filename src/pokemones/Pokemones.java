import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import pokemones.Pokeball;
import pokemones.Pokemon;

public class Pokemones {

    static ArrayList<Pokemon> lista_pokemon = new ArrayList<>();
    static ArrayList<Pokeball> pokeballList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Crear Pokémon");
            System.out.println("2. Crear Pokebola");
            System.out.println("3. Listar Pokémon");
            System.out.println("4. Eliminar Pokémon");
            System.out.println("5. Capturar Pokémon");
            System.out.println("6. Modificar Pokémon");
            System.out.println("7. Salir");

            System.out.print("Elija una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    crear_pokemon();
                    break;
                case 2:
                    crear_pokebola();
                    break;
                case 3:
                    listar_pokemones();
                    break;
                case 4:
                    eliminar_pokemon();
                    break;
                case 5:
                    capturar();
                    break;
                case 6:
                    modificar_pokemon();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (option != 7);
    }//fin main

    private static void crear_pokemon() {
        System.out.println("Elija el tipo de Pokémon (1. Fire, 2. Water, 3. Grass): ");
        int typeOption = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre del Pokémon: ");
        String name = scanner.nextLine();
        System.out.print("Número de Pokedex: ");
        int pokedexNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Naturaleza del Pokémon: ");
        String nature = scanner.nextLine();

        switch (typeOption) {
            case 1:
                System.out.print("Potencia de Llamas: ");
                int flamePower = scanner.nextInt();
                lista_pokemon.add(new fire(flamePower, name, pokedexNumber, nature, false));
                break;
            case 2:
                System.out.print("¿Puede vivir fuera del agua? (true/false): ");
                boolean canLiveOutsideWater = scanner.nextBoolean();
                System.out.print("Rapidez al nadar: ");
                int swimSpeed = scanner.nextInt();
                lista_pokemon.add(new water(canLiveOutsideWater, swimSpeed, name, pokedexNumber, nature, false));
                break;
            case 3:
                System.out.print("Hábitat del Pokémon: ");
                String habitat = scanner.nextLine();
                System.out.print("Dominio sobre las plantas (0 - 100): ");
                int plantDominance = scanner.nextInt();
                lista_pokemon.add(new grass(habitat, plantDominance, name, pokedexNumber, nature, false));
                break;
            default:
                System.out.println("Opción no válida.");
        }
        System.out.println("Pokémon creado exitosamente.");

    }

    private static void crear_pokebola() {
        System.out.print("Color de la Pokebola: ");
        String color = scanner.nextLine();
        System.out.print("Número de serie: ");
        int serialNumber = scanner.nextInt();
        System.out.print("Eficiencia de atrapado (1-3): ");
        int efficiency = scanner.nextInt();
        pokeballList.add(new pokeball(color, serialNumber, efficiency));
        System.out.println("Pokebola creada exitosamente.");
    }

    private static void listar_pokemones() {
        System.out.println("\nListado de Pokémon:");
        for (pokemon pokemon : lista_pokemon) {
            System.out.println(pokemon.nombre + " - " + pokemon.getClass().getSimpleName());
        }
    }

    private static void eliminar_pokemon() {
        System.out.println("Elija el tipo de Pokémon a eliminar (1. Fire-Type, 2. Water-Type, 3. Grass-Type): ");
        int typeOption = scanner.nextInt();
        scanner.nextLine();

        ArrayList<pokemon> filteredList = new ArrayList<>();

        switch (typeOption) {
            case 1:
                filteredList = filterPokemonList(fire.class);
                break;
            case 2:
                filteredList = filterPokemonList(water.class);
                break;
            case 3:
                filteredList = filterPokemonList(grass.class);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        if (!filteredList.isEmpty()) {
            System.out.println("Seleccione el índice del Pokémon a eliminar:");
            for (int i = 0; i < filteredList.size(); i++) {
                System.out.println(i + ". " + filteredList.get(i).nombre);
            }

            int indexToDelete = scanner.nextInt();
            if (indexToDelete >= 0 && indexToDelete < filteredList.size()) {
                lista_pokemon.remove(filteredList.get(indexToDelete));
                System.out.println("Pokémon eliminado exitosamente.");
            } else {
                System.out.println("Índice no válido.");
            }
        } else {
            System.out.println("No hay Pokémon de ese tipo para eliminar.");
        }
    }

    private static ArrayList<pokemon> filterPokemonList(Class<?> type) {
        ArrayList<pokemon> filteredList = new ArrayList<>();
        for (pokemon pokemon : lista_pokemon) {
            if (type.isInstance(pokemon)) {
                filteredList.add(pokemon);
            }
        }
        return filteredList;
    }

    private static void capturar() {
        if (pokeballList.isEmpty() || lista_pokemon.isEmpty()) {
            System.out.println("No hay suficientes Pokebolas o Pokémon para realizar la captura.");
            return;
        }

        System.out.println("Seleccione una Pokebola para utilizar:");
        for (int i = 0; i < pokeballList.size(); i++) {
            System.out.println(i + ". " + pokeballList.get(i).color);
        }

        int selectedPokeballIndex = scanner.nextInt();
        if (selectedPokeballIndex < 0 || selectedPokeballIndex >= pokeballList.size()) {
            System.out.println("Índice de Pokebola no válido.");
            return;
        }

        pokeball selectedPokeball = pokeballList.get(selectedPokeballIndex);

        ArrayList<pokemon> availablePokemons = getAvailablePokemons();
        if (availablePokemons.isEmpty()) {
            System.out.println("No hay Pokémon disponibles para capturar en este momento.");
            return;
        }

        pokemon capturedPokemon = availablePokemons.get(random.nextInt(availablePokemons.size()));
        System.out.println("¡El Pokémon " + capturedPokemon.nombre + " ha aparecido!");

        System.out.println("¿Desea intentar capturarlo o huir? (1. Capturar, 2. Huir): ");
        int captureChoice = scanner.nextInt();
        if (captureChoice == 1) {
            captureAttempt(selectedPokeball, capturedPokemon);
        } else if (captureChoice == 2) {
            System.out.println("Ha huido del encuentro.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static ArrayList<pokemon> getAvailablePokemons() {
        ArrayList<pokemon> availablePokemons = new ArrayList<>();
        for (pokemon pokemon : lista_pokemon) {
            if (!pokemon.atrapado) {
                availablePokemons.add(pokemon);
            }
        }
        return availablePokemons;
    }

    private static void captureAttempt(pokeball pokeball, pokemon pokemon) {
        double captureChance = 0.0;

        switch (pokeball.eficencia) {
            case 1:
                captureChance = 1.0 / 3.0;
                break;
            case 2:
                captureChance = 2.0 / 3.0;
                break;
            case 3:
                captureChance = 1.0;
                break;
        }

        if (random.nextDouble() <= captureChance) {
            pokemon.atrapado = true;
            //pokemon.pokebolaAtrapado = pokeball;
            pokeballList.remove(pokeball);
            System.out.println("¡Has capturado a " + pokemon.nombre + " con éxito!");
        } else {
            pokeballList.remove(pokeball);
            System.out.println("No se pudo capturar a " + pokemon.nombre + ".");
        }
    }

    private static void modificar_pokemon() {
        if (lista_pokemon.isEmpty()) {
            System.out.println("No hay Pokémon para modificar.");
            return;
        }

        System.out.println("Seleccione el tipo de Pokémon a modificar (1. Fire-Type, 2. Water-Type, 3. Grass-Type): ");
        int typeOption = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        ArrayList<pokemon> filteredList = new ArrayList<>();

        switch (typeOption) {
            case 1:
                filteredList = filterPokemonList(fire.class);
                break;
            case 2:
                filteredList = filterPokemonList(water.class);
                break;
            case 3:
                filteredList = filterPokemonList(grass.class);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        if (!filteredList.isEmpty()) {
            System.out.println("Seleccione el índice del Pokémon a modificar:");
            for (int i = 0; i < filteredList.size(); i++) {
                System.out.println(i + ". " + filteredList.get(i).nombre);
            }

            int indexToModify = scanner.nextInt();
            if (indexToModify >= 0 && indexToModify < filteredList.size()) {
                modificar_atributos(filteredList.get(indexToModify));
            } else {
                System.out.println("Índice no válido.");
            }
        } else {
            System.out.println("No hay Pokémon de ese tipo para modificar.");
        }
    }

    private static void modificar_atributos(pokemon pokemon) {
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Número de Pokedex");
        System.out.println("3. Atributo específico del tipo de Pokémon");

        int attributeChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (attributeChoice) {
            case 1:
                System.out.print("Nuevo nombre: ");
                String newName = scanner.nextLine();
                pokemon.nombre = newName;
                System.out.println("Nombre modificado exitosamente.");
                break;
            case 2:
                System.out.print("Nuevo número de Pokedex: ");
                int newPokedexNumber = scanner.nextInt();
                pokemon.entrada = newPokedexNumber;
                System.out.println("Número de Pokedex modificado exitosamente.");
                break;
            case 3:
                if (pokemon instanceof fire) {
                    modifyFireTypeAttributes((fire) pokemon);
                } else if (pokemon instanceof water) {
                    modifyWaterTypeAttributes((water) pokemon);
                } else if (pokemon instanceof grass) {
                    modifyGrassTypeAttributes((grass) pokemon);
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void modifyFireTypeAttributes(fire fireType) {
        System.out.print("Nueva potencia de llamas: ");
        int newFlamePower = scanner.nextInt();
        fireType.potencia = newFlamePower;
        System.out.println("Potencia de llamas modificada exitosamente.");
    }

    private static void modifyWaterTypeAttributes(water waterType) {
        System.out.print("¿Puede vivir fuera del agua? (true/false): ");
        boolean newCanLiveOutsideWater = scanner.nextBoolean();
        System.out.print("Nueva rapidez al nadar: ");
        int newSwimSpeed = scanner.nextInt();
        waterType.vivir = newCanLiveOutsideWater;
        waterType.rapidez = newSwimSpeed;
        System.out.println("Atributos modificados exitosamente.");
    }

    private static void modifyGrassTypeAttributes(grass grassType) {
        System.out.print("Nuevo hábitat del Pokémon: ");
        String newHabitat = scanner.nextLine();
        System.out.print("Nuevo dominio sobre las plantas (0 - 100): ");
        int newPlantDominance = scanner.nextInt();
        grassType.habitat = newHabitat;
        grassType.dominio = newPlantDominance;
        System.out.println("Atributos modificados exitosamente.");
    }

}