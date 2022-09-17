import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    private List<NestedInteger> pack;
    private Integer val;

    public NestedInteger(Object[] list) {
        pack = new ArrayList<>();
        for (Object each : list) {
            if (each instanceof Integer) {
                pack.add(new NestedInteger((Integer)each));
            }
            else if (each instanceof Object[]) {
                pack.add(new NestedInteger((Object[])each));
            }
        }
    }

    public NestedInteger(Integer i) {
        val = i;
    }

    public boolean isInteger() {
        return pack == null;
    }

    public Integer getInteger() {
        return val;
    }

    public List<NestedInteger> getList() {
        return pack;
    }
}