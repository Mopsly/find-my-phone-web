package com.jsonwitneses.findmyphone.dao;

import com.jsonwitneses.findmyphone.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
