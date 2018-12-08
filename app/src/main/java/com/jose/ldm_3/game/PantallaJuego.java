package com.jose.ldm_3.game;

import android.graphics.Color;

import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;
import com.jose.ldm_3.interfaces.Input.TouchEvent;
import com.jose.ldm_3.interfaces.Pixmap;

import java.util.List;


public class PantallaJuego extends Pantalla {
    enum EstadoJuego {
        Preparado,
        Ejecutandose,
        Pausado,
        FinJuego
    }

    EstadoJuego estado = EstadoJuego.Preparado;
    Mundo mundo;
    int antiguaPuntuacion = 0;
    String puntuacion = "0";

    public PantallaJuego(Juego juego) {
        super(juego);
        mundo = new Mundo();
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();

        if(estado == EstadoJuego.Preparado)
            updateReady(touchEvents);
        if(estado == EstadoJuego.Ejecutandose)
            updateRunning(touchEvents, deltaTime);
        if(estado == EstadoJuego.Pausado)
            updatePaused(touchEvents);
        if(estado == EstadoJuego.FinJuego)
            updateGameOver(touchEvents);

    }

    private void updateReady(List<TouchEvent> touchEvents) {
        if(touchEvents.size() > 0)
            estado = EstadoJuego.Ejecutandose;
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x < 64 && event.y < 64) {
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    estado = EstadoJuego.Pausado;
                    return;
                }
            }
            if(event.type == TouchEvent.TOUCH_DOWN) {
                if(event.x < 64 && event.y > 416) {
                    mundo.jollyroger.girarIzquierda();
                }
                if(event.x > 256 && event.y > 416) {
                    mundo.jollyroger.girarDerecha();
                }
            }
        }

        mundo.update(deltaTime);
        if(mundo.finalJuego) {
            if(Configuraciones.sonidoHabilitado)
                Assets.derrota.play(1);
            estado = EstadoJuego.FinJuego;
        }
        if(antiguaPuntuacion != mundo.puntuacion) {
            antiguaPuntuacion = mundo.puntuacion;
            puntuacion = "" + antiguaPuntuacion;
            if(Configuraciones.sonidoHabilitado)
                Assets.ataque.play(1);
        }
    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > 80 && event.x <= 240) {
                    if(event.y > 100 && event.y <= 148) {
                        if(Configuraciones.sonidoHabilitado)
                            Assets.pulsar.play(1);
                        estado = EstadoJuego.Ejecutandose;
                        return;
                    }
                    if(event.y > 148 && event.y < 196) {
                        if(Configuraciones.sonidoHabilitado)
                            Assets.pulsar.play(1);
                        juego.setScreen(new MainMenuScreen(juego));
                        return;
                    }
                }
            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x >= 128 && event.x <= 192 &&
                        event.y >= 200 && event.y <= 264) {
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    juego.setScreen(new MainMenuScreen(juego));
                    return;
                }
            }
        }
    }


    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.fondo, 0, 0);
        drawWorld(mundo);
        if (estado == EstadoJuego.Preparado)
            drawReadyUI();
        if (estado == EstadoJuego.Ejecutandose)
            drawRunningUI();
        if (estado == EstadoJuego.Pausado)
            drawPausedUI();
        if (estado == EstadoJuego.FinJuego)
            drawGameOverUI();

        drawText(g, puntuacion, g.getWidth() / 2 - puntuacion.length() * 20 / 2, g.getHeight() - 42);
    }

    private void drawWorld(Mundo mundo) {
        Graficos g = juego.getGraphics();
        JollyRoger jollyroger = mundo.jollyroger;
        Tripulacion head = jollyroger.equipo.get(0);

        Tripulacion pokemonSalvaje = mundo.pokemonSalvaje;


        Pixmap pokemonSalvajePixmap = null;
        if(pokemonSalvaje.pixmap != null) {
            pokemonSalvajePixmap = pokemonSalvaje.pixmap;
        } else {
            pokemonSalvajePixmap = Assets.pokedex[pokemonSalvaje.numPokemon][0];
        }
        int x = pokemonSalvaje.x * 32;
        int y = pokemonSalvaje.y * 32;
        g.drawPixmap(pokemonSalvajePixmap, x, y);


        int len = jollyroger.equipo.size();
        for(int i = 1; i < len; i++) {
            Tripulacion pokemon = jollyroger.equipo.get(i);
            Pixmap pokemonPixmap = null;

            if (pokemon.direccion == JollyRoger.ABAJO) {
                if(pokemon.pixmap != null) {
                    pokemonPixmap = pokemon.pixmap;
                } else {
                    pokemonPixmap = Assets.pokedex[pokemon.numPokemon][0];
                }
            }
            if (pokemon.direccion == JollyRoger.IZQUIERDA) {
                if(pokemon.pixmap != null) {
                    pokemonPixmap = pokemon.pixmap;
                } else {
                    pokemonPixmap = Assets.pokedex[pokemon.numPokemon][4];
                }
            }
            if (pokemon.direccion == JollyRoger.DERECHA) {
                if(pokemon.pixmap != null) {
                    pokemonPixmap = pokemon.pixmap;
                } else {
                    pokemonPixmap = Assets.pokedex[pokemon.numPokemon][8];
                }
            }
            if (pokemon.direccion == JollyRoger.ARRIBA) {
                if(pokemon.pixmap != null) {
                    pokemonPixmap = pokemon.pixmap;
                } else {
                    pokemonPixmap = Assets.pokedex[pokemon.numPokemon][12];
                }
            }
            x = pokemon.x * 32;
            y = pokemon.y * 32;
            g.drawPixmap(pokemonPixmap, x, y);
        }


        Pixmap headPixmap = null;
        if (jollyroger.direccion == JollyRoger.ABAJO) {
            if(jollyroger.rojoPixmap != null) {
                headPixmap = jollyroger.rojoPixmap;
            } else {
                headPixmap = Assets.rojo[1];
            }
        }
        if (jollyroger.direccion == JollyRoger.IZQUIERDA) {
            if(jollyroger.rojoPixmap != null) {
                headPixmap = jollyroger.rojoPixmap;
            } else {
                headPixmap = Assets.rojo[4];
            }
        }
        if (jollyroger.direccion == JollyRoger.DERECHA) {
            if(jollyroger.rojoPixmap != null) {
                headPixmap = jollyroger.rojoPixmap;
            } else {
                headPixmap = Assets.rojo[8];
            }
        }
        if (jollyroger.direccion == JollyRoger.ARRIBA) {
            if(jollyroger.rojoPixmap != null) {
                headPixmap = jollyroger.rojoPixmap;
            } else {
                headPixmap = Assets.rojo[12];
            }
        }
        x = head.x * 32;
        y = head.y * 32;
        g.drawPixmap(headPixmap, x, y);
    }

    private void drawReadyUI() {
        Graficos g = juego.getGraphics();

        g.drawPixmap(Assets.preparado, 47, 100);
        //g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawRunningUI() {
        Graficos g = juego.getGraphics();

        //g.drawPixmap(Assets.botones, 0, 0, 64, 128, 64, 64);
        //g.drawLine(0, 416, 480, 416, Color.BLACK);
        g.drawPixmap(Assets.botones, 0, 1216, 64, 64, 64, 64);
        g.drawPixmap(Assets.botones, 656, 1216, 0, 64, 64, 64);
    }

    private void drawPausedUI() {
        Graficos g = juego.getGraphics();

        g.drawPixmap(Assets.menupausa, 80, 100);
        //g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawGameOverUI() {
        Graficos g = juego.getGraphics();

        g.drawPixmap(Assets.finjuego, 62, 100);
        g.drawPixmap(Assets.botones, 128, 200, 0, 128, 64, 64);
        //g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    public void drawText(Graficos g, String line, int x, int y) {
        int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);

            if (character == ' ') {
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixmap(Assets.numeros, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }

    @Override
    public void pause() {
        if(estado == EstadoJuego.Ejecutandose)
            estado = EstadoJuego.Pausado;

        if(mundo.finalJuego) {
            Configuraciones.addScore(mundo.puntuacion);
            Configuraciones.save(juego.getFileIO());
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}