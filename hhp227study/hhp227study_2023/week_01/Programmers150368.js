/**
이모티콘 할인행사
https://school.programmers.co.kr/learn/courses/30/lessons/150368
*/

function solution(users, emoticons) {
    var answer = [];
    var stack = [];
    
    dfs(emoticons, [10, 20, 30, 40], users, stack, answer);
    answer.sort((a, b) => a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
    return answer[0];
}

function dfs(emoticons, rates, users, stack, array) {
    for (rate of rates) {
        stack.push(rate);
        if (stack.length == emoticons.length) {
            array.push(getResult(emoticons, users, stack));
        } else {
            dfs(emoticons, rates, users, stack, array);
        }
        stack.pop();
    }
}

function getResult(emoticons, users, stack) {
    var totalCost = 0;
    var totalSubscribers = 0;
    
    for (user of users) {
        let [limit, cost] = user;
        var sum = 0;
        var subscribe = 0;
        
        for (i in stack) {
            if (stack[i] >= limit) {
                sum += (emoticons[i] - emoticons[i] * stack[i] / 100);
            }
        }
        if (sum >= cost) {
            sum = 0;
            subscribe++;
        }
        totalCost += sum;
        totalSubscribers += subscribe;
    }
    return [totalSubscribers, totalCost];
}
