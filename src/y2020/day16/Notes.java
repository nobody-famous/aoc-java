package y2020.day16;

import java.util.List;

public class Notes {
    private List<Field> fields;
    private List<Ticket> nearby;

    public Notes(List<Field> fields, Ticket mine, List<Ticket> nearby) {
        this.fields = fields;
        this.nearby = nearby;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Ticket> getNearby() {
        return nearby;
    }
}
