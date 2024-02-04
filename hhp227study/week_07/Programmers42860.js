/**
조이스틱
https://school.programmers.co.kr/learn/courses/30/lessons/42860
*/

function solution(name) {
    return getJoyStickControlCount((() => {
        const map = {};
    
        for (let i = 1; i < 14; i++) {
            map[String.fromCharCode(65 + i)] = i;
            map[String.fromCharCode(91 - i)] = i;
        }
        return map;
    })(), name, 0, 0);
}

function getJoyStickControlCount(map, name, index, count) {
    if (name.charAt(index) != 'A') {
        count += map[name.charAt(index)];
        name = name.substring(0, index) + 'A' + name.substring(index + 1);
    }
    if (count > -1) {
        let prevIndexOfNotA = findPrevIndexOfNotA(name, index);
        let nextIndexOfNotA = findNextIndexOfNotA(name, index);

        if (isAString(name) || prevIndexOfNotA < 0 || nextIndexOfNotA < 0) return count;
        else {
            let rightSum = getJoyStickControlCount(map, name, nextIndexOfNotA, count + (name.length - index + nextIndexOfNotA) % name.length);
            let leftSum = getJoyStickControlCount(map, name, prevIndexOfNotA, count + (name.length + index - prevIndexOfNotA) % name.length);
            return Math.min(rightSum, leftSum);
        }
    } else return count;
}

function findNextIndexOfNotA(name, index) {
    for (let i = index; i < name.length * 2; i++) {
        let idx = (name.length + i) % name.length;
        
        if (name.charAt(idx) !== 'A') return idx;
    }
    return -1;
}

function findPrevIndexOfNotA(name, index) {
    for (let i = index + name.length; i >= 0; i--) {
        let idx = (name.length + i) % name.length;
        
        if (name.charAt(idx) !== 'A') return idx;
    }
    return -1;
}

function isAString(s) {
    for (const c of s) if (c !== 'A') return false;
    return true;
}
