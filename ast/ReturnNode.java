package ast;

public class ReturnNode extends InstrNode {
    public Node value;

    public ReturnNode(Node value) {
        this.value = value;
    }

    @Override
    public void execute() {
        System.out.println("Return statement");
    }
        
    @Override
    public Object evaluate() {
        return null;  
    }
}
