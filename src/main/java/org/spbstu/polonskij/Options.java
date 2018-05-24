package org.spbstu.polonskij;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Options {
    /**
     * @param dir      directory
     * @param fileName wanted file name
     * @return the path of the search file in the specified directory and its subdirectories
     */

    public static ArrayList<String> searchFile(File dir, final String fileName) throws Exception {
        final ArrayList<String> list = new ArrayList<String>();
        Path directory = Paths.get(dir.toString());
        final String fileNameToFind = fileName;


        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
                    if (path.toFile().getName().equals(fileNameToFind) || path.getFileName().equals(fileName)) {
                        list.add(path.toString());
                        return FileVisitResult.CONTINUE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) throw new Exception("File not found :(");
        return list;
    }

    /**
     * @param dir      directory
     * @param fileName wanted file name
     * @return the path of the search file in the specified directory
     */

    public static ArrayList<String> getFile(final File dir, String fileName) throws Exception {
        final ArrayList<String> list = new ArrayList<String>();
        Path directory = Paths.get(dir.toString());
        final String fileNameToFind = fileName;

        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
                    if (path.toFile().getName().equals(fileNameToFind) && !path.getFileName().equals(dir)) {
                        list.add(path.toString());
                        return FileVisitResult.CONTINUE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) throw new Exception("File not found :(");
        return list;
    }
}