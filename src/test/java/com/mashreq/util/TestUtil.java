package com.mashreq.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class TestUtil {

	public static String getJSONObjectStringByJSONFileName(String jsonFileName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		InputStream resourceAsStream = TestUtil.class.getResourceAsStream("/staticrequest/"+jsonFileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
		 return ((JSONObject) parser.parse(bufferedReader)).toString();
	}
	
}
