# raspberry_LED

This is a sample application for the Raspberry Pi to teach Java with LEDs.

Execute in Terminal as follows:

1. javac -cp "lib/*" -d gen in/sse/led/MainLED.java
2. sudo java -cp "./gen:lib/*" in.sse.led.MainLED
 
 
Use Geany's build function "Build->Set Build Commands"
 
"Java Commands"  <br />
"Command" javac -cp "lib/*" -d gen in/sse/led/MainLED.java  <br />
"Working directory" YOUR_ROOT_PATH (e.g. /home/pi/Documents/Dev/raspberry_LED)
 
"Java Commands"  <br />
"Command" sudo java -cp "./gen:lib/*" in.sse.led.MainLED <br />
"Working directory" YOUR_ROOT_PATH (e.g. /home/pi/Documents/Dev/raspberry_LED)
