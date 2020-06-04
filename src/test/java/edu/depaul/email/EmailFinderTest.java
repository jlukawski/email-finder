package edu.depaul.email;
/*
 * Author: Jake Lukawski
 */

import edu.depaul.email.EmailFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailFinderTest {

//Testing emailFinder() function

	@Test
	@DisplayName("valid url")
	void testEmailFinderValidURL() {
		try{
			EmailFinder.main(new String[] {"http://www.depaul.edu"});
		}
		catch(Exception e) {
			assert(false);
		}
	}
	@Test
	@DisplayName("valid url with args")
	void testEmailFinderValidURLAndArgs() {
		try{
			EmailFinder.main(new String[] {"http://www.depaul.edu","2"});
		}
		catch(Exception e) {
			assert(false);
		}
	}

	@Test
	@DisplayName("invalid url")
	void testEmailFinderInvalidURL() {
		String[] url = {"abcdefg"};
		EmailFinder finder = new EmailFinder();
		assertDoesNotThrow(() -> finder.run(url));
	}



	}
