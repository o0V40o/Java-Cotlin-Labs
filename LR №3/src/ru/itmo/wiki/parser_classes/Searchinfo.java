package ru.itmo.wiki.parser_classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Searchinfo {

    @SerializedName("totalhits")
    @Expose
    public int totalhits;

}