package com.jsonwitneses.findmyphone.dao;

import com.jsonwitneses.findmyphone.entity.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Metric,Long> {

    @Query("SELECT DISTINCT m " +
            "FROM Metric m " +
            "WHERE m.id =?1 order by m.timeStamp desc")
    Metric getLastMetricForDevice(Long id);

    Metric getLocationMetricByDevice_Id(Long id);

    List<Metric> findAllByDevice_Id(Long id);
}
