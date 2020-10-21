package ru.itmo.wiki;

import com.google.gson.Gson;
import ru.itmo.wiki.parser_classes.Query;
import ru.itmo.wiki.parser_classes.Search;
import ru.itmo.wiki.parser_classes.WikiPage;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WikiSearch
{
    private String search;

    public WikiSearch(String search) throws UnsupportedEncodingException {
        this.search = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=\""+
                URLEncoder.encode(search, StandardCharsets.UTF_8) + "\"";
    }

    public String getJson() throws IOException
    {
        String json = "";
        URL url = new URL(search);
        InputStream urlIN = url.openStream();
        Scanner urlScanner = new Scanner(urlIN);

        while(urlScanner.hasNextLine()) {
            json = json.concat(' ' + urlScanner.next());
        }

        urlScanner.close();
        urlIN.close();
        return json;
    }

    public void parseToConsole() throws IOException {
        WikiPage page = new Gson().fromJson(getJson(), WikiPage.class);
        Query query = page.query;
        for (Search search : query.search) {
            System.out.println('\t' + search.title);
            System.out.println(search.snippet);
        }
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
