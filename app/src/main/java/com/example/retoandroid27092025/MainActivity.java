package com.example.retoandroid27092025;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button newQuoteButton;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        newQuoteButton = findViewById(R.id.newQuoteButton);

        newQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchNewQuote();
            }
        });

        // Fetch a quote when the app starts
        fetchNewQuote();
    }

    private void fetchNewQuote() {
        // Show a loading message or disable button
        quoteTextView.setText("Cargando nueva frase...");
        newQuoteButton.setEnabled(false);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String result = null;
                HttpURLConnection urlConnection = null;
                try {
                    URL url = new URL("https://zenquotes.io/api/random");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    if (inputStream == null) {
                        result = "Error: No se pudo obtener respuesta del servidor.";
                    } else {
                        result = readStream(inputStream);
                    }
                } catch (IOException e) {
                    result = "Error de conexión: " + e.getMessage();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

                final String finalResult = result;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parseAndDisplayQuote(finalResult);
                        newQuoteButton.setEnabled(true);
                    }
                });
            }
        });
    }

    private String readStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append('\n');
        }
        in.close();
        return sb.toString();
    }

    private void parseAndDisplayQuote(String jsonResponse) {
        if (jsonResponse == null || jsonResponse.startsWith("Error")) {
            quoteTextView.setText(jsonResponse != null ? jsonResponse : "Error desconocido al obtener la frase.");
            return;
        }
        try {
            JSONArray jsonArray = new JSONArray(jsonResponse);
            if (jsonArray.length() > 0) {
                JSONObject quoteObject = jsonArray.getJSONObject(0);
                String quote = quoteObject.getString("q");
                String author = quoteObject.getString("a"); // Author, not used in TextView directly but good to have
                quoteTextView.setText("\"" + quote + "\"\n- " + author);
            } else {
                quoteTextView.setText("No se encontraron frases.");
            }
        } catch (JSONException e) {
            quoteTextView.setText("Error al parsear la frase: " + e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Shutdown executor service
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
