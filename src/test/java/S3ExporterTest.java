import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class S3ExporterTest {

    @Test
    public void shouldRetrieveAllConceptsFromReader() {
        ConceptReader conceptReader = mock(ConceptReader.class);
        ConceptProcessor conceptProcessor = mock(ConceptProcessor.class);
        when(conceptReader.read()).thenReturn(Arrays.asList("uuid-1", "uuid-2"));
        S3Exporter s3Exporter = new S3Exporter(conceptReader, conceptProcessor);

        s3Exporter.export();

        verify(conceptProcessor).process("uuid-1");
        verify(conceptProcessor).process("uuid-2");


    }
}
