#2)	Write a python program to implement simple Linear Regression for predicting house price.***

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn import linear_model 

df=pd.read_excel("./position.xlsx")
print("first five details\n")
print(df.head())
plt.xlabel("Level")
plt.ylabel("Salary")

lr=linear_model.LinearRegression()
lr.fit(df[["Level"]],df.Salary)
print("Prediction at 15:")
print(lr.predict([[15]]))

print("coeficent " )
print(lr.coef_)
print("\nintercept")
print(lr.intercept_)

plt.scatter(df.Level, df.Salary,color="red")
plt.plot(df.Level, lr.predict([df.Level]),color="red")
plt.show()

