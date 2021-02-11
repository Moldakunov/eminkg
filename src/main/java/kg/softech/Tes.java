package kg.softech;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kg.softech.config.globalvariable.GlobalVar;
import kg.softech.model.OrderInAccount;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import sun.security.util.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;

public class Tes {
    /*public static void main(String[] args) {
        String scopes = "https://www.googleapis.com/auth/indexing";
        String endPoint = "https://indexing.googleapis.com/v3/urlNotifications:publish";

        JsonFactory jsonFactory = new JacksonFactory();

// service_account_file.json is the private key that you created for your service account.
        InputStream in = IOUtils.toInputStream("service_account_file.json");

        GoogleCredential credentials =
                GoogleCredential.fromStream(in, this.httpTransport, jsonFactory).createScoped(Collections.singleton(scopes));

        GenericUrl genericUrl = new GenericUrl(endPoint);
        HttpRequestFactory requestFactory = this.httpTransport.createRequestFactory();

// Define content here. The structure of the content is described in the next step.
        String content = "{"
                + "\"url\": \"http://example.com/jobs/42\","
                + "\"type\": \"URL_UPDATED\","
                + "}";

        HttpRequest request =
                requestFactory.buildPostRequest(genericUrl, ByteArrayContent.fromString("application/json", content));

        credentials.initialize(request);
        HttpResponse response = request.execute();
        int statusCode = response.getStatusCode();
    }*/
}
