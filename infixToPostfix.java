public class infixtoPostfix {

   public static int Prec(char ch){
       switch(ch){
           case '*':
           case '/':
               return 2;
           case '-':
           case '+':
               return 1;
           case '^':
               return 3;
       }
       return -1;
   }

   public static String infixToPostfix(String str){
       String result=new String("");
       Deque<Character> stack=new ArrayDeque<>();
       for(int i=0;i<str.length();i++){
           char c=str.charAt(i);
           if(c=='('){
               stack.push(c);
           }
           else if(Character.isLetterOrDigit(c)){
               result+=c;
           }
           else if(c==')'){
               while (!stack.isEmpty() && stack.peek() != '(') {
                   result+=stack.peek();
                   stack.pop();
               }
               stack.pop();
           }
           else{
               while(!stack.isEmpty()&&Prec(stack.peek())>=Prec(c)){
                   result+=stack.peek();
                   stack.pop();
               }
               stack.push(c);
           }
       }
       while(!stack.isEmpty()){
           if(stack.peek()=='('){
               return "Invalid Expression";
           }
           else{
               result+=stack.peek();
               stack.pop();
           }
       }
       return result;
   }

    public static void main(String[] args) {
        String str="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(str));
    }

}
