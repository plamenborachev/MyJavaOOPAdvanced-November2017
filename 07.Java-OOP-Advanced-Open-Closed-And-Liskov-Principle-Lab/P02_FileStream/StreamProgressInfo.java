package P02_FileStream;


public class StreamProgressInfo {
    private Stream stream;

    // If we want to stream a music file, we can't
    public StreamProgressInfo(Stream stream) {
        this.stream = stream;
    }

    public int calculateCurrentPercent() {
        return (this.stream.getBytesSent() * 100) / this.stream.getLength();
    }
}
