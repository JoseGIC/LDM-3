package com.jose.ldm_3.game;

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

    public static EstadoJuego estado = EstadoJuego.Preparado;
    Mundo mundo;
    int antiguaPuntuacion = 0;
    String puntuacion = "0";

    public PantallaJuego(Juego juego) {
        super(juego);
        mundo = new Mundo();
        if(Configuraciones.sonidoHabilitado) {
            Assets.musicaJuego.setLooping(true);
            Assets.musicaJuego.play();
        }
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
            if(event.type == TouchEvent.TOUCH_DOWN) {
                if(event.x < 130 && event.y > 1150) {
                    mundo.jollyroger.girarIzquierda();
                }
                if(event.x > 590 && event.y > 1150) {
                    mundo.jollyroger.girarDerecha();
                }
            }
        }

        mundo.update(deltaTime);
        if(mundo.finalJuego) {
            if(Configuraciones.sonidoHabilitado)
                Assets.derrota.play(1);
                Assets.musicaJuego.stop();
            estado = EstadoJuego.FinJuego;
        }
        if(antiguaPuntuacion != mundo.puntuacion) {
            antiguaPuntuacion = mundo.puntuacion;
            puntuacion = "" + antiguaPuntuacion;
            if(Configuraciones.sonidoHabilitado)
                Assets.capturar.play(1);
        }
    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 102, 200, 516, 120)) {
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    estado = EstadoJuego.Ejecutandose;
                    return;
                }
                if(inBounds(event, 102, 360, 516, 120)) {
                        if(Configuraciones.sonidoHabilitado) {
                            Assets.pulsar.play(1);
                            Assets.musicaJuego.stop();
                        }
                        estado = EstadoJuego.Preparado;
                        juego.setScreen(new MainMenuScreen(juego));
                        return;
                }
            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 295, 350, 130, 130)) {
                    if(Configuraciones.sonidoHabilitado) {
                        Assets.pulsar.play(1);
                        Assets.musicaJuego.stop();
                    }
                    estado = EstadoJuego.Preparado;
                    juego.setScreen(new MainMenuScreen(juego));
                    return;
                }
            }
        }
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }


    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.fondo2, 0, 0);
        drawWorld(mundo);
        if (estado == EstadoJuego.Preparado)
            drawReadyUI();
        if (estado == EstadoJuego.Ejecutandose)
            drawRunningUI();
        if (estado == EstadoJuego.Pausado)
            drawPausedUI();
        if (estado == EstadoJuego.FinJuego)
            drawGameOverUI();

        drawText(g, puntuacion, g.getWidth() / 2 - puntuacion.length() * 24 / 2, 1200);
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
        g.drawPixmap(Assets.preparado, 102, 400);
    }

    private void drawRunningUI() {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.botonIzquierda, 0, 1150);
        g.drawPixmap(Assets.botonDerecha, 590, 1150);
    }

    private void drawPausedUI() {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.menupausa, 0, 200);
    }

    private void drawGameOverUI() {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.finjuego, 102, 200);
        g.drawPixmap(Assets.botonSalir, 295, 350);
    }

    public void drawText(Graficos g, String linea, int x, int y) {
        int len = linea.length();
        for (int i = 0; i < len; i++) {
            char character = linea.charAt(i);

            if (character == ' ') {
                x += 30;
                continue;
            }

            int index;
            if (character == '.') {
                //index = 11;
                continue;
            } else if(character == 'o') {
                //index = 10;
                continue;
            } else if(character == 'p') {
                //index = 12;
                continue;
            } else {
                index = (character - '0');
            }

            g.drawPixmap(Assets.numeros[index], x, y);
            x += 30;
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