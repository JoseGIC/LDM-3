package com.jose.ldm_3.game;

import java.util.List;

import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;
import com.jose.ldm_3.interfaces.Input.TouchEvent;


public class PantallaMaximasPuntuaciones extends Pantalla {
    String lineas[] = new String[5];

    public PantallaMaximasPuntuaciones(Juego juego) {
        super(juego);

        for (int i = 0; i < 5; i++) {
            lineas[i] = (i + 1) + "o." + Configuraciones.maxPuntuaciones[i] + " p";
        }
        if(Configuraciones.sonidoHabilitado) {
            Assets.musicaPuntuaciones.setLooping(true);
            Assets.musicaPuntuaciones.play();
        }
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 295, 1150, 130, 130)) {
                    juego.setScreen(new MainMenuScreen(juego));
                    if(Configuraciones.sonidoHabilitado) {
                        Assets.musicaPuntuaciones.stop();
                        Assets.pulsar.play(1);
                    }
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
        g.drawPixmap(Assets.puntuaciones, 0, 0);
        g.drawPixmap(Assets.botonSalir, 295, 1150);

        int y = 320;
        for (int i = 0; i < 5; i++) {
            dibujarTexto(g, lineas[i], 180, y);
            y += 50;
        }


    }

    public void dibujarTexto(Graficos g, String linea, int x, int y) {
        int len = linea.length();
        for (int i = 0; i < len; i++) {
            char character = linea.charAt(i);

            if (character == ' ') {
                x += 30;
                continue;
            }

            int index;
            if (character == '.') {
                index = 11;
            } else if(character == 'o') {
                    index = 10;
            } else if(character == 'p') {
                index = 12;
            } else {
                index = (character - '0');
            }

            g.drawPixmap(Assets.numeros[index], x, y);
            x += 30;
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
