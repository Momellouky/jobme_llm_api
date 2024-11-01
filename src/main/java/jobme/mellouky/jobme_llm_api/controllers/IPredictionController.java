package jobme.mellouky.jobme_llm_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prediction/")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public interface IPredictionController {

    @PostMapping("jobs")
    public ResponseEntity<Map<String, Double>> predict(
            @RequestBody(required = true) String userSkills
    );

}
