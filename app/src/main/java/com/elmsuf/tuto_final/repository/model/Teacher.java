package com.elmsuf.tuto_final.repository.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Teacher {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("cognome")
    @Expose
    private String cognome;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("username", username).append("nome", nome).append("cognome", cognome).toString();
    }
}



