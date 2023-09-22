import com.azure.ai.textanalytics.*;
import com.azure.ai.textanalytics.models.*;
import com.azure.core.credential.AzureKeyCredential;

public class SentimentAnalysisApp {

    public static void main(String[] args) {
        String endpoint = "YOUR_TEXT_ANALYTICS_ENDPOINT";
        String apiKey = "YOUR_TEXT_ANALYTICS_API_KEY";

        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
                .endpoint(endpoint)
                .credential(new AzureKeyCredential(apiKey))
                .buildClient();

        String text = "Eu estou muito feliz hoje!";

        analyzeSentiment(client, text);
    }

    private static void analyzeSentiment(TextAnalyticsClient client, String text) {
        System.out.println("Analisando o sentimento do texto: " + text);

        AnalyzeSentimentResult result = client.analyzeSentiment(text, "pt");

        System.out.println("Sentimento: " + result.getSentiment());
        System.out.println("Pontuação de sentimento: " + result.getConfidenceScores().get(result.getSentiment()));
    }
}
