package ru.itmo.wiki;

import com.google.gson.Gson;
import ru.itmo.wiki.parser_classes.WikiPage;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String search = scanner.next();

        try {
            WikiSearch wiki = new WikiSearch(search);
            System.out.println("JSON: " + wiki.getJson());
            System.out.println("\nРезультаты запроса:");
            wiki.parseToConsole();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        scanner.close();
    }
}