# data cleaning 
if (!file.exist("data")) #����ļ�Ŀ¼�Ƿ����
{
        dir.create("data")  #�����ļ���
}
fileUrl <- "https://data.baltimorecity.gov/api/views/dz54-2aru/rows.csv?accessType=DOWNLOAD"
download.file(fileUrl, destfile = "cameras.csv", method = "curl")
# �������� Mac-OS ʹ�á�curl�� Windows ʹ��Ĭ�ϼ���
dateDownLoaded <- date() # ��������
cameraData <- read.table("./data/cameras.csv")
# read.table ֱ�Ӷ����ڴ棬���ʺϴ����ݡ�³���Ժá�����
# Ĭ�����Ʊ������ָ���
cameraData <- read.table("./data/cameras.csv", sep = ",", header = TRUE)
head(cameraData)

# quote="" ###���'or" ������

####### ����ȡһ���Ӽ�
colIndex <- 2:3
rowIndex <- 1:4
cameraDataSubset <- read.xlsx("./data/cameras.xlsx", sheetIndex=1, 
                              colIndex=colIndex, rowIndex=rowIndex)
XPath http://www.stat.berkeley.edu/~statcur/Workshop2/Presentations/XML.pdf

xpathSApply(rootNode, "//name", xmlValue)
### ���������ĵ����ҵ����б��Ϊname��Ԫ�����ڵĽڵ㣬���ؽڵ�xmlֵ(xmlValue)
xpathSApply(rootNode, "//price", xmlValue)

## ��������Ƶ���������� ��ҳԴ����
http://espn.go.com/nfl/team/_/name/bal/baltimore-ravens
fileUrl <- "http://espn.go.com/nf/team/_/name/bal/baltimore-ravens"
doc <- htmlTreeParse(fileUrl, useInternal = TRUE)
### ����HTML�ļ�htmlTreeParse������XML�ļ�xmlTreeParse
scores <- xpathSApply(doc, "//li[@class='score']", xmlValue)
teams <- xpathSApply(doc, "//li[@class='team-name']", xmlValue)
scores


############### ��װswirl
## https://github.com/ywang2014/swirl_courses ���ص�����
library(swirl)
install_course_zip("D:/Development/BigData/coursera/swirl_courses-master.zip", multi=TRUE, which_course="Getting_and_Cleaning_Data")