R���Ա��

#                 #ע��
dir()             #�г�����Ŀ¼�µ����г����ļ�
ls()              #�г��ļ������еĺ���
source("name.R")  #���س���
print(x)          #��ӡ
a                 #����Ĭ������
a <- 1            #��ֵ��䣬
a <- 1:20         #��ֵ��һ��������1,2,3,4,5,��������20
a <- c("a","b","c') #character vector
a <- vector("numeric", length = 10) # a = 0 0 ������0��Ĭ��ȱʡֵ��ʼ��
as.logical(x)     #ǿ������ת�����߼�ֵT F����as.
a <- matrix(nrow = 2, ncol = 3) #��������
dim(a)         #����ά��
attributes(a)  #��������
a <- matrix(1:6��nrow = 2, ncol = 3) #����������

m <- 1:10
dim(m) <- c(2:5) #�������󷽷���

x <- 1:3
y <- 10:12
cbind(x,y) #���������ɾ���
rbind(x,y) #���������ɾ���

x <- list(1, "a", TRUE, 1+4i) #list�����в�ͬ����
#####vector���������ͬ��character number logical(Ĭ��ת����͵ģ���ߣ�����������ת��)