/*
 * MainLED.java
 * 
 * Copyright 2016  paul.spiesberger@sseptp.org
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
 
 /*
  * Execute in Terminal as follows:
  * 
  * 1. javac -cp "lib/*" -d gen in/sse/led/MainLED.java
  * 2. sudo java -cp "./gen:lib/*" in.sse.led.MainLED
  * 
  * 
  * Use Geany's build function "Build->Set Build Commands"
  * 
  * "Java Commands" 
  * "Command" javac -cp "lib/*" -d gen in/sse/led/MainLED.java
  * "Working directory" YOUR_ROOT_PATH (e.g. /home/pi/Documents/Dev/raspberry_LED)
  * 
  * "Java Commands" 
  * "Command" sudo java -cp "./gen:lib/*" in.sse.led.MainLED
  * "Working directory" YOUR_ROOT_PATH (e.g. /home/pi/Documents/Dev/raspberry_LED)
  * 
  */
  
package in.sse.led;
 
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class MainLED {
	
	public static void main(String args[]) throws InterruptedException {
		
		// get a handle to the GPIO controller
    	final GpioController gpio = GpioFactory.getInstance();
        
        // creating the pin with parameter PinState.HIGH
        // will instantly power up the pin
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "PinLED", PinState.HIGH);
        System.out.println("light is: ON");
        
        // wait 1 seconds
        Thread.sleep(1000);
        
        // turn off GPIO 1
        pin.low();
 
        System.out.println("light is: OFF");
        // wait 1 second
        Thread.sleep(1000);
        // turn on GPIO 1 for 1 second and then off
        System.out.println("light is: ON for 1 second");
        pin.pulse(1000, true);
        
        // release the GPIO controller resources
        gpio.shutdown();
	}
}

