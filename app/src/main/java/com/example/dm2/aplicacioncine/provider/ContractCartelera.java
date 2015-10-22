package com.example.dm2.aplicacioncine.provider;

/**
 * Created by DM2 on 22/10/2015.
 */
public class ContractCartelera {
    /**
     * Autoridad del Content Provider
     */
    public final static String AUTHORITY="com.dm2.AplicacionCine";
    /**
     * Representación de la tabla a consultar
     */
    public static final String PELICULAS = "peliculas";
    /**
     * Tipo MIME que retorna la consulta de una sola fila
     */
    public final static String SINGLE_MIME = "vnd.android.cursor.item/vnd." + AUTHORITY + PELICULAS;





}
