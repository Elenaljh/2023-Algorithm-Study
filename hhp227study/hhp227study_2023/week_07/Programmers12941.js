/**
최솟값 만들기
https://school.programmers.co.kr/learn/courses/30/lessons/12941
*/

function solution(a, b){
    var answer = 0;

    a.sort((a, b) => a - b);
    b.sort((a, b) => a - b);
    for (var i = 0; i < a.length; i++) {
        answer += (a[i] * b[a.length - 1 - i]);
    }
    return answer;
}
