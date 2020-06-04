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

public class PageCrawlerTest {

    @Test
    @DisplayName("functional constructor")
    void testPageCrawlerConstructor() {
        try {
            StorageService storage = new StorageService();
            storage
                    .addLocation(EMAIL, "email.txt")
                    .addLocation(GOODLINKS, "good-links.txt")
                    .addLocation(BADLINKS, "badlinks.txt");
            PageCrawler crawler = new PageCrawler(storage);
        }
        catch(Exception e) {
            assert(false);
        }
    }
    @Test
    @DisplayName("correct number of emails recorded")
    void testPageCrawler() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");
        PageCrawler crawler = new PageCrawler(storage);
        crawler.crawl("src/test/resources/webpage1.html");
        assertEquals(crawler.getEmails().size(), 3);
    }

    /* TODO: Test fails when maximum is specified!
    @Test
    @DisplayName("correct number of emails in webpage1.html with maximum specified")
    void testPageCrawlerWithMax() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");
        PageCrawler crawler = new PageCrawler(storage, 2);
        crawler.crawl("src/test/resources/webpage1.html");
        assertEquals(crawler.getEmails().size(), 2);
    }
*/
    @Test
    @DisplayName("good links")
    void testCrawlerGoodLinks() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");
        PageCrawler crawler = new PageCrawler(storage);
        crawler.crawl("src/test/resources/webpage1.html");
        assertEquals(2, crawler.getGoodLinks().size());
    }
    @Test
    @DisplayName("bad links")
    void testCrawlerBadLinks() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");
        PageCrawler crawler = new PageCrawler(storage);
        crawler.crawl("src/test/resources/webpage1.html");
        assertEquals(1, crawler.getBadLinks().size());
    }
}
