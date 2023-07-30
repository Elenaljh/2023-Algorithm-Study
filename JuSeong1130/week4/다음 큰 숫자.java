import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCount = Integer.bitCount(n);
        for(int i = n+1; i <= 1000000; i++) {
            int iCount = Integer.bitCount(i);
            if(nCount == iCount) {
                return i;
            }
        }
        return answer;
        
        
        
    
        /*StringBuilder str = new StringBuilder(nBinary);
        for(int i = nBinary.length()-1; i >= 0 ; i--) {
            if(nBinary.charAt(i) == '0') {
                str.setCharAt(i,'1');
                break;
            }
        }
        return Integer.parseInt(str.toString(),2);*/
        
        
        /*System.out.println(nOneCount);
        for(int i = n+1; i <= 1000000; i++) {
            int iOneCount = Integer.toBinaryString(i).replace("0","").length();
           if(nOneCount == iOneCount) {
               return i;
           }
        }*/
    
    }
}
