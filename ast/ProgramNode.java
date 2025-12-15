package ast;
import java.util.*;

public class ProgramNode extends Node {
    public String name;
    public List<VarDeclNode> globalVars;
    public List<FunctionNode> functions;
    public MainNode main;

    public ProgramNode(String name, List<VarDeclNode> globalVars, List<FunctionNode> functions, MainNode main) {
        this.name = name;
        this.globalVars = globalVars;
        this.functions = functions;
        this.main = main;
    }

    @Override
    public void execute() {
        System.out.println("Exécution du programme: " + name);
        main.execute();
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
