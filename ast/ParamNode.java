package ast;

public class ParamNode extends Node {
    public String type;
    public String name;

    public ParamNode(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void execute() {
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
