package ast;

public class BinOpNode extends Node {
    public Node left;
    public String operator;
    public Node right;

    public BinOpNode(Node left, String operator, Node right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public void execute(Environment env) {
    }
    
    @Override
    public Object evaluate(Environment env) {
        Object leftVal = left.evaluate(env);
        Object rightVal = right.evaluate(env);
        
        if (operator.equals("+")) {
            if (leftVal instanceof Integer) {
                return (Integer) leftVal + (Integer) rightVal;
            } else {
                return (Float) leftVal + (Float) rightVal;
            }
        } else if (operator.equals("-")) {
            if (leftVal instanceof Integer) {
                return (Integer) leftVal - (Integer) rightVal;
            } else {
                return (Float) leftVal - (Float) rightVal;
            }
        } else if (operator.equals("*")) {
            if (leftVal instanceof Integer) {
                return (Integer) leftVal * (Integer) rightVal;
            } else {
                return (Float) leftVal * (Float) rightVal;
            }
        } else if (operator.equals("/")) {
            if (leftVal instanceof Integer) {
                return (Integer) leftVal / (Integer) rightVal;
            } else {
                return (Float) leftVal / (Float) rightVal;
            }
        } else if (operator.equals(">")) {
            if (leftVal instanceof Integer) {
                return (Integer) leftVal > (Integer) rightVal;
            } else {
                return (Float) leftVal > (Float) rightVal;
            }
        } else if (operator.equals("<")) {
            if (leftVal instanceof Integer) {
                return (Integer) leftVal < (Integer) rightVal;
            } else {
                return (Float) leftVal < (Float) rightVal;
            }
        } else if (operator.equals(">=")) {
            if (leftVal instanceof Integer) {
                return (Integer) leftVal >= (Integer) rightVal;
            } else {
                return (Float) leftVal >= (Float) rightVal;
            }
        } else if (operator.equals("<=")) {
            if (leftVal instanceof Integer) {
                return (Integer) leftVal <= (Integer) rightVal;
            } else {
                return (Float) leftVal <= (Float) rightVal;
            }
        } else if (operator.equals("==")) {
            return leftVal.equals(rightVal);
        } else if (operator.equals("!=")) {
            return !leftVal.equals(rightVal);
        } else if (operator.equals("||")) {
            return (Boolean) leftVal || (Boolean) rightVal;
        }
        return null;
    }
}
