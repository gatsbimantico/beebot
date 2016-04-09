import dht11
import RPi.GPIO as GPIO
# initialize GPIO
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()

instance = dht11.DHT11(pin=23)

class Temperature:
	__instance = None
	def __init__(self):
	       if Temperature.__instance is None:
                   Temperature.__instance = dht11.DHT11(pin=23)
	def getData(self):
		aux=Temperature.__instance.read()
		if not (aux.is_valid()):
			raise NameError('Invalid Temperature')
			return
		return aux.temperature

