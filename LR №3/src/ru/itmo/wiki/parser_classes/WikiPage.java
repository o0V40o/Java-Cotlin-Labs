package ru.itmo.wiki.parser_classes;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WikiPage {

    @SerializedName("batchcomplete")
    @Expose
    public String batchcomplete;
    @SerializedName("continue")
    @Expose
    public Continue _continue;
    @SerializedName("query")
    @Expose
    public Query query;

}