package ast;

public class ReturnNode extends InstrNode {
    public Node value;

    public ReturnNode(Node value) {
        this.value = value;
    }

    @Override
    public void execute(Environment env) {
        System.out.println("Return statement");
    }
        
    @Override
    public Object evaluate(Environment env) {
        return null;  
    }
}
