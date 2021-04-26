package leetcode.序号.n100;

/**
 * 给定一个文本文件&nbsp;file.txt，请只打印这个文件中的第十行。

示例:

假设&nbsp;file.txt 有如下内容：

Line 1
Line 2
Line 3
Line 4
Line 5
Line 6
Line 7
Line 8
Line 9
Line 10

你的脚本应当显示第十行：

Line 10

说明:<br>
1. 如果文件少于十行，你应当输出什么？<br>
2. 至少有三种不同的解法，请尝试尽可能多的方法来解题。

相关标签：

原题地址：https://leetcode-cn.com/problems/tenth-line/
  
 *  
 * @author Ikarosx 
 * @date 2021/4/26 
 */ 
 public class N195第十行 { 
 	// Read from the file file.txt and output the tenth line to stdout.
    //awk 'NR == 10' file.txt NR在awk中指行号
    //
    //sed -n 10p file.txt -n表示只输出匹配行，p表示Print
    //
    //tail -n+10 file.txt|head -1 tail -n +10表示从第10行开始输出
 } 