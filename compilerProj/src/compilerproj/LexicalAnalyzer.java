package compilerproj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    // Define regular expressions for tokens
    private static final String IDENTIFIER_REGEX = "[a-zA-Z]+[a-zA-Z0-9]*";
    private static final HashMap<String, String> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("abstract", "keyword");
        keywords.put("assert", "keyword");
        keywords.put("boolean", "keyword");
        keywords.put("break", "keyword");
        keywords.put("byte", "keyword");
        keywords.put("case", "keyword");
        keywords.put("catch", "keyword");
        keywords.put("char", "keyword");
        keywords.put("class", "keyword");
        keywords.put("const", "keyword");
        keywords.put("continue", "keyword");
        keywords.put("default", "keyword");
        keywords.put("double", "keyword");
        keywords.put("do", "keyword");
        keywords.put("else", "keyword");
        keywords.put("enum", "keyword");
        keywords.put("extends", "keyword");
        keywords.put("final", "keyword");
        keywords.put("finally", "keyword");
        keywords.put("float", "keyword");
        keywords.put("for", "keyword");
        keywords.put("goto", "keyword");
        keywords.put("if", "keyword");
        keywords.put("implements", "keyword");
        keywords.put("import", "keyword");
        keywords.put("instanceof", "keyword");
        keywords.put("int", "keyword");
        keywords.put("interface", "keyword");
        keywords.put("long", "keyword");
        keywords.put("native", "keyword");
        keywords.put("new", "keyword");
        keywords.put("package", "keyword");
        keywords.put("private", "keyword");
        keywords.put("protected", "keyword");
        keywords.put("public", "keyword");
        keywords.put("return", "keyword");
        keywords.put("short", "keyword");
        keywords.put("static", "keyword");
        keywords.put("strictfp", "keyword");
        keywords.put("super", "keyword");
        keywords.put("switch", "keyword");
        keywords.put("synchronized", "keyword");
        keywords.put("this", "keyword");
        keywords.put("throw", "keyword");
        keywords.put("throws", "keyword");
        keywords.put("transient", "keyword");
        keywords.put("try", "keyword");
        keywords.put("void", "keyword");
        keywords.put("volatile", "keyword");
        keywords.put("while", "keyword");
    }

    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String SYMBOL_REGEX = "[\\!&;(){}]";
    private static final String OPERATOR_REGEX = "[=+*-></]";


            //to split if(
     public static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                }
            } else if (currentChar == '(' || currentChar == ')'|| currentChar == '+'|| currentChar == '*'|| currentChar == '/'|| currentChar == '-'|| currentChar == '>'|| currentChar == '<') {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                }
                tokens.add(String.valueOf(currentChar));
            } else {
                currentToken.append(currentChar);
            }
        }

        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        return tokens;
    }
     
    public static void analyze(String input) {
        Pattern identifierPattern = Pattern.compile(IDENTIFIER_REGEX);
        Pattern numberPattern = Pattern.compile(NUMBER_REGEX);
        Pattern symbolPattern = Pattern.compile(SYMBOL_REGEX);
        Pattern operatorPattern = Pattern.compile(OPERATOR_REGEX);

        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            Matcher identifierMatcher = identifierPattern.matcher(token);
            Matcher numberMatcher = numberPattern.matcher(token);
            Matcher symbolMatcher = symbolPattern.matcher(token);
            Matcher operatorMatcher = operatorPattern.matcher(token);

            String lowerCaseStr = token.toLowerCase();

              if (keywords.containsKey(lowerCaseStr)){
                 System.out.println( "keyword : " +token );
            } 
              else if (identifierMatcher.matches()) {
                System.out.println("Identifier: " + token);
            } else if (numberMatcher.matches()) {
                System.out.println("Number: " + token);
                
            }
           
            else if (symbolMatcher.matches()) {
                System.out.println("special character: " + token);
            } else if (operatorMatcher.matches()) {
                System.out.println("Operator : " + token);
            }
            else {
                System.out.println("Invalid token: " + token);
            }
        }
    }


     
    public static void main(String[] args) {
          Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
         List<String> tokenizedInput = tokenize(input);

        for (String tokens : tokenizedInput) {
           analyze(tokens);
        }
        
    }
}