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

import java.util.List;
import java.util.Set;

@RestController("/rest")
public class MetricController {

    private final MetricService metricService;
    private final UserService userService;


    @Autowired
    public MetricController(MetricService service, UserService userService) {
        this.metricService = service;
        this.userService = userService;
    }

    @GetMapping("/device/{id}")
    public MetricDto getMetric(@PathVariable Long id) {
        MetricDto metric = MetricMapper.metricToDto(metricService.getAllDeviceMetrics(id).get(0));
        return metric;
    }

    @GetMapping("/user/last/{id}")
    public List<Metric> getLastMetricsForUser(@PathVariable Long id) {
        return metricService.getLastDeviceMetricsForUser(id);
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
