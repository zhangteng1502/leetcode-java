# LeetCode Java 练习场

JDK 17，零外部依赖（不装 Maven、不联网下 jar 也能跑）。

## 目录约定

```
src/main/java/
├── leetcode/
│   ├── q0001_two_sum/Solution.java        # 一题一个包，类名统一叫 Solution
│   └── q0206_reverse_linked_list/Solution.java
├── ds/                                     # ListNode / TreeNode（与官方签名一致）
└── util/                                   # Assert（断言自测）、Prints（打印/构造）
```

## 三种跑法

1. **IDEA 里（推荐）**：打开 `Solution.java`，点 `main` 左边的绿色三角 → Run。
   快捷键：`⌃⇧R`（Control+Shift+R）运行、`⌃R` 重跑、`⌃⇧D` 调试、打断点后 Debug 可以单步看变量。
2. **命令行**：`./run.sh leetcode.q0001_two_sum.Solution`
3. **开新题**：`./new.sh 15 three_sum`，会自动建包和模板，然后 IDEA 里直接开写。

## 自测写法

```java
Solution s = new Solution();
Assert.arrayEq(new int[]{0, 1}, s.twoSum(new int[]{2, 7, 11, 15}, 9));
Assert.eq(3, s.answer());
Assert.done();   // 最后一行：输出 ---- 3/3 通过 ----，有失败会标红
```

调试打印：

```java
System.out.println(Prints.str(nums));                    // 数组
System.out.println(Prints.str(head));                    // 链表
System.out.println(Prints.levelOrder(root));             // 树
ListNode h = Prints.list(1, 2, 3);                       // 构造链表
TreeNode t = Prints.tree(1, null, 2, 3);                 // 构造树（层序）
```

## 提交到 LeetCode

只粘**方法本身**（含方法签名），`main` 和 `import util.Assert` 不用粘。
`ds.ListNode` / `ds.TreeNode` 已在 LeetCode 环境里预定义，不要一起粘过去。

## 练习路线建议

| 阶段 | 专题 | 建议题号 |
|---|---|---|
| 热身 | 数组 / 双指针 | 1, 15, 26, 27, 283, 167 |
| 基础 | 哈希表 / 字符串 | 3, 49, 242, 438, 567 |
| 数据结构 | 链表 / 栈队列 | 206, 21, 141, 20, 232, 155 |
| 递归 | 树 / DFS / BFS | 104, 102, 226, 101, 98 |
| 进阶 | 二分 / 贪心 / DP | 704, 35, 121, 70, 322, 300 |

想刷哪一类直接说，我可以按专题把题目和模板都备好。
