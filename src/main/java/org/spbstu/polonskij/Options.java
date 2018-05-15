package org.spbstu.polonskij;

import java.io.File;
import java.util.ArrayList;

public class Options {

    /**
     * @param dir      directory
     * @param fileName wanted file name
     * @return the path of the search file in the specified directory and its subdirectories
     */
    public ArrayList<String> searchFile(File dir, String fileName) {

        ArrayList<String> result = new ArrayList<String>();

        if (dir.isDirectory()) {

            File[] paths = dir.listFiles();

            for (File path : paths != null ? paths : new File[0]) {
                result.addAll(this.searchFile(path, fileName));
            }
        } else {
            if (dir.getName().equals(fileName))
                result.add(dir.getAbsolutePath());
        }
        return result;
    }

    /**
     * @param dir      diiectory
     * @param fileName wanted file name
     * @return the path of the search file in the specified directory
     */
    public String getFile(File dir, String fileName) {
        for (File file : dir.listFiles()) {
            if (file.getName().equals(fileName))
                return file.getAbsolutePath();
        }
        return null;
    }
}