import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
import org.jibble.pircbot.PircBot;

public class MyBot extends PircBot { 
	public MyBot() { //MyBot constructor 
		this.setName("MyWeatherBot1949"); //set name of bot
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message){ //method that reads IRC input and checks for certain keywords
		if(message.contains("weather")) {
			String[] arr = message.split(" "); //create string array from IRC input, split by spaces
			String call = APICall.call(arr[1]); //use the second word (word after weather) as the string to call API and store string in variable call
			
			sendMessage(channel, ""+ call);  //print variable call to IRC channel
			
		}
		
		if(message.contains("hello")) { //if user says hello print hello back to IRC channel
			sendMessage(channel, "Hey " + sender + "! "); 
		}
		
		if(message.contains("numbers")) { //if user says numbers then print random number trivia fact
			try {
			URL url = new URL("http://numbersapi.com/random/trivia"); //get numbers API
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			int status = con.getResponseCode();
			BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			StringBuffer content = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			sendMessage(channel, ""+ content.toString()); //print content to IRC channel
			in.close();
			
			con.disconnect();
			}catch(Exception e) {}
		}
		
		
	}
}

