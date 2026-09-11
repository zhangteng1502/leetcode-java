#!/usr/bin/env bash
# 编译并运行某个类的 main 方法
# 用法：./run.sh leetcode.q0001_two_sum.Solution
set -e
cd "$(dirname "$0")"

if [ $# -eq 0 ]; then
  echo "用法: ./run.sh <全限定类名>   例: ./run.sh leetcode.q0001_two_sum.Solution"
  exit 1
fi

mkdir -p out
find src/main/java -name "*.java" > out/.sources
javac -encoding UTF-8 -d out @out/.sources
java -cp out "$@"
