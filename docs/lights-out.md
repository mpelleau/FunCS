# Lights Out

[Lights Out](https://en.wikipedia.org/wiki/Lights_Out_(game)) is an electronic game released by Tiger Electronics in 1995.
The game consists of a 5 x 5 grid of lights. The game starts, a random number of lights are switched on. Pressing any of the lights will toggle it and its 4 adjacent lights. The goal of the game is to find the smallest combination of lights in order to switch all the lights off.

## Material
  - 3D Printer and 3D filament
  - [Adafruit Trellis](https://www.adafruit.com/product/1616)
  - [Adafruit Silicon Keypad](https://www.adafruit.com/product/1611)
  - Leds
  - Wires
  - Arduino
  - Soldering iron and solder
  - ø3x12 countersunk head bolts and nuts

## DIY
  1. Print the [box](../LightsOut/3DModels/)
  
  ![Print](../LightsOut/pictures/Print.jpg)
  
  2. Solder the leds on the Trellis
  
  2. For the big board, solder the trellis together and their identification
  
  3. Solder the wires on the Trellis
  4. Fix the Arduino on the bottom of the box
  5. Wire the Trellis to the Arduino
  
  ![Wire on Uno](../LightsOut/pictures/UnoWiring.jpg)![Wire on Leonardo](../LightsOut/pictures/LeonardoWiring.jpg)
  
  6. Assemble the box
  
  ![Assemble](../LightsOut/pictures/Assembler.jpg)
  
  7. Using the [Arduino IDE](https://www.arduino.cc/en/Main/Software) download the [code](code/) on the Arduino
  
  ![Small board](../LightsOut/pictures/small.jpg)![Big board](../LightsOut/pictures/big.jpg)
  
  
## Activity description
  1. Tell the participant the rules of the game
  2. Let them play around and try to switch off the lights
  3. If they are stuck and need some help show them the [light chasing](https://en.wikipedia.org/wiki/Lights_Out_(game)#Light_chasing) strategy
  4. Once solved, press on a fixed number k of lights, tell the participants they can solve it by pressing on k lights
  5. If they still want to play tell them now that they have to turn on all the lights

## References
The material of this activity is based on the following references:
  - 3D Models based on the [Trellis Box](https://www.thingiverse.com/thing:211447)
  - Code based on the [Adafruit Trellis Library](https://github.com/adafruit/Adafruit_Trellis_Library)
  - Activity inspired by the article [Lights Out: A little mathematic game](https://github.com/Mystelven/LightsOuts-Math)

## Sources
  - note in [english](../LightsOut/note.pdf) in [french](../LightsOut/fiche.pdf)
  - 3D models for the [4x4 box](../LightsOut/3DModels/Trellis_box_4x4/) and [8x8 box](../LightsOut/3DModels/Trellis_box_8x8/)
  - code for the [4x4 game](../LightsOut/code/LightsOut4x4.ino) and [8x8 game](../LightsOut/code/LightsOut8x8.ino)