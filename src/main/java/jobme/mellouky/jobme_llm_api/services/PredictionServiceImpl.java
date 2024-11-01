package jobme.mellouky.jobme_llm_api.services;

import jobme.mellouky.jobme_llm_api.utils.factories.IModelFactory;
import jobme.mellouky.jobme_llm_api.utils.factories.IPromptFactory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class PredictionServiceImpl implements IPredictionService{

    @Autowired
    IModelFactory modelFactory;

    @Autowired
    IPromptFactory promptFactory;

    @Override
    public Map<String, Double> predict(String userSkills) {
        ChatModel chatModel = modelFactory.createModel();
        Prompt prompt = promptFactory.createPrompt(userSkills);
        ChatResponse response = chatModel.call(prompt);
        System.out.println("model answer: " + response.getResult().getOutput().getContent());
        System.out.println("response.getResult(): " + response.getResult());
        System.out.println("response.getResult().getOutput()): " + response.getResult().getOutput());
        return handleResponse(response.getResult().getOutput().getContent()); // TODO: check if the toString() function should be overloaded
    }

    private Map<String, Double> handleResponse(String response) {

        Map<String, Double> jobPercentages = new HashMap<>();
        for(String percentage : response.substring(1, response.length() - 1).split(",")) {
            String[] split = percentage.split(":");
            jobPercentages.put(split[0], Double.parseDouble(split[1].substring(0, split[1].length() - 1)));
        }
        return jobPercentages;
    }
}
