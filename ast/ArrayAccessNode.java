package ast;

public class ArrayAccessNode extends Node {
    public String arrayName;
    public Node index;

    public ArrayAccessNode(String arrayName, Node index) {
        this.arrayName = arrayName;
        this.index = index;
    }

    @Override
    public void execute(Environment env) {
    }

    @Override
    public Object evaluate(Environment env) {
        Object arrayObj = env.get(arrayName);
        if (!(arrayObj instanceof Object[])) {
            throw new RuntimeException(arrayName + " n'est pas un tableau");
        }
        Object[] array = (Object[]) arrayObj;
        Object indexObj = index.evaluate(env);
        if (!(indexObj instanceof Integer)) {
            throw new RuntimeException("L'indice doit être un entier");
        }
        int idx = (Integer) indexObj;
        if (idx < 0 || idx >= array.length) {
            throw new RuntimeException("Indice hors limites : " + idx);
        }
        return array[idx];
    }
}
