package org.spbstu.polonskij;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.util.ArrayList;

/**
 * Search for a file with the name specified in the command line in the specified directory
 * Options:
 * -d directory option, by default in the current directory
 * -r switch indicates the need to search in all subdirectories
 * Example of command line:
 * "[-r] [-d directory] filename.txt"
 * Returns the path or list of paths for the specified file
 */
public class Find {

    @Option(name = "-r")
    private boolean r = false;

    @Option(name = "-d")
    private String d = "src";

    @Argument(required = true)
    private String fileName = null;

    public static void main(String[] args) throws Exception {
        new Find().launch(args);
    }

    public ArrayList<String> launch(String[] args) throws Exception {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Expected arguments: [-r] [-d directory] filename.txt");
            parser.printUsage(System.err);
            return null;
        }
        Options activity = new Options();

        ArrayList<String> result = r ? activity.searchFile(new File(d), fileName) : activity.getFile(new File(d), fileName);

        if(result.isEmpty()) System.err.println("File not found :(");
           return result;
    }
}
