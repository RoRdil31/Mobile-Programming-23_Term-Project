import numpy as np
import matplotlib.pyplot as plt
import math

# Make BMI data.
#-------------------------------------------------------

wt=40+50*np.random.random(100) # Fill the weight. random float numbers between 40.0 and 90.0.
ht=np.floor(140+60*np.random.random(100)) # fill the height. random integers between 140 and 200(centimeters).

ht=ht/100

X=zip(wt,ht)

BMI={}

i=0
for w,h in (tuple(X)):
    BMI[i]=w/(h*h)
    i+=1

#---------------------------------------------------------

#Draw Bar chart, Histogram, Pie chart, Scatter plot

data=[0,0,0,0]

for j in range(0,100):
    #print(BMI[j])

    if(18.5>float(BMI[j])):
       data[0]+=1
    elif(18.5<=float(BMI[j])<=24.9):
        data[1]+=1
    elif(25.0<=float(BMI[j])<=29.9):
        data[2]+=1
    else:
        data[3]+=1

print(data)
       
Weight_status = ['Underweight\n(Below 18.5)','Healthy\n(18.5-24.9)','Overweight\n(25.0-29.9)','Obese\n(30.0 and above)']


plt.title("Bar chart of result")
plt.bar(Weight_status,data)
Bar=plt
Bar.show()
#plt.show()

#---------------------------------------------------------

# Draw Histogram
#print(BMI.values())
val=BMI.values()
print(val)
plt.title("Histogram of result")
plt.hist(BMI.values(),bins=[0.0,18.5,25.0,30.0,60.0])
plt.xticks([0.0,18.5,25.0,30.0,60.0])
Histo=plt
Histo.show()
#plt.show()

#---------------------------------------------------------

# Draw Pie Chart

plt.title("Pie Chart of result")
plt.pie(data,labels=Weight_status,autopct='%1.2f%%')
Chart=plt
Chart.show()
#plt.show()


#---------------------------------------------------------

# Draw Scatter Plot

plt.title("Scatter Plot of result")
plt.scatter(ht*100,wt)
plt.xlabel('Height(centimeters)')
plt.ylabel('Weight(kg)')
Scatt=plt
Scatt.show()
#plt.show()

#---------------------------------------------------------


