package ast;

public abstract class Node {
    public abstract void execute(Environment env);
    public abstract Object evaluate(Environment env);
}
