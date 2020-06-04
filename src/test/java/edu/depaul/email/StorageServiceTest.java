package edu.depaul.email;
/*
 * Author: Jake Lukawski
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static edu.depaul.email.StorageService.StorageType.GOODLINKS;
import java.util.List;
import java.util.Arrays;

public class StorageServiceTest {
    @Test
    @DisplayName("no emails provided")
    void testStoreListNoEmails() {
        StorageService storage = new StorageService();
        assertThrows(EmailFinderException.class, () -> storage.storeList(StorageService.StorageType.EMAIL, null));
    }
    @Test
    @DisplayName("no location provided")
    void testStoreListNoLocation() {
        StorageService storage = new StorageService();
        storage.addLocation(GOODLINKS, "");
        List<String> email = Arrays.asList("exampleEmail@gmail.com");
        assertThrows(EmailFinderException.class, () -> storage.storeList(StorageService.StorageType.EMAIL, email));
    }
}
