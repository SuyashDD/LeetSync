class Solution {
    public String reverseWords(String s) {
        if(s == null) return null;

        char a[] = s.toCharArray();
        int n = s.length();

        reverse(a , 0 , n - 1);
        reverseWords(a , n);
        return cleanSpaces(a , n); 
    }

    public String cleanSpaces(char[] a , int n){
        int i = 0 ; int j = 0;
        while(j < n){
            while(j < n && a[j] == ' ') j++;
            while(j < n && a[j] != ' ') a[i++] = a[j++];
            while(j < n && a[j] == ' ') j++;
            if(j < n) a[i++] = ' ';
        }
        return new String(a).substring(0 , i);
    }



    public void reverseWords(char a[] , int n){
        int i = 0 ;
        int j = 0;

        while(i < n){
            while(i < j || i < n && a[i] == ' ') i++;
            while(j < i || j < n && a[j] != ' ') j++;
            reverse(a , i , j - 1);
        }
    }

    public void reverse(char a[] , int i , int j){
        while(i < j){
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

}