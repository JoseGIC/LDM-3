package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Input.TouchEvent;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;

import java.util.List;


public class MainMenuScreen extends Pantalla {


    public MainMenuScreen(Juego juego) {
        super(juego);
        JuegoPiratas.onMainMenu = true;
        if(Configuraciones.sonidoHabilitado) {
            Assets.musicaInicio.setLooping(true);
            Assets.musicaInicio.play();
        }
    }

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 295, 1150, 130, 130)) {
                    Configuraciones.sonidoHabilitado = !Configuraciones.sonidoHabilitado;
                    if(Configuraciones.sonidoHabilitado) {
                        Assets.pulsar.play(1);
                        Assets.musicaInicio.play();
                    } else {
                        Assets.musicaInicio.stop();
                    }
                }
                if(inBounds(event, 102, 590, 516, 119) ) {
                    JuegoPiratas.onMainMenu = false;
                    Assets.musicaInicio.stop();
                    juego.setScreen(new PantallaJuego(juego));
                    if(Configuraciones.sonidoHabilitado)
                    {Assets.pulsar.play(1);
                    }
                    return;
                }
                if(inBounds(event, 102, 720, 516, 119) ) {
                    JuegoPiratas.onMainMenu = false;
                    Assets.musicaInicio.stop();
                    juego.setScreen(new PantallaMaximasPuntuaciones(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    return;
                }
                if(inBounds(event, 102, 850, 516, 119) ) {
                    JuegoPiratas.onMainMenu = false;
                    Assets.musicaInicio.stop();
                    juego.setScreen(new PantallaAyuda(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
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
        g.drawPixmap(Assets.logo, 0, 20);
        g.drawPixmap(Assets.menuprincipal, 0, 580);
        if(Configuraciones.sonidoHabilitado)
            g.drawPixmap(Assets.botonVolumen, 295, 1150);
        else
            g.drawPixmap(Assets.botonMute, 295, 1150);
    }

    @Override
    public void pause() {
        Configuraciones.save(juego.getFileIO());
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
