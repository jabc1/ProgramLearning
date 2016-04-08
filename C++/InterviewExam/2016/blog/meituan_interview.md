# 美团电话面试

第一题，直接编码，实现翻转链表

	感觉相对比较容易，因为知道其原理，所以很容易就实现了如下代码：
	
	struct Node {
		int val;
		Node *next;
	}Node;

	void reverse(Node *head) {
		// invalid parameter
		if (head == NULL){
			return ;
		}
		
		Node *currentNode = NULL;
		Node *nextNode = NULL;
		
		while (head != NULL){
			nextNode = head->next;
			head->next = currentNode;
			currentNode = head;
			head = nextNode;
		}
		
		head = currentNode;
	}
	
	面试官，只是简单的说了一句，正确！
	
第二题，关于所做的项目问题
	
	1.alpha-β剪枝算法讲解：
	
	
	2.如何实现C语言版本到C++版本五子棋的迭代
	
	3.五子棋游戏的模块
		
		开始以为是功能模块，说了一些C语言版本的函数，后来面试官强调是类，然后我就说了三个类：棋子，棋盘，玩家
		
第三题，关于操作系统读写功能的具体过程分析。write()函数过程讲解

	函数调用，第一步必须压栈操作，保存现场；第二步，用户态切换到内核态，因为读写磁盘等，必须是内核态的，
	执行写操作，首先写到缓冲区，然后一次写入文件，然后返回到原主调函数处。
	
第四题，内存管理讲解

	分页分段式管理，页表等
	
	malloc、free函数。
	
	自动内存管理：Java(GC)、C++(智能指针auto_ptr shared_ptr unique_ptr)、C手动管理
	
第五题，对于他们团队项目的了解，主要是关于云存储的，分布式系统存储等

	完全忘记了面试美团的什么职位，也是醉了。
	

####建议
多做一些实践操作，应该多做些事情。

非常感谢面试官的面试和指导！谢谢


####总结
1.一定要多总结自己写的项目，对自己的项目，一定要熟悉得不能再熟悉！
	
	项目中某个比较重要的点是如何实现的（需要深入技术的原理）
	遇到的最大困难是什么（有哪些），你怎么解决的？ 
	如果需要扩展某个功能，如何降低系统的耦合度 
	如果针对某个功能进行优化，你会怎么设计和优化
	
2.面试之前一定要做点功课，不要盲目自信

	可以简单了解公司背景，文化理念等
	了解你面试岗位的任职要求，公司招聘哪一块的人员
	了解某团队做的项目
	
	好处两点：
		1.体现找工作的热情，对公司的尊重和喜欢
		2.面试官一般都会问其项目相关的内容，看看你的了解程度，如此你做了准备，刚好回答
		
本人铁头功，第一次阿里面试也是，搜索引擎的东西，一问三不知，这次是云存储的东西，还是一问三不知，醉了！

**谦虚使人进步，努力学习！**