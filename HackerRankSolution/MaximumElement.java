package HackerRankSolution;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */
    static class Pair{
        int val, index;
        public Pair(int val,int index){
            this.val = val;
            this.index = index;
        }
    }
    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        Stack<Pair> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(String str : operations){
            int type = str.charAt(0)-'0';
            int val = 0;
            if(type == 1) val = Integer.parseInt(str.substring(2));
            if(type == 1){
                count++;
                if(stack.isEmpty() || stack.peek().val < val){
                    stack.push(new Pair(val,count));
                }
            }
            else if(type == 2){
                if(!stack.isEmpty() && stack.peek().index == count){
                    stack.pop();
                }
                count--;
            }
            else{
                list.add(stack.peek().val);
            }
        }
        return list;
    }
    public static int max(Stack<Integer> stack){
        if(stack.isEmpty()){
            return 0;
        }
        int val = stack.pop();
        int maxNum = Math.max(val,max(stack));
        stack.push(val);
        return maxNum;
    }

}

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
/* 
STDIN   Function
-----   --------
10      operations[] size n = 10
1 97    operations = ['1 97', '2', '1 20', ....]
2
1 20
2
1 26
1 20
2
3
1 91
3
*/