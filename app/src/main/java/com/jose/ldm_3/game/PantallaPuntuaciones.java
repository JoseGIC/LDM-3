package com.jose.ldm_3.game;

import java.util.List;

import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;
import com.jose.ldm_3.interfaces.Input.TouchEvent;


public class PantallaPuntuaciones extends Pantalla {

    String lineas[] = new String[5];


    public PantallaPuntuaciones(Juego juego) {
        super(juego);

        for (int i = 0; i < 5; i++) {
            lineas[i] = (i + 1) + " " + Configuraciones.maxPuntuaciones[i];
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

        g.drawPixmap(Assets.fondo, 0, 0);
        g.drawPixmap(Assets.pantallaPuntuaciones, 0, 0);
        g.drawPixmap(Assets.botones, 295, 1150, 130, 260, 130, 130);

        int y = 450;
        for (int i = 0; i < 5; i++) {
            dibujarTexto(g, lineas[i], 200, y);
            y += 80;
        }


    }


    public void dibujarTexto(Graficos g, String linea, int x, int y) {
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

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
