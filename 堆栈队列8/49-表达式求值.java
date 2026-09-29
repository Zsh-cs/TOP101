import java.util.*;


public class Solution {
    // 使用map维护运算符优先级
    private static final Map<Character, Integer> map = new
    HashMap<Character, Integer>() {
        {
            put('+', 1);
            put('-', 1);
            put('*', 2);
        }
    };

    /**
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        // 把所有的空格去掉
        s = s.replaceAll("\\s+", "");
        char[] chars = s.toCharArray();

        // 数字栈
        Stack<Integer> nums = new Stack<>();
        // 先往nums压入一个0，防止第一个数是负数的情况
        nums.push(0);
        // 符号栈
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    if (ops.peek() != '(') {
                        calculate(nums, ops);
                    } else {
                        ops.pop();
                        break;
                    }
                }
            } else if (Character.isDigit(ch)) {
                int num = 0;
                int j = i;
                // 将从i位置开始后面的连续数字整体取出，压入nums
                while (j < chars.length && Character.isDigit(chars[j])) {
                    num = num * 10 + (chars[j++] - '0');
                }
                nums.push(num);
                // 将i指向连续数字的末位数字
                i = j - 1;
            } else {
                if (i > 0 && chars[i - 1] == '(') {
                    nums.push(0);
                }
                // 当有一个新运算符要压入ops时，若栈顶运算符>=当前运算符，则把栈内可以算的都算了
                while (!ops.isEmpty() && ops.peek() != '(') {
                    char prev = ops.peek();
                    if (map.get(prev) >= map.get(ch)) {
                        calculate(nums, ops);
                    } else {
                        break;
                    }
                }
                ops.push(ch);
            }
        }
        // 将剩余的计算完
        while (!ops.isEmpty() && ops.peek() != '(') {
            calculate(nums, ops);
        }
        return nums.peek();
    }

    // 计算逻辑：从nums中取出两个操作数，从ops中取出运算符，然后根据运算符进行计算
    public void calculate(Stack<Integer> nums, Stack<Character> ops) {
        if (nums.size() < 2 || ops.isEmpty()) {
            return;
        }
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();
        int res = 0;
        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
        }
        nums.push(res);
    }
}