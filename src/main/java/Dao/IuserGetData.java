package Dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface IuserGetData {
	public Map<String,String> Select(String str);
}
