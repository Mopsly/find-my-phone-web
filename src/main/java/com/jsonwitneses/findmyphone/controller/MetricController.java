package com.jsonwitneses.findmyphone.controller;

import com.jsonwitneses.findmyphone.dto.MetricDto;
import com.jsonwitneses.findmyphone.entity.Device;
import com.jsonwitneses.findmyphone.entity.Metric;
import com.jsonwitneses.findmyphone.entity.User;
import com.jsonwitneses.findmyphone.mapper.MetricMapper;
import com.jsonwitneses.findmyphone.service.DeviceService;
import com.jsonwitneses.findmyphone.service.MetricService;
import com.jsonwitneses.findmyphone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest")
public class MetricController {

    private final MetricService metricService;
    private final UserService userService;
    private final DeviceService deviceService;


    @Autowired
    public MetricController(MetricService service, UserService userService, DeviceService deviceService) {
        this.metricService = service;
        this.userService = userService;
        this.deviceService = deviceService;
    }

    @GetMapping("/device/{id}/last")
    public MetricDto getLastMetric(@PathVariable Long id) {
        MetricDto metric = MetricMapper.metricToDto(metricService.getLastDeviceMetric(id));
        return metric;
    }

    @GetMapping("device/{id}/all")
    public List<MetricDto> getAllMetrics(@PathVariable Long id) {
        List<Metric> metrics = metricService.getAllDeviceMetrics(id);
        List<MetricDto> metricDtos = new ArrayList<>();
        for (Metric metric : metrics) {
            metricDtos.add(MetricMapper.metricToDto(metric));
        }
        return metricDtos;
    }

    @GetMapping("/user/last/{id}")
    public List<MetricDto> getLastMetricsForUser(@PathVariable Long id) {
        List<MetricDto> metricDtos = new ArrayList<>();
        List<Metric> metrics = metricService.getLastDeviceMetricsForUser(id);
        for (Metric metirc:metrics) {
            metricDtos.add(MetricMapper.metricToDto(metirc));
        }
        return metricDtos;
    }

    @PostMapping("/add/metric/")
    public void insertDeviceMetric(@RequestBody Metric metric) {
        metricService.insertMetric(metric);
    }

    @PostMapping("/user/{id}/addDevice")
    public void addDeviceToUser(@PathVariable Long id, @RequestParam Device device) {
        User user = userService.getUserById(id);
        Set<Device> devices = user.getDevices();
        devices.add(device);
        user.setDevices(devices);
        userService.save(user);
    }

    @PutMapping("/listUser")
    public void putListUsers(@RequestBody List<User> users) {
        userService.insertUsers(users);
    }

    @PutMapping("/rest/listMetric")
    public void putListMetrics(@RequestBody List<Metric> metrics) {
        metricService.insertMetrics(metrics);
    }

    @PutMapping("/test")
    public void temp() {
    deviceService.save(new Device(2L,"Another Kid",Set.of(userService.getUserById(1L))));
        metricService.insertMetric(new Metric(3L, deviceService.getDeviceById(2L), 123457L,
                37.6, 43, 1, 2, 3, 4, 5,
                "ID", "USER", "sas"));
    }
}
