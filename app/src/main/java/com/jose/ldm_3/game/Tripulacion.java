package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Pixmap;

public class Tripulacion {

    public Pixmap pixmap, lastPixmap;

    public int x, y, numPokemon, direccion;

    public Tripulacion(int x, int y, int numPokemon) {
        this.x = x;
        this.y = y;
        this.numPokemon = numPokemon;
    }
}
