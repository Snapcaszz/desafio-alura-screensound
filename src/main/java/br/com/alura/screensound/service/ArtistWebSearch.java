package br.com.alura.screensound.service;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ArtistWebSearch {
    public static String searchArtistInformation(String artistName) {
        OpenAiService service = new OpenAiService(System.getenv("OPEN_AI_KEY"));

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Give me a short sumary of who is the following artist: " + artistName)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(request);
        return response.getChoices().get(0).getText();
    }
}
