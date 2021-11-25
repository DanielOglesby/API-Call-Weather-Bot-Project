import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

public class APICall {
	
	public static void main(String[] args) {
		
	}
		
	/*public static Map<String, Object> jsonToMap (String str){
		Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType());
		return map;
	}*/ //didn't end up using this 
	
	public static String call(String loc) {
		String API_KEY = "3fea59c5224fbad2d80aba062f1f7be2"; //api key 
		String LOCATION = loc; //location string read in from IRC channel
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY +
				"&units=imperial"; //urlString combines given API URL, location, and api key to make API call
		try {
			URL url = new URL(urlString); //connect to API URL
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); //open connection to API URL
			con.setRequestMethod("GET"); //set API call type to get 
			
			int status = con.getResponseCode();
			BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			StringBuffer content = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) { //read in entire json string into content
				content.append(inputLine);
			}
			
			in.close(); //close bufferedreader
			
			con.disconnect(); //disconnect from API URL
			Test gson = new Gson().fromJson(content.toString(), Test.class);
			return "It is currently " + gson.main.temp + "F with " + gson.weather[0].description; //return string with temperature and weather description
		}catch(Exception e) {return e.toString();} //catch block for exception handling/testing
		//return "ERROR";
	}
}	 



class Test{ //classes that mimic json node for parsing
	Main main;
	Weather weather[];
}
class Weather{
	String description;
}
class Main{
	String temp;
}

