import math
import pandas_datareader as web
import numpy as np
import pandas as pd
from sklearn.preprocessing import MinMaxScaler


from keras.models import Sequential
from keras.layers import Dense, LSTM
import matplotlib.pyplot as plt

import os
import sys
working = os.getcwd()


plt.style.use('fivethirtyeight')

Ma = str(sys.argv[1])
nguon = 'yahoo'
batDau = '2018-01-01'
ketthuc = '2022-3-9'

df = web.DataReader(Ma, data_source = nguon, start = batDau, end = ketthuc)

plt.figure(figsize=(16, 8))
plt.title('Close prices')
plt.plot(df['Close'])
plt.xlabel('Date', fontsize=18)
plt.ylabel('Close price USD', fontsize = 18)
#plt.show()

data = df.filter(['Close'])
dataset = data.values
trainingDataLen = math.ceil(len(dataset) * 0.8)
#print(trainingDataLen)

scaler = MinMaxScaler(feature_range=(0,1))
scaled_data = scaler.fit_transform(dataset)

train_data = scaled_data[0: trainingDataLen, :]
x_train = []
y_train = []

for i in range(60, len(train_data)):
    x_train.append(train_data[i-60:i, 0])
    y_train.append(train_data[i, 0])

x_train = np.array(x_train)
y_train = np.array(y_train)

x_train = np.reshape(x_train, (x_train.shape[0], x_train.shape[1], 1))
#print(x_train.shape)

model = Sequential()
model.add(LSTM(50, return_sequences=True, input_shape=(x_train.shape[1], 1)))
model.add(LSTM(50, return_sequences=False))
model.add(Dense(25))
model.add(Dense(1))

model.compile(optimizer='adam', loss='mean_squared_error')

model.fit(x_train, y_train, batch_size=1, epochs=1)

test_data = scaled_data[trainingDataLen-60: , : ]
x_test = []
y_test = dataset[trainingDataLen: , :]

for i in range(60, len(test_data)):
    x_test.append(test_data[i-60:i, 0])

x_test = np.array(x_test)

x_test = np.reshape(x_test, (x_test.shape[0], x_test.shape[1], 1))

pridiction = model.predict(x_test)
pridiction = scaler.inverse_transform(pridiction)

rmse = np.sqrt(np.mean(pridiction - y_test)**2)
#print(rmse)

train = data[: trainingDataLen]
valid = data[trainingDataLen: ]
valid['Predictions'] = pridiction

plt.figure(figsize=(16, 8))
plt.title('Model')
plt.xlabel('Date', fontsize=18)
plt.ylabel('Close Price USD', fontsize=18)
plt.plot(train['Close'])
plt.plot(valid[['Close', 'Predictions']])
plt.legend(['Train', 'Val', 'Predictions'], loc = 'lower right')
#plt.show()


Apple_quote = web.DataReader(Ma, data_source = nguon, start = batDau, end = ketthuc)
new_df = Apple_quote.filter(['Close'])
last_60_days = new_df[-60:].values
last_60_days_scaled = scaler.transform(last_60_days)

X_test = []
X_test.append(last_60_days_scaled)
X_test = np.array(X_test)
X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], 1))
pred_price = model.predict(X_test)
pred_price = scaler.inverse_transform(pred_price)
print(pred_price)




