package com.mattjoneslondon.ghactions.services;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


class TimeDiscoveryServiceImplTest {

    @Test
    void getCurrentDateTimeReturnsZonedDateTimeWithinExpectedTolerance() {
        var timeDiscoveryService = new TimeDiscoveryServiceImpl();
        var discoveredDateTime = timeDiscoveryService.getCurrentDateTime();
        var currentDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC"));
        assertThat(Duration.between(discoveredDateTime, currentDateTime), lessThan(Duration.ofMillis(1000L)));
    }
}