package ast;
import java.util.*;

public class ProcCallNode extends InstrNode {
    public String name;
    public List<Node> args;

    public ProcCallNode(String name, List<Node> args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public void execute() {
        System.out.println("Appel procédure: " + name);
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
