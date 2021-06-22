package golang

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSubStructure(A *TreeNode, B *TreeNode) bool {
	if A == nil || B == nil {
		return false
	}

	return compare(A, B) || isSubStructure(A.Left, B) || isSubStructure(A.Right, B)
}

func compare(A *TreeNode, B *TreeNode) bool {
	if B == nil {
		return true
	}

	if A == nil || A.Val != B.Val {
		return false
	}

	return compare(A.Left, B.Left) && compare(A.Right, B.Right)
}
