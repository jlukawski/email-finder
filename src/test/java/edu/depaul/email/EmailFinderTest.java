
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
	@DisplayName("blank args")
	void testNoExceptionsThrown() {
		try{
			EmailFinder.main(new String[] {"http://www.depaul.edu", "3"});
		}
		catch(Exception e) {
			assert(false);
		}

	}
}