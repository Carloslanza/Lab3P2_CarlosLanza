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
public class FireType extends Pokemon {

    int potenciaLlamas;

    public FireType(int potencia, String nombre, int entrada, boolean atrapado) {
        super(nombre, entrada, atrapado);
        this.potenciaLlamas = potencia;
    }

    public int getPotencia() {
        return potenciaLlamas;
    }

    public void setPotencia(int potencia) {
        this.potenciaLlamas = potencia;
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
        return "FireType{" + "potencia=" + potenciaLlamas + '}';
    }

}
