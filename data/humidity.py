import dht11
import RPi.GPIO as GPIO
# initialize GPIO
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()

instance = dht11.DHT11(pin=23)

class Humidity:
	__instance = None
	def __init__(self):
	       if Humidity.__instance is None:
                   Humidity.__instance = dht11.DHT11(pin=23)
	def getData(self):
		aux=Humidity.__instance.read()
		if not (aux.is_valid()):
			raise NameError('bad Humidity')
			return
		return aux.humidity
