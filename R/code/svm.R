# ���ɭ��
# install.packages("randomForest") #��װrandomForest
library("randomForest")
data(iris) #iris���ݼ�����R�����Դ������ݼ�
set.seed(100)
ind = sample(2, nrow(iris), replace = TRUE, prob = c(0.8, 0.2))
iris.rf = randomForest(Species~., iris[ind == 1,], ntree = 50, nPerm = 10, 
                       mtry = 3, proximity = TRUE, importance = TRUE)
print(iris.rf)
iris.pred = predict(iris.rf, iris[ind == 2, ])
table(observed = iris[ind == 2, "Species"], predicted = iris.pred)

# randomForest()��ѵ���������ݽ��д��������ɾ�����
# Species~.:������ҪԤ����У�species���е����ơ�
# iris[ind==1,]�����ɾ�������ѵ����
# ntree�����ɾ���������Ŀ
# nperm������importanceʱ���ظ�����
# mtry��ѡ��ķ������Եĸ���
# proximity=TRUE����ʾ�����ٽ�����
# importance=TRUE������������Ե���Ҫ��
# iris.pred=predict( iris.rf,iris[ind==2,] )
# iris.rf����ʾ���ɵ����ɭ��ģ��
# iris[ind==2,] ������Ԥ��Ĳ��Լ�