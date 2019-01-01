package com.jose.ldm_3.game;


import com.jose.ldm_3.implementations.AndroidJuego;
import com.jose.ldm_3.interfaces.Juego;
import com.jose.ldm_3.interfaces.Pantalla;


public class JuegoPokemon extends AndroidJuego {

    public static boolean onMainMenu = false;

    @Override
    public Pantalla getStartScreen() {
        return new LoadingScreen(this);
    }

    @Override
    public void onBackPressed() {
        if(onMainMenu){
            if(Configuraciones.sonidoHabilitado) {
                Assets.musicaInicio.stop();
            }
            Configuraciones.save(this.getFileIO());
            finish();
        } else if(PantallaJuego.estado == PantallaJuego.EstadoJuego.Ejecutandose){
            if(Configuraciones.sonidoHabilitado)
                Assets.pulsar.play(1);
            PantallaJuego.estado = PantallaJuego.EstadoJuego.Pausado;
            return;
        } else if(PantallaJuego.estado == PantallaJuego.EstadoJuego.Pausado) {
            if(Configuraciones.sonidoHabilitado)
                Assets.pulsar.play(1);
            PantallaJuego.estado = PantallaJuego.EstadoJuego.Ejecutandose;
            return;
        }
    }
}
