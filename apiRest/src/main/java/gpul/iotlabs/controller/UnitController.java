package gpul.iotlabs.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gpul.iotlabs.dao.UnitDAO;
import gpul.iotlabs.db.model.Unit;

@RestController
@RequestMapping(path="/unit")
public class UnitController {

	@Autowired
	private UnitDAO unitDao;
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public List<Unit> getUnits(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		return unitDao.findAll();
	}
	
}
