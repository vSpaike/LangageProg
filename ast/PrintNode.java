package ast;

public class PrintNode extends InstrNode {
    public Node expression;

    public PrintNode(Node expression) {
        this.expression = expression;
    }

    @Override
    public void execute() {
        Object value = expression.evaluate();
        System.out.println(value);
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
