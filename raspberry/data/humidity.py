import dht11
import RPi.GPIO as GPIO
import sensor
class Humidity:
	def getData(self):
		aux=sensor.Sensor.getInstance().read()
		if not (aux.is_valid()):
			raise NameError('bad Humidity')
			return
		return aux.humidity
