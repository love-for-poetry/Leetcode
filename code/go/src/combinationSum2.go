package main

import (
	"sort"
	"strconv"
	"testing"
)

/**
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

*/

func combinationSum2(candidates []int, target int) [][]int {
	var arr []int
	var reArr [][]int
	var sum int
	sort.Ints(candidates)
	aMap := make(map[string]int)
	recu(target, arr, sum, candidates, 0, &reArr, aMap)
	return reArr
}

func recu(target int, arr []int, sum int, candidates []int, num int, reArr *[][]int, aMap map[string]int) {
	if sum == target {
		str := intArrToString(arr)
		if _, ok := aMap[str]; !ok {
			*reArr = append(*reArr, arr)
			aMap[str] = 1
		}
	}

	for i := num; i < len(candidates); i++ {
		if sum < target {
			tmp := make([]int, len(arr))
			copy(tmp, arr)
			tmp = append(tmp, candidates[i])
			recu(target, tmp, sum+candidates[i], candidates, i+1, reArr, aMap)
		}
	}

	return
}

func intArrToString(arr []int) (str string) {
	for _, v := range arr {
		str += strconv.Itoa(v)
	}
	return
}

func TestA(t *testing.T) {
	candidates := []int{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
	a := combinationSum2(candidates, 27)
	t.Log(a)
}
