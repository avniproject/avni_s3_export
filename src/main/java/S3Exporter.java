public class S3Exporter {

    private ConceptReader conceptReader;
    private ConceptProcessor conceptProcessor;

    public S3Exporter(ConceptReader conceptReader, ConceptProcessor conceptProcessor) {
        this.conceptReader = conceptReader;
        this.conceptProcessor = conceptProcessor;
    }

    public void export() {
        conceptReader.read().stream().forEach(uuid -> conceptProcessor.process(uuid));
    }
}
