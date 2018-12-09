package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Pixmap;

public class Tripulacion {

    public Pixmap pixmap, lastPixmap;

    public int x, y, numPokemon, direccion, puntos;

    public Tripulacion(int x, int y, int numPokemon) {
        this.x = x;
        this.y = y;
        this.numPokemon = numPokemon;
        this.puntos = calcularPuntos();
    }

    public int calcularPuntos() {
        int pts = 0;
        int n = this.numPokemon;
        if(n == 0 || n == 3 || n ==  6 || n ==  9) {
            pts = 10;
        } else if(n == 1 || n == 4 || n ==  7 || n == 10) {
            pts = 20;
        } else if(n == 2 || n == 5 || n ==  8 || n == 11) {
            pts = 30;
        } else if(n == 12 || n == 13 || n ==  14) {
            pts = 50;
        } else if(this.numPokemon == 15) {
            pts = 80;
        }
        return pts;
    }
}
