package jobme.mellouky.jobme_llm_api.utils.factories;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.AbstractMessage;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FewShotPrompt implements IPromptFactory {
    @Override
    public Prompt createPrompt(String userSkills) {
        String systemMsj = """
                You are an assistant. You can assist job seeker to suggest a job according to their skills.
                You will get the skills of the job seeker as input. The expected input is [skill1, skill2, ...]
                We expect the following format:
                [job1 : percentage1%, job2 : percentage2%, ...]
                The sum of the percentages (percentage1 + percentage2 + ...) should be equal to 100%
                The answer should cover all skills. Give equal interest to all skills in the user input.
                Be straight to the point. Do not explain your answer. Answer only with the array that contains the percentage of each job.
                Be creative, Find matching jobs outside the list of job examples you have.
                """;
        String fewShots = """
                Example of Skills : [Python, Java, C#, TensorFlow, Unity 3D, HTML, Godot, Golang, Numpy, Rust, Pandas, C++, Matplotlib, C, Keras, Unreal Engine, Javascript ...]
                Example of jobs : [Network Engineer, Backend Engineer, Data Scientist, Researcher, Game Developer, Web Developer, Front End Engineer ... ]
                Example: 
                    set of skills : [Python, JAVA, Pandas, Javascript, C++, Numpy, Unity 3D, Pandas, C#, TensorFlow, Godot, C, Keras, Unreal Engine]
                    output: [Backend engineering: 40%, Data science: 40%, Game Development: 20%]
                """;
//        String fewShots = """
//                Examples:
//                    input: ["HTML", "Flask", "Numpy", "Scikit-learn", "JAVA", "CSS", "C#", "Python", "JavaScript", "TensorFlow", "Pandas"]
//                    output : [Data science: 60%, Backend engineering: 30%, Frontend engineering: 10%]
//                    Input: ["Java Spring boot",  "Python", "Spring Data", "Flask", "Numpy", "Django" , "Pandas"]
//                    output: [Backend engineering: 60%, Data science: 10%, Full-stack engineering: 30%]
//
//                """;
        String userPrompt = "User skills: " + userSkills;

        String fullPrompt = systemMsj + fewShots + userPrompt;
//        String fullPrompt = systemMsj + userPrompt;


        PromptTemplate promptTemplate = new SystemPromptTemplate(fullPrompt);

        return promptTemplate.create(Map.of("userSkills", userSkills));

    }
}
