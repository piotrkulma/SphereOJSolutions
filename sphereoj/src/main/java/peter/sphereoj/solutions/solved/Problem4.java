package peter.sphereoj.solutions.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Piotr Kulma on 07.03.15.
 *
 * Status: done
 */
public class Problem4 {
    private final String brackets = "()";
    private final String operators = "+-*/^";
    private final String operands = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        new Problem4().runSolution();
    }

    private void runSolution() throws IOException {
        String line;
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int dataCount = Integer.parseInt(reader.readLine());

        while((line = reader.readLine()) != null) {
            System.out.println(transform(line));
        }
    }

    private int priority(char c) {
        switch(c) {
            case '+':
                return 0;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '^':
                return 4;
            default:
                return 0;
        }
    }

    private String transform(String expression) {
        String onp= "";
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(operands.contains(c+"")) {
                onp = onp + c;
            }else if(brackets.contains(c+"")) {
                if(c == '(') {
                    stack.push(c);
                } else if(c == ')') {
                    if (!stack.isEmpty()) {
                        while (!stack.isEmpty()) {
                            char sp = stack.pop();
                            if (sp != '(') {
                                onp = onp + sp;
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else if(operators.contains(c+"")) {
                if(!stack.isEmpty()) {
                    char cs = stack.peek();
                    if(priority(cs) > priority(c)) {
                        stack.pop();
                        onp = onp + cs;
                    }
                    stack.push(c);

                } else {
                    stack.push(c);
                }
            }
        }

        if(!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                onp = onp + stack.pop();
            }
        }

        return onp;
    }
}
