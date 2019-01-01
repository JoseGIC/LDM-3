package com.jose.ldm_3.game;

import com.jose.ldm_3.interfaces.FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Configuraciones {


    public static boolean sonidoHabilitado = true;
    public static int[] maxPuntuaciones = {0, 0, 0, 0, 0};


    public static void cargar(FileIO files) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(files.leerArchivo(".pokemon")));
            sonidoHabilitado = Boolean.parseBoolean(in.readLine());
            for (int i = 0; i < 5; i++) {
                maxPuntuaciones[i] = Integer.parseInt(in.readLine());
            }
        } catch (IOException e) {
            System.out.println("Fallo al cargar: IOException");
        } catch (NumberFormatException e) {
            System.out.println("Fallo al cargar: NumberFormatException");
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
        }
    }


    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(files.escribirArchivo(".pokemon")));
            out.write(Boolean.toString(sonidoHabilitado));
            out.write("\n");
            for (int i = 0; i < 5; i++) {
                out.write(Integer.toString(maxPuntuaciones[i]));
                out.write("\n");
            }
            System.out.println("Guardado!");

        } catch (IOException e) {
            System.out.println("Fallo al guardar: IOException");
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                System.out.println("Fallo al guardar: IOException");
            }
        }
    }


    public static void addScore(int score) {
        for (int i = 0; i < 5; i++) {
            if (maxPuntuaciones[i] < score) {
                for (int j = 4; j > i; j--)
                    maxPuntuaciones[j] = maxPuntuaciones[j - 1];
                maxPuntuaciones[i] = score;
                break;
            }
        }
    }
}