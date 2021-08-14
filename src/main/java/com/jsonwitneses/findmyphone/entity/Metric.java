package com.jsonwitneses.findmyphone.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "location_metric")
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Device device;
//    @Column
//    private Long deviceId;

    @Column
    private Timestamp timeStamp;

    //временное решение - широта долгота
    @Column
    private double lambda;
    @Column
    private double fi;

    public Metric( Long id, Device device, Timestamp timeStamp, double lambda, double fi) {
        this.id = id;
        this.device = device;
        this.timeStamp = timeStamp;
        this.lambda = lambda;
        this.fi = fi;

    }

    public Metric() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

//    public Long getDeviceId() {
//        return deviceId;
//    }
//
//    public void setDeviceId(Long deviceId) {
//        this.deviceId = deviceId;
//    }

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

    @Override
    public String toString() {
        return "LocationMetric{" +
                "id=" + id +
                ", device=" + device +
                ", timeStamp=" + timeStamp +
                ", lambda=" + lambda +
                ", fi=" + fi +
                '}';
    }
}
