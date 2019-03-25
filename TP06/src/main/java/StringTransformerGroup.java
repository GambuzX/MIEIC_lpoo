import java.util.ArrayList;
import java.util.List;

public class StringTransformerGroup implements StringTransformer {

    private List<StringTransformer> transformers = new ArrayList<StringTransformer>();

    public StringTransformerGroup(List<StringTransformer> t) {
        transformers = t;
    }

    public void execute() {
        for (StringTransformer st : transformers)
            st.execute();
    }

    public void undo() {
        for (int i = transformers.size() - 1; i >= 0; i--)
            transformers.get(i).undo();
    }
}
