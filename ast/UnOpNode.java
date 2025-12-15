package ast;

public class UnOpNode extends Node {
    public String operator;
    public Node operand;

    public UnOpNode(String operator, Node operand) {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public void execute(Environment env) {
    }
    
    @Override
    public Object evaluate(Environment env) {
        return null;  
    }

}
