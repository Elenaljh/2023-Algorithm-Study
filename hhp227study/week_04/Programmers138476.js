/**
귤 고르기
https://school.programmers.co.kr/learn/courses/30/lessons/138476
*/

function solution(k, tangerine) {
    return Object.values(tangerine.reduce((acc, curr) => (acc[curr] = (acc[curr] || 0) + 1, acc), {}))
        .sort((a, b) => b - a)
        .reduce((acc, value) => acc[1] >= k ? acc : [acc[0] + 1, acc[1] + value], [0, 0])
        [0];
}
