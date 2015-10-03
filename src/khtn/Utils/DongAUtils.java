package khtn.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

import khtn.models.Item;
import khtn.models.ItemArr;

public class DongAUtils {
	public static String getJSON(String path) throws MalformedURLException, IOException{
		URL url = new URL(path);
		URLConnection con = url.openConnection();
		BufferedReader reader = new BufferedReader
				(new InputStreamReader(con.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line = null;
		while ((line=reader.readLine())!=null) {
			builder.append(line);
		}return builder.toString();
	}
	
	public static Item[] parseToItem(String json) {
		Gson gson = new Gson();
		ItemArr obj = gson.fromJson(json, ItemArr.class);
//		String ret = gson.toJson(obj);
//		System.out.println(ret);
		return obj.getItems();
	}
}
