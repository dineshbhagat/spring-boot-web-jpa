package com.example;

import com.example.dto.Manga;
import com.example.dto.MangaResult;
import com.example.service.MangaService;
import io.micrometer.core.instrument.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//Ref: https://dzone.com/articles/unit-and-integration-tests-in-spring-boot-2
@RunWith(SpringRunner.class)
@SpringBootTest
public class MangaServiceUnitTest {
    @Autowired
    private MangaService mangaService;
    // MockBean is the annotation provided by Spring that wraps mockito one
    // Annotation that can be used to add mocks to a Spring ApplicationContext.
    // If any existing single bean of the same type defined in the context will be replaced by the mock, if no existing bean is defined a new one will be added.
    @MockBean
    private RestTemplate template;

    @Test
    public void testGetMangasByTitle() throws IOException {
        // Parsing mock file
        MangaResult mRs = null;//JsonUtils.jsonFile2Object("ken.json", MangaResult.class);
        // Mocking remote service
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity(mRs, HttpStatus.OK));
        // I search for goku but system will use mocked response containing only ken, so I can check that mock is used.
        List<Manga> mangasByTitle = mangaService.getMangasByTitle("goku");
        assertThat(mangasByTitle).isNotNull()
                .isNotEmpty()
                .allMatch(p -> p.getTitle()
                        .toLowerCase()
                        .contains("ken"));
    }
}
