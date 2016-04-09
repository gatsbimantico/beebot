package gpul.iotlabs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import gpul.iotlabs.db.model.Unit;

@Service
public interface UnitDAO extends JpaRepository<Unit, Long>{ 
}
