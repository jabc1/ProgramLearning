# ��R�л�ȡ���ݽ��з���
# R�ɶ�ȡ���ݺࣺܶ
#       ���ӱ���
#       Excel
#       ���ݿ�
#       ͼƬ
#       �ı��ļ�
#       ������ʽ

getwd() # ��ȡ��ǰ����Ŀ¼
setwd() # ���������ļ�����Ŀ¼

fdata <- scan("testsample.tex", what = "") # ���ı��л�ȡ����
head(fdata)
fdata <- tolower(fdata)
ft <- table(fdata)      # ����ʵ�ʹ��Ƶ��
pie(ft)         # �鿴ft�ı�ͼ���
max(ft)
head(ft)
dotchart(ft)    # ��ͼ��ʾ��ʹ��Ƶ��
read.csv("test.csv", header = TRUE)
read.table("test.csv", header = TRUE)
# ֱ�Ӵ����϶�ȡ����
data <- read.table("http://lib.statNaNu.edu/datasets/csb/ch3a.dat")

# �Ķ����ӱ������ݣ�������Ҫ��װgdata��
install.packages("gdata")
library(gdata)
read.xls("test.xls")
x <- edit(as.data.frame(NULL))  # ͨ���༭R���������������
data(Airpassengers)     # ���������ݼ�����R��
help(Airpassengers)     # �鿴��������
head(Airpassengers)     # �鿴ʵ������