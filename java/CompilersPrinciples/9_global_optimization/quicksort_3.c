/**
	快速排序对应的中间代码 -- 三地址代码
*/
i = m-1
j = n;
t1 = 4 * n;
v = a[t1]
i = i + 1
t2 = 4 * i
t3 = a[t2]
if t3 < v goto 8L
j = j - 1
t4 = 4 * j
t5 = a[t4]
if t5 > v goto 12L
if i >= j goto 26L
t6 = 4 * i
x = a[t6]
t7 = 4 * i 
t8 = 4 * j
t9 = a[t8]
a[t7] = t9
t10 = 4 * j
a[t10] = x
goto 8L
t11 = 4 * i 
x = a[t11]
t12 = 4 * i 
t13 = 4 * n
t14 = a[t13]
a[t12] = t14
t15 = 4 * n 
a[t15] = x
