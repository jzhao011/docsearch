import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.File;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/");
        assertEquals("There are 1391 total files to search.", h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        String sep = File.separator;
        URI rootPath = new URI("http://localhost/search?q=Resonance");
        String expect = String.format("Found 2 paths:\n.%stechnical%sbiomed%sar615.txt\n.%stechnical%splos%sjournal.pbio.0020150.txt", sep, sep, sep, sep, sep, sep);
        assertEquals(expect, h.handleRequest(rootPath));
	}
    @Test
    public void testSearch2() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        String sep = File.separator;
        URI rootPath = new URI("http://localhost/search?q=rrna");
        String expect = String.format("Found 1 paths:\n.%stechnical%sbiomed%s1471-2105-3-2.txt", sep, sep, sep);
        assertEquals(expect, h.handleRequest(rootPath));
    }

    @Test
    public void testSearch3() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        String sep = File.separator;
        URI rootPath = new URI("http://localhost/search?q=trna");
        String expect = String.format("Found 1 paths:\n.%stechnical%sbiomed%s1471-2199-2-3.txt", sep, sep, sep);
        assertEquals(expect, h.handleRequest(rootPath));
    }
}

