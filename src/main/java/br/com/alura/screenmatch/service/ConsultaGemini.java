package br.com.alura.screenmatch.service;


import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {
    public static String obterTraducao(String texto) {
        Client client = Client.builder().apiKey(System.getenv("GEMINI_APIKEY")).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3-flash-preview",
                        "Traduza para língua portuguesa o seguinte trecho da forma mais direta, não pergunte mais nada, apenas faça: "+texto,
                        null);

        return response.text();
    }
}