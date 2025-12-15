package ast;

public class ForNode extends InstrNode {
    public VarDeclNode initVar;
    public Node condition;
    public Node increment;
    public BlockNode body;

    public ForNode(VarDeclNode initVar, Node condition, Node increment, BlockNode body) {
        this.initVar = initVar;
        this.condition = condition;
        this.increment = increment;
        this.body = body;
    }

    @Override
    public void execute(Environment env) {
        initVar.execute(env);
        
        while (true) {
            Object condValue = condition.evaluate(env);
            
            boolean isTrue = false;
            if (condValue instanceof Boolean) {
                isTrue = (Boolean) condValue;
            } else if (condValue instanceof Integer) {
                isTrue = (Integer) condValue != 0;
            } else if (condValue instanceof Float) {
                isTrue = (Float) condValue != 0.0f;
            }
            
            if (!isTrue) break;
            
            body.execute(env);
            
            increment.evaluate(env);
        }
    }

    @Override
    public Object evaluate(Environment env) {
        return null;
    }
}
