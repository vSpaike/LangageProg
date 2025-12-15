package ast;

public class FloatLitNode extends Node {
    public float value;

    public FloatLitNode(float value) {
        this.value = value;
    }

    @Override
    public void execute() {
    }
    
    @Override
    public Object evaluate() {
        return value;
    }
}
