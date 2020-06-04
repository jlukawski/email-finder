package edu.depaul.email;
/*
 * Author: Jake Lukawski
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collection;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ListWriterTest {
    @Test
    @DisplayName("writeList() with input")
    void testListWriter() throws IOException {
        try{
            String input = "line 1" + "\n" + "line 2" + "\n";
            Collection<String> data = Arrays.asList(new String[]{"line 1", "line 2"});
            OutputStream stream = new ByteArrayOutputStream();
            ListWriter l = new ListWriter(stream);
            l.writeList(data);
            assertEquals(input, stream.toString());
        }
        catch(IOException e) {
            assert(false);
        }
    }
    @Test
    @DisplayName("writeList() without input")
    void testListWriterEmpty() throws IOException {
        try{
            String input = "\n";
            Collection<String> data = Arrays.asList(new String[]{""});
            OutputStream stream = new ByteArrayOutputStream();
            ListWriter l = new ListWriter(stream);
            l.writeList(data);
            assertEquals(input, stream.toString());
        }
        catch(IOException e) {
            assert(false);
        }
    }
}
