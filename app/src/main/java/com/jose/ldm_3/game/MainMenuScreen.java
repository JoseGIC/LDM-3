package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Input.TouchEvent;
import com.jose.ldm_3.interfaces.Pantalla;

import java.util.List;


public class MainMenuScreen extends Pantalla {


    public MainMenuScreen(com.jose.ldm_3.interfaces.Juego juego) {
        super(juego);
        JuegoPokemon.onMainMenu = true;
        if(Configuraciones.sonidoHabilitado) {
            Assets.musicaInicio.setLooping(true);
            Assets.musicaInicio.play();
        }
    }


    @Override
    public void update(float deltaTime) {
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
                if(inBounds(event, 102, 500, 516, 120) ) {
                    JuegoPokemon.onMainMenu = false;
                    Assets.musicaInicio.stop();
                    juego.setScreen(new PantallaJuego(juego));
                    if(Configuraciones.sonidoHabilitado)
                    {Assets.pulsar.play(1);
                    }
                    return;
                }
                if(inBounds(event, 102, 640, 516, 120) ) {
                    JuegoPokemon.onMainMenu = false;
                    Assets.musicaInicio.stop();
                    juego.setScreen(new PantallaEntrenadores(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    return;
                }
                if(inBounds(event, 102, 780, 516, 120) ) {
                    JuegoPokemon.onMainMenu = false;
                    Assets.musicaInicio.stop();
                    juego.setScreen(new PantallaPuntuaciones(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    return;
                }
                if(inBounds(event, 102, 920, 516, 120) ) {
                    JuegoPokemon.onMainMenu = false;
                    Assets.musicaInicio.stop();
                    juego.setScreen(new PantallaAyuda1(juego));
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

        g.drawPixmap(Assets.fondo, 0, 0);
        g.drawPixmap(Assets.pantallaPrincipal, 0, 0);
        if(Configuraciones.sonidoHabilitado)
            g.drawPixmap(Assets.botones, 295, 1150, 130, 130, 130, 130);
        else
            g.drawPixmap(Assets.botones, 295, 1150, 0, 130, 130, 130);
    }


    @Override
    public void pause() {
        Configuraciones.save(juego.getFileIO());
    }


    @Override
    public void resume() {}


    @Override
    public void dispose() {}

}
