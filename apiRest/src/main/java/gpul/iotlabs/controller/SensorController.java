	package gpul.iotlabs.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gpul.iotlabs.dao.DataDAO;
import gpul.iotlabs.dao.SensorDAO;
import gpul.iotlabs.db.model.Data;
import gpul.iotlabs.db.model.Sensor;

/**
 * 
 * @author viticlick
 *
 */
@RestController
@RequestMapping(path="/sensor")
public class SensorController {
	
	@Autowired
	private DataDAO dataDAO;
	
	@Autowired
	private SensorDAO sensorDAO;

	/**
	 * Return data recorded
	 * @param id
	 * @return list of recorded data
	 */
	@RequestMapping(path="/{id}/historic", method=RequestMethod.GET)
	public List<Data> getAllHistoricData(@PathVariable final long id, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		List<Data> list = dataDAO.findBySensorId(id);
		return list;
	}
	
	/**
	 * Return the data recorded between two dates
	 * @param id The sensor id
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the recorded data
	 */
	@RequestMapping(path="/{id}/historic/{startDate}/{endDate}", method=RequestMethod.GET)
	public List<Data> getHistoricDataBetweenDates( @PathVariable final long id,
			@PathVariable("startDate") Date startDate ,
			@PathVariable("endDate") Date endDate,
			HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		List<Data> list = dataDAO.findSensorDataBetweenDates(id, startDate, endDate);
		return list;
	}
	
	@RequestMapping(path="/{id}/last/{rows}")
	public List<Data> getLastsRows(@PathVariable final long id,
			@PathVariable Integer rows,
			HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
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
	public List<Sensor> getSensors(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		return sensorDAO.findAll();
	}
}
