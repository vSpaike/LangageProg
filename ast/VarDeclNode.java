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
    public void execute() {
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
