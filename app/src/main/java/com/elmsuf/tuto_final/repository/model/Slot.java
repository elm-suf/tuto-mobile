package com.elmsuf.tuto_final.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Slot {

    @SerializedName("slot")
    @Expose
    private String slot;
    @SerializedName("stato")
    @Expose
    private String stato;

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("slot", slot).append("stato", stato).toString();
    }
}