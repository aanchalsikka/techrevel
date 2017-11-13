package blog.techrevel.api;

import java.io.StringReader;

//import javax.json.Json;
//import javax.json.JsonArray;
//import javax.json.JsonObject;
//import javax.json.JsonReader;

public class JavaxJsonObject {

	public static void main(String[] args) {
		String jsonString = "[{\"linktext\":\"link1\",\"linkURL\":\"#testanchor\"},"
				+ "{\"linktext\":\"link2\",\"linkURL\":\"/content/oneMarketing/page1\"},"
				+ "{\"linktext\":\"link3\",\"linkURL\":\"http://www.google.de\"}]";
//		JsonReader jsonReader = null;
//		try {
//			StringReader stringReader = new StringReader(jsonString);
//			jsonReader = Json.createReader(stringReader);
//			JsonArray jsonArray = jsonReader.readArray();
//			for (JsonObject fieldJson : jsonArray.getValuesAs(JsonObject.class)) {
//				System.out.println(fieldJson.getString("linktext"));
//				System.out.println(fieldJson.getString("linkURL"));
//			}
//		} finally {
//			if (jsonReader != null) {
//				jsonReader.close();
//			}
//		}
	}
}
