import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConceptReader {

    private final URL url;

    public ConceptReader(URL url) {
        this.url = url;
    }

    public List<String> read() {
        List<String> conceptList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(new File(url.toURI()));
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                conceptList.add(line);
            }
            fr.close();

            return conceptList;
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
