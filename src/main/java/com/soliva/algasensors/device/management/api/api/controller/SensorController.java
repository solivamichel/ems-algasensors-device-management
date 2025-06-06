package com.soliva.algasensors.device.management.api.api.controller;

import com.soliva.algasensors.device.management.api.api.model.SensorInput;
import com.soliva.algasensors.device.management.api.api.model.SensorOutput;
import com.soliva.algasensors.device.management.common.IdGenerator;
import com.soliva.algasensors.device.management.domain.model.Sensor;
import com.soliva.algasensors.device.management.domain.model.SensorId;
import com.soliva.algasensors.device.management.domain.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorRepository sensorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SensorOutput create(@RequestBody SensorInput input) {
        Sensor sensor = Sensor.builder()
                .id(new SensorId(IdGenerator.generateTSID()))
                .name(input.getName())
                .ip(input.getIp())
                .location(input.getLocation())
                .protocol(input.getProtocol())
                .model(input.getModel())
                .enabled(false)
                .build();

        sensor = sensorRepository.saveAndFlush(sensor);

        return convertToModel(sensor);
    }

    private static SensorOutput convertToModel(Sensor sensor) {
        return SensorOutput.builder()
                .id(sensor.getId().getValue())
                .name(sensor.getName())
                .ip(sensor.getIp())
                .location(sensor.getLocation())
                .protocol(sensor.getProtocol())
                .enabled(sensor.getEnabled())
                .build();
    }
}
