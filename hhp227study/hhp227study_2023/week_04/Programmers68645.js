/**
삼각 달팽이
https://school.programmers.co.kr/learn/courses/30/lessons/68645
*/

function solution(n) {
    let array = [];
    let result = [];
    let num = 0;
    let line = "left";
    let repeated = 0;

    for (let i = 0; i < n; i++) {
        array.push(new Array(i + 1).fill(0));
    }
    for (let i = 0; i < n; i++) {
        switch (line) {
            case "left":
                line = "bottom";

                for (let j = repeated * 2; j < array.length - repeated; j++) {
                    num++;
                    array[j][repeated] = num;
                }
                break;
            case "bottom":
                line = "right";

                for (let j = repeated + 1; j < array[array.length - 1 - repeated].length - repeated; j++) {
                    num++;
                    array[array.length - 1 - repeated][j] = num;
                }
                break;
            case "right":
                line = "left";
                repeated++;
                for (let k = array.length - 1 - repeated; k > 2 * repeated - 2; k--) {
                    num++;
                    array[k][array[k].length - repeated] = num;
                }
                break;
        }
    }
    array.forEach((childArray) => {
        childArray.forEach((value) => {
            result.push(value);
        });
    });
    return result;
}
