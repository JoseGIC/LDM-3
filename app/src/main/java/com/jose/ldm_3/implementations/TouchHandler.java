package com.jose.ldm_3.implementations;

import java.util.List;

import android.view.View.OnTouchListener;

import com.jose.ldm_3.interfaces.Input.TouchEvent;


public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<TouchEvent> getTouchEvents();
}

