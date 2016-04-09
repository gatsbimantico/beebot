package gpul.iotlabs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import gpul.iotlabs.db.model.Data;

@Service
public interface DataDAO extends JpaRepository<Data, Long> {

	@Query("SELECT d FROM Data d WHERE d.sensor = :sensorId")
	public List<Data> findBySensorId(@Param("sensorId") Long sensorId);
	
	@Query("SELECT d FROM Data d WHERE d.sensor = :sensorId and d.date >= :startDate and d.date <= :endDate")
	public List<Data> findSensorDataBetweenDates(@Param("sensorId") Long sensorId,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	@Query("SELECT d FROM Data d WHERE d.sensor = :sensorId order by time desc")
	public List<Data> findLastEntry(@Param("sensorId") Long sensorId);

	@Query("SELECT d FROM Data d WHERE d.date >= :startDate and d.date <= :endDate")
	public List<Data> findBetweenDates(@Param("startDate") long startDate, @Param("endDate") long endDate);
	
}
