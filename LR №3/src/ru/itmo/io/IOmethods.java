package ru.itmo.io;

import java.io.*;
import java.util.Scanner;

public class IOmethods {

    public static void console_read_file(String path) throws IOException {

        FileReader fileReader = new FileReader(path);
        Scanner scanner = new Scanner(fileReader);

        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

        scanner.close();
        fileReader.close();
    }

    public static void string_to_file(String path, String string) throws IOException {

        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(string);
        fileWriter.close();
    }

    public static void file_concat(String dest_path, String source_path) throws IOException {

        File read_file = new File(source_path);
        FileReader fileReader = new FileReader(read_file);
        Scanner scanner = new Scanner(fileReader);

        FileWriter fileWriter = new FileWriter(dest_path, true);

        while(scanner.hasNextLine()){
            fileWriter.write('\n' + scanner.nextLine());
        }

        scanner.close();
        fileReader.close();
        fileWriter.close();

        if(!dest_path.equals(source_path)) {
            read_file.delete();
        }
    }

    public static void file_copy(String dest_path, String source_path) throws IOException {

        InputStream in = new FileInputStream(source_path);
        OutputStream out = new FileOutputStream(dest_path);

        byte[] buffer = new byte[50];
        int curr_length;
        while ((curr_length = in.read(buffer)) > 0) {
            out.write(buffer, 0, curr_length);
        }

        in.close();
        out.close();
    }

    public static void dir_filenames_include_string(String dir_path, String string) throws IOException {

        File dir = new File(dir_path);
        File[] files = dir.listFiles();

        int quantity_files = files == null ? 0: files.length;
        for(int i=0; i<quantity_files; ++i){
            if(files[i].isFile() && files[i].getName().contains(string)){
                System.out.println(files[i].getName());
            }
        }
    }

    public static void dir_files_include_string(String dir_path, String string) throws IOException {

        File dir = new File(dir_path);
        File[] files = dir.listFiles();

        String string_buf;
        int quantity_files = files == null ? 0: files.length;
        for(int i=0; i<quantity_files; ++i){

            FileReader fileReader = new FileReader(files[i]);
            Scanner scanner = new Scanner(fileReader);

            while(scanner.hasNextLine()){

                string_buf = scanner.nextLine();
                if(string_buf.contains(string)){
                    System.out.println(files[i].getName());
                    break;
                }
            }

            scanner.close();
            fileReader.close();
        }
    }

    public static void dir_elements_bigger(String dir_path, int size) throws IOException {

        File dir = new File(dir_path);
        File[] files = dir.listFiles();

        int quantity_files = files == null ? 0: files.length;
        for(int i=0; i<quantity_files; ++i){
            if(files[i].length() > size){
                System.out.println(files[i].getName());
            }
        }
    }
}
