package ast;

public class WhileNode extends InstrNode {
    public Node condition;
    public BlockNode body;

    public WhileNode(Node condition, BlockNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void execute(Environment env) {
        System.out.println("While loop...");
        body.execute(env);
    }
        
    @Override
    public Object evaluate(Environment env) {
        return null;  
    }
}
