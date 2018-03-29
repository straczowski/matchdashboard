package matchday;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@EnableAutoConfiguration
public class MatchdashboardController {


    private static final Logger log = LoggerFactory.getLogger(MatchdashboardController.class);


    public static void main(String[] args) throws Exception {
        SpringApplication.run(MatchdashboardController.class, args);
    }


    @RequestMapping(path = "/", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity home() {
        ResponseEntity jsonObject = getJsonObject();
        return jsonObject;
    }


    public ResponseEntity getJsonObject() {
        String apiEndpoint = "https://jsonplaceholder.typicode.com/posts/1";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiEndpoint);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);


        log.info(response.toString());

        return response;
    }
}
