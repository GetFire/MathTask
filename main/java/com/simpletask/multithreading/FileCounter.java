package com.simpletask.multithreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileCounter {

    private static final char DEFAULT_SEPARATOR = ';';
    private String[] args;
    private List<String> directions;

    public FileCounter(String[] args) {
        if (args.length == 0) {
            System.out.println("Please amend your parameters and restart app");
            return;
        }
        this.args = args;
    }

    public static void main(String[] args) {
        FileCounter counter = new FileCounter(args);
        counter.countAndWriteFiles();
    }

    public void countAndWriteFiles() {
        getDirections();
        for (int i = 0; i < directions.size(); i++) {
            List<File> files = findFilesInDirectives(directions.get(i));
            printResult(files);
            writeCSV(files.size(), directions.get(i));
        }
    }

    private void writeCSV(int size, String direction) {
        if (args[1] != null && !args[1].equals("")) {
            if (!args[1].endsWith(".csv")) {
                int ind = args[1].indexOf('.');
                args[1] = args[1].substring(0, ind) + ".csv";
            }

            File file = new File(args[1]);
            boolean isNew = file.exists();
            try (FileWriter writer = new FileWriter(file, true)) {
                if (!isNew) {
                    writer.append(new StringBuffer("File directive").append(DEFAULT_SEPARATOR).append("Count\n"));
                }
                writer.append(new StringBuilder(direction).append(DEFAULT_SEPARATOR).append(size).append("\n").toString());
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new RuntimeException("Please amend your result filepath");
        }

    }

    private List<File> findFilesInDirectives(String dir) {
        File listFile = new File(dir);
        List<File> result = new ArrayList<>();
        File[] exportFiles = listFile.listFiles();
        for (int i = 0; i < exportFiles.length; i++) {
            if (exportFiles[i].isDirectory()) {
                result.addAll(findFilesInDirectives(exportFiles[i]
                        .getAbsolutePath()));
            } else if (!exportFiles[i].isDirectory()) {
                result.add(exportFiles[i]);
            }
        }
        return result;
    }

    private void printResult(List<File> source) {
        System.out.println("|--|------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|# |   Count    |                         File path                                                                                                                              |");
        for (int i = 0; i < source.size(); i++) {
            int numb = i + 1;
            System.out.println("|--|------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            if (numb <= 9) {
                System.out.println("|0" + numb + "|      " + source.size() + "    |   " + source.get(i).getPath());
            } else {
                System.out.println("|" + numb + "|      " + source.size() + "    |   " + source.get(i).getPath());
            }
        }
        System.out.println("|==|============|================================================================================================================================================================|");
        System.out.println("==================================================================================================================================================================================");
    }

    private void getDirections() {
        if (args[0] != null && !args[0].equals("")) {
            directions = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    directions.add(currentLine);
                }

            } catch (IOException ex) {
                ex.getCause();
            }
        } else {
            throw new RuntimeException("Please amend your source filepath");
        }
    }


}
