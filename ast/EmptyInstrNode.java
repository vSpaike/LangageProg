package ast;

public class EmptyInstrNode extends InstrNode {
    @Override
    public void execute() {
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
