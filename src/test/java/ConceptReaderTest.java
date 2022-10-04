import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ConceptReaderTest {

    @Test
    public void shouldRetrieveConceptUuidsFromFile() {
        URL url = this.getClass().getResource("concepts.txt");
        ConceptReader conceptReader = new ConceptReader(url);
        List concepts = conceptReader.read();
        assertThat(concepts.get(0), is(equalTo("uuid-1")));
        assertThat(concepts.get(1), is(equalTo("uuid-2")));
    }
}
