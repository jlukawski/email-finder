package edu.depaul.email;
/*
 * Author: Jake Lukawski
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.jsoup.nodes.Document;

import static org.junit.jupiter.api.Assertions.*;

public class PageParserTest {
    @Test
    @DisplayName("findEmails() with non-zero result")
    void testPageParserfindEmailsNonZero() {
        PageParser parser = new PageParser();
        Document doc = new PageFetcher().get("src/test/resources/webpage1.html");
        assertEquals(3, parser.findEmails(doc).size());
    }
    @Test
    @DisplayName("findEmails() with zero result")
    void testPageParserfindEmailsZero() {
        PageParser parser = new PageParser();
        Document doc = new PageFetcher().get("http://itcorp.com");
        assertEquals(0, parser.findEmails(doc).size());
    }
    @Test
    @DisplayName("findLinks() with non-zero result")
    void testPageParserfindLinksNonZero() {
        PageParser parser = new PageParser();
        Document doc = new PageFetcher().get("src/test/resources/webpage1.html");
        assertEquals(2, parser.findLinks(doc).size());
    }
    @Test
    @DisplayName("findLinks() with non-zero result")
    void testPageParserfindLinksZero() {
        PageParser parser = new PageParser();
        Document doc = new PageFetcher().get("http://itcorp.com");
        assertEquals(0, parser.findLinks(doc).size());
    }
}
