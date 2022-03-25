package me.angles.kinggen.requests;

import me.angles.kinggen.KingGen;
import me.angles.kinggen.exceptions.InvalidApiKeyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.String.format;
import static me.angles.kinggen.KingGen.gson;

public class RequestUtil {

    public static <T> T fetch(Endpoint endpoint, String apiKey, Class<T> type) {
        try {
            final URL url = new URL(format(KingGen.BASE_ROUTE, endpoint.getName(), apiKey));
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            checkResponseCode(connection);
            final String response = readStream(connection.getInputStream());
            connection.disconnect();
            return gson.fromJson(response, type);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static String readStream(InputStream stream) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        final StringBuilder builder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null)
            builder.append(line);

        stream.close();
        reader.close();
        return builder.toString();
    }

    private static void checkResponseCode(HttpURLConnection connection) throws IOException {
        final int code = connection.getResponseCode();
        if(code == 401) throw new InvalidApiKeyException(); //401 - unauthorized, returned with an invalid api key
    }
}
