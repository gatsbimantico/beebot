package gpul.iotlabs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import gpul.iotlabs.db.model.Sensor;

@Service
public interface SensorDAO extends JpaRepository<Sensor, Long>{ 
	
}
