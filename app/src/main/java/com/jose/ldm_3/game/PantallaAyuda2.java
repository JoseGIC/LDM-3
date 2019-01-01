package com.jose.ldm_3.game;


import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;
import com.jose.ldm_3.interfaces.Input.TouchEvent;

import java.util.List;


public class PantallaAyuda2 extends Pantalla {


    public PantallaAyuda2(Juego juego) {
        super(juego);
    }


    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 0, 1150, 130, 130)) {
                    juego.setScreen(new PantallaAyuda1(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    return;
                } else if(inBounds(event, 295, 1150, 130, 130)) {
                    juego.setScreen(new MainMenuScreen(juego));
                    if(Configuraciones.sonidoHabilitado) {
                        Assets.musicaAyuda.stop();
                        Assets.pulsar.play(1);
                    }
                    return;
                } else if(inBounds(event, 590, 1150, 130, 130)) {
                    juego.setScreen(new PantallaAyuda3(juego));
                    if(Configuraciones.sonidoHabilitado) {
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
        g.drawPixmap(Assets.pantallaAyuda2, 0, 0);
        g.drawPixmap(Assets.botones, 0, 1150, 130, 0, 130, 130);
        g.drawPixmap(Assets.botones, 295, 1150, 130, 260, 130, 130);
        g.drawPixmap(Assets.botones, 590, 1150, 0, 0, 130, 130);
    }


    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}

}

