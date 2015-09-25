# R ���ݿ��ӻ�
        # ֱ��ͼ
# install.packages("RColorBrewer") #��װRColorBrewer
library(RColorBrewer)
data(VADeaths)
par(mfrow = c(2, 3)) #�����ذѶ��ͼ����һҳ��
# pal(n, name): n ��ɫ��������name ��ɫ��ʽ
hist(VADeaths, breaks = 10, col = brewer.pal(3, "Set3"), main = "Set3 3 colors")
hist(VADeaths, breaks = 3, col = brewer.pal(3, "Set2"), main = "Set2 3 colors")
hist(VADeaths, breaks = 7, col = brewer.pal(3, "Set1"), main = "Set1 3 colors")
hist(VADeaths, breaks = 2, col = brewer.pal(8, "Set3"), main = "Set3 8 colors")
hist(VADeaths, col = brewer.pal(8, "Greys"), main = "Greys 8 colors")
hist(VADeaths, col = brewer.pal(8, "Greens"), main = "Greens 8 colors")

        #����ͼ/����ͼ
plot(AirPassengers, type = "1")

barplot(iris$Petal.Length)
barplot(iris$Sepal.Length, col = brewer.pal(3, "Set1"))
barplot(table(iris$Species, iris$Sepal.Length), col = brewer.pal(3, "Set1"))

        #��ʽͼ
boxplot(iris$Petal.Length ~ iris$Species)

# ����Ļ����ʾ4��ͼ
# ʹ��~ ��(��Ƭ�ĳ���)����չ����ο�������(������)���п��ӻ�
# ʹ�õ�ɫ�崴����Ŀ��ͼ��
data(iris)
par(mfrow = c(2, 2))
boxplot(iris$Sepal.Length, col = "red")
boxplot(iris$Sepal.Length~iris$Species, col = "red")
boxplot(iris$Sepal.Length~iris$Species, col = heat.colors(3)) #��ɫ��
boxplot(iris$Sepal.Length~iris$Species, col = topo.colors(3)) #��ɫ��
# http://decisionstats.com/2011/04/21/using-color-palettes-in-r/

        # ɢ��ͼ
plot(x = iris$Petal.Length)
plot(x = iris$Petal.Length, y = iris$Species)
plot(iris, col = brewer.pal(3, "Set1"))
    
        # ��ͼ
pie(table(iris$Species))