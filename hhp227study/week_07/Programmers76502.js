/**
괄호 회전하기
https://school.programmers.co.kr/learn/courses/30/lessons/76502
*/

var stack = []

function solution(s) {
    var answer = 0;
    var sb = s;
    
    for (let i = 0; i < s.length; i++) {
        sb = sb.slice(1) + sb[0];
        
        if (correctParenthesis(sb)) {
            answer += 1;
        }
    }
    return answer;
}

function correctParenthesis(s) {
    for (c of s) {
        if (!(check(c, "(", ")") && check(c, "[", "]") && check(c, "{", "}"))) {
            return false;
        }
    }
    return stack.length == 0;
}

function check(c, a, b) {
    switch (c) {
        case a:
            stack.push(a);
            break;
        case b:
            if (stack.length > 0 && stack[stack.length - 1] == a) {
                stack.pop();
            } else {
                return false;
            }
            break;
    }
    return true;
}
