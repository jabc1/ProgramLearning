################assignment4
set.seed(1)
rpois(5, 2)
###�������� 1, 1, 2, 4, 1 ������
dnorm() �����ܶ�(probability density)����
pnorm() �ۼƷֲ�(cumulative distribution)����
rnorm() �����̬�ֲ�
qnorm() ��λ����
d ������֪��ֵ�ͱ�׼��ĸ��ʷֲ��ܶ�
r ���������
p �����ۻ��ֲ�
q ���Ʒ�λ��

set.seed()������ָ��RӦ��ʹ���ĸ�������������㷨���Ա�֤�����ԺͿɸ�����

set.seed(10)
x <- rbinom(10, 10, 0.5) #����ֲ������
e <- rnorm(10, 0, 20)
y <- 0.5 + 2 * x + e
plot(x, y)



