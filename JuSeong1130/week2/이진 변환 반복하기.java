class Solution {
    public int[] solution(String s) {
        int left = 0;
        int right = 0;
        while(true) {
            if(s.equals("1")) {
                break;
            }
            int prev = s.length();
            s = s.replaceAll("0","");
            right += (prev - s.length());
            s = Integer.toString(s.length(),2);
            left++;
        }
        int[] answer = {left,right};
        return answer;
    }
}
