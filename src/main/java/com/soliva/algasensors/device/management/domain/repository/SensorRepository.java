package com.soliva.algasensors.device.management.domain.repository;

import com.soliva.algasensors.device.management.domain.model.Sensor;
import com.soliva.algasensors.device.management.domain.model.SensorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, SensorId> {
}
