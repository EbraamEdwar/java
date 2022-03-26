package finalprojectwebservice.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class LinkCreator {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	public String readData(String path) {
		String df = restTemplate.getForObject("http://localhost:8080/"+path, String.class);
		return df;
		}


}