package com.project1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.entity.payload.RequestData;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class VoltageServiceImpl implements VoltageService {

    static HttpClient client = new DefaultHttpClient();
    static String firstElement;
    public String postData(String data[]) throws Exception {


        try {
            HttpPost post = new HttpPost("http://localhost:8082/encrypt");
            post.addHeader("Content-Type", "application/json");

            RequestData requestData = new RequestData("debit-card", data);

            ObjectMapper mapper = new ObjectMapper();
            StringEntity json = new StringEntity(mapper.writeValueAsString(requestData));
            post.setEntity(json);

            HttpResponse response = client.execute(post);
            System.out.println(response);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with Http error code : " + statusCode);

            }

            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response Body : " + responseBody);

            JSONObject object =  new JSONObject(responseBody);
            System.out.println(object);

            JSONArray array = object.getJSONArray("data");
            firstElement =  array.getString(0);
            System.out.println(firstElement);

        } finally {
            client.getConnectionManager().shutdown();
        }

        return firstElement;
    }

    public String fetchData(String phoneNumber[]) throws Exception{

        HttpClient client = new DefaultHttpClient();
        String firstElement;
        try{
            HttpPost post = new HttpPost("http://localhost:8082/decrypt");
            post.addHeader("Content-Type" , "application/json");

            RequestData data = new RequestData("cc" ,phoneNumber);

            ObjectMapper mapper = new ObjectMapper();
            StringEntity json = new StringEntity(mapper.writeValueAsString(data));
            post.setEntity(json);

            HttpResponse response = client.execute(post);
            System.out.println(response);

            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != 200){
                throw new RuntimeException("Http status code error : " + statusCode);
            }
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println(responseBody);

            JSONObject object = new JSONObject(responseBody);
            System.out.println(object);

            JSONArray array = object.getJSONArray("data");
            firstElement = array.getString(0);
            System.out.println(firstElement);

        }finally {
            client.getConnectionManager().shutdown();
        }
        return firstElement;
    }

}
