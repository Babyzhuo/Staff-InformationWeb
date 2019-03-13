package Service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service("helloService")
public interface IHelloService{
	public Map<String, String> getData(String str1);
}
