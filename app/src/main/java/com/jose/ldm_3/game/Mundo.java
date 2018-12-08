package com.jose.ldm_3.game;

import java.util.Random;

public class Mundo {

    static final int MUNDO_ANCHO = 19;
    static final int MUNDO_ALTO = 36;
    static final int INCREMENTO_PUNTUACION = 10;
    static final float TICK_INICIAL = 0.5f;
    static final float TICK_DECREMENTO = 0.05f;

    public JollyRoger jollyroger;
    public static Tripulacion pokemonSalvaje;
    public boolean finalJuego = false;
    public int puntuacion = 0;

    boolean campos[][] = new boolean[MUNDO_ANCHO][MUNDO_ALTO];
    Random random = new Random();
    float tiempoTick = 0;
    static float tick = TICK_INICIAL;

    public Mundo() {
        jollyroger = new JollyRoger();
        colocarBotin();
    }

    private void colocarBotin() {
        for (int x = 0; x < MUNDO_ANCHO; x++) {
            for (int y = 0; y < MUNDO_ALTO; y++) {
                campos[x][y] = false;
            }
        }

        int len = jollyroger.equipo.size();
        for (int i = 0; i < len; i++) {
            Tripulacion equipo = jollyroger.equipo.get(i);
            if(equipo.x < MUNDO_ANCHO && equipo.y < MUNDO_ALTO) {
                campos[equipo.x][equipo.y] = true;
            }
        }

        int botinX = random.nextInt(MUNDO_ANCHO);
        int botinY = random.nextInt(MUNDO_ALTO);
        while (true) {
            if (!campos[botinX][botinY])
                break;
            botinX += 1;
            if (botinX >= MUNDO_ANCHO) {
                botinX = 0;
                botinY += 1;
                if (botinY >= MUNDO_ALTO) {
                    botinY = 0;
                }
            }
        }
        pokemonSalvaje = new Tripulacion(botinX, botinY, random.nextInt(15));
    }

    public void update(float deltaTime) {
        if (finalJuego)
            return;

        tiempoTick += deltaTime;

        while (tiempoTick > tick) {
            tiempoTick -= tick;
            jollyroger.avance();
            animacionPokemonSalvaje();
            if (jollyroger.comprobarChoque()) {
                finalJuego = true;
                return;
            }

            Tripulacion head = jollyroger.equipo.get(0);
            if (head.x == pokemonSalvaje.x && head.y == pokemonSalvaje.y) {
                puntuacion += INCREMENTO_PUNTUACION;
                jollyroger.abordaje(pokemonSalvaje.numPokemon);
                if (jollyroger.equipo.size() == MUNDO_ANCHO * MUNDO_ALTO) {
                    finalJuego = true;
                    return;
                } else {
                    colocarBotin();
                }

                if (puntuacion % 100 == 0 && tick - TICK_DECREMENTO > 0) {
                    tick -= TICK_DECREMENTO;
                }
            }
        }
    }


    public void animacionPokemonSalvaje() {
        if (pokemonSalvaje.lastPixmap == Assets.pokedex[pokemonSalvaje.numPokemon][0]) {
            pokemonSalvaje.pixmap = Assets.pokedex[pokemonSalvaje.numPokemon][1];
        } else if (pokemonSalvaje.lastPixmap == Assets.pokedex[pokemonSalvaje.numPokemon][1]) {
            pokemonSalvaje.pixmap = Assets.pokedex[pokemonSalvaje.numPokemon][2];
        } else if (pokemonSalvaje.lastPixmap == Assets.pokedex[pokemonSalvaje.numPokemon][2]) {
            pokemonSalvaje.pixmap = Assets.pokedex[pokemonSalvaje.numPokemon][3];
        } else if (pokemonSalvaje.lastPixmap == Assets.pokedex[pokemonSalvaje.numPokemon][3]) {
            pokemonSalvaje.pixmap = Assets.pokedex[pokemonSalvaje.numPokemon][0];
        } else {
            pokemonSalvaje.pixmap = Assets.pokedex[pokemonSalvaje.numPokemon][0];
        }
        pokemonSalvaje.lastPixmap = pokemonSalvaje.pixmap;
    }
}
