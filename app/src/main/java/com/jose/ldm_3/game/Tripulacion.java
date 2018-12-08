package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Pixmap;

public class Tripulacion {

    public static final int TIPO_1 = 0;
    public static final int TIPO_2 = 1;
    public static final int TIPO_3 = 2;

    public Pixmap pixmap, lastPixmap;

    public int x, y, numPokemon, direccion;

    public Tripulacion(int x, int y, int numPokemon) {
        this.x = x;
        this.y = y;
        this.numPokemon = numPokemon;
    }
}
