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
        Object rightValue = expression.evaluate(env);
        
        Object currentValue = env.get(lvalue.name);
        
        Object newValue = null;
        
        if (operator.equals("=")) {
            newValue = rightValue;
        } else if (operator.equals("+=")) {
            if (currentValue instanceof Integer && rightValue instanceof Integer) {
                newValue = (Integer) currentValue + (Integer) rightValue;
            } else {
                newValue = (Float) currentValue + (Float) rightValue;
            }
        } else if (operator.equals("-=")) {
            if (currentValue instanceof Integer && rightValue instanceof Integer) {
                newValue = (Integer) currentValue - (Integer) rightValue;
            } else {
                newValue = (Float) currentValue - (Float) rightValue;
            }
        } else if (operator.equals("*=")) {
            if (currentValue instanceof Integer && rightValue instanceof Integer) {
                newValue = (Integer) currentValue * (Integer) rightValue;
            } else {
                newValue = (Float) currentValue * (Float) rightValue;
            }
        } else if (operator.equals("/=")) {
            if (currentValue instanceof Integer && rightValue instanceof Integer) {
                newValue = (Integer) currentValue / (Integer) rightValue;
            } else {
                newValue = (Float) currentValue / (Float) rightValue;
            }
        }
        
        env.assign(lvalue.name, newValue);
    }

    @Override
    public Object evaluate(Environment env) {
        return null;
    }
}
