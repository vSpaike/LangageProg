package ast;

import java.util.*;

public class MainNode extends Node {
    public List<VarDeclNode> vars;
    public List<InstrNode> instrs;

    public MainNode(List<VarDeclNode> vars, List<InstrNode> instrs) {
        this.vars = vars;
        this.instrs = instrs;
    }

    @Override
    public void execute(Environment env) {
        for (VarDeclNode v : vars) {
            v.execute(env);
        }
        for (InstrNode i : instrs) {
            i.execute(env);
        }
    }

    @Override
    public Object evaluate(Environment env) {
        return null;
    }
}
