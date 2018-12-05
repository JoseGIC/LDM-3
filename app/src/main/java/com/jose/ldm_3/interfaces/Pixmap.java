package com.jose.ldm_3.interfaces;

import com.jose.ldm_3.interfaces.Graficos.PixmapFormat;

public interface Pixmap {

    public int getWidth();

    public int getHeight();

    public PixmapFormat getFormat();

    public void dispose();
}