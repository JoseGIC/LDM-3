package com.jose.ldm_3.game;


import com.jose.ldm_3.interfaces.Graficos;
import com.jose.ldm_3.interfaces.Graficos.PixmapFormat;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;
import com.jose.ldm_3.interfaces.Pixmap;



public class LoadingScreen extends Pantalla {

    public LoadingScreen(Juego juego) {
        super(juego);
    }

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();

        Assets.fondo = g.newPixmap("pokemon/fondo_720.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.menuprincipal = g.newPixmap("menuprincipal.png", PixmapFormat.ARGB4444);
        Assets.botones = g.newPixmap("botones.png", PixmapFormat.ARGB4444);
        Assets.ayuda1 = g.newPixmap("ayuda1.png", PixmapFormat.ARGB4444);
        Assets.ayuda2 = g.newPixmap("ayuda2.png", PixmapFormat.ARGB4444);
        Assets.ayuda3 = g.newPixmap("ayuda3.png", PixmapFormat.ARGB4444);
        Assets.numeros = g.newPixmap("numeros.png", PixmapFormat.ARGB4444);
        Assets.preparado = g.newPixmap("preparado.png", PixmapFormat.ARGB4444);
        Assets.menupausa = g.newPixmap("menupausa.png", PixmapFormat.ARGB4444);
        Assets.finjuego = g.newPixmap("finjuego.png", PixmapFormat.ARGB4444);

        Assets.rojoAbajo1 = g.newPixmap("pokemon/rojo/rojo_01.png", PixmapFormat.RGB565);
        Assets.rojoAbajo2 = g.newPixmap("pokemon/rojo/rojo_02.png", PixmapFormat.RGB565);
        Assets.rojoAbajo3 = g.newPixmap("pokemon/rojo/rojo_03.png", PixmapFormat.RGB565);
        Assets.rojoAbajo4 = g.newPixmap("pokemon/rojo/rojo_04.png", PixmapFormat.RGB565);
        Assets.rojoIzquierda1 = g.newPixmap("pokemon/rojo/rojo_05.png", PixmapFormat.RGB565);
        Assets.rojoIzquierda2 = g.newPixmap("pokemon/rojo/rojo_06.png", PixmapFormat.RGB565);
        Assets.rojoIzquierda3 = g.newPixmap("pokemon/rojo/rojo_07.png", PixmapFormat.RGB565);
        Assets.rojoIzquierda4 = g.newPixmap("pokemon/rojo/rojo_08.png", PixmapFormat.RGB565);
        Assets.rojoDerecha1 = g.newPixmap("pokemon/rojo/rojo_09.png", PixmapFormat.RGB565);
        Assets.rojoDerecha2 = g.newPixmap("pokemon/rojo/rojo_10.png", PixmapFormat.RGB565);
        Assets.rojoDerecha3 = g.newPixmap("pokemon/rojo/rojo_11.png", PixmapFormat.RGB565);
        Assets.rojoDerecha4 = g.newPixmap("pokemon/rojo/rojo_12.png", PixmapFormat.RGB565);
        Assets.rojoArriba1 = g.newPixmap("pokemon/rojo/rojo_13.png", PixmapFormat.RGB565);
        Assets.rojoArriba2 = g.newPixmap("pokemon/rojo/rojo_14.png", PixmapFormat.RGB565);
        Assets.rojoArriba3 = g.newPixmap("pokemon/rojo/rojo_15.png", PixmapFormat.RGB565);
        Assets.rojoArriba4 = g.newPixmap("pokemon/rojo/rojo_16.png", PixmapFormat.RGB565);

        Assets.pokemon1 = g.newPixmap("pokemon/charmander/charmander_01.png", PixmapFormat.RGB565);
        Assets.pokemon2 = g.newPixmap("pokemon/pikachu/pikachu_01.png", PixmapFormat.RGB565);
        Assets.pokemon3 = g.newPixmap("pokemon/pikachu/pikachu_01.png", PixmapFormat.RGB565);

        Assets.pulsar = juego.getAudio().nuevoSonido("pulsar.ogg");
        Assets.ataque = juego.getAudio().nuevoSonido("ataque.ogg");
        Assets.derrota = juego.getAudio().nuevoSonido("derrota.ogg");

        Assets.charmander = new Pixmap[]{
                g.newPixmap("pokemon/charmander/charmander_01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/charmander/charmander_16.png", PixmapFormat.RGB565)
        };

        Assets.pikachu = new Pixmap[]{
                g.newPixmap("pokemon/pikachu/pikachu_01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/pikachu/pikachu_16.png", PixmapFormat.RGB565)
        };

        Assets.pokedex = new Pixmap[3][16];
        for(int i = 0; i < 16; i++) {
            Assets.pokedex[0][i] = Assets.charmander[i];
            Assets.pokedex[1][i] = Assets.pikachu[i];
            Assets.pokedex[2][i] = Assets.pikachu[i];
        }


        Configuraciones.cargar(juego.getFileIO());
        juego.setScreen(new MainMenuScreen(juego));
    }

    @Override
    public void present(float deltaTime) {

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
