package jobme.mellouky.jobme_llm_api.services;

import org.springframework.stereotype.Service;

import java.util.Map;


public interface IPredictionService {
    Map<String, Double> predict(String userSkills);
}
