package me.vdipalma.enzo.recyclerinpillole;

/**
 * Created by enzo on 12/02/18.
 */

public class OggettoStupido {
    private String nome;
    private String cognome;
    private long numero;

    public OggettoStupido(String nome, String cognome, long numero) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public long getNumero() {
        return numero;
    }
}
