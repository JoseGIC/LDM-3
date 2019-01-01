package com.jose.ldm_3.game;

public class Equipo {


    public static final int ARRIBA = 0;
    public static final int IZQUIERDA = 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;
    public int numero, direccion, x, y, lastX, lastY, xT, yT, srcX, srcY;


    public Equipo(int x, int y, int numero) {
        this.numero = numero;
        this.direccion = ABAJO;
        this.x = x;
        this.y = y;
        this.lastX = x;
        this.lastY = y;
        this.xT = x * 64;
        this.yT = y * 64;
        this.srcX = 0;
        this.srcY = 0;
    }


    public void transicion() {
        if(x * 64 < xT) {
            if(x == 0 && lastX == 10) {
                xT += 8;
                if(xT >= lastX * 64 + 32) {
                    xT = -32;
                }
            } else {
                xT -= 8;
            }
        }
        if(x * 64 > xT) {
            if(x == 10 && lastX == 0) {
                xT -= 8;
                if(xT <= lastX * 64 - 32) {
                    xT = 10 * 64 + 32;
                }
            } else {
                xT += 8;
            }
        }
        if(y * 64 < yT) {
            if(y == 0 && lastY == 16) {
                yT += 16;
                if(yT >= lastY * 64 + 32) {
                    yT = -32;
                }
            } else {
                yT -= 8;
            }
        }
        if(y * 64 > yT) {
            if(y == 16 && lastY == 0) {
                yT -= 8;
                if(yT <= lastY * 64 - 32) {
                   yT = 16 * 64 + 32;
                }
            } else {
                yT += 8;
            }
        }
    }


    public void animacion() {
        if (direccion == ABAJO) {
            srcY = 0;
            srcX = (srcX + 64) % 256;
        }
        if (direccion == IZQUIERDA) {
            srcY = 64;
            srcX = (srcX + 64) % 256;
        }
        if (direccion == DERECHA) {
            srcY = 128;
            srcX = (srcX + 64) % 256;
        }
        if (direccion == ARRIBA) {
            srcY = 192;
            srcX = (srcX + 64) % 256;
        }
    }

}
