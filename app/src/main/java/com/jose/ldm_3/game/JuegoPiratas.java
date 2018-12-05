package com.jose.ldm_3.game;


import com.jose.ldm_3.implementations.AndroidJuego;
import com.jose.ldm_3.interfaces.Pantalla;


public class JuegoPiratas extends AndroidJuego {

    @Override
    public Pantalla getStartScreen() {

        return new LoadingScreen(this);
    }
}
