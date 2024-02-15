package com.mattjoneslondon.ghactions.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class TimeDiscoveryServiceImpl implements TimeDiscoveryService {

    @Override
    public ZonedDateTime getCurrentDateTime() {
        return ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC"));
    }
}