package main

import "math"

/**
36. 有效的数独
请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。

注意：

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。

示例 1：
输入：board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：true
示例 2：

输入：board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：false
解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
*/
func isValidSudoku(board [][]byte) bool {
	x := make([]int, 9)
	y := make([]int, 9)
	xy := make([][3]int, 3)
	for i, v := range board {
		for j, _ := range v {
			if board[i][j] == '.' { //如果是.直接跳出
				continue
			}
			//用与运算判断行中是否出现某该元素，若出现直接返回false
			if x[i]&int(math.Pow(2, float64(board[i][j]-'0'))) == int(math.Pow(2, float64(board[i][j]-'0'))) {
				return false
			} else {
				//用或运算将该元素对应的位填充为1
				x[i] = x[i] | int(math.Pow(2, float64(board[i][j]-'0')))
			}
			//同上
			if y[j]&int(math.Pow(2, float64(board[i][j]-'0'))) == int(math.Pow(2, float64(board[i][j]-'0'))) {
				return false
			} else {
				y[j] = y[j] | int(math.Pow(2, float64(board[i][j]-'0')))
			}
			//同上
			if xy[i/3][j/3]&int(math.Pow(2, float64(board[i][j]-'0'))) == int(math.Pow(2, float64(board[i][j]-'0'))) {
				return false
			} else {
				xy[i/3][j/3] = xy[i/3][j/3] | int(math.Pow(2, float64(board[i][j]-'0')))
			}
		}
	}
	return true
}
