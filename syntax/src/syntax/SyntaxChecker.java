package syntax;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class SyntaxChecker {

    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, "D:/testjava/syntax/src/said.java");
        if (compilationResult == 0) {
            System.out.println("The syntax of the Java source file is correct.");
        } else {
            System.out.println("The syntax of the Java source file is noooooot correct.");
        }
    }
}