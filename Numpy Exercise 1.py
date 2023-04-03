import numpy as np

wt=40+50*np.random.random(100) # Fill the weight. random float numbers between 40.0 and 90.0.
ht=np.floor(140+60*np.random.random(100)) # fill the height. random integers between 140 and 200(centimeters).

ht=ht/100

X=zip(wt,ht)

BMI={}

i=0
for w,h in (tuple(X)):
    BMI[i]=w/(h*h)
    i+=1

for j in range(0,100):
    print(BMI[j])