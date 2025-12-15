package ast;
import java.util.*;

public class FunctionNode extends Node {
    public String returnType;
    public String name;
    public List<ParamNode> params;
    public List<VarDeclNode> vars;
    public List<InstrNode> instrs;

    public FunctionNode(String returnType, String name, List<ParamNode> params, List<VarDeclNode> vars, List<InstrNode> instrs) {
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.vars = vars;
        this.instrs = instrs;
    }

    @Override
    public void execute() {
        System.out.println("Fonction: " + name + " de type " + returnType);
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
