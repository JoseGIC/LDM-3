package com.jose.ldm_3.interfaces;


public interface Juego{

    public Input getInput();

    public FileIO getFileIO();

    public Graficos getGraphics();

    public Audio getAudio();

    public void setScreen(Pantalla pantalla);

    public Pantalla getCurrentScreen();

    public Pantalla getStartScreen();
}