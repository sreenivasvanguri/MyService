package com.mobiquity.assignment.atmlocator;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mobiquity.assignment.atmlocator.beans.AtmDetails;
import com.mobiquity.assignment.atmlocator.service.ServiceLocator;

@RestController 
public class ATMController {
	
	@Autowired
    private ServiceLocator locator;

    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Response<AtmDetails> getLocationsfromService() throws Exception {
        Response<AtmDetails> responseObject= new Response<>();
        responseObject.setList(locator.getATMListfromService());
        return responseObject;
    }

	@RequestMapping(value = "/locations/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Response<AtmDetails> getLocationsfromByCity(@PathVariable("city") String city)
			throws Exception {
		Response<AtmDetails> responseObject = new Response<>();
		responseObject.setList(locator.getLocationsByCity(city));
		return responseObject;
	}
	
	public class Response<E> {
		private List<E> list;
	    public List<E> getList() {
	        return list;
	    }

	    public void setList(List<E> list) {
	        this.list = list;
	    }

	    
	}
 }


