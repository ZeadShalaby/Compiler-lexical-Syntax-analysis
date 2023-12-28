package syntax;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;



public class SyntaxChecker {
 
   
  
   
    public static void main(String[] args) {
        
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, "D:/my projects/last year project/compiler/project compiler/compilerProj/test/test.java");
        if (compilationResult == 0) {
            System.out.println("The syntax of the Java source file is correct.");
        } else {
            System.out.println("The syntax of the Java source file is noooooot correct.");
        }
    }
}