package ast;
import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Object> variables = new HashMap<>();
    private Map<String, FunctionNode> functions = new HashMap<>();

    private Environment parent;

    public Environment(Environment parent) {
        this.parent = parent;
    }

    public void define(String name, Object value) {
        variables.put(name, value);
    }

    public Object get(String name) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        } else if (parent != null) {
            return parent.get(name);
        }
        throw new RuntimeException("Variable non définie : " + name);
    }

    public void assign(String name, Object value) {
        if (variables.containsKey(name)) {
            variables.put(name, value);
        } else if (parent != null) {
            parent.assign(name, value);
        } else {
            throw new RuntimeException("Impossible d'assigner une variable non déclarée : " + name);
        }
    }
    
    // Fonctions
    public void setFunctionTable(Map<String, FunctionNode> table) {
        this.functions = table;
    }

    public FunctionNode getFunction(String name) {
        if (functions.containsKey(name)) return functions.get(name);
        if (parent != null) return parent.getFunction(name);
        throw new RuntimeException("Fonction inconnue : " + name);
    }

}
