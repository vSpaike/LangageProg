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
        Object condValue = condition.evaluate(env);

        boolean isTrueCondition = false;
        if (condValue instanceof Boolean) {
            isTrueCondition = (Boolean) condValue;
        } else if (condValue instanceof Integer) {
            isTrueCondition = (Integer) condValue != 0;
        } else if (condValue instanceof Float) {
            isTrueCondition = (Float) condValue != 0.0f;
        }

        if (isTrueCondition) {
            ifBlock.execute(env);
        } else if (elseBlock != null) {
            elseBlock.execute(env);
        }
    }

    @Override
    public Object evaluate(Environment env) {
        return null;
    }
}
