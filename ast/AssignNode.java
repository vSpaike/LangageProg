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
    public void execute() {
        System.out.println("Assignment: " + lvalue.name + " " + operator + " ...");
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
