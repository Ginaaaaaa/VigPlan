package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vigplan.vo.KakaoApiVo;

@WebServlet("/map")
public class test {
	private static final String CLIENT_ID = "dd4d3097d3505db8a32dc36cafd99fe1"; 
	private static final String AUTHORIZATION_CODE = "KakaoAK dd4d3097d3505db8a32dc36cafd99fe1"; // 로그인 과정중 얻은 authorization code 값


		OutputStreamWriter writer = null;
		static BufferedReader reader = null;
		static InputStreamReader isr = null;

		public static List<KakaoApiVo> searchPlace(String keyword, int size, int page){
		List<KakaoApiVo> list = null;
		
		try {
		
			String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");
			String LOCAL_SEARCH_API_URL = "https://dapi.kakao.com/v2/local/search/keyword.json?size=" + size + "&page=" + page +"&query=" ; 																												// 가능
			URL url = new URL(LOCAL_SEARCH_API_URL + encodedKeyword);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
	
			con.setRequestProperty("Authorization", AUTHORIZATION_CODE);

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
			
            System.out.println("RESPONSE:" + response.toString());
			Gson gson = new Gson();
			JsonObject json = gson.fromJson(response.toString(), JsonObject.class);
			System.out.println("JSON:" + json);
			JsonArray arr = json.get("documents").getAsJsonArray();
			
			KakaoApiVo[] places = gson.fromJson(arr, KakaoApiVo[].class);
			list = Arrays.asList(places);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
