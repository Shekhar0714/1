#5)	Write a python program to implement Polynomial Regression for positionsal.csv dataset.
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

df=pd.read_excel("./position.xlsx")
print(df)
X = df.iloc[:, 1:2].values
y = df.iloc[:, 2].values
print(X)
print(y)

lin = LinearRegression() 
print(lin.fit(X, y))

poly = PolynomialFeatures(degree=4)
X_poly = poly.fit_transform(X)
 
poly.fit(X_poly, y)
lin2 = LinearRegression()
print(lin2.fit(X_poly, y))

plt.scatter(X, y, color='blue')
 
plt.plot(X, lin.predict(X), color='red')
plt.title('Linear Regression')
plt.xlabel('level')
plt.ylabel('salary')

plt.show()

plt.scatter(X, y, color='blue')
 
plt.plot(X, lin2.predict(poly.fit_transform(X)),
         color='red')
plt.title('Polynomial Regression')
plt.xlabel('Level')
plt.ylabel('salary')
 
plt.show()
