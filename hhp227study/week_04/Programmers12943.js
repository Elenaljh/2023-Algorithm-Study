/**
콜라츠 추측
https://school.programmers.co.kr/learn/courses/30/lessons/12943
*/

function solution(n) {
    var answer = 0
  
    while (n != 1) {
        answer++;
        n = n % 2 == 0 ? n / 2 : 3 * n + 1;
    }
    return answer > 500 ? -1 : answer;
}
