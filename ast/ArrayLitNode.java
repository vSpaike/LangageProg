package ast;

import java.util.List;

public class ArrayLitNode extends Node {
    public List<Node> elements;

    public ArrayLitNode(List<Node> elements) {
        this.elements = elements;
    }

    @Override
    public void execute(Environment env) {
    }

    @Override
    public Object evaluate(Environment env) {
        Object[] array = new Object[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            array[i] = elements.get(i).evaluate(env);
        }
        return array;
    }
}
