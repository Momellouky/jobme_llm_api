package jobme.mellouky.jobme_llm_api.controllers;

import jobme.mellouky.jobme_llm_api.services.IPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prediction")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class PredictionController implements IPredictionController{

    @Autowired
    IPredictionService predictionService;

    @PostMapping("jobs")
    public ResponseEntity<String> predict(
            @RequestBody(required = true) String userSkills
    ) {
       String response = predictionService.predict(userSkills);
       return new ResponseEntity<String>(response, HttpStatus.OK);
    }

}
