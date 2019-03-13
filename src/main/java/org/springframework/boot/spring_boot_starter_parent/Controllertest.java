package org.springframework.boot.spring_boot_starter_parent;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Service.helloService;

@Controller
public class Controllertest {

	@RequestMapping("/zz")
	public String aha(String ch) throws Exception { 	
		return "hello";
	}

	@RequestMapping("/getData")
	@ResponseBody
	public String get(HttpServletRequest request) {
		String ch = request.getParameter("user");
		helloService hs = new helloService();
		Map<String, String> result = new HashMap<String, String>();
		result = hs.getData(ch);
		ObjectMapper obj = new ObjectMapper();
		String jsonRes;
		try {
			if(result.size() == 0) {
				result.put("status", "error");
				jsonRes = obj.writeValueAsString(result);
			}
			else{
				result.put("status", "success");
				jsonRes = obj.writeValueAsString(result);
			} 
		}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{\"status\": \"error\"}";
		}
		return jsonRes;
	}
}
