package m;
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
//
//
// 示例 1：
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//
//
// 示例 2：
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//
// Related Topics 数组
// 👍 25 👎 0

import java.util.HashSet;
import java.util.Set;

public class M0108 {

    /**
     * 使用Set，效率比较低
     */
    public void setZeroes1(int[][] matrix) {

        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row.contains(i)) {
                    matrix[i][j] = 0;
                }
                if (column.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用数组实现，效率高
     */
    public void setZeroes2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] rows = new int[m];
        int[] colums = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    colums[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || colums[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
