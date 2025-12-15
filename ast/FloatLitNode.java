package ast;

public class FloatLitNode extends Node {
    public float value;

    public FloatLitNode(float value) {
        this.value = value;
    }

    @Override
    public void execute(Environment env) {
    }
    
    @Override
    public Object evaluate(Environment env) {
        return value;
    }
}
