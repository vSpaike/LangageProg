package ast;

public class AssignNode extends InstrNode {
    public LValueNode lvalue;
    public String operator;
    public Node expression;

    public AssignNode(LValueNode lvalue, String operator, Node expression) {
        this.lvalue = lvalue;
        this.operator = operator;
        this.expression = expression;
    }

    @Override
    public void execute(Environment env) {
        Object rightValue = expression.evaluate(env);

        // Si c'est un accès à un élément de tableau
        if (lvalue.index != null) {
            Object arrayObj = env.get(lvalue.name);
            if (!(arrayObj instanceof Object[])) {
                throw new RuntimeException(lvalue.name + " n'est pas un tableau");
            }
            Object[] array = (Object[]) arrayObj;
            Object indexObj = lvalue.index.evaluate(env);
            if (!(indexObj instanceof Integer)) {
                throw new RuntimeException("L'indice doit être un entier");
            }
            int idx = (Integer) indexObj;
            if (idx < 0 || idx >= array.length) {
                throw new RuntimeException("Indice hors limites : " + idx);
            }

            Object currentValue = array[idx];
            Object newValue = null;

            if (operator.equals("=")) {
                newValue = rightValue;
            } else if (operator.equals("+=")) {
                if (currentValue instanceof Integer && rightValue instanceof Integer) {
                    newValue = (Integer) currentValue + (Integer) rightValue;
                } else {
                    newValue = ((Number) currentValue).floatValue() + ((Number) rightValue).floatValue();
                }
            } else if (operator.equals("-=")) {
                if (currentValue instanceof Integer && rightValue instanceof Integer) {
                    newValue = (Integer) currentValue - (Integer) rightValue;
                } else {
                    newValue = ((Number) currentValue).floatValue() - ((Number) rightValue).floatValue();
                }
            } else if (operator.equals("*=")) {
                if (currentValue instanceof Integer && rightValue instanceof Integer) {
                    newValue = (Integer) currentValue * (Integer) rightValue;
                } else {
                    newValue = ((Number) currentValue).floatValue() * ((Number) rightValue).floatValue();
                }
            } else if (operator.equals("/=")) {
                if (currentValue instanceof Integer && rightValue instanceof Integer) {
                    newValue = (Integer) currentValue / (Integer) rightValue;
                } else {
                    newValue = ((Number) currentValue).floatValue() / ((Number) rightValue).floatValue();
                }
            }

            array[idx] = newValue;
        } else {
            // Affectation à une variable simple
            Object currentValue = env.get(lvalue.name);
            Object newValue = null;

            if (operator.equals("=")) {
                newValue = rightValue;
            } else if (operator.equals("+=")) {
                if (currentValue instanceof Integer && rightValue instanceof Integer) {
                    newValue = (Integer) currentValue + (Integer) rightValue;
                } else {
                    newValue = (Float) currentValue + (Float) rightValue;
                }
            } else if (operator.equals("-=")) {
                if (currentValue instanceof Integer && rightValue instanceof Integer) {
                    newValue = (Integer) currentValue - (Integer) rightValue;
                } else {
                    newValue = (Float) currentValue - (Float) rightValue;
                }
            } else if (operator.equals("*=")) {
                if (currentValue instanceof Integer && rightValue instanceof Integer) {
                    newValue = (Integer) currentValue * (Integer) rightValue;
                } else {
                    newValue = (Float) currentValue * (Float) rightValue;
                }
            } else if (operator.equals("/=")) {
                if (currentValue instanceof Integer && rightValue instanceof Integer) {
                    newValue = (Integer) currentValue / (Integer) rightValue;
                } else {
                    newValue = (Float) currentValue / (Float) rightValue;
                }
            }

            env.assign(lvalue.name, newValue);
        }
    }

    @Override
    public Object evaluate(Environment env) {
        return null;
    }
}
