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

        Assets.fondo = g.newPixmap("interfaz/fondo.png", PixmapFormat.RGB565);
        Assets.pantallaPrincipal = g.newPixmap("interfaz/pantalla_principal.png", PixmapFormat.ARGB4444);
        Assets.pantallaEntrenadores = g.newPixmap("interfaz/pantalla_entrenadores.png", PixmapFormat.ARGB4444);
        Assets.pantallaPuntuaciones = g.newPixmap("interfaz/pantalla_puntuaciones.png", PixmapFormat.ARGB4444);
        Assets.pantallaAyuda1 = g.newPixmap("interfaz/pantalla_ayuda_1.png", PixmapFormat.ARGB4444);
        Assets.pantallaAyuda2 = g.newPixmap("interfaz/pantalla_ayuda_2.png", PixmapFormat.ARGB4444);
        Assets.pantallaAyuda3 = g.newPixmap("interfaz/pantalla_ayuda_3.png", PixmapFormat.ARGB4444);
        Assets.pantallaAyuda4 = g.newPixmap("interfaz/pantalla_ayuda_4.png", PixmapFormat.ARGB4444);
        Assets.botones = g.newPixmap("interfaz/botones.png", PixmapFormat.ARGB4444);
        Assets.numeros = g.newPixmap("interfaz/numeros.png", PixmapFormat.ARGB4444);
        Assets.letras = g.newPixmap("interfaz/letras.png", PixmapFormat.ARGB4444);
        Assets.preparado = g.newPixmap("interfaz/preparado.png", PixmapFormat.ARGB4444);
        Assets.menuPausa = g.newPixmap("interfaz/menu_pausa.png", PixmapFormat.ARGB4444);
        Assets.finJuego = g.newPixmap("interfaz/fin_del_juego.png", PixmapFormat.ARGB4444);
        Assets.victoria = g.newPixmap("interfaz/victoria.png", PixmapFormat.ARGB4444);

        Assets.entrenadores = new Pixmap[16];
        for(int i = 0; i < Assets.entrenadores.length; i++) {
            Assets.entrenadores[i] = g.newPixmap("entrenadores/" + String.format("%02d", i + 1) + ".png", PixmapFormat.RGB565);
        }

        Assets.pokemons = new Pixmap[152]; //151 pokemons + 1 entrenador
        Assets.pokemons[0] = g.newPixmap("entrenadores/01.png", PixmapFormat.RGB565);
        for(int i = 1; i < Assets.pokemons.length; i++) {
            Assets.pokemons[i] = g.newPixmap("pokedex/" + String.format("%03d", i) + ".png", PixmapFormat.RGB565);
        }


// ------ Sonidos ------ //

        Assets.pulsar = juego.getAudio().nuevoSonido("audio/Choose.mp3");
        Assets.capturar = juego.getAudio().nuevoSonido("audio/balldrop.mp3");
        Assets.derrota = juego.getAudio().nuevoSonido("audio/normaldamage.mp3");
        Assets.musicaInicio = juego.getAudio().nuevaMusica("audio/Intro.mp3");
        Assets.musicaJuego = juego.getAudio().nuevaMusica("audio/Ruta 4.mp3");
        Assets.musicaEntrenadores = juego.getAudio().nuevaMusica("audio/Gimnasio.mp3");
        Assets.musicaPuntuaciones = juego.getAudio().nuevaMusica("audio/Frente Batalla.mp3");
        Assets.musicaAyuda = juego.getAudio().nuevaMusica("audio/Centro Pokemon.mp3");
        Assets.musicaVictoria = juego.getAudio().nuevaMusica("audio/Victoria.mp3");


        Configuraciones.cargar(juego.getFileIO());
        juego.setScreen(new MainMenuScreen(juego));
    }


    @Override
    public void present(float deltaTime) {}

    @Override
    public void pause() {}


    @Override
    public void resume() {}

    @Override
    public void dispose() {}

}
