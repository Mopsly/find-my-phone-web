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

    @Column
    private Long timeStamp;
    //временное решение - широта долгота
    @Column
    private double latitude;
    @Column
    private double longitude;

    @Column
    private int cellid;
    @Column
    private int lac;
    @Column
    private int rsrp;
    @Column
    private int rsrq;
    @Column
    private int sinr;

    @Column
    private String deviceid;
    @Column
    private String userid;
    @Column
    private String imsi;

    public Metric( Long id, Device device, Long timeStamp, double longitude, double latitude) {
        this.id = id;
        this.device = device;
        this.timeStamp = timeStamp;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public Metric() {
    }

    public Metric(Long id, Device device, Long timeStamp, double latitude,
                  double longitude, int cellid, int lac, int rsrp, int rsrq,
                  int sinr, String deviceid, String userid, String imsi) {
        this.id = id;
        this.device = device;
        this.timeStamp = timeStamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cellid = cellid;
        this.lac = lac;
        this.rsrp = rsrp;
        this.rsrq = rsrq;
        this.sinr = sinr;
        this.deviceid = deviceid;
        this.userid = userid;
        this.imsi = imsi;
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

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double fi) {
        this.longitude = fi;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getCellid() {
        return cellid;
    }

    public void setCellid(int cellid) {
        this.cellid = cellid;
    }

    public int getLac() {
        return lac;
    }

    public void setLac(int lac) {
        this.lac = lac;
    }

    public int getRsrp() {
        return rsrp;
    }

    public void setRsrp(int rsrp) {
        this.rsrp = rsrp;
    }

    public int getRsrq() {
        return rsrq;
    }

    public void setRsrq(int rsrq) {
        this.rsrq = rsrq;
    }

    public int getSinr() {
        return sinr;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public void setSinr(int sinr) {
        this.sinr = sinr;
    }
}
