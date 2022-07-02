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
                new Song(1, "Heart Attack", "https://www.youtube.com/watch?v=qhrdHl1LZH4",
                        "Noizy X Loredana", 2022),
                new Song(2, "Tequila","https://www.youtube.com/watch?v=I4ZSvYLnOcQ" ,
                        "Tayna", 2022)
        );
        doReturn(song).when(songService).findAll();

        mockMvc.perform(get("/api/v1/songs/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Heart Attack"))
                .andExpect(jsonPath("$.[0].song_link").value("https://www.youtube.com/watch?v=qhrdHl1LZH4"))
                .andExpect(jsonPath("$.[0].author").value("Noizy X Loredana"))
                .andExpect(jsonPath("$.[0].release_year").value(2022))
                .andExpect(jsonPath("$.[1].id").value(2))
                .andExpect(jsonPath("$.[1].title").value("Tequila"))
                .andExpect(jsonPath("$.[1].song_link").value("https://www.youtube.com/watch?v=I4ZSvYLnOcQ"))
                .andExpect(jsonPath("$.[1].author").value("Tayna"))
                .andExpect(jsonPath("$.[1].release_year").value(2022));
    }}
