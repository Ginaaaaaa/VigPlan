package api;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;


public class APIExamTranslateNMT {

    public static void main(String[] args) {
        String clientId = "BUxggQkvPjaUaNp736T4";
        String clientSecret = "QWUDEGsa78";
        try {
            String text = URLEncoder.encode("고기", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/local.json?query=" + text;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            con.setDoOutput(true);

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { 
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            
            //	TODO: 아래 코드를 참조
            //		json 내부의 items 노드를 뜯어서
            //		PlaceVo의 List로 변환
            
            Gson gson = new Gson();	//	Gson 객체 인스턴스화
            JsonObject json = gson.fromJson(response.toString(), JsonObject.class);	//	JsonString을 객체로 변환
//            System.out.println(json);
//            System.out.println(json.get("items"));
            //	TODO: 1차 목표는 List<PlaceVo>로 만드는 것~
            JsonArray arr = json.get("items").getAsJsonArray();
//            System.out.println(arr);
            
            for (JsonElement item: arr) {
//            	System.out.println(item);
            	JsonObject j = item.getAsJsonObject();
//            	System.out.println(j.get("title"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}