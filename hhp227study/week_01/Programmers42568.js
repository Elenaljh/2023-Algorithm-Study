/**
기능개발
https://school.programmers.co.kr/learn/courses/30/lessons/42586
*/

function solution(progresses, speeds) {
    return progresses.map((i, index) => Math.ceil((100 - i) / speeds[index]))
        .reduce((acc, i) => {
        if (acc[0] < i) {
            acc[0] = i;
            
            acc.push(1);
        } else {
            acc[acc.length - 1]++;
        }
        return acc;
    }, [0])
        .slice(1);
}
