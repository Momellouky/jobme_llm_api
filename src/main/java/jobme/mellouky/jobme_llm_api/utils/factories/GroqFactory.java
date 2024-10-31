package jobme.mellouky.jobme_llm_api.utils.factories;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroqFactory implements IModelFactory{

    @Autowired
    private ChatModel chatModel;

    @Override
    public String getModelName() {
        return "GroqCloud"; // TODO : change the name of the model.
                            // TODO : Get the model name from the application.properties
    }

    @Override
    public ChatModel createModel() {
        return this.chatModel;
    }
}
