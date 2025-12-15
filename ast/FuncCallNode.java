package ast;
import java.util.*;

public class FuncCallNode extends Node {
    public String name;
    public List<Node> args;

    public FuncCallNode(String name, List<Node> args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public void execute() {
        System.out.println("Appel fonction: " + name);
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
