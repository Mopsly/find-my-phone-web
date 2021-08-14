package com.jsonwitneses.findmyphone.controller;

import com.jsonwitneses.findmyphone.dto.MetricDto;
import com.jsonwitneses.findmyphone.entity.Device;
import com.jsonwitneses.findmyphone.entity.Metric;
import com.jsonwitneses.findmyphone.entity.User;
import com.jsonwitneses.findmyphone.mapper.MetricMapper;
import com.jsonwitneses.findmyphone.service.MetricService;
import com.jsonwitneses.findmyphone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class MetricController {

    private final MetricService metricService;
    private final UserService userService;


    @Autowired
    public MetricController(MetricService service, UserService userService) {
        this.metricService = service;
        this.userService = userService;
    }

    @GetMapping("rest/device/{id}/last")
    public MetricDto getLastMetric(@PathVariable Long id) {
        MetricDto metric = MetricMapper.metricToDto(metricService.getLastDeviceMetric(id));
        return metric;
    }
    @GetMapping("rest/device/{id}/all")
    public MetricDto getAllMetrics(@PathVariable Long id) {
        MetricDto metric = MetricMapper.metricToDto(metricService.getLastDeviceMetric(id));
        return metric;
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

    @PostMapping("/add/metric/{deviceId}")
    public void insertDeviceMetric(@PathVariable Long deviceId,
                                   @RequestBody Metric metric){
        metricService.insertMetric(metric);
    }

    @PostMapping("/user/{id}/addDevice")
    public void addDeviceToUser(@PathVariable Long id, @RequestParam Device device){
        User user = userService.getUserById(id);
        Set<Device> devices = user.getDevices();
        devices.add(device);
        user.setDevices(devices);
        userService.save(user);
    }
    @PutMapping("/rest/listUser")
    public void putListUsers(@RequestBody List<User> users){
        userService.insertUsers(users);
    }

    @PutMapping("/rest/listMetric")
    public void putListMetrics(@RequestBody List<Metric> metrics){
        metricService.insertMetrics(metrics);
    }
}
