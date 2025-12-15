package ast;

import java.util.List;

public class ProcCallNode extends InstrNode {
    public String name;
    public List<Node> args;

    public ProcCallNode(String name, List<Node> args) {  
        this.name = name;
        this.args = args;
    }

    @Override
    public void execute(Environment env) {
        FunctionNode f = env.getFunction(name); 

        Environment local = new Environment(env);

        for (int i = 0; i < f.params.size(); i++) {
            ParamNode p = f.params.get(i);
            Object value = args.get(i).evaluate(env);
            local.define(p.name, value);
        }

        for (VarDeclNode v : f.vars) v.execute(local);
        for (InstrNode instr : f.instrs) {
            instr.execute(local);
        }
    }

    @Override
    public Object evaluate(Environment env) { return null; }
}
