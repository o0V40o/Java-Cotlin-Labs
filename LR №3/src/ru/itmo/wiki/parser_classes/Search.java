package ru.itmo.wiki.parser_classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search {

    @SerializedName("ns")
    @Expose
    public int ns;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("pageid")
    @Expose
    public int pageid;

    @SerializedName("size")
    @Expose
    public int size;

    @SerializedName("wordcount")
    @Expose
    public int wordcount;

    @SerializedName("snippet")
    @Expose
    public String snippet;

    @SerializedName("timestamp")
    @Expose
    public String timestamp;

}