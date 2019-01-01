package com.jose.ldm_3.game;

import java.util.ArrayList;
import java.util.List;


public class Entrenador {


    public static final int ARRIBA = 0;
    public static final int IZQUIERDA = 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;
    public List<Equipo> equipo = new ArrayList<Equipo>();
    public int direccion;


    public Entrenador() {
        direccion = ABAJO;
        equipo.add(new Equipo(5, 10, 0));
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


    public void capturar(int tipo) {
        Equipo end = equipo.get(equipo.size() - 1);
        Equipo nuevoPokemon = new Equipo(end.x, end.y, tipo);
        equipo.add(nuevoPokemon);
        calcularDireccion(nuevoPokemon, end);
    }


    public void calcularDireccion(Equipo segundo, Equipo primero) {
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
        Equipo entrenador = equipo.get(0);

        int len = equipo.size() - 1;
        for(int i = len; i > 0; i--) {
            Equipo primero = equipo.get(i-1);
            Equipo segundo = equipo.get(i);
            calcularDireccion(segundo, primero);
            segundo.animacion();
            segundo.lastX = segundo.x;
            segundo.lastY = segundo.y;
            segundo.x = primero.x;
            segundo.y = primero.y;
        }

        entrenador.lastX = entrenador.x;
        entrenador.lastY = entrenador.y;

        if(direccion == ARRIBA)
            entrenador.y -= 1;
        if(direccion == IZQUIERDA)
            entrenador.x -= 1;
        if(direccion == ABAJO)
            entrenador.y += 1;
        if(direccion == DERECHA)
            entrenador.x += 1;

        if(entrenador.x < 0) {
            entrenador.x = 10;
        }
        if(entrenador.x > 10) {
            entrenador.x = 0;
        }
        if(entrenador.y < 0) {
            entrenador.y = 16;
        }
        if(entrenador.y > 16) {
            entrenador.y = 0;
        }

        equipo.get(0).direccion = direccion;
        equipo.get(0).animacion();
    }


    public boolean comprobarChoque() {
        int len = equipo.size();
        Equipo barco = equipo.get(0);
        for(int i = 1; i < len; i++) {
            Equipo parte = equipo.get(i);
            if(parte.x == barco.x && parte.y == barco.y)
                return true;
        }
        return false;
    }

}

