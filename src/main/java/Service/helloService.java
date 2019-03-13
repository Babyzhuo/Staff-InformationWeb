package Service;
import java.util.*;
import org.springframework.stereotype.Service;

import Dao.userGetDAta;

@Service("helloService")
public class helloService implements IHelloService{
		
	 public Map<String, String> getData(String str1){
		 userGetDAta ug = new userGetDAta();
		 Map<String,String> map = new HashMap<String,String>();
		 map = ug.Select(str1);
		 return map;
	 }
}
