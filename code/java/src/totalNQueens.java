/**
 52. N皇后 II
 n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 示例 1：


 输入：n = 4
 输出：2
 解释：如上图所示，4 皇后问题存在两个不同的解法。
 示例 2：

 输入：n = 1
 输出：1


 提示：

 1 <= n <= 9
 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 **/

class Solution {
    public int totalNQueens(int n) {
        //用来返回答案种数
        int num = 0;
        //用来标记可以被皇后攻击的位子
        int[][] isHave = new int[n][n];
        //设置默认值
        solveNQueensAll(n,0,isHave,num);
        return solveNQueensAll(n,0,isHave,num);
    }

    public static int solveNQueensAll(int n,int h,int[][] isHave,int num){
        if(h == n){
            return 1;
        }
        num = 0;
        for (int y = 0;y < n;y++){
//            System.out.println("h="+h);
//            System.out.println("y="+y);
//            System.out.println(Arrays.deepToString(isHave));
//            System.out.println("\n");
            if(isHave[h][y] == 0){
                //标记皇后占领的地盘(竖着往下)
                for (int b = h;b < n;b++){
                    isHave[b][y]++;
                }
                //标记皇后占领的地盘(斜着往右下)
                int c = h;
                int d = y;
                while(c < n && d < n){
                    isHave[c][d]++;
                    c++;
                    d++;
                }
                //标记皇后占领的地盘(斜着往左下)
                int e = h;
                int f = y;
                while(e < n && f >= 0){
                    isHave[e][f]++;
                    e++;
                    f--;
                }

                num += solveNQueensAll(n,h+1,isHave,num);

                //取消标记皇后占领的地盘(竖着往下)
                for (int b = h;b < n;b++){
                    isHave[b][y]--;
                }
                //取消标记皇后占领的地盘(斜着往右下)
                int cc = h;
                int dd = y;
                while(cc < n && dd < n){
                    isHave[cc][dd]--;
                    cc++;
                    dd++;
                }
                //取消标记皇后占领的地盘(斜着往左下)
                int ee = h;
                int ff = y;
                while(ee < n && ff >= 0){
                    isHave[ee][ff]--;
                    ee++;
                    ff--;
                }
            }
        }

        return num;
    }
}