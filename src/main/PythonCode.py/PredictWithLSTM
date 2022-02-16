import websocket, json
import os, sys
import pyodbc

working = os.getcwd()

Stock = "wss://stream.binance.com:9443/ws/ethusdt@kline_1m"
closes = []
Up_price = []
Down_price = []

i = 0
len_RSI = 14
RSI_BUY = 36
RSI_SELL = 69

diem_cat_lo = 93
gia_dau = 0

def on_open(ws):
    print("Start")
def on_close(ws):
    print("End")
def on_message(ws, message):

    global closes, i

    print('Received')

    json_message = json.loads(message)
    #pprint.pprint(json_message)

    #lay data
    candle = json_message['k']
    check_candle_closed = candle['x']
    close = candle['c']

    if check_candle_closed:
        #print('Candle closed at {}'.format(close))
        closes.append(float(close))
        print(close)
        conx = pyodbc.connect('DRIVER={SQL Server Native Client 11.0}; SERVER=DESKTOP-F3U0QFS\SQLEXPRESS; Database=STOCK_JAVA; UID=sa; PWD=aaa')
        cursor = conx.cursor()
        cursor.execute("UPDATE Trading_BOT set GIA = ?",close)
        conx.commit()
        conx.close()
        #print('closes')
        #print(close)

        #xu ly data
        i += 1
        if i != 1:
            dieu_chinh = closes[-1] - closes[-2]
            if dieu_chinh > 0:
                Up_price.append(dieu_chinh)
            elif dieu_chinh < 0:
                Down_price.append(dieu_chinh*(-1))
        else:
            gia_dau = close

        if len(closes) > 14:
            dot_bien = closes[-1]/closes[-2] * 100
            xoa = closes[-14] - closes[-15]

            if xoa > 0:
                Up_price.pop(0)
            elif xoa < 0:
                Down_price.pop(0)
            #print("ALO")
            rsi = 100 - (100/(1 + sum(Up_price)/sum(Down_price)))
            print("Alo1")
            print(rsi)
            print("Alo2")

            conx = pyodbc.connect('DRIVER={SQL Server Native Client 11.0}; SERVER=DESKTOP-F3U0QFS\SQLEXPRESS; Database=STOCK_JAVA; UID=sa; PWD=aaa')
            cursor = conx.cursor()
            for row in cursor.execute("SELECT TONGTS FROM Trading_BOT WHERE BOT = '1'"):
                tai_san = row[0]
            conx.commit()
            conx.close()

            # cat lo
            if tai_san/20000*100 < diem_cat_lo or close/gia_dau*100 < diem_cat_lo:
                print("SELL ALL")

                conx = pyodbc.connect('DRIVER={SQL Server Native Client 11.0}; SERVER=DESKTOP-F3U0QFS\SQLEXPRESS; Database=STOCK_JAVA; UID=sa; PWD=aaa')
                cursor = conx.cursor()
                cursor.execute("BEGIN DECLARE @GIA FLOAT = ?, @KHOILUONG FLOAT; SELECT @KHOILUONG = KHOILUONG FROM Trading_BOT IF @KHOILUONG >= 0.5 BEGIN UPDATE  Trading_BOT SET TIEN = TIEN + @KHOILUONG * @GIA, KHOILUONG = KHOILUONG-@KHOILUONG, TONGTS = TIEN + KHOILUONG*@GIA, LAI = (TONGTS/20000 - 1)*100 INSERT INTO LStrade VALUES ('B', @KHOILUONG, @GIA) END END",close)
                conx.commit()
                conx.close()
            # giao dich
            else:
                if rsi > RSI_SELL:
                    print('SELL')

                    conx = pyodbc.connect('DRIVER={SQL Server Native Client 11.0}; SERVER=DESKTOP-F3U0QFS\SQLEXPRESS; Database=STOCK_JAVA; UID=sa; PWD=aaa')
                    cursor = conx.cursor()
                    cursor.execute("BEGIN DECLARE @GIA FLOAT = ?, @KHOILUONG FLOAT; SELECT @KHOILUONG = KHOILUONG FROM Trading_BOT IF @KHOILUONG >= 0.5 BEGIN UPDATE  Trading_BOT SET TIEN = TIEN + 0.5 * @GIA, KHOILUONG = KHOILUONG-0.5, TONGTS = TIEN + KHOILUONG*@GIA, LAI = (TONGTS/20000 - 1)*100 INSERT INTO LStrade VALUES ('B', 0.5, @GIA) END END", close)
                    conx.commit()
                    conx.close()
                elif dot_bien < 95:
                    print('SELL')

                    conx = pyodbc.connect('DRIVER={SQL Server Native Client 11.0}; SERVER=DESKTOP-F3U0QFS\SQLEXPRESS; Database=STOCK_JAVA; UID=sa; PWD=aaa')
                    cursor = conx.cursor()
                    cursor.execute("BEGIN DECLARE @GIA FLOAT = ?, @KHOILUONG FLOAT; SELECT @KHOILUONG = KHOILUONG FROM Trading_BOT IF @KHOILUONG >= 0.5 BEGIN UPDATE  Trading_BOT SET TIEN = TIEN + 0.5 * @GIA, KHOILUONG = KHOILUONG-0.5, TONGTS = TIEN + KHOILUONG*@GIA, LAI = (TONGTS/20000 - 1)*100 INSERT INTO LStrade VALUES ('B', 0.5, @GIA) END END", close)
                    conx.commit()
                    conx.close()
                elif rsi < RSI_BUY and dot_bien > 97:
                    print('BUY')

                    conx = pyodbc.connect('DRIVER={SQL Server Native Client 11.0}; SERVER=DESKTOP-F3U0QFS\SQLEXPRESS; Database=STOCK_JAVA; UID=sa; PWD=aaa')
                    cursor = conx.cursor()
                    cursor.execute("BEGIN DECLARE @GIA FLOAT = ?, @TIENCO FLOAT; SELECT @TIENCO = TIEN FROM Trading_BOT IF @TIENCO > @GIA*0.5 BEGIN UPDATE Trading_BOT SET TIEN = TIEN - 0.5 * @GIA, KHOILUONG = KHOILUONG+0.5, TONGTS = TIEN + KHOILUONG*@GIA, LAI = (TONGTS/20000 - 1)*100 INSERT INTO LStrade VALUES ('M', 0.5, @GIA) END END", close)
                    conx.commit()
                    conx.close()



ws = websocket.WebSocketApp(Stock, on_open=on_open, on_close=on_close, on_message=on_message)
ws.run_forever()

