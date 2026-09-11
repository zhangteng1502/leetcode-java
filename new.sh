#!/usr/bin/env bash
# 快速新建一道题的目录和 Solution 模板
# 用法：./new.sh 15 three_sum      -> src/main/java/leetcode/q0015_three_sum/Solution.java
set -e
cd "$(dirname "$0")"

if [ $# -lt 2 ]; then
  echo "用法: ./new.sh <题号> <英文名>   例: ./new.sh 15 three_sum"
  exit 1
fi

NUM=$1
NAME=$2
PKG="leetcode.q$(printf '%04d' "$NUM")_${NAME}"
DIR="src/main/java/$(echo "$PKG" | tr '.' '/')"
FILE="$DIR/Solution.java"

if [ -f "$FILE" ]; then
  echo "已存在: $FILE"
  exit 0
fi

mkdir -p "$DIR"
cat > "$FILE" <<EOF
package $PKG;

import util.Assert;

/**
 * TODO: 第 $NUM 题
 * 提交时只需把下面的方法体粘到 LeetCode 编辑器（main 不用粘）。
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        // TODO: 在这里写用例
        Assert.done();
    }
}
EOF

echo "已创建: $FILE"
