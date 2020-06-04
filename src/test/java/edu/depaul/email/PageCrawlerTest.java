package edu.depaul.email;
/*
 * Author: Jake Lukawski
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.depaul.email.StorageService.StorageType.EMAIL;
import static edu.depaul.email.StorageService.StorageType.GOODLINKS;
import static edu.depaul.email.StorageService.StorageType.BADLINKS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Tag;

public class PageCrawlerTest {

    @Test
    @Tag("mock")
    @DisplayName("functional constructor")
    void testPageCrawlerConstructor() {
        try {
            StorageService storage = mock(StorageService.class);
            storage.addLocation(EMAIL, "email.txt");
            storage.addLocation(GOODLINKS, "good-links.txt");
            storage.addLocation(BADLINKS, "badlinks.txt");
            PageCrawler crawler = new PageCrawler(storage);
            assertTrue(crawler != null);
        }
        catch(Exception e) {
            assert(false);
        }
    }
    @Test
    @Tag("mock")
    @DisplayName("correct number of emails recorded")
    void testPageCrawler() {
        StorageService storage = mock(StorageService.class);
        storage.addLocation(EMAIL, "email.txt");
        storage.addLocation(GOODLINKS, "good-links.txt");
        storage.addLocation(BADLINKS, "badlinks.txt");
        PageCrawler crawler = new PageCrawler(storage);
        crawler.crawl("src/test/resources/webpage1.html");
        assertEquals(crawler.getEmails().size(), 3);
    }

    /*
    @Test
    @Tag("mock")
    @DisplayName("TEST FAILS: correct number of emails in webpage1.html with maximum specified")
    void testPageCrawlerWithMax() {
        StorageService storage = mock(StorageService.class);
        storage.addLocation(EMAIL, "email.txt");
        storage.addLocation(GOODLINKS, "good-links.txt");
        storage.addLocation(BADLINKS, "badlinks.txt");
        PageCrawler crawler = new PageCrawler(storage, 2);
        crawler.crawl("src/test/resources/webpage1.html");
        assertEquals(crawler.getEmails().size(), 2);
    }
*/
    @Test
    @Tag("mock")
    @DisplayName("good links")
    void testCrawlerGoodLinks() {
        StorageService storage = mock(StorageService.class);
        storage.addLocation(EMAIL, "email.txt");
        storage.addLocation(GOODLINKS, "good-links.txt");
        storage.addLocation(BADLINKS, "badlinks.txt");
        PageCrawler crawler = new PageCrawler(storage);
        crawler.crawl("src/test/resources/webpage1.html");
        assertEquals(2, crawler.getGoodLinks().size());
    }
    @Test
    @Tag("mock")
    @DisplayName("bad links")
    void testCrawlerBadLinks() {
        StorageService storage = mock(StorageService.class);
        storage.addLocation(EMAIL, "email.txt");
        storage.addLocation(GOODLINKS, "good-links.txt");
        storage.addLocation(BADLINKS, "badlinks.txt");
        PageCrawler crawler = new PageCrawler(storage);
        crawler.crawl("src/test/resources/webpage1.html");
        assertEquals(1, crawler.getBadLinks().size());
    }
}
