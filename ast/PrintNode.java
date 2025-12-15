package ast;

public class PrintNode extends InstrNode {
    public Node expression;

    public PrintNode(Node expression) {
        this.expression = expression;
    }

    @Override
    public void execute(Environment env) {
        Object val = expression.evaluate(env);
        System.out.println(val);
    }

    @Override
    public Object evaluate(Environment env) {
        return null;  
    }
}
