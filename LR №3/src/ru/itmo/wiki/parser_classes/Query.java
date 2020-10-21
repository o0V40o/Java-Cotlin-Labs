package ru.itmo.wiki.parser_classes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query {

    @SerializedName("searchinfo")
    @Expose
    public Searchinfo searchinfo;
    @SerializedName("search")
    @Expose
    public List<Search> search = null;

    @Override
    public String toString() {
        return "Query{" +
                "searchinfo=" + searchinfo +
                ", search=" + search +
                '}';
    }
}