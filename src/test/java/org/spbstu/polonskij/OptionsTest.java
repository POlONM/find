package org.spbstu.polonskij;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class OptionsTest {
    private Options options = new Options();

    @Test
    public void searchFile() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("src\\test\\resources\\files\\hello.txt");
        list.add("src\\test\\resources\\files\\home\\hello.txt");
        assertEquals(list, options.searchFile(new File("src"), "hello.txt"));
    }

    @Test
    public void searchFile2() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("src\\test\\resources\\files\\house.txt");
        assertEquals(list, options.searchFile(new File("src\\test\\resources\\files"), "house.txt"));
    }

    @Test
    public void fileNotFound() {
        try {
            Options.searchFile(new File("src"), "mom.txt");
            assertTrue(false);
        } catch (Exception ex) {
        }
        assertTrue(true);
    }

    @Test
    public void getFile() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("src\\test\\resources\\files\\home\\hello.txt");
        assertEquals(list,
                options.getFile(new File("src\\test\\resources\\files\\home"), "hello.txt"));
    }

    @Test
    public void getFile2() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("src\\test\\resources\\files\\house.txt");
        assertEquals(list,
                options.getFile(new File("src\\test\\resources\\files"), "house.txt"));
    }

    @Test
    public void fileNotFound2() {
        try {
            Options.searchFile(new File("src\\test\\resources\\files\\home"), "mom.txt");
            assertTrue(false);
        } catch (Exception ex) {
        }
        assertTrue(true);
    }
}
