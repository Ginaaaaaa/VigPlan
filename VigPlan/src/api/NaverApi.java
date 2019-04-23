//package api;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.servlet.annotation.WebServlet;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.vigplan.vo.PlaceVo;
//
//// @WebServlet("/map")
//public class NaverApi {
//	private static final String clientId = "BUxggQkvPjaUaNp736T4";
//	private static final String clientSecret = "QWUDEGsa78";
//
//	
//    public static List<PlaceVo> searchPlace(String keyword, int display, int start) {
//        List<PlaceVo> list = null;
//        
//        try {
//            String text = URLEncoder.encode(keyword, "UTF-8");
//            String apiURL = "https://openapi.naver.com/v1/search/local.json?display=" + display + "&start=" + start + "&sort=sim&query=" + text;
//            URL url = new URL(apiURL);
//            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//            con.setRequestMethod("GET");
//            
//            con.setRequestProperty("X-Naver-Client-Id", clientId);
//            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//
//            con.setDoOutput(true);
//
//            int responseCode = con.getResponseCode();
//            BufferedReader br;
//            if(responseCode==200) { 
//                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            } else {  
//                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//            }
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = br.readLine()) != null) {
//                response.append(inputLine);
//            }
//            br.close();
//            
//            Gson gson = new Gson();	//	Gson 객체 인스턴스화 
//            JsonObject json = gson.fromJson(response.toString(), JsonObject.class);
//            System.out.println("JSON:" + json);
//            JsonArray arr = json.get("items").getAsJsonArray();
//            
//            PlaceVo[] places = gson.fromJson(arr, PlaceVo[].class);
//            list = Arrays.asList(places);
//            
//        } catch (Exception e) {
//           e.printStackTrace();
//        }
//        
//        return list;
//    }
//}