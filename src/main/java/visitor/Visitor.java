package visitor;

import java.util.Map;

public interface Visitor<T> {
    Map<String, String> onSignature(Task<T> task);
    Map<String, String> onGroupStart(Task<T> task);
    void stamp();
}
