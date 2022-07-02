package htw.berlin.webtech.srandom;

import htw.berlin.webtech.srandom.web.api.Song;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SrandomApplicationTests {

	@Test
	@DisplayName("get method of Song should give back the correct Title")
	void getSongTitle() {
		Song songObject = new Song(1, "Sugar", "Maroon 5", 2021, "Link");
		String actualTitle = songObject.getTitle();
		String expectedTitle = "Sugar";
		assertEquals(expectedTitle, actualTitle);
	}
}
