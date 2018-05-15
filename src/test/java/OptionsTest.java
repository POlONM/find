import org.junit.Test;
import org.spbstu.polonskij.Options;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OptionsTest {
    private Options options = new Options();

 @Test
    public void searchFile(){
     ArrayList<String> list = new ArrayList<String>();
     list.add("C:\\Users\\Asus\\IdeaProjects\\consoleapp\\.\\files\\hello.txt");
     assertEquals(list, options.searchFile(new File("."), "hello.txt"));
 }
    @Test
    public void searchFile2(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("C:\\Users\\Asus\\IdeaProjects\\consoleapp\\files\\house.txt");
        assertEquals(list, options.searchFile(new File("files"), "house.txt"));
    }

    @Test
    public void getFile(){
        assertEquals("C:\\Users\\Asus\\IdeaProjects\\consoleapp\\files\\hello.txt",
                options.getFile(new File("files"), "hello.txt"));
    }

    @Test
    public void getFile2(){
        assertEquals("C:\\Users\\Asus\\IdeaProjects\\consoleapp\\files\\house.txt",
                options.getFile(new File("files"), "house.txt"));
    }
}
