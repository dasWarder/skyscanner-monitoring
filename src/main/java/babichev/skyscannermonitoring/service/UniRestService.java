package babichev.skyscannermonitoring.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public interface UniRestService {

    HttpResponse<JsonNode> get(String path);
}
