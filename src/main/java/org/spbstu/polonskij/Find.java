package org.spbstu.polonskij;
/**
 * C:\Users\Asus\IdeaProjects\consoleapp\files
 */

import java.io.File;
import java.util.Scanner;

/**
 *Search for a file with the name specified in the command line in the specified directory
 * Options:
 * -d directory option, by default in the current directory
 * -r switch indicates the need to search in all subdirectories
 * Example of command line:
 *  "find -r -d C://directory filename.txt"
 *  Returns the path or list of paths for the specified file
 */
public class Find {
    public static void main(String[] args) {
        String input;
        String[] cmdLine;
        String filename;
        File directory;
        try {
            System.out.print("Command line: ");
            Scanner in = new Scanner(System.in);
            input = (in.nextLine());
            cmdLine = input.split(" ");
            Options result = new Options();
            if (cmdLine[1] == "-r") {
                directory = new File(cmdLine[3]);
                filename = cmdLine[4];
                System.out.println(result.searchFile(directory, filename));
            }
            else {
                directory = new File(cmdLine[2]);
                filename = cmdLine[3];
                System.out.println(result.getFile(directory, filename));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
}
