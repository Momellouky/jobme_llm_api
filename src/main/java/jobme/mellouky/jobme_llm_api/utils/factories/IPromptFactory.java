package jobme.mellouky.jobme_llm_api.utils.factories;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Component;


public interface IPromptFactory {

    Prompt createPrompt(String userSkills);

}
