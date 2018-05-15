package org.spbstu.polonskij;
/**
 * C:\Users\Asus\IdeaProjects\consoleapp\files
 */

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;

/**
 * Search for a file with the name specified in the command line in the specified directory
 * Options:
 * -d directory option, by default in the current directory
 * -r switch indicates the need to search in all subdirectories
 * Example of command line:
 * "find -r -d C://directory filename.txt"
 * Returns the path or list of paths for the specified file
 */
public class Find {

    @Option(name = "-r")
    private boolean r = false;

    @Option(name = "-d")
    private String d = ".";

    @Argument(required = true)
    private String fileName = null;

    public static void main(String[] args) {
        new Find().launch(args);
    }

    public void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.exit(-1);
        }

        Options result = new Options();

        System.out.println(r ? result.searchFile(new File(d), fileName) : result.getFile(new File(d), fileName));

    }
}
