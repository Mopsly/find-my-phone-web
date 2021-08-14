package com.jsonwitneses.findmyphone.mapper;

import com.jsonwitneses.findmyphone.dto.MetricDto;
import com.jsonwitneses.findmyphone.entity.Device;
import com.jsonwitneses.findmyphone.entity.Metric;
import org.apache.tomcat.util.descriptor.web.MultipartDef;

import java.util.HashSet;

public class MetricMapper {
    public static MetricDto metricToDto(Metric metric){
        return new MetricDto(metric.getId()
                , metric.getDevice().getId()
                , metric.getTimeStamp()
                , metric.getLambda()
                , metric.getFi());
    }
        public static Metric dtoToMetric(MetricDto metric){
            return new Metric(metric.getId()
                    , new Device(metric.getId(),"", new HashSet<>())
                    , metric.getTimeStamp()
                    , metric.getLambda()
                    , metric.getFi());
        }
    }
