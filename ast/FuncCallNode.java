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
    public void execute(Environment env) {
        evaluate(env); 
    }

    @Override
    public Object evaluate(Environment env) {
        FunctionNode f = env.getFunction(name);


        Environment local = new Environment(env);

        for (int i = 0; i < f.params.size(); i++) {
            ParamNode p = f.params.get(i);
            Object value = args.get(i).evaluate(env);
            local.define(p.name, value);
        }

        for (VarDeclNode v : f.vars) v.execute(local);

        for (InstrNode instr : f.instrs) {
            if (instr instanceof ReturnNode r) {
                return r.value == null ? null : r.value.evaluate(local);
            }
            instr.execute(local);
        }
        return null;
    }
}
