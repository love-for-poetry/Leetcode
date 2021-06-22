package main

import (
	"sort"
	"strconv"
)

/**
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
*/

func combinationSum(candidates []int, target int) [][]int {
	var arr []int
	var reArr [][]int
	var sum int
	aMap := make(map[string]int)
	recursion(target, arr, sum, candidates, &reArr, aMap)
	return reArr
}

func recursion(target int, arr []int, sum int, candidates []int, reArr *[][]int, aMap map[string]int) {

	for _, v := range candidates {
		if sum == target {
			sort.Ints(arr)
			str := IntArrToString(arr)
			if _, ok := aMap[str]; !ok {
				*reArr = append(*reArr, arr)
				aMap[str] = 1
			}
		}

		if sum < target {
			tmp := arr[:len(arr):len(arr)]
			tmp = append(tmp, v)
			recursion(target, tmp, sum+v, candidates, reArr, aMap)
		}
	}

	return
}

func IntArrToString(arr []int) (str string) {
	for _, v := range arr {
		str += strconv.Itoa(v)
	}
	return
}
