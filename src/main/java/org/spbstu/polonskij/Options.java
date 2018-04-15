package org.spbstu.polonskij;

import java.io.File;
import java.util.ArrayList;

public class Options {
    public ArrayList<String> searchFile(File dir, String fileName) {

        ArrayList<String> result = new ArrayList<String>();

        if (dir.isDirectory()) {

            File[] paths = dir.listFiles();

            for (File path : paths) {
                result.addAll(this.searchFile(path, fileName));
            }
        } else {
            if (dir.getName().equals(fileName))
                result.add(dir.getAbsolutePath());
        }
        return result;
    }

    public String getFile(File dir, String fileName) {
        for (File file : dir.listFiles()) {
            if (file.getName().equals(fileName))
                return file.getAbsolutePath();
        }
        return null;
    }
}
