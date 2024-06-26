// class Solution {
//     public String removeOuterParentheses(String s) {
//         boolean op = false;
//         int open = 0;
//         int close = 0;
//         StringBuilder str = new StringBuilder();
//         StringBuilder tmp = new StringBuilder();


//         for(int i = 0 ; i < s.length() ; i++){
//             char cch = s.charAt(i);

//             if(cch == '('){
//                 if(op == true){
//                     open += 1;
//                     tmp.append("(");
//                 }
//                 else{
//                     op = true;
//                 }
//             }
//             else{
//                 if(op == true && open > 0){
//                     close += 1;
//                     tmp.append(")");
//                     if(open > 0 && close > 0 && open == close){
//                         str.append(tmp);
//                         tmp = new StringBuilder();
//                         open = 0;
//                         close = 0;
//                     }
//                 }
//                 else{
//                     op = false;
//                 }
//             }
//         }
//         return str.toString();
//     }
// }

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                if (openCount > 0) {
                    result.append(c);
                }
                openCount++;
            } else {
                openCount--;
                if (openCount > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}
