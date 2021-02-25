package m;

import org.junit.jupiter.api.Test;
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//
// 示例1:
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
//
//
// 示例2:
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
//
//
//
//
//
// 提示：
//
//
// 字符串长度在[0, 100000]范围内。
//
//
// 说明:
//
//
// 你能只调用一次检查子串的方法吗？
//
// Related Topics 字符串
// 👍 58 👎 0

public class M0109 {

    @Test
    public void test() {

    }


    /**
     * 首先如果两个字符串不相等，直接返回false
     * <p>
     * 如果s2是s1 轮转后得来的，将两个s2拼接起来，中间必定包含s1
     */
    public boolean isFlipedString(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        String s = s2 + s2;

        return s.contains(s1);
    }
}
