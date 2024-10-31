package jobme.mellouky.jobme_llm_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prediction/")
public interface IPredictionController {

    @PostMapping("jobs")
    public ResponseEntity<String> predict(
            @RequestBody(required = true) String userSkills
    );

}
