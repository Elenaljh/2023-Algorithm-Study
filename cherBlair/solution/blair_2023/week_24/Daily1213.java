package blair_2023.week_24;

public class Daily1213 {

    // 옹알이
    // https://school.programmers.co.kr/learn/courses/30/lessons/120956

    public int solution(String[] babbling) {
        int answer = 0;
        String[] check = {"aya", "ye", "woo", "ma"};

        for (String b : babbling) {
            for (String c : check) {
                b = b.replace(c, " ");
            }
            if (b.replaceAll(" ", "").equals("")) {
                answer++;
            }
        }
        return answer;
    }
    
    // 다른 풀이 참고
    // class Solution {
    //    public int solution(String[] babbling) {
    //        int answer = 0;
    //
    //        for(int i =0; i < babbling.length; i++) {
    //            babbling[i] = babbling[i].replace("aya", "1");
    //            babbling[i] = babbling[i].replace("woo", "1");
    //            babbling[i] = babbling[i].replace("ye", "1");
    //            babbling[i] = babbling[i].replace("ma", "1");
    //            babbling[i] = babbling[i].replace("1", "");
    //            if(babbling[i].isEmpty()) {
    //                answer = answer + 1;
    //            }
    //        }
    //
    //        return answer;
    //    }
    //}
}
