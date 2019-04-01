import java.util.List;
import java.util.ArrayList;

public class StringRecipe {

    private List<StringTransformer> transformers = new ArrayList<StringTransformer>();

    public List<StringTransformer> getTransformers() {
        return transformers;
    }

    public void setTransformers(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void mix() {
        for (StringTransformer transform : transformers)
            transform.execute();
    }
}
