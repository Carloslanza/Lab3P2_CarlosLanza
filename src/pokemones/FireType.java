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
int potencia;   

    public FireType(int potencia, String nombre, int entrada, boolean atrapado) {
        super(nombre, entrada, atrapado);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
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
        return "FireType{" + "potencia=" + potencia + '}';
    }

}
