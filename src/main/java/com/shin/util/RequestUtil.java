package com.shin.util;

import com.shin.common.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class RequestUtil {

    public static String requestPapago(String targetStr) {

        String translateStr = null;
        String papagoResult = null;
        try {
            String text = URLEncoder.encode(targetStr, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", Constants.CLIENT_ID);
            con.setRequestProperty("X-Naver-Client-Secret", Constants.CLIENT_SECRET);
            // post request
            String postParams = "source=ko&target=en&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            papagoResult = response.toString();
            translateStr = selectResultFromRes(papagoResult);

        } catch (Exception e) {
            System.out.println(e);
        }
        return translateStr;
    }


    public static String selectResultFromRes(String rawStr) throws Exception {
        String translateStr = null;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(rawStr);
            JSONObject jsonRoot = (JSONObject)obj;
            JSONObject message = (JSONObject)jsonRoot.get("message");
            JSONObject result = (JSONObject)message.get("result");
            translateStr = (String)result.get("translatedText");
        } catch (ParseException e) {
            throw new Exception("selectResultFromRes error", e);
        }

        return translateStr;
    }
}
