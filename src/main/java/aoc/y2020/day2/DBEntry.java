package aoc.y2020.day2;

public class DBEntry {
    private Policy policy;
    private String password;

    public DBEntry(Policy policy, String password) {
        this.policy = policy;
        this.password = password;
    }

    public Policy getPolicy() {
        return policy;
    }

    public String getPassword() {
        return password;
    }
}
