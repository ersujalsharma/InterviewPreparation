package Recursion;

import java.util.*;

public class GenerateValidCustomParanthesis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of ()
        int m = scanner.nextInt(); // number of {}
        List<String> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        help(n, n, m, m, "", stack, list);

        // Collections.sort(list); // sort the list to get lexicographically ordered output

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    public static void help(int nOpen, int nClose, int mOpen, int mClose, String str, Stack<Character> stack, List<String> list) {
        if (nClose == 0 && mClose == 0) {
            list.add(str);
            return;
        }

        if (nOpen > 0) {
            stack.push('(');
            help(nOpen - 1, nClose, mOpen, mClose, str + "(", stack, list);
            stack.pop();
        }

        if (mOpen > 0) {
            stack.push('{');
            help(nOpen, nClose, mOpen - 1, mClose, str + "{", stack, list);
            stack.pop();
        }

        if (nClose > nOpen && !stack.isEmpty() && stack.peek() == '(') {
            char top = stack.pop();
            help(nOpen, nClose - 1, mOpen, mClose, str + ")", stack, list);
            stack.push(top);
        }

        if (mClose > mOpen && !stack.isEmpty() && stack.peek() == '{') {
            char top = stack.pop();
            help(nOpen, nClose, mOpen, mClose - 1, str + "}", stack, list);
            stack.push(top);
        }
    }
}
