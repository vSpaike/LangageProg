package ast;
import java.util.*;

public class ProgramNode extends Node {
    public String name;
    public List<VarDeclNode> globalVars;
    public List<FunctionNode> functions; 
    public MainNode main;

    private Map<String, FunctionNode> functionTable = new HashMap<>();

    public ProgramNode(String name, List<VarDeclNode> globalVars,
                       List<FunctionNode> functions, MainNode main) {
        this.name = name;
        this.globalVars = globalVars;
        this.functions = functions;
        this.main = main;
    }

    @Override
    public void execute(Environment env) {
        Environment globalEnv = new Environment(null);

        if (globalVars != null) {
            for (VarDeclNode v : globalVars) {
                v.execute(globalEnv);
            }
        }

        if (functions != null) {
            for (FunctionNode f : functions) {
                functionTable.put(f.name, f);
            }
        }

        globalEnv.setFunctionTable(functionTable);

        main.execute(globalEnv);
    }

    @Override
    public Object evaluate(Environment env) { return null; }
}
