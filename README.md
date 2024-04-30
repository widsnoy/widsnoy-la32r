## 4 月 16 日
目前实现了一个单周期 CPU, 支持 CPU 实战 Loongarch32 精简版实验 6 的 20 条指令，并且通过了 trace 测试。  
遇到了一个奇怪的问题  
如果我在 EXE 阶段计算某个值，就会出现计算结果错误的问题  
```scala
// IF 阶段得到 op2_sel
val op2_data = MuxCase(0.U(32.W), Seq(
    (op2_sel === OP2_OF16) -> i16
))
(exe_fun === BR_BEQ)   -> (op1_data + Cat(Fill(14, op2_data(15)), op2_data, 0.U(2.W)))
```
但是如果我在 IF 阶段就把这个值算出来，EXE 阶段直接用就没有问题了。
```scala
val of16_sex = Cat(Fill(14, inst(25)), inst(25, 10), 0.U(2.W)) // IF Stage
(exe_fun === BR_BEQ)   -> (op1_data + op2_data)                // EX Stage
```

在学长的帮助下解决了这个问题。原因是 val op2_data = MuxCase 那里会自动推断无符号扩展成 32 位的数，我把它当成 16 位 Cat 就会出问题。


## 4 月 19 日
完成了不考虑相关冲突的流水线，并通过了测试。  
感觉和单周期的区别就是加上了缓存和一些控制信号。

## 4 月 22 日
做了实验 8 之后，被 lwt 拉去搞 soc_simulator，搞了一晚上 trace 都进不去... 暂时先不管模拟器了

## 4 月 23 日
感觉前递解决冲突比阻塞好写多了，速度还快些。当然我是不管源寄存器是否有用都等着拿写数据，如果 ld.w 比较多可能会慢一些。但是特判又会增加代码复杂度，目前就先不管了。目前测试下来比生成 golden_trace 的那个 cpu 慢一些，比阻塞的快接近一倍。优化等代码基本完成再说吧，现在也不知道是不是关键路径。

## 4 月 28 日
1. 感谢学长指出我代码的问题，优化了 ALU, 提前计算答案避免综合出多个 ALU。  
2. 将一字节变量的位运算改为 Bool 的逻辑运算，增强代码可读性。   
3. 参考 pua_mips 用 ip 核实现乘除法完成了 lab10。

## 4 月 30 日
昨天对着 confreg.v 改了下模拟器 confreg，终于可以用了。  
发现之前的代码判断 to_fs_valid 为 1 的时机是有问题的，应该是 reset 置 0 的下一拍，否则 inst_sram 才能读出数据，将 to_fs_valid 设为 reg 就可以解决。  
完成了 lab11, 比较坑的一点是 ld.b, st.b 之类地址可以是非对齐的，最开始没理解调试了很久。