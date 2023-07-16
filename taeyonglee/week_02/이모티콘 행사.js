// https://school.programmers.co.kr/learn/courses/30/lessons/150368

const solution = (users, emoticons) => {
	const salePercent = [10, 20, 30, 40];
	const cases = [];
	const arr = [];
	const emoLen = emoticons.length;
	const result = [0, 0];
	function saleDFS(depth = 0) {
		if (depth === emoLen) {
			cases.push([...arr]);
			return;
		}
		for (let i = 0; i < salePercent.length; i++) {
			arr[depth] = salePercent[i];
			saleDFS(depth + 1);
		}
	}
	saleDFS();
	cases.forEach((curCase, curCaseIdx) => {
		let emoticonPlus = 0;
		let sumPrice = 0;
		users.forEach(([buyPercent, buyPlus], userIdx) => {
			let price = 0;
			let etPlusFlag = false;
			emoticons.every((et, etIdx) => {
				if (curCase[etIdx] >= buyPercent) {
					price += (et * (100 - curCase[etIdx])) / 100;
				}
				if (price >= buyPlus) {
					etPlusFlag = true;
					return false;
				}
				return true;
			});
			if (etPlusFlag) emoticonPlus++;
			else sumPrice += price;
		});
		if (emoticonPlus > result[0]) {
			result[0] = emoticonPlus;
			result[1] = sumPrice;
		} else if (result[0] === emoticonPlus && sumPrice > result[1]) {
			result[1] = sumPrice;
		}
	});
	return result;
};
