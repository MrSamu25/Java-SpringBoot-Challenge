package com.accenture.challenge.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RestApiConfigTest {

    @InjectMocks
    private RestApiConfig restApiConfig;

    @Test
    void shouldBuildRestTemplate() {
        Assertions.assertNotNull(restApiConfig.buildRestTemplate());
    }
}
