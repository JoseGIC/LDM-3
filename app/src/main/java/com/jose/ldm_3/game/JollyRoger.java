package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Pixmap;

import java.util.ArrayList;
import java.util.List;


public class JollyRoger{


    public static final int ARRIBA = 0;
    public static final int IZQUIERDA= 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;
    public List<Tripulacion> equipo = new ArrayList<Tripulacion>();
    public int direccion;
    public Pixmap rojoPixmap, rojoLastPixmap;


    public JollyRoger() {
        direccion = ABAJO;
        equipo.add(new Tripulacion(10, 19, -1));
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
        Tripulacion end = equipo.get(equipo.size()-1);
        Tripulacion nuevoPokemon = new Tripulacion(end.x, end.y, tipo);
        equipo.add(nuevoPokemon);
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
        Tripulacion barco = equipo.get(0);

        int len = equipo.size() - 1;
        for(int i = len; i > 0; i--) {
            Tripulacion primero = equipo.get(i-1);
            Tripulacion segundo = equipo.get(i);
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
        int len = equipo.size();
        Tripulacion barco = equipo.get(0);
        for(int i = 1; i < len; i++) {
            Tripulacion parte = equipo.get(i);
            if(parte.x == barco.x && parte.y == barco.y)
                return true;
        }
        return false;
    }


    public void animacionRojo() {
        if (direccion == ABAJO) {
            if (rojoLastPixmap == Assets.rojo[0]) {
                rojoPixmap = Assets.rojo[1];
            } else if (rojoLastPixmap == Assets.rojo[1]) {
                rojoPixmap = Assets.rojo[2];
            } else if (rojoLastPixmap == Assets.rojo[2]) {
                rojoPixmap = Assets.rojo[3];
            } else if (rojoLastPixmap == Assets.rojo[3]) {
                rojoPixmap = Assets.rojo[0];
            } else {
                rojoPixmap = Assets.rojo[0];
            }
        }
        if (direccion == IZQUIERDA) {
            if (rojoLastPixmap == Assets.rojo[4]) {
                rojoPixmap = Assets.rojo[5];
            } else if (rojoLastPixmap == Assets.rojo[5]) {
                rojoPixmap = Assets.rojo[6];
            } else if (rojoLastPixmap == Assets.rojo[6]) {
                rojoPixmap = Assets.rojo[7];
            } else if (rojoLastPixmap == Assets.rojo[7]) {
                rojoPixmap = Assets.rojo[4];
            } else {
                rojoPixmap = Assets.rojo[4];
            }
        }
        if (direccion == DERECHA) {
            if (rojoLastPixmap == Assets.rojo[8]) {
                rojoPixmap = Assets.rojo[9];
            } else if (rojoLastPixmap == Assets.rojo[9]) {
                rojoPixmap = Assets.rojo[10];
            } else if (rojoLastPixmap == Assets.rojo[10]) {
                rojoPixmap = Assets.rojo[11];
            } else if (rojoLastPixmap == Assets.rojo[11]) {
                rojoPixmap = Assets.rojo[8];
            } else {
                rojoPixmap = Assets.rojo[8];
            }
        }
        if (direccion == ARRIBA) {
            if (rojoLastPixmap == Assets.rojo[12]) {
                rojoPixmap = Assets.rojo[13];
            } else if (rojoLastPixmap == Assets.rojo[13]) {
                rojoPixmap = Assets.rojo[14];
            } else if (rojoLastPixmap == Assets.rojo[14]) {
                rojoPixmap = Assets.rojo[15];
            } else if (rojoLastPixmap == Assets.rojo[15]) {
                rojoPixmap = Assets.rojo[12];
            } else {
                rojoPixmap = Assets.rojo[12];
            }
        }
        rojoLastPixmap = rojoPixmap;
    }


    public void animacionPokemons(Tripulacion pokemon) {
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
        pokemon.lastPixmap = pokemon.pixmap;
    }
}

