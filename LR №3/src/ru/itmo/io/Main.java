package ru.itmo.io;

import java.io.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        String base_path="C:/Users/User/Desktop/Картинки для учёбы/4 курс/РМП/IO, Потоки, Коллекции/src/ru/itmo/io/";

        try {
            IOmethods.console_read_file(base_path + "File_to_console.txt");

            //IOmethods.string_to_file(base_path + "File_put_string.txt", "String\nis\nput");

            //IOmethods.file_concat(base_path + "File_part_1.txt", base_path + "File_part_2.txt");

            //IOmethods.file_copy(base_path + "File_copy_got.txt", base_path + "File_to_copy.txt");

            /*IOmethods.dir_filenames_include_string(base_path + "Files for search", "Hello");
            System.out.println();
            IOmethods.dir_files_include_string(base_path + "Files for search", "pip");
            System.out.println();
            Function<Double, Integer> double_to_int = value -> (int) Math.round(value);
            IOmethods.dir_elements_bigger(base_path + "Files for search", double_to_int.apply(15.46754));*/

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
