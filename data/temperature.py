import dht11
import RPi.GPIO as GPIO
import sensor
class Temperature:
	def getData(self):
		aux=sensor.Sensor.getInstance().read()
		if not (aux.is_valid()):
			raise NameError('Invalid Temperature')
		return aux.temperature
