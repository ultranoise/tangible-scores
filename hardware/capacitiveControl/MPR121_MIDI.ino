/*********************************************************
This is a library for the MPR121 12-channel Capacitive touch sensor

Designed specifically to work with the MPR121 Breakout in the Adafruit shop 
  ----> https://www.adafruit.com/products/

These sensors use I2C communicate, at least 2 pins are required 
to interface

Adafruit invests time and resources providing this open source code, 
please support Adafruit and open-source hardware by purchasing 
products from Adafruit!

Written by Limor Fried/Ladyada for Adafruit Industries.  
BSD license, all text above must be included in any redistribution
**********************************************************/


#include <Wire.h>
#include "Adafruit_MPR121.h"

// the MIDI channel number to send messages
const int channel = 1;
int pin = 13;

// You can have up to 4 on one i2c bus but one is enough for testing!
Adafruit_MPR121 cap = Adafruit_MPR121();

// Keeps track of the last pins touched
// so we know when buttons are 'released'
uint16_t lasttouched = 0;
uint16_t currtouched = 0;

int highThres = 4;
int lowThres = 3;
float pinc = 0;

void OnControlChange(byte channel, byte control, byte value)
{
  /*
  if(control == 3){
    highThres = value;
    usbMIDI.sendControlChange(11, highThres, channel);
  }
  if(control == 2){
    lowThres = value;
    usbMIDI.sendControlChange(12, lowThres, channel);
  }
  cap.setThreshholds(highThres, lowThres);
  */

  //alternative control
  if((control -1) % 2 == 0) {  //es el high
    cap.setThresholdH(value,(pin-1)/2);
    highThres = value;
    usbMIDI.sendControlChange(11, highThres, channel);
  }
  else { //es el low
    cap.setThresholdL(value,(pin-2)/2);
    lowThres = value;
    usbMIDI.sendControlChange(12, lowThres, channel);
  }
  cap.setThreshholds(highThres, lowThres);

  cap.writeRegister(MPR121_ECR, 0x0);
  cap.setThresholds(highThres,lowThres);
  cap.writeRegister(MPR121_ECR, 0x8F);

   
}


void setup() {

  //just to see the board is alive
  pinMode(13, OUTPUT);
  digitalWrite(13, HIGH);   
  delay(1000);
  digitalWrite(13, LOW);   
  delay(1000);
  digitalWrite(13, HIGH); 
    
  
  // Default address is 0x5A, if tied to 3.3V its 0x5B
  // If tied to SDA its 0x5C and if SCL then 0x5D
  if (!cap.begin(0x5A)) {
    digitalWrite(13, LOW); 
  }
  digitalWrite(13, HIGH); //if found board LED must be on

  cap.setThreshholds(highThres, lowThres);

  //alternative
  //cap.setThreshold(highThres, lowThres,5);

  cap.setThresholdH(highThres,5);
  cap.setThresholdL(lowThres,5);

  //set Handle for listening MIDI in (CCs)
  usbMIDI.setHandleControlChange(OnControlChange);
}

void loop() {
  
  // Get the currently touched pads
  currtouched = cap.touched();
  
  for (uint8_t i=0; i<12; i++) {
    // it if *is* touched and *wasnt* touched before, alert!
    if ((currtouched & _BV(i)) && !(lasttouched & _BV(i)) ) {
      //Serial.print(i); Serial.println(" touched");
      usbMIDI.sendNoteOn(60 + i, 99, channel);
    }
    // if it *was* touched and now *isnt*, alert!
    if (!(currtouched & _BV(i)) && (lasttouched & _BV(i)) ) {
      //Serial.print(i); Serial.println(" released");
      usbMIDI.sendNoteOff(60 + i, 0, channel);
    }
  }

  // reset our state
  lasttouched = currtouched;

  usbMIDI.read();

  
  
  /*
  // uncomment out this line for detailed data from the sensor!
  // debugging info, what
  Serial.print("\t\t\t\t\t\t\t\t\t\t\t\t\t 0x"); Serial.println(cap.touched(), HEX);
  Serial.print("Filt: ");
  for (uint8_t i=0; i<12; i++) {
    Serial.print(cap.filteredData(i)); Serial.print("\t");
  }
  Serial.println();
  Serial.print("Base: ");
  for (uint8_t i=0; i<12; i++) {
    Serial.print(cap.baselineData(i)); Serial.print("\t");
  }
  Serial.println();
  
  // put a delay so it isn't overwhelming
  delay(100);
  */


  
}


