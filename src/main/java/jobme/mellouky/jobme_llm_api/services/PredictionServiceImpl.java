package jobme.mellouky.jobme_llm_api.services;

import jobme.mellouky.jobme_llm_api.utils.factories.IModelFactory;
import jobme.mellouky.jobme_llm_api.utils.factories.IPromptFactory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PredictionServiceImpl implements IPredictionService{

    @Autowired
    IModelFactory modelFactory;

    @Autowired
    IPromptFactory promptFactory;

    @Override
    public String predict(String userSkills) {
        ChatModel chatModel = modelFactory.createModel();
        Prompt prompt = promptFactory.createPrompt(userSkills);
        ChatResponse response = chatModel.call(prompt);
        System.out.println("model answer: " + response.getResult().getOutput().getContent());

        return response.getResult().getOutput().getContent(); // TODO: check if the toString() function should be overloaded
    }
}
