package blair_2023.week_21;

public class PR1126 {

    // 💛 치킨 쿠폰
    // https://school.programmers.co.kr/learn/courses/30/lessons/120884

    class Solution {
        public int solution(int chicken) {
            int answer = 0;

            while (chicken >= 10) {
                int newChicken = chicken / 10;
                int restChicken = chicken % 10;
                chicken = newChicken + restChicken;

                answer += newChicken;
            }
            return answer;
        }
    }

    // 다른 풀이
    // class Solution {
    //    public int solution(int chicken) {
    //        int answer = chicken/9;
    //        if(chicken>1&&chicken%9==0){
    //            answer--;
    //        }
    //
    //
    //        return answer;
    //    }
    //}
    //
    // 풀이 comment
    // 닭 10마리 중 한마리는 공짜입니다. => 9마리를 주문하면 한마리를 공짜로 얻을 수 있습니다.
    // => 9 나누기 9=1 , 다만 첫 주문시에는 10마리 값을 모두 지불해야 공짜 닭을 받을 수 있기 때문에,
    // 9로 딱 나누어 떨어질 경우 마지막 한마리 값을 더 지불해야 합니다.
    // 또 한마리도 시켜먹지 않았을 경우에도 받을 수 없는 공짜 닭이 없어 if조건에서 true를 반환받기 때문에 조건에서 제외해주어야 합니다.
}
