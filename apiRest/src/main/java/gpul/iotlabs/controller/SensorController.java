	package gpul.iotlabs.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gpul.iotlabs.dao.DataDAO;
import gpul.iotlabs.dao.SensorDAO;
import gpul.iotlabs.db.model.Data;
import gpul.iotlabs.db.model.Sensor;

@RestController
@RequestMapping(path="/sensor")
public class SensorController {
	
	@Autowired
	private DataDAO dataDAO;
	
	@Autowired
	private SensorDAO sensorDAO;

	@RequestMapping(path="/{id}/historic", method=RequestMethod.GET)
	public List<Data> getAllHistoricData(@PathVariable final long id){
		List<Data> list = dataDAO.findBySensorId(id);
		return list;
	}
	
	@RequestMapping(path="/{id}/historic/{startDate}/{endDate}", method=RequestMethod.GET)
	public List<Data> getHistoricDataBetweenDates( @PathVariable final long id,
			@PathVariable("startDate") Date startDate ,
			@PathVariable("endDate") Date endDate){
		List<Data> list = dataDAO.findSensorDataBetweenDates(id, startDate, endDate);
		return list;
	}
	
	@RequestMapping(path="/{id}/last/{rows}")
	public List<Data> getLastsRows(@PathVariable final long id,
			@PathVariable Integer rows){
		if(rows == null){
			rows = 5;
		}
		List<Data> list = dataDAO.findLastEntry(id);
		if( list.size() >= rows){
			return list.subList(0, rows );
		}
		return list;
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Sensor> getSensors(){
		return sensorDAO.findAll();
	}
}
