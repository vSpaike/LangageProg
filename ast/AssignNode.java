package ast;

public class AssignNode extends InstrNode {
    public LValueNode lvalue;
    public String operator;
    public Node expression;

    public AssignNode(LValueNode lvalue, String operator, Node expression) {
        this.lvalue = lvalue;
        this.operator = operator;
        this.expression = expression;
    }

    @Override
    public void execute(Environment env) {
        Object val = expression.evaluate(env);
        env.assign(lvalue.name, val); 
    }
        
    @Override
    public Object evaluate(Environment env) {
        return null;  
    }
}
