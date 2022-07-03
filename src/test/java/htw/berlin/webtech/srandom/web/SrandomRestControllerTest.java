package htw.berlin.webtech.srandom.web;

import htw.berlin.webtech.srandom.service.SongService;
import htw.berlin.webtech.srandom.web.api.Song;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SrandomRestController.class)
class SrandomRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;

    @Test
    @DisplayName("should return found song from song service")
    void should_return_found_song_from_song_service() throws Exception {
        var song = List.of(
                new Song(1, "Heart Attack", "Noizy X Loredana",
                        2022, "https://www.youtube.com/watch?v=qhrdHl1LZH4", false, false),
                new Song(2, "Tequila", "Tayna",
                        2022, "https://www.youtube.com/watch?v=I4ZSvYLnOcQ", false, false)
        );
        doReturn(song).when(songService).findAll();

        mockMvc.perform(get("/api/v1/songs/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Heart Attack"))
                .andExpect(jsonPath("$.[0].author").value("Noizy X Loredana"))
                .andExpect(jsonPath("$.[0].releaseYear").value(2022))
                .andExpect(jsonPath("$.[0].songLink").value("https://www.youtube.com/watch?v=qhrdHl1LZH4"))
                .andExpect(jsonPath("$.[0].isOriginal").value(false))
                .andExpect(jsonPath("$.[0].isFavorite").value(false))
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].title").value("Tequila"))
                .andExpect(jsonPath("$.[1].author").value("Tayna"))
                .andExpect(jsonPath("$.[1].releaseYear").value(2022))
                .andExpect(jsonPath("$.[1].songLink").value("https://www.youtube.com/watch?v=I4ZSvYLnOcQ"))
                .andExpect(jsonPath("$.[1].isOriginal").value(false))
                .andExpect(jsonPath("$.[1].isFavorite").value(false));
    }

    @Test
    @DisplayName("should return 404 if song is not found")
    void should_return_404_if_song_is_not_found() throws Exception {
        // given
        doReturn(null).when(songService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/songs/123"))
                // then
                .andExpect(status().isNotFound());
    }
}
