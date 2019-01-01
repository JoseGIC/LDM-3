package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;
import com.jose.ldm_3.interfaces.Input.TouchEvent;

import java.util.List;


public class PantallaJuego extends Pantalla {

    enum EstadoJuego {
        Preparado,
        Ejecutandose,
        Pausado,
        FinJuego,
        Victoria
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
        if(estado == EstadoJuego.Victoria)
            updateVictory(touchEvents);
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
                    mundo.entrenador.girarIzquierda();
                }
                if(event.x > 590 && event.y > 1150) {
                    mundo.entrenador.girarDerecha();
                }
            }
        }

        mundo.update(deltaTime);
        if(mundo.victoria) {
            if(Configuraciones.sonidoHabilitado) {
                Assets.musicaJuego.stop();
                Assets.musicaVictoria.play();
            }
            estado = EstadoJuego.Victoria;
        }
        if(mundo.finalJuego) {
            if(Configuraciones.sonidoHabilitado) {
                Assets.derrota.play(1);
                Assets.musicaJuego.stop();
            }
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
                    mundo.resetTime();
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
                if(inBounds(event, 295, 400, 130, 130)) {
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


    private void updateVictory(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 295, 400, 130, 130)) { // cambiar
                    if(Configuraciones.sonidoHabilitado) {
                        Assets.pulsar.play(1);
                        Assets.musicaVictoria.stop();
                    }
                    estado = EstadoJuego.Preparado;
                    juego.setScreen(new MainMenuScreen(juego));
                    return;
                }
            }
        }
    }


    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.fondo, 0, 0);
        drawWorld(mundo);
        if(estado == EstadoJuego.Preparado)
            drawReadyUI();
        if(estado == EstadoJuego.Ejecutandose)
            drawRunningUI();
        if(estado == EstadoJuego.Pausado)
            drawPausedUI();
        if(estado == EstadoJuego.FinJuego)
            drawGameOverUI();
        if(estado == EstadoJuego.Victoria)
            drawVictoryUI();

        drawText(g, puntuacion, g.getWidth() / 2 - puntuacion.length() * 24 / 2, 1200);
    }


    private void drawWorld(Mundo mundo) {
        Graficos g = juego.getGraphics();
        Equipo personaje = mundo.pokemonSalvaje;

        g.drawPixmap(Assets.pokemons[personaje.numero], personaje.xT, personaje.yT, personaje.srcX, personaje.srcY, 64, 64);

        for(int i = 0; i < mundo.entrenador.equipo.size(); i++) {
            personaje = mundo.entrenador.equipo.get(i);
            g.drawPixmap(Assets.pokemons[personaje.numero], personaje.xT, personaje.yT, personaje.srcX, personaje.srcY, 64, 64);
        }
    }


    private void drawReadyUI() {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.preparado, 102, 400);
    }


    private void drawRunningUI() {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.botones, 0, 1150, 130, 0, 130, 130);
        g.drawPixmap(Assets.botones, 590, 1150, 0, 0, 130, 130);
    }


    private void drawPausedUI() {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.menuPausa, 0, 200);
    }


    private void drawGameOverUI() {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.finJuego, 102, 200);
        g.drawPixmap(Assets.botones, 295, 400, 130, 260, 130, 130);
    }


    private void drawVictoryUI() {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.victoria, 102, 200);
        g.drawPixmap(Assets.botones, 295, 400, 130, 260, 130, 130);
    }


    public void drawText(Graficos g, String linea, int x, int y) {
        int len = linea.length();
        for (int i = 0; i < len; i++) {
            char character = linea.charAt(i);

            if (character == ' ') {
                x += 180;
                continue;
            }

            int srcX = (character - '0') * 25;

            g.drawPixmap(Assets.numeros, x, y, srcX, 0, 25, 40);
            x += 25;
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
    public void resume() {}


    @Override
    public void dispose() {}

}