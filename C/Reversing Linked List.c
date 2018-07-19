/*
1074 Reversing Linked List (25)（25 point(s)）

Given a constant K and a singly linked list L, you are supposed to reverse the links of every K elements on L. For example, given L being 1→2→3→4→5→6, if K = 3, then you must output 3→2→1→6→5→4; if K = 4, you must output 4→3→2→1→5→6.

Input Specification:

Each input file contains one test case. For each case, the first line contains the address of the first node, a positive N (<= 10^5^) which is the total number of nodes, and a positive K (<=N) which is the length of the sublist to be reversed. The address of a node is a 5-digit nonnegative integer, and NULL is represented by -1.

Then N lines follow, each describes a node in the format:

Address Data Next

where Address is the position of the node, Data is an integer, and Next is the position of the next node.

Output Specification:

For each case, output the resulting ordered linked list. Each node occupies a line, and is printed in the same format as in the input.

Sample Input:

00100 6 4
00000 4 99999
00100 1 12309
68237 6 -1
33218 3 00000
99999 5 68237
12309 2 33218
Sample Output:

00000 4 33218
33218 3 12309
12309 2 00100
00100 1 99999
99999 5 68237
68237 6 -1
*/

#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
	int Data;
	int Next;
}node;

int main()
{
	//输入数据
	node  a[100000],b;
	int head, N, K,i,add;
	scanf("%d%d%d", &head, &N, &K);
	for (i = 1; i <= N; i++)
	{
		scanf("%d",&add);
		scanf("%d%d", &a[add].Data, &a[add].Next);
	}
	//反转链表
	b.Next = head;
	int new, old, temp,first1;
	int cnt;

	new = b.Next;
	old = a[new].Next;
	cnt = 1;
	while (cnt < K)
	{
		temp = a[old].Next;
		a[old].Next = new;
		new = old; old = temp;
		cnt++;
	}
	a[head].Next = old;
	first1 = b.Next;
	b.Next = new;

	int first2;
	for (i = 1; i <= N/K - 1; i++)
	{
		first2 = old;
		new = old;
		old = a[old].Next;
		cnt = 1;
		while (cnt < K)
		{
			temp = a[old].Next;
			a[old].Next = new;
			new = old; old = temp;
			cnt++;
		}
		a[first1].Next = new;
		a[first2].Next = old;
		first1 = first2;
	}

	//输出链表
	int r = b.Next;
	while (r != -1)
	{
		if (a[r].Next != -1)
		{
			printf("%05d %d %05d\n", r, a[r].Data, a[r].Next);
			r = a[r].Next;
		}
		else
		{
			printf("%05d %d %d\n", r, a[r].Data, a[r].Next);
			r = a[r].Next;
		}
	}
	return 0;
}