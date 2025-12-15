package ast;

public class IntLitNode extends Node {
    public int value;

    public IntLitNode(int value) {
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
