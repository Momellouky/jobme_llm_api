package jobme.mellouky.jobme_llm_api.services;

import org.springframework.stereotype.Service;

@Service
public interface IPredictionService {
    String predict(String userSkills);
}
