package ast;

public class EmptyInstrNode extends InstrNode {
    @Override
    public void execute(Environment env) {
    }
        
    @Override
    public Object evaluate(Environment env) {
        return null;  
    }
}
