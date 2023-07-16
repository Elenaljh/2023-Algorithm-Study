//school.programmers.co.kr/learn/courses/30/lessons/92342

const solution = (n, info) => {
	let answer = Array(11).fill(0);
	let maxCount = 0;

	function findMaxPoint(apeachCount, ryanCount, usedShots, point, arr) {
		if (n < usedShots) return;

		if (point > 10) {
			let diff = ryanCount - apeachCount;
			if (maxCount < diff) {
				arr[10] = n - usedShots;
				maxCount = diff;
				answer = arr;
			}
			return;
		}

		if (n > usedShots) {
			let current = [...arr];
			current[10 - point] = info[10 - point] + 1;
			findMaxPoint(
				apeachCount,
				ryanCount + point,
				usedShots + info[10 - point] + 1,
				point + 1,
				current
			);
		}

		if (info[10 - point] > 0) {
			findMaxPoint(apeachCount + point, ryanCount, usedShots, point + 1, arr);
		} else {
			findMaxPoint(apeachCount, ryanCount, usedShots, point + 1, arr);
		}
	}

	findMaxPoint(0, 0, 0, 0, answer);

	return maxCount <= 0 ? [-1] : answer;
};
