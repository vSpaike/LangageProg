package ast;

public class IfNode extends InstrNode {
    public Node condition;
    public BlockNode ifBlock;
    public BlockNode elseBlock;

    public IfNode(Node condition, BlockNode ifBlock, BlockNode elseBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public void execute(Environment env) {
        System.out.println("If condition...");
        ifBlock.execute(env);
        if (elseBlock != null) {
            elseBlock.execute(env);
        }
    }    
    
    @Override
    public Object evaluate(Environment env) {
        return null;  
    }
}
