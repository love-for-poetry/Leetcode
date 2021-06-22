/**
 51. N 皇后
 n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 示例 1：


 输入：n = 4
 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 解释：如上图所示，4 皇后问题存在两个不同的解法。
 示例 2：

 输入：n = 1
 输出：[["Q"]]


 提示：

 1 <= n <= 9
 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 **/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        //用来放全部返回值的，是引用传参
        List<List<String>> strList = new ArrayList<>();
        //用来放递归层数中每行皇后的位置
        int[] strIndex = new int[n];
        //用来标记可以被皇后攻击的位子
        int[][] isHave = new int[n][n];
        //设置默认值
        solveNQueensAll(strList,n,0,strIndex,isHave);
        return strList;
    }

    public void solveNQueensAll(List<List<String>> strList,int n,int h,int[] strIndex,int[][] isHave){
        if(h == n){
            strList.add(intToString(strIndex));
            return;
        }
        for (int y = 0;y < n;y++){
//            System.out.println("h="+h);
//            System.out.println("y="+y);
//            System.out.println(Arrays.deepToString(isHave));
//            System.out.println("\n");
            if(isHave[h][y] == 0){
                //设置该行皇后
                strIndex[h] = y;
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

                solveNQueensAll(strList,n,h+1,strIndex,isHave);

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
    }

    /**
     * 将每行存放皇后位置的int数组转化为字符串
     * @param strIndex
     * @return
     */
    public List<String> intToString(int[] strIndex){
        List<String> str = new ArrayList<>();
        char[] tmp = new char[strIndex.length];
        Arrays.fill(tmp,'.');
        for (int i=0;i < strIndex.length;i++){
            tmp[strIndex[i]] = 'Q';
            str.add(new String(tmp));
            tmp[strIndex[i]] = '.';
        }

        return str;
    }
}

