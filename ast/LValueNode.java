package ast;

public class LValueNode extends Node {
    public String name;
    public Node index;

    public LValueNode(String name, Node index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void execute() {
    }
    
    @Override
    public Object evaluate() {
        return "Valeur de " + name;
    }
}
