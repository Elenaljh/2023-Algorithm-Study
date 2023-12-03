/**
[PCCP 기출문제] 1번 / 붕대 감기
https://school.programmers.co.kr/learn/courses/30/lessons/250137
*/

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int pos = 0;
        int combo = 0;

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (i == attacks[pos][0]) { 
                combo = 0;
                answer -= attacks[pos][1];
                pos++;
            } else {
                answer = Math.min(health, answer + bandage[1]);
                combo++;
                if (combo == bandage[0]) {
                    answer = Math.min(health, answer + bandage[2]);
                    combo = 0;
                }
            }
            if (answer < 1) return -1;
        }
        return answer;
    }
}
