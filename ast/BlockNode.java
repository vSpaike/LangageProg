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
    public void execute() {
        for (InstrNode instr : instrs) {
            instr.execute();
        }
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
