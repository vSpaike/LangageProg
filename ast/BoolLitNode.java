package ast;

public class BoolLitNode extends Node {
    public boolean value;

    public BoolLitNode(boolean value) {
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
