class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        
        return "";
    }
}

// class Solution {
//     public String largestOddNumber(String num) {
//         long op = 0;
//         for(int i = 0 ; i < num.length(); i++){
//             for(int j = i ; j < num.length(); j++){
//                 String temp = num.substring(i , j + 1);
//                 long res = Long.parseLong(temp);
//                 // System.out.print(res + " ->");
//                 if(res % 2 == 1){
//                     op = Math.max(op , res);
//                 }
//             }
//         }
//         if(op == 0) return "";
//         return Long.toString(op);
        
//     }
// }