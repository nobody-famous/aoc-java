package y2020.day13;

public class Notes {
    private long timestamp;
    private Integer[] ids;

    public Notes(long timestamp, Integer[] ids) {
        this.timestamp = timestamp;
        this.ids = ids;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Integer[] getIds() {
        return ids;
    }
}
