package org.spbstu.polonskij;
/**
 * C:\Users\Asus\IdeaProjects\consoleapp\files
 */

import java.io.File;
import java.util.Scanner;

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
