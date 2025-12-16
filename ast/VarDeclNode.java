package ast;

public class VarDeclNode extends Node {
    public String type;
    public String name;
    public Node initialValue;

    public VarDeclNode(String type, String name, Node initialValue) {
        this.type = type;
        this.name = name;
        this.initialValue = initialValue;
    }

    @Override
    public void execute(Environment env) {
        Object val;

        // Si c'est un tableau (type contient "[")
        if (type.contains("[")) {
            if (initialValue != null) {
                // Initialisation explicite avec un littéral de tableau
                val = initialValue.evaluate(env);
            } else {
                // Extraction de la taille du tableau depuis le type (ex: "int[10]")
                int size = extractArraySize(type);
                if (size > 0) {
                    // Créer un tableau de la taille spécifiée
                    val = new Object[size];
                    // Initialiser avec des valeurs par défaut
                    Object[] array = (Object[]) val;
                    Object defaultValue = getDefaultValue(type);
                    for (int i = 0; i < size; i++) {
                        array[i] = defaultValue;
                    }
                } else {
                    // Tableau de taille non spécifiée
                    val = new Object[0];
                }
            }
        } else {
            // Variable simple
            val = 0;
            if (initialValue != null) {
                val = initialValue.evaluate(env);
            }
        }

        env.define(name, val);
    }

    private int extractArraySize(String type) {
        // Extraire la taille du tableau depuis le type (ex: "int[10]" -> 10)
        int start = type.indexOf('[');
        int end = type.indexOf(']');
        if (start != -1 && end != -1 && end > start + 1) {
            String sizeStr = type.substring(start + 1, end);
            try {
                return Integer.parseInt(sizeStr);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }

    private Object getDefaultValue(String type) {
        if (type.startsWith("int"))
            return 0;
        if (type.startsWith("float"))
            return 0.0f;
        if (type.startsWith("boolean"))
            return false;
        return null;
    }

    @Override
    public Object evaluate(Environment env) {
        return null;
    }
}
