package ast;
import java.util.*;

public class ProcNode extends FunctionNode {
    public ProcNode(String name, List<ParamNode> params, List<VarDeclNode> vars, List<InstrNode> instrs) {
        super("void", name, params, vars, instrs);
    }

    @Override
    public void execute() {
        System.out.println("Procédure: " + name);
    }
}
