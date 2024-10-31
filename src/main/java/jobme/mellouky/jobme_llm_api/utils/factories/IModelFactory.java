package jobme.mellouky.jobme_llm_api.utils.factories;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Component;

public interface IModelFactory {

    String getModelName();
    ChatModel createModel();

}
