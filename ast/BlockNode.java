package ast;
import java.util.*;

public class BlockNode extends InstrNode {
    public List<VarDeclNode> vars;
    public List<InstrNode> instrs;

    public BlockNode(List<VarDeclNode> vars, List<InstrNode> instrs) {
        this.vars = vars;
        this.instrs = instrs;
    }

    @Override
    public void execute(Environment env) {
        for (InstrNode instr : instrs) {
            instr.execute(env);
        }
    }
        
    @Override
    public Object evaluate(Environment env) {
        return null;  
    }
}
