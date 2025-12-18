class Solution {
    public int calculate(String s) {

         Stack<Integer> stack = new Stack<>();
        
        int result = 0;   // stores current evaluated result
        int num = 0;      // stores current number being formed
        int sign = 1;     // +1 or -1 depending on last operator
        
        for (char ch : s.toCharArray()) {
            
            // If char is digit → build the number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');   // handles multi-digit numbers
            }
            
            // If '+' operator → finalize previous number & reset
            else if (ch == '+') {
                result += sign * num;  // apply previous sign
                num = 0;               // reset number
                sign = 1;              // update sign
            }
            
            // If '-' operator → finalize previous number & reset
            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;             // update sign to negative
            }
            
            // If '(' → push current computation state to stack
            else if (ch == '(') {
                stack.push(result);    // save current result
                stack.push(sign);      // save current sign
                result = 0;            // reset result for new bracket scope
                sign = 1;              // reset sign
            }
            
            // If ')' → close current bracket scope
            else if (ch == ')') {
                result += sign * num;  // first complete current expression
                num = 0;
                
                result *= stack.pop(); // multiply with sign before '('
                result += stack.pop(); // add result stored before '('
            }
        }
        
        // Add any remaining number after loop ends
        return result + (sign * num);
        
    }
}