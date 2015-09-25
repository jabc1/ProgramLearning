best <- function(state, outcome)
{
        file <- "assign/rprog_data_ProgAssignment3-data/outcome-of-care-measures.csv"
        outcome_data <- read.csv(file);
        s_outcome <- c("heart attack", "heart failure", "pneumonia")
        a <- outcome_data["State"] == state
        b <- subset(outcome_data, a)
        if (nrow(b) == 0)
        {
                return("invalid state")
        }
        if (outcome == s_outcome[1])
        {
                data <- data.frame(b[, 2], b[, 11])
        }
        else if (outcome == s_outcome[2])
        {
                b[, 17] <- factor(b[, 17], 
                                  levels=c("1.0", "2.0", "3.0", "4.0", "5.0", 
                                           "6.0", "7.0", "8.0", "9.0", "10.0",
                                           "11.0", "12.0"), 
                                  ordered=TRUE)
                data <- data.frame(b[, 2], b[, 17])
        }
        else if (outcome == s_outcome[3])
        {
                b[, 23] <- factor(b[, 23], 
                                  levels=c("1.0", "2.0", "3.0", "4.0", "5.0", 
                                           "6.0", "7.0", "8.0", "9.0", "10.0",
                                           "11.0", "12.0"), 
                                  ordered=TRUE)
                data <- data.frame(b[, 2], b[, 23])
        }
        else
        {
                return("invalid outcome")
        }
        bad <- data[2] == "Not Available"
        data <- subset(data, !bad)
        data[, 2] <- as.numeric(data[, 2])
        c <- data[order(data[,2]), ]
        d <- as.character(c[1, 1])
        d
}
# best("NY", "pneumonia")
# best("NN", "pneumonia")
##########�Զ�������
#datagrp <- factor(grp, levels=c("1.1", "8.7", "10.1"), ordered=TRUE)
####���� b, c, a��˳��

#    ����factor����levels "1.1", "10.1", "8.7" �������20��Ԫ��
#    grp <- factor(sample(c("10.1", "8.7", "1.1"), 20, replace = TRUE))
#    datagrp <- factor(grp, levels=c("1.1", "8.7", "10.1"), ordered=TRUE)
#    ����������̬�������
#    val1 <- rnorm(20)
#    val2 <- rnorm(20)
#    ���ݿ����
#    dat <- data.frame(grp = grp, val1 = val1, val2 = val2)
#    data <-data.frame(datagrp = datagrp,val1 = val1, val2 = val2)
#    �Ե�һ��Ϊ��׼����
#    newdat <- dat[order(dat[, 1]), ]
#    newdata <- data[order(data[, 1]), ]
#    �Ե�һ�еĶ������ ��� 
#    tapply(newdat[, 2], newdat[, 1], sum)