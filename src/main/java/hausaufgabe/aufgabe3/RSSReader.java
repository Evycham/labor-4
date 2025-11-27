package hausaufgabe.aufgabe3;

/*
 * Author : Yurii Gruzevych
 * Mat. Num. 20367
 * */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class RSSReader {

	public static void main(String[] args) {

        try {
			URI uri = new URI("https://rss.dw.com/xml/rss-de-all");

			URL url = uri.toURL();

            URLConnection connection = url.openConnection();

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)
            )) {
                String line;

                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (Exception e) {
                System.out.println("Fehler beim Lesen des RSS-Feeds: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Lesen des RSS-Feeds: " + e.getMessage());
        }
    }
}
