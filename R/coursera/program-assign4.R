read <- function()
{
        olddir <- getwd()
        setwd("assign/rprog_data_ProgAssignment3-data")
        outcome <- read.csv("outcome-of-care-measures.csv")
        head(outcome)
        ncol(outcome)
        nrow(outcome)
        names(outcome)
        
        outcome[, 11] <- as.numeric(outcome[, 11])
        hist(outcome[,11])
        setwd(olddir)
}

##########ctrl+L ��տ���̨
#####rm(list = ls()) ��չ���Ŀ¼����