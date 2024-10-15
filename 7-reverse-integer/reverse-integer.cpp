class Solution {
public:
    int reverse(int x) {
        int res = 0 ;
        while(x)
        {
            if(res > INT_MAX / 10 || res < INT_MIN / 10)
                return 0;
            else{
                    int rem = x % 10;
                    res = (res * 10) + rem;
                    x = x / 10;
            }

        }
        return res;
    }
};

// class Solution {
// public:
//     int reverse(int x) {
//         int y=0;
//         while(x){
//             if(y>INT_MAX/10 || y<INT_MIN/10){
//                 return 0;
//             }else{
//                 y=y*10 +x%10;
//                 x=x/10;
//             }
//         }
//         return y;
//     }
// };