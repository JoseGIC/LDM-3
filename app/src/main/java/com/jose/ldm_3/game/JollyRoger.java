package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Pixmap;

import java.util.ArrayList;
import java.util.List;


public class JollyRoger{


    public static final int ARRIBA = 0;
    public static final int IZQUIERDA= 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;
    public List<Tripulacion> partes = new ArrayList<Tripulacion>();
    public int direccion;
    public Pixmap rojoPixmap, rojoLastPixmap;


    public JollyRoger() {
        direccion = ARRIBA;
        partes.add(new Tripulacion(5, 6, 0));
        //partes.add(new Tripulacion(5, 7, 0));
        //partes.add(new Tripulacion(5, 8, 0));
    }


    public void girarIzquierda() {
        direccion += 1;
        if(direccion > DERECHA)
            direccion = ARRIBA;
    }


    public void girarDerecha() {
        direccion -= 1;
        if(direccion < ARRIBA)
            direccion = DERECHA;
    }


    public void abordaje(int tipo) {
        Tripulacion end = partes.get(partes.size()-1);
        Tripulacion nuevoPokemon = new Tripulacion(end.x, end.y, tipo);
        partes.add(nuevoPokemon);
        calcularDireccion(nuevoPokemon, end);
    }


    public void calcularDireccion(Tripulacion segundo, Tripulacion primero) {
        if(segundo.x == primero.x) {
            if(segundo.y < primero.y) {
                segundo.direccion = ABAJO;
            } else {
                segundo.direccion = ARRIBA;
            }
        } else if(segundo.y == primero.y) {
            if(segundo.x < primero.x) {
                segundo.direccion = DERECHA;
            } else {
                segundo.direccion = IZQUIERDA;
            }
        }
    }


    public void avance() {
        Tripulacion barco = partes.get(0);

        int len = partes.size() - 1;
        for(int i = len; i > 0; i--) {
            Tripulacion primero = partes.get(i-1);
            Tripulacion segundo = partes.get(i);
            calcularDireccion(segundo, primero);
            animacionPokemons(segundo);
            segundo.x = primero.x;
            segundo.y = primero.y;
        }

        if(direccion == ARRIBA)
            barco.y -= 1;
        if(direccion == IZQUIERDA)
            barco.x -= 1;
        if(direccion == ABAJO)
            barco.y += 1;
        if(direccion == DERECHA)
            barco.x += 1;

        if(barco.x < 0)
            barco.x = 21;
        if(barco.x > 21)
            barco.x = 0;
        if(barco.y < 0)
            barco.y = 38;
        if(barco.y > 38)
            barco.y = 0;

        animacionRojo();
    }


    public boolean comprobarChoque() {
        int len = partes.size();
        Tripulacion barco = partes.get(0);
        for(int i = 1; i < len; i++) {
            Tripulacion parte = partes.get(i);
            if(parte.x == barco.x && parte.y == barco.y)
                return true;
        }
        return false;
    }


    public void animacionRojo() {
        if (direccion == ARRIBA) {
            if (rojoLastPixmap == Assets.rojoArriba1) {
                rojoPixmap = Assets.rojoArriba2;
            } else if (rojoLastPixmap == Assets.rojoArriba2) {
                rojoPixmap = Assets.rojoArriba3;
            } else if (rojoLastPixmap == Assets.rojoArriba3) {
                rojoPixmap = Assets.rojoArriba4;
            } else if (rojoLastPixmap == Assets.rojoArriba4) {
                rojoPixmap = Assets.rojoArriba1;
            } else {
                rojoPixmap = Assets.rojoArriba1;
            }
        }
        if (direccion == IZQUIERDA) {
            if (rojoLastPixmap == Assets.rojoIzquierda1) {
                rojoPixmap = Assets.rojoIzquierda2;
            } else if (rojoLastPixmap == Assets.rojoIzquierda2) {
                rojoPixmap = Assets.rojoIzquierda3;
            } else if (rojoLastPixmap == Assets.rojoIzquierda3) {
                rojoPixmap = Assets.rojoIzquierda4;
            } else if (rojoLastPixmap == Assets.rojoIzquierda4) {
                rojoPixmap = Assets.rojoIzquierda1;
            } else {
                rojoPixmap = Assets.rojoIzquierda1;
            }
        }
        if (direccion == ABAJO) {
            if (rojoLastPixmap == Assets.rojoAbajo1) {
                rojoPixmap = Assets.rojoAbajo2;
            } else if (rojoLastPixmap == Assets.rojoAbajo2) {
                rojoPixmap = Assets.rojoAbajo3;
            } else if (rojoLastPixmap == Assets.rojoAbajo3) {
                rojoPixmap = Assets.rojoAbajo4;
            } else if (rojoLastPixmap == Assets.rojoAbajo4) {
                rojoPixmap = Assets.rojoAbajo1;
            } else {
                rojoPixmap = Assets.rojoAbajo1;
            }
        }
        if (direccion == DERECHA) {
            if (rojoLastPixmap == Assets.rojoDerecha1) {
                rojoPixmap = Assets.rojoDerecha2;
            } else if (rojoLastPixmap == Assets.rojoDerecha2) {
                rojoPixmap = Assets.rojoDerecha3;
            } else if (rojoLastPixmap == Assets.rojoDerecha3) {
                rojoPixmap = Assets.rojoDerecha4;
            } else if (rojoLastPixmap == Assets.rojoDerecha4) {
                rojoPixmap = Assets.rojoDerecha1;
            } else {
                rojoPixmap = Assets.rojoDerecha1;
            }
        }
        rojoLastPixmap = rojoPixmap;
    }


    public void animacionPokemons(Tripulacion pokemon) {
        if (pokemon.direccion == ARRIBA) {
            if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][12]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][13];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][13]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][14];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][14]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][15];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][15]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][12];
            } else {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][12];
            }
        }
        if (pokemon.direccion == IZQUIERDA) {
            if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][4]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][5];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][5]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][6];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][6]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][7];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][7]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][4];
            } else {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][4];
            }
        }
        if (pokemon.direccion == ABAJO) {
            if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][0]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][1];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][1]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][2];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][2]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][3];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][3]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][0];
            } else {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][0];
            }
        }
        if (pokemon.direccion == DERECHA) {
            if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][8]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][9];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][9]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][10];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][10]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][11];
            } else if (pokemon.lastPixmap == Assets.pokedex[pokemon.numPokemon][11]) {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][8];
            } else {
                pokemon.pixmap = Assets.pokedex[pokemon.numPokemon][8];
            }
        }
        pokemon.lastPixmap = pokemon.pixmap;
    }
}

