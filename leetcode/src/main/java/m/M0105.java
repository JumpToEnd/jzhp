package m;
//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
//
//
// 示例 1:
//
// 输入:
//first = "pale"
//second = "ple"
//输出: True
//
//
//
// 示例 2:
//
// 输入:
//first = "pales"
//second = "pal"
//输出: False
//
// Related Topics 字符串 动态规划
// 👍 55 👎 0

public class M0105 {

    /**
     * 解法1
     */
    public boolean oneEditAway1(String first, String second) {
        // 分为两种情况
        // 一种情况
        if (first == null || second == null) {
            return false;
        }

        int len1 = first.length();
        int len2 = second.length();

        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        if (len1 < len2) {
            return oneEditAway1(second, first);
        }

        // len1 比 len2 长
        for (int i = 0; i < len1; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(i).equals(second.substring(len1 == len2 ? i : i - 1));
            }
        }

        return false;
    }
}
