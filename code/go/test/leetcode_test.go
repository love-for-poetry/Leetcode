package test

import (
	"sort"
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

func combinationSum2(candidates []int, target int) (reArr [][]int) {
	sort.Ints(candidates)  //排序
	var freqArr []int   //统计元素出现的次数
	for _,v := range candidates{
		if freqArr == nil || v != freqArr[len(freqArr)-1]{
			freqArr = append(freqArr,v)
		}
	}

	var arr []int
	recursion(&reArr,arr,freqArr,0,0,target)
	return reArr
}

func recursion(reArr *[][]int,arr []int,freqArr []int,n int,sum int,target int) {
	if sum == target{
		*reArr = append(*reArr,arr)
	}

	for i := n;i < len(freqArr);i++{
		tmp := make([]int,len(arr))
		copy(tmp,arr)
		tmp = append(tmp,freqArr[i])
		recursion(reArr,tmp,freqArr,i + 1,sum + freqArr[i],target)
	}
}

func TestA(t *testing.T) {
	candidates := []int{2,5,2,1,2}
	a := combinationSum2(candidates, 5)
	t.Log(a)
}
