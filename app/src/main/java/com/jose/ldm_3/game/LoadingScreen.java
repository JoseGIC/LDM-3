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

        Assets.fondo1 = g.newPixmap("pokemon/fondo1_720.png", PixmapFormat.RGB565);
        Assets.fondo2 = g.newPixmap("pokemon/fondo2_720.png", PixmapFormat.RGB565);
        Assets.fondo3 = g.newPixmap("pokemon/fondo3_720.png", PixmapFormat.RGB565);

        Assets.logo = g.newPixmap("pokemon/titulo.png", PixmapFormat.ARGB4444);
        Assets.menuprincipal = g.newPixmap("pokemon/menu_principal.png", PixmapFormat.ARGB4444);

        Assets.botonIzquierda = g.newPixmap("pokemon/boton_izquierda.png", PixmapFormat.ARGB4444);
        Assets.botonDerecha = g.newPixmap("pokemon/boton_derecha.png", PixmapFormat.ARGB4444);
        Assets.botonSalir = g.newPixmap("pokemon/boton_salir.png", PixmapFormat.ARGB4444);
        Assets.botonPausa = g.newPixmap("pokemon/boton_pausa.png", PixmapFormat.ARGB4444);
        Assets.botonVolumen = g.newPixmap("pokemon/boton_volumen.png", PixmapFormat.ARGB4444);
        Assets.botonMute = g.newPixmap("pokemon/boton_mute.png", PixmapFormat.ARGB4444);

        Assets.puntuaciones = g.newPixmap("pokemon/pantalla_puntuaciones.png", PixmapFormat.ARGB4444);
        Assets.ayuda1 = g.newPixmap("pokemon/pantalla_ayuda_1.png", PixmapFormat.ARGB4444);
        Assets.ayuda2 = g.newPixmap("pokemon/pantalla_ayuda_2.png", PixmapFormat.ARGB4444);
        Assets.ayuda3 = g.newPixmap("pokemon/pantalla_ayuda_3.png", PixmapFormat.ARGB4444);

        Assets.preparado = g.newPixmap("pokemon/preparado.png", PixmapFormat.ARGB4444);
        Assets.menupausa = g.newPixmap("pokemon/menu_pausa.png", PixmapFormat.ARGB4444);
        Assets.finjuego = g.newPixmap("pokemon/fin_del_juego.png", PixmapFormat.ARGB4444);

        Assets.numeros = new Pixmap[] {
                g.newPixmap("pokemon/numeros/00.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/01.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/02.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/03.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/04.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/05.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/06.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/07.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/08.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/09.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/ordinal.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/punto.png", PixmapFormat.ARGB4444),
                g.newPixmap("pokemon/numeros/puntos.png", PixmapFormat.ARGB4444)
        };

// ------ Sonidos ------ //

        Assets.pulsar = juego.getAudio().nuevoSonido("pokemon/audio/Choose.mp3");
        Assets.capturar = juego.getAudio().nuevoSonido("pokemon/audio/balldrop.mp3");
        Assets.derrota = juego.getAudio().nuevoSonido("pokemon/audio/normaldamage.mp3");
        Assets.musicaInicio = juego.getAudio().nuevaMusica("pokemon/audio/Intro.mp3");
        Assets.musicaJuego = juego.getAudio().nuevaMusica("pokemon/audio/Frente Batalla.mp3");
        Assets.musicaPuntuaciones = juego.getAudio().nuevaMusica("pokemon/audio/Gimnasio.mp3");
        Assets.musicaAyuda = juego.getAudio().nuevaMusica("pokemon/audio/Centro Pokemon.mp3");


// ------- Rojo ------- //

        Assets.rojo = new Pixmap[]{
                g.newPixmap("pokemon/rojo/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/rojo/16.png", PixmapFormat.RGB565)
        };

// ----- Pokedex ----- //

        Assets.bulbasaur = new Pixmap[]{
                g.newPixmap("pokemon/01/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/01/16.png", PixmapFormat.RGB565)
        };

        Assets.ivysaur = new Pixmap[]{
                g.newPixmap("pokemon/02/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/02/16.png", PixmapFormat.RGB565)
        };

        Assets.venusaur = new Pixmap[]{
                g.newPixmap("pokemon/03/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/03/16.png", PixmapFormat.RGB565)
        };

        Assets.charmander = new Pixmap[]{
                g.newPixmap("pokemon/04/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/04/16.png", PixmapFormat.RGB565)
        };

        Assets.charmeleon = new Pixmap[]{
                g.newPixmap("pokemon/05/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/05/16.png", PixmapFormat.RGB565)
        };

        Assets.charizard = new Pixmap[]{
                g.newPixmap("pokemon/06/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/06/16.png", PixmapFormat.RGB565)
        };

        Assets.squirtle = new Pixmap[]{
                g.newPixmap("pokemon/07/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/07/16.png", PixmapFormat.RGB565)
        };

        Assets.wartortle = new Pixmap[]{
                g.newPixmap("pokemon/08/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/08/16.png", PixmapFormat.RGB565)
        };

        Assets.blastoise = new Pixmap[]{
                g.newPixmap("pokemon/09/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/09/16.png", PixmapFormat.RGB565)
        };

        Assets.pichu = new Pixmap[]{
                g.newPixmap("pokemon/10/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/10/16.png", PixmapFormat.RGB565)
        };

        Assets.pikachu = new Pixmap[]{
                g.newPixmap("pokemon/11/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/11/16.png", PixmapFormat.RGB565)
        };

        Assets.raichu = new Pixmap[]{
                g.newPixmap("pokemon/12/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/12/16.png", PixmapFormat.RGB565)
        };

        Assets.moltres = new Pixmap[]{
                g.newPixmap("pokemon/13/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/13/16.png", PixmapFormat.RGB565)
        };

        Assets.zapdos = new Pixmap[]{
                g.newPixmap("pokemon/14/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/14/16.png", PixmapFormat.RGB565)
        };

        Assets.articuno = new Pixmap[]{
                g.newPixmap("pokemon/15/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/15/16.png", PixmapFormat.RGB565)
        };

        Assets.ekans = new Pixmap[]{
                g.newPixmap("pokemon/16/01.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/02.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/03.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/04.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/05.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/06.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/07.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/08.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/09.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/10.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/11.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/12.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/13.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/14.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/15.png", PixmapFormat.RGB565),
                g.newPixmap("pokemon/16/16.png", PixmapFormat.RGB565)
        };


        Assets.pokedex = new Pixmap[16][16]; //numPokemons, numSprites
        for(int i = 0; i < 16; i++) {
            Assets.pokedex[0][i] = Assets.bulbasaur[i];
            Assets.pokedex[1][i] = Assets.ivysaur[i];
            Assets.pokedex[2][i] = Assets.venusaur[i];
            Assets.pokedex[3][i] = Assets.charmander[i];
            Assets.pokedex[4][i] = Assets.charmeleon[i];
            Assets.pokedex[5][i] = Assets.charizard[i];
            Assets.pokedex[6][i] = Assets.squirtle[i];
            Assets.pokedex[7][i] = Assets.wartortle[i];
            Assets.pokedex[8][i] = Assets.blastoise[i];
            Assets.pokedex[9][i] = Assets.pichu[i];
            Assets.pokedex[10][i] = Assets.pikachu[i];
            Assets.pokedex[11][i] = Assets.raichu[i];
            Assets.pokedex[12][i] = Assets.moltres[i];
            Assets.pokedex[13][i] = Assets.zapdos[i];
            Assets.pokedex[14][i] = Assets.articuno[i];
            Assets.pokedex[15][i] = Assets.ekans[i];
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
