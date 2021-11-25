import org.jibble.pircbot.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MyBotMain {
	public static void main(String[] args) throws Exception {
		
		MyBot bot = new MyBot(); //instantiate bot object 
		bot.setVerbose(true); //set bot to verbose
		
		bot.connect("irc.freenode.net"); //connect bot to IRC IP

		bot.joinChannel("#DanielOglesby"); //connect bot to IRC channel
		
	}
}
