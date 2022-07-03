package htw.berlin.webtech.srandom.service;


import htw.berlin.webtech.srandom.persistence.SongRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SongServiceTest implements WithAssertions {

    @Mock
    private SongRepository repository;

    @InjectMocks
    private SongService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful(){
        //given
        Long givenId = 111L;
        doReturn(true).when(repository).existsById(givenId);
        //when
        boolean result = underTest.deleteById(givenId);

        //then
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if song to delete does not exist")
    void should_return_false_if_song_to_delete_does_not_exist(){
        //given
        Long givenId = 111L;
        doReturn(false).when(repository).existsById(givenId);

        //when
        boolean result = underTest.deleteById(givenId);

        //then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
