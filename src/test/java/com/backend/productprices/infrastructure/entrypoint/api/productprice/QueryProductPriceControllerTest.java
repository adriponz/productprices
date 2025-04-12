package com.backend.productprices.infrastructure.entrypoint.api.productprice;

import com.backend.productprices.application.productprice.search.dto.ProductPriceDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QueryProductPriceControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @ParameterizedTest
    @DisplayName("GET /prices: returns 200 OK and a Price")
    @MethodSource("provideCriteriaAndExpectedResult")
    void getPrices_validCriteria_returnsValidResponseEntity(Long productId, Long brandId, LocalDateTime date, Long expectedPriceListId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        String url = String.format("http://localhost:%s/api/prices?productId=%s&brandId=%s&date=%s",
                port, productId, brandId, date.format(formatter));

        ResponseEntity<ProductPriceDTO> response = restTemplate.getForEntity(url, ProductPriceDTO.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().getPriceListId()).isEqualTo(expectedPriceListId);
    }

    private static Stream<Arguments> provideCriteriaAndExpectedResult() {
        return Stream.of(
                Arguments.of(35455L, 1L, LocalDateTime.of(2020, 6, 14, 10, 0), 1L),
                Arguments.of(35455L, 1L, LocalDateTime.of(2020, 6, 14, 16, 0), 2L),
                Arguments.of(35455L, 1L, LocalDateTime.of(2020, 6, 14, 21, 0), 1L),
                Arguments.of(35455L, 1L, LocalDateTime.of(2020, 6, 15, 10, 0), 3L),
                Arguments.of(35455L, 1L, LocalDateTime.of(2020, 6, 16, 21, 0), 4L)
        );
    }
}