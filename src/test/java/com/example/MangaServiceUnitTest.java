package com.example;

import com.example.dto.Manga;
import com.example.dto.MangaResult;
import com.example.service.MangaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MangaServiceUnitTest {

    @Autowired
    private MangaService mangaService;

    @MockitoBean
    private RestClient restClient;

    @Test
    public void testGetMangasByTitle() {
        // Build a proper mock result
        Manga kenManga = Manga.builder().title("Ken").description("Test manga").volumes(1).score(8.0).build();
        MangaResult mRs = new MangaResult();
        mRs.setResult(List.of(kenManga));

        // Mock the RestClient fluent API chain
        RestClient.RequestHeadersUriSpec uriSpec = mock(RestClient.RequestHeadersUriSpec.class);
        RestClient.RequestHeadersSpec headersSpec = mock(RestClient.RequestHeadersSpec.class);
        RestClient.ResponseSpec responseSpec = mock(RestClient.ResponseSpec.class);

        when(restClient.get()).thenReturn(uriSpec);
        when(uriSpec.uri(anyString())).thenReturn(headersSpec);
        when(headersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.body(MangaResult.class)).thenReturn(mRs);

        // I search for goku but system will use mocked response containing only ken
        List<Manga> mangasByTitle = mangaService.getMangasByTitle("goku");
        assertThat(mangasByTitle).isNotNull()
                .isNotEmpty()
                .allMatch(p -> p.getTitle()
                        .toLowerCase()
                        .contains("ken"));
    }
}
