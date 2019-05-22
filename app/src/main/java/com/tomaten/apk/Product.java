package com.tomaten.apk;

import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Serializable {

    private String volym, pris, alkohol, apk, namn;

    public Product(String volym, String pris, String alkohol, String apk){

        this.volym = volym;
        this.pris = pris;
        this.alkohol = alkohol;
        this.apk = apk;
    }

    public Product(String namn, String volym, String pris, String alkohol, String apk){

        this.volym = volym;
        this.pris = pris;
        this.alkohol = alkohol;
        this.apk = apk;
        this.namn = namn;
    }

    public String volym(){

        return volym;
    }

    public String pris(){

        return pris;
    }

    public String alkohol(){

        return alkohol;
    }

    public String apk(){

        return apk;
    }

    public String namn(){
        return namn;
    }

    @Override
    public String toString() {

        if (namn == null) {
            return "Volym: " + volym + ", Pris: " + pris + ", Alkohol: " + alkohol + ", APK: " + apk;

        } else {
            return "Namn: " + namn + ", Volym: " + volym + ", Pris: " + pris + ", Alkohol: " + alkohol + ", APK: " + apk;
        }
    }
}
