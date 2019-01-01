package com.jose.ldm_3.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Mundo {

    static final int MUNDO_ANCHO = 10;
    static final int MUNDO_ALTO = 16;
    static final float TICK_INICIAL = 0.8f;
    static final float TICK_DECREMENTO = 0.05f;
    static final float TICK_TRANSICION = 0.1f;
    static final float TICK_TRANSICION_DECREMENTO = 0.00625f;

    public Entrenador entrenador;
    public static Equipo pokemonSalvaje;
    public boolean finalJuego = false;
    public boolean victoria = false;
    public int puntuacion = 0;

    boolean campos[][] = new boolean[MUNDO_ANCHO][MUNDO_ALTO];
    ArrayList<Integer> listaPokemons;
    Random random = new Random();
    float tiempoTick, tiempoTickTransicion;
    static float tick, tickTransicion;



    public Mundo() {
        tiempoTick = 0;
        tiempoTickTransicion = 0;
        tick = TICK_INICIAL;
        tickTransicion = TICK_TRANSICION;
        entrenador = new Entrenador();
        crearListaPokemons();
        colocarPokemon();
    }


    public void resetTime() {
        tiempoTick = 0;
        tiempoTickTransicion = 0;
        tick = TICK_INICIAL;
        tickTransicion = TICK_TRANSICION;
    }


    private void crearListaPokemons() {
        listaPokemons = new ArrayList<>();
        for(int i = 1; i <= 151; i++) {
            listaPokemons.add(i);
        }
        Collections.shuffle(listaPokemons);
    }


    private int nuevoPokemon() {
        int numPokemon = listaPokemons.get(0);
        listaPokemons.remove(0);
        return numPokemon;
    }


    private void colocarPokemon() {
        for (int x = 0; x < MUNDO_ANCHO; x++) {
            for (int y = 0; y < MUNDO_ALTO; y++) {
                campos[x][y] = false;
            }
        }

        int len = entrenador.equipo.size();
        for (int i = 0; i < len; i++) {
            Equipo equipo = entrenador.equipo.get(i);
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
        pokemonSalvaje = new Equipo(botinX, botinY, nuevoPokemon());
    }


    public void update(float deltaTime) {
        if (finalJuego)
            return;

        tiempoTick += deltaTime;
        tiempoTickTransicion += deltaTime;

        while(tiempoTick > tick) {
            tiempoTick -= tick;
            entrenador.avance();
            pokemonSalvaje.animacion();
            if (entrenador.comprobarChoque()) {
                finalJuego = true;
                return;
            }

            Equipo head = entrenador.equipo.get(0);
            if (head.x == pokemonSalvaje.x && head.y == pokemonSalvaje.y) {
                puntuacion++;
                entrenador.capturar(pokemonSalvaje.numero);
                if (entrenador.equipo.size() == Assets.pokemons.length - 1) { // 151
                    resetTime();
                    victoria = true;
                    return;
                } else {
                    colocarPokemon();
                }

                if(entrenador.equipo.size() % 5 == 0) {
                    if(tick - TICK_DECREMENTO > 0) {
                        tick -= TICK_DECREMENTO;
                        if(tickTransicion - TICK_TRANSICION_DECREMENTO > 0) {
                            tickTransicion -= TICK_TRANSICION_DECREMENTO;
                        }
                    }
                }
            }
        }

        while(tiempoTickTransicion > tickTransicion) {
            tiempoTickTransicion -= tickTransicion;
            for(int i = 0; i < entrenador.equipo.size(); i++) {
                entrenador.equipo.get(i).transicion();
            }
        }
    }

}
