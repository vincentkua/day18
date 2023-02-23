package nus.iss.day18.services;

import java.io.StringReader;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class HttpinService {

    public void postAsJson(String name, String email) {
        JsonObject json = Json.createObjectBuilder()
                .add("name", name)
                .add("email", email)
                .build();

        RequestEntity<String> req = RequestEntity
                .post("http://httpbin.org/post")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(json.toString(), String.class);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        System.out.println("Response :" + resp);

        String payload = resp.getBody();
        System.out.println("Payload :" + payload);

    }

    public void post(String name, String email) {

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.set("name", name);
        form.set("email", email);

        RequestEntity<MultiValueMap<String, String>> req = RequestEntity
                .post("http://httpbin.org/post")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                // .header("Content-Type ", "application/x-www-form-urlencoded")
                // .header("Accept ", "application/json")
                .body(form, MultiValueMap.class);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        System.out.println("#####################################");
        System.out.println("Response :" + resp);

        String payload = resp.getBody();
        System.out.println("#####################################");
        System.out.println("Payload :" + payload);

    }

    public void get(String name, String email) {
        String url = UriComponentsBuilder.fromUriString("http://httpbin.org/get")
                .queryParam("name", name)
                .queryParam("email", email)
                .toUriString();
        System.out.println("#####################################");
        System.out.println("Your Url:" + url);

        RequestEntity<Void> req = RequestEntity
                .get(url)
                .build();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        System.out.println("#####################################");
        System.out.println("Response :" + resp);
        String payload = resp.getBody();
        System.out.println("#####################################");
        System.out.println("Payload :" + payload);

    }

    public void get() {
        // Create a Get request
        RequestEntity<Void> req = RequestEntity.get("http://httpbin.org/get")
                .build();

        // Create a REST template
        RestTemplate template = new RestTemplate();

        // Make the request , the payload of the response will be string
        ResponseEntity<String> resp = template.exchange(req, String.class);

        // Check the status code
        System.out.println("#####################################");
        System.out.println("Status Code :" + resp.getStatusCode());

        // Get the payload
        String payload = resp.getBody();
        System.out.println("#####################################");
        System.out.println("Payload : " + payload);

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject json = reader.readObject();
        JsonObject headers = json.getJsonObject("headers");
        String traceId = headers.getString("X-Amzn-Trace-Id");
        System.out.println("#####################################");
        System.out.println("Trace ID :" + traceId);

    }

}
