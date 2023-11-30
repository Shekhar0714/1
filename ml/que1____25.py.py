#1   Write a python program to transform data with Principal Component
#Analysis (PCA)

from sklearn.datasets import load_digits
import pandas as pd

dataset = load_digits()
dataset.keys()

dataset.data[0].reshape(8,8)

df = pd.DataFrame(dataset.data, columns=dataset.feature_names)
df.head()

dataset.target

X = df

y = dataset.target

from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)
X_scaled

from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(X_scaled, y, test_size=0.2, random_state=30)

from sklearn.linear_model import LogisticRegression

model = LogisticRegression()
model.fit(X_train, y_train)
model.score(X_test, y_test)

from sklearn.decomposition import PCA

pca = PCA(0.95)
X_pca = pca.fit_transform(X)
X_pca.shape

print(pca.explained_variance_ratio_)

print(pca.n_components_)

print(X_pca)

X_train_pca, X_test_pca, y_train, y_test = train_test_split(X_pca, y, test_size=0.2, random_state=30)

from sklearn.linear_model import LogisticRegression

model = LogisticRegression(max_iter=1000)
model.fit(X_train_pca, y_train)
print(model.score(X_test_pca, y_test))

