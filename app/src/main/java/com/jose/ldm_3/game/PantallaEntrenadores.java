package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Input.TouchEvent;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;

import java.util.List;


public class PantallaEntrenadores extends Pantalla {


    private int numero = 0;
    private String nombres[] = {"ROJO", "OAK", "BILL", "BROCK",
                                "MAXIMO", "FREDO", "LANCE", "DRAKE",
                                "CINTIA", "INGRID", "LUTHIEN", "KAREN",
                                "ZEUS", "LOCKE", "TRAGAFUEGO", "PAYASO"};


    public PantallaEntrenadores(Juego juego) {
        super(juego);
        if(Configuraciones.sonidoHabilitado) {
            Assets.musicaEntrenadores.setLooping(true);
            Assets.musicaEntrenadores.play();
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
                        Assets.musicaEntrenadores.stop();
                        Assets.pulsar.play(1);
                    }
                    return;
                }
                if(inBoundsGrid(event, 150, 520, 80, 100)) {
                    Assets.pokemons[0] = Assets.entrenadores[numero];
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


    private boolean inBoundsGrid(TouchEvent event, int x, int y, int width, int height) {
        int eventX = event.x;
        int eventY = event.y;
        for(int i = 0; i < Assets.entrenadores.length; i++) {
            if((i % 4 == 0) && i != 0) {
                x = 150;
                y += 120;
            }
            if(eventX > x && eventX < x + width - 1 && eventY > y && eventY < y + height - 1) {
                numero = i;
                return true;
            }
            x += 110;
        }
        return false;

    }


    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.fondo, 0, 0);
        g.drawPixmap(Assets.pantallaEntrenadores, 0, 0);
        g.drawPixmap(Assets.botones, 295, 1150, 130, 260, 130, 130);
        g.drawPixmap(Assets.pokemons[0], 330, 360, 0, 0, 64, 64);

        String nombre = nombres[numero];
        dibujarNombre(g, nombre, g.getWidth() / 2 - nombre.length() * 40 / 2, 440);
    }


    public void dibujarNombre(Graficos g, String nombre, int x, int y) {
        int len = nombre.length();
        for (int i = 0; i < len; i++) {
            char caracter = nombre.charAt(i);
            int srcX = (caracter - 'A') * 40;
            g.drawPixmap(Assets.letras, x, y, srcX, 0, 40, 43);
            x += 40;
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
