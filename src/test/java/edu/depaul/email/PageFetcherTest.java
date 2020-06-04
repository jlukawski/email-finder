package edu.depaul.email;
/*
 * Author: Jake Lukawski
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PageFetcherTest {

    @Test
    @DisplayName("getString() valid")
    void testPageFetcherGetStringValid() {
        PageFetcher fetcher = new PageFetcher();
        String url = "http://depaul.edu";
        assertTrue(fetcher.getString(url) != null);
    }
    @Test
    @DisplayName("getString() invalid")
    void testPageFetcherGetStringInvalid() {
        PageFetcher fetcher = new PageFetcher();
        String url = "http://iAmAbsolutelyPositiveThisIsNotARealURL.com";
        assertThrows(EmailFinderException.class, () -> fetcher.getString(url));
    }
    @Test
    @DisplayName("get() valid")
    void testPageFetcherGetValid() {
        PageFetcher fetcher = new PageFetcher();
        String url = "http://depaul.edu";
        assertTrue(fetcher.get(url) != null);
    }
    @Test
    @DisplayName("get() invalid")
    void testPageFetcherGetInvalid() {
        PageFetcher fetcher = new PageFetcher();
        String url = "http://iAmAbsolutelyPositiveThisIsNotARealURL.com";
        assertThrows(EmailFinderException.class, () -> fetcher.get(url));
    }

}
