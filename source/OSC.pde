
//OpenSoundControl Management

/////////////////////////////////////////////////////////////////
////////////receiverssssss
/////////////////////////////////////////////////////////////////

/* incoming osc message are forwarded to the oscEvent method. */
void oscEvent(OscMessage theOscMessage) {

  if(theOscMessage.checkAddrPattern("/startup/project")==true) {
     //name of the project
     
     if(projectDefined){
       //send OSC announcement to audioengine
        sendOscString(projectName,100);
     }
     else{
         sendOscString("",100);
     }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/requestdata")==true) {
     //we have to send in order!!! (values arrive PD via OSC non ordered)
     
      sendOsc(Math.round(n1.getValue())+1,33);      
      sendOsc(Math.round(n1.getValue()),33); 
      sendOsc(Math.round(j1.getValue())+1,32);
      sendOsc(Math.round(j1.getValue()),32);   
      sendOsc(Math.round(d1.getValue())+1,31); 
      sendOsc(Math.round(d1.getValue()),31); 
      sendOsc(Math.round(gl1.getValue()),34);
      sendOsc(Math.round(gh1.getValue()),35);
      sendOsc(Math.round(d1.getValue()),31);
    
      sendOsc(Math.round(n2.getValue()),43); 
      sendOsc(Math.round(j2.getValue()),42);   
      sendOsc(Math.round(d2.getValue()),41); 
      sendOsc(Math.round(gl2.getValue()),44);
      sendOsc(Math.round(gh2.getValue()),45);
      
      sendOsc(Math.round(n3.getValue())+1,53); 
      sendOsc(Math.round(n3.getValue()),53); 
      sendOsc(Math.round(j3.getValue())+1,52);  
      sendOsc(Math.round(j3.getValue()),52);   
      sendOsc(Math.round(d3.getValue())+1,51); 
      sendOsc(Math.round(d3.getValue()),51); 
      sendOsc(Math.round(gl3.getValue()),54);
      sendOsc(Math.round(gh3.getValue()),55);
      
      sendOsc(Math.round(n4.getValue()),63); 
      sendOsc(Math.round(j4.getValue()),62);   
      sendOsc(Math.round(d4.getValue()),61); 
      sendOsc(Math.round(gl4.getValue()),64);
      sendOsc(Math.round(gh4.getValue()),65);
     
      sendOsc(Math.round(n5.getValue()),73); 
      sendOsc(Math.round(j5.getValue()),72);   
      sendOsc(Math.round(d5.getValue()),71); 
      sendOsc(Math.round(gl5.getValue()),74);
      sendOsc(Math.round(gh5.getValue()),75);    
      return;
  }
  
//pedals
  if(theOscMessage.checkAddrPattern("/pedal/ch1")==true) {
     if(theOscMessage.typetag().equals("f")){
       if(pedal1Active){ 
          cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).floatValue()*maxdesc1/1000);
          //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).floatValue()));
        }
      if(pedal2Active){ 
          cp5.getController("sliderDescriptor2").setValue(theOscMessage.get(0).floatValue()*maxdesc2/1000);
          //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).floatValue()));
        } 
      if(pedal3Active){ 
          cp5.getController("sliderDescriptor3").setValue(theOscMessage.get(0).floatValue()*maxdesc3/1000);
          //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).floatValue()));
        } 
      if(pedal4Active){ 
          cp5.getController("sliderDescriptor4").setValue(theOscMessage.get(0).floatValue()*maxdesc4/1000);
          //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).floatValue()));
        } 
      if(pedal5Active){ 
          cp5.getController("sliderDescriptor5").setValue(theOscMessage.get(0).floatValue()*maxdesc5/1000);
          //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).floatValue()));
        }   
     }
    if(theOscMessage.typetag().equals("i")){
      if(pedal1Active){ 
         cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).intValue()*maxdesc1/1000);
       //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).intValue()));
      }
      if(pedal2Active){ 
         cp5.getController("sliderDescriptor2").setValue(theOscMessage.get(0).intValue()*maxdesc2/1000);
       //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).intValue()));
      }
      if(pedal3Active){ 
         cp5.getController("sliderDescriptor3").setValue(theOscMessage.get(0).intValue()*maxdesc3/1000);
       //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).intValue()));
      }
      if(pedal4Active){ 
         cp5.getController("sliderDescriptor4").setValue(theOscMessage.get(0).intValue()*maxdesc4/1000);
       //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).intValue()));
      }
      if(pedal5Active){ 
         cp5.getController("sliderDescriptor5").setValue(theOscMessage.get(0).intValue()*maxdesc5/1000);
       //println(cp5.getController("sliderDescriptor1").setValue(theOscMessage.get(0).intValue()));
      }
    }
      return;
  }

  if(theOscMessage.checkAddrPattern("/areaTouched")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("areaTouched").setValue(theOscMessage.get(0).floatValue());
      if(areaSw1Active){
         activeAreaCh1.setValue(Float.toString(theOscMessage.get(0).floatValue()));
         indexAreaCh1 = (int)theOscMessage.get(0).floatValue();
         cp5.getController("sliderDescriptor1").setValue(desCh1[indexAreaCh1]); 
         cp5.getController("jump1").setValue(jumpCh1[indexAreaCh1]); 
         cp5.getController("neighborhood1").setValue(nbhCh1[indexAreaCh1]); 
         cp5.getController("grainLow1").setValue(glCh1[indexAreaCh1]); 
         cp5.getController("grainHigh1").setValue(ghCh1[indexAreaCh1]); 
      }   
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("areaTouched").setValue(theOscMessage.get(0).intValue());
       if(areaSw1Active){
         activeAreaCh1.setValue(Integer.toString(theOscMessage.get(0).intValue()));
         indexAreaCh1 = theOscMessage.get(0).intValue();
         cp5.getController("sliderDescriptor1").setValue(desCh1[indexAreaCh1]);
         cp5.getController("jump1").setValue(jumpCh1[indexAreaCh1]);
         cp5.getController("neighborhood1").setValue(nbhCh1[indexAreaCh1]); 
         cp5.getController("grainLow1").setValue(glCh1[indexAreaCh1]); 
         cp5.getController("grainHigh1").setValue(ghCh1[indexAreaCh1]);   
       }  
    }
      return;
  }
  if(theOscMessage.checkAddrPattern("/areaTouched2")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("areaTouched2").setValue(theOscMessage.get(0).floatValue());
      if(areaSw2Active){
         activeAreaCh2.setValue(Float.toString(theOscMessage.get(0).floatValue()));
         indexAreaCh2 = (int)theOscMessage.get(0).floatValue();
         cp5.getController("sliderDescriptor2").setValue(desCh2[indexAreaCh2]);
         cp5.getController("jump2").setValue(jumpCh2[indexAreaCh2]); 
         cp5.getController("neighborhood2").setValue(nbhCh2[indexAreaCh2]); 
         cp5.getController("grainLow2").setValue(glCh2[indexAreaCh2]); 
         cp5.getController("grainHigh2").setValue(ghCh2[indexAreaCh2]);  
      }   
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("areaTouched2").setValue(theOscMessage.get(0).intValue());
       if(areaSw2Active){
         activeAreaCh2.setValue(Integer.toString(theOscMessage.get(0).intValue()));
         indexAreaCh2 = theOscMessage.get(0).intValue();
         cp5.getController("sliderDescriptor2").setValue(desCh2[indexAreaCh2]);
         cp5.getController("jump2").setValue(jumpCh2[indexAreaCh2]); 
         cp5.getController("neighborhood2").setValue(nbhCh2[indexAreaCh2]); 
         cp5.getController("grainLow2").setValue(glCh2[indexAreaCh2]); 
         cp5.getController("grainHigh2").setValue(ghCh2[indexAreaCh2]);   
       }  
    }
      return;
  }
  if(theOscMessage.checkAddrPattern("/areaTouched3")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("areaTouched3").setValue(theOscMessage.get(0).floatValue());
      if(areaSw3Active){
         activeAreaCh3.setValue(Float.toString(theOscMessage.get(0).floatValue()));
         indexAreaCh3 = (int)theOscMessage.get(0).floatValue();
         cp5.getController("sliderDescriptor3").setValue(desCh3[indexAreaCh3]);
         cp5.getController("jump3").setValue(jumpCh3[indexAreaCh3]); 
         cp5.getController("neighborhood3").setValue(nbhCh3[indexAreaCh3]); 
         cp5.getController("grainLow3").setValue(glCh3[indexAreaCh3]); 
         cp5.getController("grainHigh3").setValue(ghCh3[indexAreaCh3]);   
      }   
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("areaTouched3").setValue(theOscMessage.get(0).intValue());
       if(areaSw3Active){
         activeAreaCh3.setValue(Integer.toString(theOscMessage.get(0).intValue()));
         indexAreaCh3 = theOscMessage.get(0).intValue();
         cp5.getController("sliderDescriptor3").setValue(desCh3[indexAreaCh3]);
         cp5.getController("jump3").setValue(jumpCh3[indexAreaCh3]); 
         cp5.getController("neighborhood3").setValue(nbhCh3[indexAreaCh3]); 
         cp5.getController("grainLow3").setValue(glCh3[indexAreaCh3]); 
         cp5.getController("grainHigh3").setValue(ghCh3[indexAreaCh3]);  
       }  
    }
      return;
  }
  if(theOscMessage.checkAddrPattern("/areaTouched4")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("areaTouched4").setValue(theOscMessage.get(0).floatValue());
      if(areaSw4Active){
         activeAreaCh4.setValue(Float.toString(theOscMessage.get(0).floatValue()));
         indexAreaCh4 = (int)theOscMessage.get(0).floatValue();
         cp5.getController("sliderDescriptor4").setValue(desCh4[indexAreaCh4]);
         cp5.getController("jump4").setValue(jumpCh4[indexAreaCh4]); 
         cp5.getController("neighborhood4").setValue(nbhCh4[indexAreaCh4]); 
         cp5.getController("grainLow4").setValue(glCh4[indexAreaCh4]); 
         cp5.getController("grainHigh4").setValue(ghCh4[indexAreaCh4]);  
      }   
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("areaTouched4").setValue(theOscMessage.get(0).intValue());
       if(areaSw4Active){
         activeAreaCh4.setValue(Integer.toString(theOscMessage.get(0).intValue()));
         indexAreaCh4 = theOscMessage.get(0).intValue();
         cp5.getController("sliderDescriptor4").setValue(desCh4[indexAreaCh4]); 
         cp5.getController("jump4").setValue(jumpCh4[indexAreaCh4]); 
         cp5.getController("neighborhood4").setValue(nbhCh4[indexAreaCh4]); 
         cp5.getController("grainLow4").setValue(glCh4[indexAreaCh4]); 
         cp5.getController("grainHigh4").setValue(ghCh4[indexAreaCh4]); 
       }  
    }
      return;
  }
  if(theOscMessage.checkAddrPattern("/areaTouched5")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("areaTouched5").setValue(theOscMessage.get(0).floatValue());
      if(areaSw5Active){
         activeAreaCh5.setValue(Float.toString(theOscMessage.get(0).floatValue()));
         indexAreaCh5 = (int)theOscMessage.get(0).floatValue();
         cp5.getController("sliderDescriptor5").setValue(desCh5[indexAreaCh5]);
         cp5.getController("jump5").setValue(jumpCh5[indexAreaCh5]); 
         cp5.getController("neighborhood5").setValue(nbhCh5[indexAreaCh5]); 
         cp5.getController("grainLow5").setValue(glCh5[indexAreaCh5]); 
         cp5.getController("grainHigh5").setValue(ghCh5[indexAreaCh5]);  
      }   
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("areaTouched5").setValue(theOscMessage.get(0).intValue());
       if(areaSw5Active){
         activeAreaCh5.setValue(Integer.toString(theOscMessage.get(0).intValue()));
         indexAreaCh5 = theOscMessage.get(0).intValue();
         cp5.getController("sliderDescriptor5").setValue(desCh5[indexAreaCh5]);
         cp5.getController("jump5").setValue(jumpCh5[indexAreaCh5]); 
         cp5.getController("neighborhood5").setValue(nbhCh5[indexAreaCh5]); 
         cp5.getController("grainLow5").setValue(glCh5[indexAreaCh5]); 
         cp5.getController("grainHigh5").setValue(ghCh5[indexAreaCh5]);   
       }  
    }
      return;
  }
  
  //THRESHOLDS CHANGE FROM MIDI DEVICE VIA PD
  if(theOscMessage.checkAddrPattern("/thres/t1")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("Thres1").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("Thres1").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  if(theOscMessage.checkAddrPattern("/thres/t2")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("Thres2").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("Thres2").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  if(theOscMessage.checkAddrPattern("/thres/t3")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("Thres3").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("Thres3").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  
  
  if(theOscMessage.checkAddrPattern("/slider/ch1")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH1Input").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH1Input").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch2")==true) {
    if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH2Input").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH2Input").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch3")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH3Input").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH3Input").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch4")==true) {
    if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH4Input").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH4Input").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch5")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH5Input").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH5Input").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch1o")==true) {
     
    if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH1Output").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH1Output").setValue(theOscMessage.get(0).intValue());
    }   
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch2o")==true) {
    if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH2Output").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH2Output").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch3o")==true) {
    if(theOscMessage.typetag().equals("f")){ 
     cp5.getController("CH3Output").setValue(theOscMessage.get(0).floatValue());
    }
    if(theOscMessage.typetag().equals("i")){ 
     cp5.getController("CH3Output").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch4o")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH4Output").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH4Output").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/slider/ch5o")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("CH5Output").setValue(theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("CH5Output").setValue(theOscMessage.get(0).intValue());
    }
      return;
  }
  
  //part of capacitive interface
    if(theOscMessage.checkAddrPattern("/cap/partMap")==true) {
     if(theOscMessage.typetag().equals("f")){
      if(theOscMessage.get(0).floatValue()==1){
        cp5.getController("sliderDescriptor1").setValue(maxdesc1/6);
      }
      if(theOscMessage.get(0).floatValue()==2){
        cp5.getController("sliderDescriptor1").setValue(2*maxdesc1/6);
      }
      if(theOscMessage.get(0).floatValue()==3){
        cp5.getController("sliderDescriptor1").setValue(3*maxdesc1/6);
      }
      if(theOscMessage.get(0).floatValue()==4){
        cp5.getController("sliderDescriptor1").setValue(4*maxdesc1/6);
      }
      if(theOscMessage.get(0).floatValue()==5){
        cp5.getController("sliderDescriptor1").setValue(5*maxdesc1/6);
      }
      if(theOscMessage.get(0).floatValue()==6){
        cp5.getController("sliderDescriptor1").setValue((6*maxdesc1/6)-10);
      }
    
      
      
     }
    if(theOscMessage.typetag().equals("i")){
       if(theOscMessage.get(0).intValue()==1){
        cp5.getController("sliderDescriptor1").setValue(maxdesc1/6);
      }
      if(theOscMessage.get(0).intValue()==2){
        cp5.getController("sliderDescriptor1").setValue(2*maxdesc1/6);
      }
      if(theOscMessage.get(0).intValue()==3){
        cp5.getController("sliderDescriptor1").setValue(3*maxdesc1/6);
      }
      if(theOscMessage.get(0).intValue()==4){
        cp5.getController("sliderDescriptor1").setValue(4*maxdesc1/6);
      }
      if(theOscMessage.get(0).intValue()==5){
        cp5.getController("sliderDescriptor1").setValue(5*maxdesc1/6);
      }
      if(theOscMessage.get(0).intValue()==6){
        cp5.getController("sliderDescriptor1").setValue((6*maxdesc1/6)-10);
      }
    }
      return;
  }
  
  //RECEIVE MAX NUMBER OF DESCRIPTORS
  if(theOscMessage.checkAddrPattern("/descriptor/1")==true) {
     if(theOscMessage.typetag().equals("f")){ 
        cp5.getController("showMaxDescriptor1").setValue(theOscMessage.get(0).floatValue());
        maxdesc1 = theOscMessage.get(0).floatValue();
        //cp5.getController("sliderDescriptor1").setRange(0,theOscMessage.get(0).());
        d1.setRange(0,theOscMessage.get(0).floatValue());
        n1.setRange(0,theOscMessage.get(0).floatValue()/2);
        n1.setValue(theOscMessage.get(0).floatValue()/4);
        nb1.setRange(0,theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("showMaxDescriptor1").setValue(theOscMessage.get(0).intValue());
       maxdesc1 = theOscMessage.get(0).intValue();
       //cp5.getController("sliderDescriptor1").setRange(0,theOscMessage.get(0).intValue());
       d1.setRange(0,theOscMessage.get(0).intValue());
       n1.setRange(0,theOscMessage.get(0).intValue()/2);
       n1.setValue(theOscMessage.get(0).intValue()/4);
       nb1.setRange(0,theOscMessage.get(0).intValue());
    }
      return;
  }
  if(theOscMessage.checkAddrPattern("/descriptor/2")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("showMaxDescriptor2").setValue(theOscMessage.get(0).floatValue());
      maxdesc2 = theOscMessage.get(0).floatValue();
        d2.setRange(0,theOscMessage.get(0).floatValue());
        n2.setRange(0,theOscMessage.get(0).floatValue()/2);
        n2.setValue(theOscMessage.get(0).floatValue()/4);
        nb2.setRange(0,theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("showMaxDescriptor2").setValue(theOscMessage.get(0).intValue());
       maxdesc2 = theOscMessage.get(0).intValue();
       d2.setRange(0,theOscMessage.get(0).intValue());
       n2.setRange(0,theOscMessage.get(0).intValue()/2);
       n2.setValue(theOscMessage.get(0).intValue()/4);
       nb2.setRange(0,theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/descriptor/3")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("showMaxDescriptor3").setValue(theOscMessage.get(0).floatValue());
      maxdesc3 = theOscMessage.get(0).floatValue();
        d3.setRange(0,theOscMessage.get(0).floatValue());
        n3.setRange(0,theOscMessage.get(0).floatValue()/2);
        n3.setValue(theOscMessage.get(0).floatValue()/4);
        nb3.setRange(0,theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("showMaxDescriptor3").setValue(theOscMessage.get(0).intValue());
       maxdesc3 = theOscMessage.get(0).intValue();
       d3.setRange(0,theOscMessage.get(0).intValue());
       n3.setRange(0,theOscMessage.get(0).intValue()/2);
       n3.setValue(theOscMessage.get(0).intValue()/4);
       nb3.setRange(0,theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/descriptor/4")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("showMaxDescriptor4").setValue(theOscMessage.get(0).floatValue());
      maxdesc4 = theOscMessage.get(0).floatValue();
        d4.setRange(0,theOscMessage.get(0).floatValue());
        n4.setRange(0,theOscMessage.get(0).floatValue()/2);
        n4.setValue(theOscMessage.get(0).floatValue()/4);
        nb4.setRange(0,theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("showMaxDescriptor4").setValue(theOscMessage.get(0).intValue());
       maxdesc4 = theOscMessage.get(0).intValue();
       d4.setRange(0,theOscMessage.get(0).intValue());
       n4.setRange(0,theOscMessage.get(0).intValue()/2);
       n4.setValue(theOscMessage.get(0).intValue()/4);
       nb4.setRange(0,theOscMessage.get(0).intValue());
    }
      return;
  }
  
  if(theOscMessage.checkAddrPattern("/descriptor/5")==true) {
     if(theOscMessage.typetag().equals("f")){ 
      cp5.getController("showMaxDescriptor5").setValue(theOscMessage.get(0).floatValue());
        maxdesc5 = theOscMessage.get(0).floatValue();
        d5.setRange(0,theOscMessage.get(0).floatValue());
        n5.setRange(0,theOscMessage.get(0).floatValue()/2);
        n5.setValue(theOscMessage.get(0).floatValue()/4);
        nb5.setRange(0,theOscMessage.get(0).floatValue());
     }
    if(theOscMessage.typetag().equals("i")){
       cp5.getController("showMaxDescriptor5").setValue(theOscMessage.get(0).intValue());
       maxdesc5 = theOscMessage.get(0).intValue();
       d5.setRange(0,theOscMessage.get(0).intValue());
       n5.setRange(0,theOscMessage.get(0).intValue()/2);
       n5.setValue(theOscMessage.get(0).intValue()/4);
       nb5.setRange(0,theOscMessage.get(0).intValue());
    }
      return;
  }
  
  
}



/////////////////////////////////////////////////////////////////
////////////senders
/////////////////////////////////////////////////////////////////

void sendOsc(int value, int parameter) {
  /* in the following different ways of creating osc messages are shown by example */
  
  if(parameter==0){
    OscMessage myMessage = new OscMessage("/projectchange");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 } 
  
  if(parameter==1){
    OscMessage myMessage = new OscMessage("/ch1Vol");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 } 
 
 if(parameter==2){
    OscMessage myMessage = new OscMessage("/ch2Vol");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==3){
    OscMessage myMessage = new OscMessage("/ch3Vol");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 } 
 
 if(parameter==4){
    OscMessage myMessage = new OscMessage("/ch4Vol");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==5){
    OscMessage myMessage = new OscMessage("/ch5Vol");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==6){
    OscMessage myMessage = new OscMessage("/thres1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
    
 } 
 
 if(parameter==7){
    OscMessage myMessage = new OscMessage("/thres2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==8){
    OscMessage myMessage = new OscMessage("/thres3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 } 
 
 if(parameter==9){
    OscMessage myMessage = new OscMessage("/thres4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==10){
    OscMessage myMessage = new OscMessage("/thres5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
  if(parameter==11){
    OscMessage myMessage = new OscMessage("/activate1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==12){
    OscMessage myMessage = new OscMessage("/activate2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==13){
    OscMessage myMessage = new OscMessage("/activate3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==14){
    OscMessage myMessage = new OscMessage("/activate4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==15){
    OscMessage myMessage = new OscMessage("/activate5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==16){
    OscMessage myMessage = new OscMessage("/activate1in");
    println("toggle sent:" + value);
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==17){
    OscMessage myMessage = new OscMessage("/activate2in");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==18){
    OscMessage myMessage = new OscMessage("/activate3in");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==19){
    OscMessage myMessage = new OscMessage("/activate4in");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==20){
    OscMessage myMessage = new OscMessage("/activate5in");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==21){
    OscMessage myMessage = new OscMessage("/activate1out");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==22){
    OscMessage myMessage = new OscMessage("/activate2out");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==23){
    OscMessage myMessage = new OscMessage("/activate3out");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==24){
    OscMessage myMessage = new OscMessage("/activate4out");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==25){
    OscMessage myMessage = new OscMessage("/activate5out");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 
 if(parameter==31){
    OscMessage myMessage = new OscMessage("/search1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==32){
    OscMessage myMessage = new OscMessage("/jump1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==33){
    OscMessage myMessage = new OscMessage("/neighborhood1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==34){
    OscMessage myMessage = new OscMessage("/grainLow1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==35){
    OscMessage myMessage = new OscMessage("/grainHigh1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==41){
    OscMessage myMessage = new OscMessage("/search2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==42){
    OscMessage myMessage = new OscMessage("/jump2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==43){
    OscMessage myMessage = new OscMessage("/neighborhood2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==44){
    OscMessage myMessage = new OscMessage("/grainLow2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==45){
    OscMessage myMessage = new OscMessage("/grainHigh2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==51){
    OscMessage myMessage = new OscMessage("/search3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==52){
    OscMessage myMessage = new OscMessage("/jump3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==53){
    OscMessage myMessage = new OscMessage("/neighborhood3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==54){
    OscMessage myMessage = new OscMessage("/grainLow3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==55){
    OscMessage myMessage = new OscMessage("/grainHigh3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==61){
    OscMessage myMessage = new OscMessage("/search4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==62){
    OscMessage myMessage = new OscMessage("/jump4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==63){
    OscMessage myMessage = new OscMessage("/neighborhood4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==64){
    OscMessage myMessage = new OscMessage("/grainLow4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==65){
    OscMessage myMessage = new OscMessage("/grainHigh4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==71){
    OscMessage myMessage = new OscMessage("/search5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==72){
    OscMessage myMessage = new OscMessage("/jump5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==73){
    OscMessage myMessage = new OscMessage("/neighborhood5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==74){
    OscMessage myMessage = new OscMessage("/grainLow5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==75){
    OscMessage myMessage = new OscMessage("/grainHigh5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 
 if(parameter==121){
    OscMessage myMessage = new OscMessage("/analyze1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==122){
    OscMessage myMessage = new OscMessage("/analyze2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==123){
    OscMessage myMessage = new OscMessage("/analyze3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==124){
    OscMessage myMessage = new OscMessage("/analyze4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==125){
    OscMessage myMessage = new OscMessage("/analyze5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 
}

void sendOscString(String value, int parameter) {

  if(parameter==100){
    
    //println("received for sending to Pd: " + value);
    OscMessage myMessage = new OscMessage("/project");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
    //println("sent to Pd: " + myMessage);
 }
  
  if(parameter==111){
    
    //println("received for sending to Pd: " + value);
    OscMessage myMessage = new OscMessage("/soundfile1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
    //println("sent to Pd: " + myMessage);
 }
 if(parameter==112){
    OscMessage myMessage = new OscMessage("/soundfile2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==113){
    OscMessage myMessage = new OscMessage("/soundfile3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==114){
    OscMessage myMessage = new OscMessage("/soundfile4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==115){
    OscMessage myMessage = new OscMessage("/soundfile5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 
 if(parameter==116){
    
    //println("received for sending to Pd: " + value);
    OscMessage myMessage = new OscMessage("/soundfile1name");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
    //println("sent to Pd: " + myMessage);
 }
 if(parameter==117){
    OscMessage myMessage = new OscMessage("/soundfile2name");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==118){
    OscMessage myMessage = new OscMessage("/soundfile3name");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==119){
    OscMessage myMessage = new OscMessage("/soundfile4name");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==120){
    OscMessage myMessage = new OscMessage("/soundfile5name");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
  
  if(parameter==121){
    
    //println("received for sending to Pd: " + value);
    OscMessage myMessage = new OscMessage("/presetsoundfile1");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
    //println("sent to Pd: " + myMessage);
 }
 if(parameter==122){
    OscMessage myMessage = new OscMessage("/presetsoundfile2");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==123){
    OscMessage myMessage = new OscMessage("/presetsoundfile3");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==124){
    OscMessage myMessage = new OscMessage("/presetsoundfile4");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
 if(parameter==125){
    OscMessage myMessage = new OscMessage("/presetsoundfile5");
  
    myMessage.add(value); /* add an int to the osc message */

    /* send the message */
    oscP5.send(myMessage, myRemoteLocation);
 }
}


