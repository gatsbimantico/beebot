package gpul.iotlabs.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gpul.iotlabs.dao.DataDAO;
import gpul.iotlabs.db.model.Data;

@RestController
@RequestMapping(path="/data")
public class DataController {

	@Autowired
	private DataDAO dao;
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Data> getAllData(){
		return dao.findAll();
	}
	
	@RequestMapping(path="/historic/{startDate}/{endDate}", method=RequestMethod.GET)
	public List<Data> getDataBetweenDates(@PathVariable("startDate") final long startDate, @PathVariable("endDate") final long endDate, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		return dao.findBetweenDates(startDate,endDate);
	}
	
}
	