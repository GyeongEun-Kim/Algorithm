import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explode = br.readLine();
        Stack<Character> stack = new Stack<>();
        char lastChar = explode.charAt(explode.length()-1);
        StringBuilder sb = new StringBuilder();

       for (int i=0;i<str.length();i++) {
           stack.push(str.charAt(i));
           if (stack.peek() == lastChar) {
               int index = explode.length()-1;
               Stack<Character> temp = new Stack<>();
               while (index>=0) {
                   //pop
                   if(stack.size()>0 && stack.peek() == explode.charAt(index)) {
                       temp.push(stack.pop());
                       index--;
                   }
                   else {
                       int size = temp.size();
                       for (int j=0;j<size;j++) {
                           stack.push(temp.pop());
                       }
                       break;
                   }
               }
           }
       }

       int stackSize = stack.size();
       if (stackSize==0) System.out.println("FRULA");
       else {
           for (int i = 0; i < stackSize; i++) {
               sb.append(stack.pop());
           }

           System.out.println(sb.reverse());
       }
    }
}
