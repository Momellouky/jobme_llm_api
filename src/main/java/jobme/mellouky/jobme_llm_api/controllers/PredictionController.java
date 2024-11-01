package jobme.mellouky.jobme_llm_api.controllers;

import jobme.mellouky.jobme_llm_api.services.IPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prediction")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class PredictionController implements IPredictionController{

    @Autowired
    IPredictionService predictionService;

    @PostMapping("jobs")
    public ResponseEntity<Map<String, Double>> predict(
            @RequestBody(required = true) String userSkills
    ) {
       Map<String, Double> response = predictionService.predict(userSkills);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
