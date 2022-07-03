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
		Song songObject = new Song(1, "Sugar", "Maroon 5", 2021, "Link", false, false);
		String actualTitle = songObject.getTitle();
		String expectedTitle = "Sugar";
		assertEquals(expectedTitle, actualTitle);
	}

	@Test
	@DisplayName("get method of Song should give back the correct songLink")
	void getSongLink() {
		Song songObject = new Song(6, "Behute", "Senidah", 2021, "https://www.youtube.com/watch?v=Dz5zCSXI81Q", false, false);
		String actualSongLink = songObject.getSongLink();
		String expectedSongLink = "https://www.youtube.com/watch?v=Dz5zCSXI81Q";
		assertEquals(expectedSongLink, actualSongLink);
	}

	@Test
	@DisplayName("get method of Song should give back the correct author")
	void getAuthor() {
		Song songObject = new Song(15, "Let Me Love You", "Mario", 2004, "Link", false, false);
		String actualAuthor = songObject.getAuthor();
		String expectedAuthor = "Mario";
		assertEquals(expectedAuthor, actualAuthor);
	}

	@Test
	@DisplayName("get method of Song and give back the correct release year")
	void get_correct_releaseYear() {
		Song songObject = new Song(16, "Say My Name", "Destiny's child", 1999, "Link", false, false);
		long actualReleaseYear = songObject.getReleaseYear();
		long expectedReleaseYear = Long.parseLong("1999");
		assertEquals(expectedReleaseYear, actualReleaseYear);
	}

	@Test
	@DisplayName("get method of Song and give back the correct favorite song")
	void get_correct_favorite_song() {
		Song songObject = new Song(16, "Say My Name", "Destiny's child", 1999, "Link", false, false);
		boolean actualIsFavorite = songObject.getIsFavorite();
		boolean expectedIsFavorite = false;
		assertEquals(expectedIsFavorite, actualIsFavorite);
	}

	@Test
	@DisplayName("get method of Song and give back the correct original song")
	void get_correct_original_song() {
		Song songObject = new Song(16, "Say My Name", "Destiny's child", 1999, "Link", false, false);
		boolean actualIsOriginal = songObject.getIsOriginal();
		boolean expectedIsOriginal = false;
		assertEquals(expectedIsOriginal, actualIsOriginal);
	}

	@Test
	@DisplayName("get method of Song and remove song from favourite list")
	void remove_song_from_fav_list() {
		Song songObject = new Song(16, "Dale", "Ledri X Kida X Butrint Imeri", 1999, "Link", false, true);
		boolean actualIsFavorite = songObject.getIsFavorite();
		boolean expectedIsOriginal = true;
		assertEquals(expectedIsOriginal, actualIsFavorite);
	}
}
