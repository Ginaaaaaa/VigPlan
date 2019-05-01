package api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vigplan.vo.PlaceVo;

public class NaverApi {
	//	API 인증 정보
	private static final String clientId = "BUxggQkvPjaUaNp736T4";
	private static final String clientSecret = "QWUDEGsa78";

	public static void main(String[] args) {
		List<PlaceVo> list = searchPlace("비트", 10, 1);
		for (PlaceVo place: list) {
			System.out.println(place);
		}
	}
	
    public static List<PlaceVo> searchPlace(String keyword, int display, int start) {
        List<PlaceVo> list = null;
        
        try {
            String text = URLEncoder.encode(keyword, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/local.json?display=" + display + "&start=" + start + "&sort=sim&query=" + text;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            //	Header에 인증 정보 설정
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
            
            System.out.println("RESPONSE:" + response.toString());	// TEXT
            
            Gson gson = new Gson();	//	Gson 객체 인스턴스화 
            JsonObject json = gson.fromJson(response.toString(), JsonObject.class);
            System.out.println("JSON:" + json);	//	객체
            System.out.println("\tlastBuildDate:" + json.get("lastBuildDate"));
            
            JsonArray arr = json.get("items").getAsJsonArray();
            System.out.println("ARR:" + arr);
            
            PlaceVo[] places = gson.fromJson(arr, PlaceVo[].class);	//	VO 배열로 변환
            list = Arrays.asList(places);	//	배열 -> 리스트로 
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        return list;
    }
}