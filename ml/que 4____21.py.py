#4)	Write a python program to implement logistic Regression for handwritten digit dataset.
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn import linear_model, metrics

df=pd.read_csv("insurance_data.csv")
print(df)
print(" ")
X = df[['age']]
print(X)
y = df['bought_insurance']
print(y)

#Plotting graph
plt.scatter(df.age,df.bought_insurance,color='red',marker='+')
print(plt.show())

# splitting X and y into training and testing sets
X_train, X_test,y_train, y_test = train_test_split(X, y,test_size=0.1)
print("Train X")
print(X_train)
print("Test X")
print(X_test) 
print("Train Y")
print(y_train) 
print("Test Y")
print(y_test) 

# create logistic regression object
reg = linear_model.LogisticRegression()
print(reg) 

# train the model using the training sets
reg.fit(X_train, y_train)
 
# making predictions on the testing set
y_pred = reg.predict(X_test)
 
# comparing actual response values (y_test)
# with predicted response values (y_pred)
print("Logistic Regression model accuracy(in %):",metrics.accuracy_score(y_test, y_pred)*100)


