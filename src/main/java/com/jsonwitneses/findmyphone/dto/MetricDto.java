package com.jsonwitneses.findmyphone.dto;


import com.jsonwitneses.findmyphone.entity.Device;

import javax.persistence.*;
import java.sql.Timestamp;

public class MetricDto {
    private Long id;

    private Long deviceId;

    private Timestamp timeStamp;

    //временное решение - широта долгота
    private double lambda;
    private double fi;

    public MetricDto() {
    }

    public MetricDto(Long id, Long deviceId, Timestamp timeStamp, double lambda, double fi) {
        this.id = id;
        this.deviceId = deviceId;
        this.timeStamp = timeStamp;
        this.lambda = lambda;
        this.fi = fi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public double getFi() {
        return fi;
    }

    public void setFi(double fi) {
        this.fi = fi;
    }
}
