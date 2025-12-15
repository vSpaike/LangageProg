package ast;

public class VarDeclNode extends Node {
    public String type;
    public String name;
    public Node initialValue;

    public VarDeclNode(String type, String name, Node initialValue) {
        this.type = type;
        this.name = name;
        this.initialValue = initialValue;
    }

    @Override
    public void execute(Environment env) {
        Object val = 0; 
        if (initialValue != null) {
            val = initialValue.evaluate(env);
        }
        env.define(name, val);
    }
        
    @Override
    public Object evaluate(Environment env) {
        return null;  
    }
}
