package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

public class JSONParser {

	public static void main(String[] args) {
		new JSONParser();
	}

	public JSONParser() {
		String data = readFile();
		
		JSONObject json = new JSONObject(data);
		System.out.println(json.getString("name"));
		System.out.println(json.getString("age"));
		System.out.println(json.getJSONObject("address"));
		
	}
	
	public String readFile() {
		String data = "";
		String line = "";
		try {
			InputStream inputStream = new FileInputStream("resources/json.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream); 
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			try {
				while ((line = bufferedReader.readLine()) != null) {
					data += line + "\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
}
