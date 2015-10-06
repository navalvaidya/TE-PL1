library(RJSONIO)
emp <- fromJSON("employee.json")
str(emp)


performace.obj <- c(emp[[1]]$performance,emp[[2]]$performance,emp[[3]]$performance,emp[[4]]$performance,emp[[5]]$performance,emp[[6]]$performance,emp[[7]]$performance,emp[[8]]$performance,emp[[9]]$performance,emp[[10]]$performance,emp[[11]]$performance,emp[[12]]$performance,emp[[13]]$performance,emp[[14]]$performance,emp[[15]]$performance,emp[[16]]$performance,emp[[17]]$performance,emp[[18]]$performance,emp[[19]]$performance,emp[[20]]$performance,emp[[21]]$performance,emp[[22]]$performance,emp[[23]]$performance,emp[[24]]$performance,emp[[25]]$performance,emp[[26]]$performance,emp[[27]]$performance,emp[[28]]$performance,emp[[29]]$performance,emp[[30]]$performance,emp[[31]]$performance,emp[[32]]$performance,emp[[33]]$performance,emp[[34]]$performance,emp[[35]]$performance,emp[[36]]$performance,emp[[37]]$performance,emp[[38]]$performance,emp[[39]]$performance,emp[[40]]$performance,emp[[41]]$performance,emp[[42]]$performance,emp[[43]]$performance,emp[[44]]$performance,emp[[45]]$performance,emp[[46]]$performance,emp[[47]]$performance,emp[[48]]$performance,emp[[49]]$performance,emp[[50]]$performance)
class(performace.obj)
summary(performace.obj)
factor(performace.obj)
table(performace.obj)

#analysis on attendace

attendance.obj <- c(emp[[1]]$attendance,emp[[2]]$attendance,emp[[3]]$attendance,emp[[4]]$attendance,emp[[5]]$attendance,emp[[6]]$attendance,emp[[7]]$attendance,emp[[8]]$attendance,emp[[9]]$attendance,emp[[9]]$attendance,emp[[10]]$attendance,emp[[11]]$attendance,emp[[12]]$attendance,emp[[13]]$attendance,emp[[14]]$attendance,emp[[15]]$attendance,emp[[16]]$attendance,emp[[17]]$attendance,emp[[18]]$attendance,emp[[19]]$attendance,emp[[20]]$attendance,emp[[21]]$attendance,emp[[22]]$attendance,emp[[23]]$attendance,emp[[24]]$attendance,emp[[25]]$attendance,emp[[26]]$attendance,emp[[27]]$attendance,emp[[28]]$attendance,emp[[29]]$attendance,emp[[30]]$attendance,emp[[31]]$attendance,emp[[32]]$attendance,emp[[33]]$attendance,emp[[34]]$attendance,emp[[35]]$attendance,emp[[36]]$attendance,emp[[37]]$attendance,emp[[38]]$attendance,emp[[39]]$attendance,emp[[40]]$attendance,emp[[41]]$attendance,emp[[42]]$attendance,emp[[43]]$attendance,emp[[44]]$attendance,emp[[45]]$attendance,emp[[46]]$attendance,emp[[47]]$attendance,emp[[48]]$attendance,emp[[49]]$attendance)
summary(attendance.obj)
hist(attendance.obj)
hist(attendance.obj, xlab="attendance of employees in percentage", ylab = "no. of employees",  main = "histogram on attendance")
plot(factor(performace.obj),attendance.obj, xlab="performance of employee", ylab="attendance of employee")

#analysis on results

product <- lapply(emp[1:50], "[[", "results_prod")
z <- data.frame(product)
b <- unlist(z)
plot(b,attendance.obj)

