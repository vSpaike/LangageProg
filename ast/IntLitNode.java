package ast;

public class IntLitNode extends Node {
    public int value;

    public IntLitNode(int value) {
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
