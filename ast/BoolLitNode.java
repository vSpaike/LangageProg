package ast;

public class BoolLitNode extends Node {
    public boolean value;

    public BoolLitNode(boolean value) {
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
