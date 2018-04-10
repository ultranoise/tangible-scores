

//////////////////////////////////////////////////////////////
//LISTENERS / FUNCTIONS / OTHER STUFF
//////////////////////////////////////////////////////////////



  //ADD ITEM TO THE PRESET LIST AFTER TYPING+INTRO
  
  public void savePresetField(String theText) {
    // automatically receives results from controller input
    if(projectSaved) {
        
        File f = new File(projectPath + "/" + theText + ".ser");
        if(f.exists() && !f.isDirectory()) { 
          println("Project exists, replacing...");
        } else {
          ListBoxItem lbi =l.addItem(theText, presetCounter); 
          presetCounter=presetCounter+1;
        }
        
        
        //create new set and add the properties we want to save
        cp5.getProperties().addSet(theText);
        
        cp5.getProperties().move(cp5.getController("sliderDescriptor1"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump1"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood1"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow1"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh1"), "default", theText);
        cp5.getProperties().move(cp5.getController("sliderDescriptor2"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump2"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood2"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow2"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh2"), "default", theText);
        cp5.getProperties().move(cp5.getController("sliderDescriptor3"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump3"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood3"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow3"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh3"), "default", theText);
        cp5.getProperties().move(cp5.getController("sliderDescriptor4"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump4"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood4"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow4"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh4"), "default", theText);
        cp5.getProperties().move(cp5.getController("sliderDescriptor5"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump5"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood5"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow5"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh5"), "default", theText);
        
        cp5.getProperties().move(cp5.getController("showMaxDescriptor1"), "default", theText);
        cp5.getProperties().move(cp5.getController("showMaxDescriptor2"), "default", theText);
        cp5.getProperties().move(cp5.getController("showMaxDescriptor3"), "default", theText);
        cp5.getProperties().move(cp5.getController("showMaxDescriptor4"), "default", theText);
        cp5.getProperties().move(cp5.getController("showMaxDescriptor5"), "default", theText);
        
        
        //we add audio files names too
        cp5.getProperties().move(cp5.getController("activeSoundfile1"), "default", theText);
        cp5.getProperties().move(cp5.getController("activeSoundfile2"), "default", theText);
        cp5.getProperties().move(cp5.getController("activeSoundfile3"), "default", theText);
        cp5.getProperties().move(cp5.getController("activeSoundfile4"), "default", theText);
        cp5.getProperties().move(cp5.getController("activeSoundfile5"), "default", theText);
        
        //and important items from the default tab
        cp5.getProperties().move(cp5.getController("CH1Vol"), "default", theText);
        cp5.getProperties().move(cp5.getController("CH2Vol"), "default", theText);
        cp5.getProperties().move(cp5.getController("CH3Vol"), "default", theText);
        cp5.getProperties().move(cp5.getController("CH4Vol"), "default", theText);
        cp5.getProperties().move(cp5.getController("CH5Vol"), "default", theText);
        
        cp5.getProperties().move(cp5.getController("Thres1"), "default", theText);
        cp5.getProperties().move(cp5.getController("Thres2"), "default", theText);
        cp5.getProperties().move(cp5.getController("Thres3"), "default", theText);
        cp5.getProperties().move(cp5.getController("Thres4"), "default", theText);
        cp5.getProperties().move(cp5.getController("Thres5"), "default", theText);
        
        cp5.getProperties().move(cp5.getController("input1"), "default", theText);
        cp5.getProperties().move(cp5.getController("input2"), "default", theText);
        cp5.getProperties().move(cp5.getController("input3"), "default", theText);
        cp5.getProperties().move(cp5.getController("input4"), "default", theText);
        cp5.getProperties().move(cp5.getController("input5"), "default", theText);
        
        cp5.getProperties().move(cp5.getController("output1"), "default", theText);
        cp5.getProperties().move(cp5.getController("output2"), "default", theText);
        cp5.getProperties().move(cp5.getController("output3"), "default", theText);
        cp5.getProperties().move(cp5.getController("output4"), "default", theText);
        cp5.getProperties().move(cp5.getController("output5"), "default", theText);
        
        // prints the current list of properties registered and the set(s) they belong to 
        //cp5.getProperties().print();
        
        cp5.saveProperties(projectPath + "/" + theText + ".ser", theText);
        
        //update Active Preset Field
        activePresetField.setValue(theText);
        
        println("saving data variables to string files");
 
        String[] desCh1String = new String[100];
        for (int i=0;i<100;i++) {
          desCh1String[i] = Integer.toString(desCh1[i]);
        }
        String[] jumpCh1String = new String[100];
        for (int i=0;i<100;i++) {
          jumpCh1String[i] = Integer.toString(jumpCh1[i]);
        }
        String[] nbhCh1String = new String[100];
        for (int i=0;i<100;i++) {
          nbhCh1String[i] = Integer.toString(nbhCh1[i]);
        }
        String[] glCh1String = new String[100];
        for (int i=0;i<100;i++) {
          glCh1String[i] = Integer.toString(glCh1[i]);
        }
        String[] ghCh1String = new String[100];
        for (int i=0;i<100;i++) {
          ghCh1String[i] = Integer.toString(ghCh1[i]);
        }
        
        
        String[] desCh2String = new String[100];
        for (int i=0;i<100;i++) {
          desCh2String[i] = Integer.toString(desCh2[i]);
        }
        String[] jumpCh2String = new String[100];
        for (int i=0;i<100;i++) {
          jumpCh2String[i] = Integer.toString(jumpCh2[i]);
        }
        String[] nbhCh2String = new String[100];
        for (int i=0;i<100;i++) {
          nbhCh2String[i] = Integer.toString(nbhCh2[i]);
        }
        String[] glCh2String = new String[100];
        for (int i=0;i<100;i++) {
          glCh2String[i] = Integer.toString(glCh2[i]);
        }
        String[] ghCh2String = new String[100];
        for (int i=0;i<100;i++) {
          ghCh2String[i] = Integer.toString(ghCh2[i]);
        }
        
        
        String[] desCh3String = new String[100];
        for (int i=0;i<100;i++) {
          desCh3String[i] = Integer.toString(desCh3[i]);
        }
        String[] jumpCh3String = new String[100];
        for (int i=0;i<100;i++) {
          jumpCh3String[i] = Integer.toString(jumpCh3[i]);
        }
        String[] nbhCh3String = new String[100];
        for (int i=0;i<100;i++) {
          nbhCh3String[i] = Integer.toString(nbhCh3[i]);
        }
        String[] glCh3String = new String[100];
        for (int i=0;i<100;i++) {
          glCh3String[i] = Integer.toString(glCh3[i]);
        }
        String[] ghCh3String = new String[100];
        for (int i=0;i<100;i++) {
          ghCh3String[i] = Integer.toString(ghCh3[i]);
        }
        
              
        String[] desCh4String = new String[100];
        for (int i=0;i<100;i++) {
          desCh4String[i] = Integer.toString(desCh4[i]);
        }
        String[] jumpCh4String = new String[100];
        for (int i=0;i<100;i++) {
          jumpCh4String[i] = Integer.toString(jumpCh4[i]);
        }
        String[] nbhCh4String = new String[100];
        for (int i=0;i<100;i++) {
          nbhCh4String[i] = Integer.toString(nbhCh4[i]);
        }
        String[] glCh4String = new String[100];
        for (int i=0;i<100;i++) {
          glCh4String[i] = Integer.toString(glCh4[i]);
        }
        String[] ghCh4String = new String[100];
        for (int i=0;i<100;i++) {
          ghCh4String[i] = Integer.toString(ghCh4[i]);
        }
        
        
        
        String[] desCh5String = new String[100];
        for (int i=0;i<100;i++) {
          desCh5String[i] = Integer.toString(desCh5[i]);
        }
        String[] jumpCh5String = new String[100];
        for (int i=0;i<100;i++) {
          jumpCh5String[i] = Integer.toString(jumpCh5[i]);
        }
        String[] nbhCh5String = new String[100];
        for (int i=0;i<100;i++) {
          nbhCh5String[i] = Integer.toString(nbhCh5[i]);
        }
        String[] glCh5String = new String[100];
        for (int i=0;i<100;i++) {
          glCh5String[i] = Integer.toString(glCh5[i]);
        }
        String[] ghCh5String = new String[100];
        for (int i=0;i<100;i++) {
          ghCh5String[i] = Integer.toString(ghCh5[i]);
        }

        // Writes the strings to a file, each on a separate line
        saveStrings(projectPath + "/" + theText + "desCh1.txt", desCh1String);
        saveStrings(projectPath + "/" + theText + "jumpCh1.txt", jumpCh1String);
        saveStrings(projectPath + "/" + theText + "nbhCh1.txt", nbhCh1String);
        saveStrings(projectPath + "/" + theText + "glCh1.txt", glCh1String);
        saveStrings(projectPath + "/" + theText + "ghCh1.txt", ghCh1String);
        
        saveStrings(projectPath + "/" + theText + "desCh2.txt", desCh2String);
        saveStrings(projectPath + "/" + theText + "jumpCh2.txt", jumpCh2String);
        saveStrings(projectPath + "/" + theText + "nbhCh2.txt", nbhCh2String);
        saveStrings(projectPath + "/" + theText + "glCh2.txt", glCh2String);
        saveStrings(projectPath + "/" + theText + "ghCh2.txt", ghCh2String);
        
        saveStrings(projectPath + "/" + theText + "desCh3.txt", desCh3String);
        saveStrings(projectPath + "/" + theText + "jumpCh3.txt", jumpCh3String);
        saveStrings(projectPath + "/" + theText + "nbhCh3.txt", nbhCh3String);
        saveStrings(projectPath + "/" + theText + "glCh3.txt", glCh3String);
        saveStrings(projectPath + "/" + theText + "ghCh3.txt", ghCh3String);
        
        saveStrings(projectPath + "/" + theText + "desCh4.txt", desCh4String);
        saveStrings(projectPath + "/" + theText + "jumpCh4.txt", jumpCh4String);
        saveStrings(projectPath + "/" + theText + "nbhCh4.txt", nbhCh4String);
        saveStrings(projectPath + "/" + theText + "glCh4.txt", glCh4String);
        saveStrings(projectPath + "/" + theText + "ghCh4.txt", ghCh4String);
        
        saveStrings(projectPath + "/" + theText + "desCh5.txt", desCh5String);
        saveStrings(projectPath + "/" + theText + "jumpCh5.txt", jumpCh5String);
        saveStrings(projectPath + "/" + theText + "nbhCh5.txt", nbhCh5String);
        saveStrings(projectPath + "/" + theText + "glCh5.txt", glCh5String);
        saveStrings(projectPath + "/" + theText + "ghCh5.txt", ghCh5String);
        //end
        println("Instrument saved as: "+theText);
        
        
    } else {
      //pop up or whatever saying user must save the project
    }
  }
  
  public void areaEditCh1(String theText) {
    //update Active Area Field
     activeAreaCh1.setValue(theText);
     indexAreaCh1 = Integer.parseInt(theText);
     cp5.getController("sliderDescriptor1").setValue(desCh1[indexAreaCh1]);
     
     //ahora para jump1 y el resto
     cp5.getController("jump1").setValue(jumpCh1[indexAreaCh1]);
     cp5.getController("neighborhood1").setValue(nbhCh1[indexAreaCh1]);
     cp5.getController("grainLow1").setValue(glCh1[indexAreaCh1]);
     cp5.getController("grainHigh1").setValue(ghCh1[indexAreaCh1]);
          
     println("area1 editing: "+theText);
  }
  public void areaEditCh2(String theText) {
    //update Active Area Field
     activeAreaCh2.setValue(theText);
     indexAreaCh2 = Integer.parseInt(theText);
     cp5.getController("sliderDescriptor2").setValue(desCh2[indexAreaCh2]);
     
     //ahora para jump1 y el resto
     cp5.getController("jump2").setValue(jumpCh2[indexAreaCh2]);
     cp5.getController("neighborhood2").setValue(nbhCh2[indexAreaCh2]);
     cp5.getController("grainLow2").setValue(glCh2[indexAreaCh2]);
     cp5.getController("grainHigh2").setValue(ghCh2[indexAreaCh2]);
          
     println("area2 editing: "+theText);
  }
  public void areaEditCh3(String theText) {
    //update Active Area Field
     activeAreaCh3.setValue(theText);
     indexAreaCh3 = Integer.parseInt(theText);
     cp5.getController("sliderDescriptor3").setValue(desCh3[indexAreaCh3]);
          
     //ahora para jump1 y el resto
     cp5.getController("jump3").setValue(jumpCh3[indexAreaCh3]);
     cp5.getController("neighborhood3").setValue(nbhCh3[indexAreaCh3]);
     cp5.getController("grainLow3").setValue(glCh3[indexAreaCh3]);
     cp5.getController("grainHigh3").setValue(ghCh3[indexAreaCh3]);     
          
     println("area3 editing: "+theText);
  }
  public void areaEditCh4(String theText) {
    //update Active Area Field
     activeAreaCh4.setValue(theText);
     indexAreaCh4 = Integer.parseInt(theText);
     cp5.getController("sliderDescriptor4").setValue(desCh4[indexAreaCh4]);
          
     //ahora para jump1 y el resto
     cp5.getController("jump4").setValue(jumpCh4[indexAreaCh4]);
     cp5.getController("neighborhood4").setValue(nbhCh4[indexAreaCh4]);
     cp5.getController("grainLow4").setValue(glCh4[indexAreaCh4]);
     cp5.getController("grainHigh4").setValue(ghCh4[indexAreaCh4]);     
          
     println("area4 editing: "+theText);
  }
  public void areaEditCh5(String theText) {
    //update Active Area Field
     activeAreaCh5.setValue(theText);
     indexAreaCh5 = Integer.parseInt(theText);
     cp5.getController("sliderDescriptor5").setValue(desCh5[indexAreaCh5]);
     
     //ahora para jump1 y el resto
     cp5.getController("jump5").setValue(jumpCh5[indexAreaCh5]);
     cp5.getController("neighborhood5").setValue(nbhCh5[indexAreaCh5]);
     cp5.getController("grainLow5").setValue(glCh5[indexAreaCh5]);
     cp5.getController("grainHigh5").setValue(ghCh5[indexAreaCh5]);     
          
     println("area5 editing: "+theText);
  }  
  
  public void saveProjectAsField(String theText) {
    // automatically receives results from controller input
    println("Project saved : "+theText);
    
    projectPath = dataPath("") + "/projects/" + theText;
    File dir = new File(projectPath);
    dir.mkdir();
    
    //channels subdirectories
    String subdir = dataPath("") + "/projects/" + theText + "/ch1/";
     dir = new File(subdir);
    dir.mkdir();
    
    subdir = dataPath("") + "/projects/" + theText + "/ch2/";
    dir = new File(subdir);
    dir.mkdir();
    
    subdir = dataPath("") + "/projects/" + theText + "/ch3/";
    dir = new File(subdir);
    dir.mkdir();
    
    subdir = dataPath("") + "/projects/" + theText + "/ch4/";
    dir = new File(subdir);
    dir.mkdir();
    
    subdir = dataPath("") + "/projects/" + theText + "/ch5/";
    dir = new File(subdir);
    dir.mkdir();
    
    projectName = theText;
    projectDefined = true;
    //send OSC announcement to audioengine
    sendOscString(projectName,100);
    
    
    ListBoxItem pbi =p.addItem(theText, projectCounter); 
    projectCounter=projectCounter+1;
    
    //create new set and add the properties we want to save
    
    
    //update Active Project Field
    activeProjectField.setValue(theText);
    
    //save snapshot
    //cp5.getProperties().setSnapshot(theText);
    
  }
  
  
  
  
  //Update search sliders when dragging their numberboxes
  void numberboxDescriptor1(int theInt) {
    d1.setValue(theInt);
  }
  void numberboxDescriptor2(int theInt) {
    d2.setValue(theInt);
  }
  void numberboxDescriptor3(int theInt) {
    d3.setValue(theInt);
  }
  void numberboxDescriptor4(int theInt) {
    d4.setValue(theInt);
  }
  void numberboxDescriptor5(int theInt) {
    d5.setValue(theInt);
  }

 void showMaxDescriptor1(int theInt) {
    maxdesc1=theInt;
  }
  void showMaxDescriptor2(int theInt) {
    maxdesc2=theInt;
  }
  void showMaxDescriptor3(int theInt) {
    maxdesc3=theInt;
  }
  void showMaxDescriptor4(int theInt) {
    maxdesc4=theInt;
  }
  void showMaxDescriptor5(int theInt) {
    maxdesc5=theInt;
  }

  // GET EVENTS FROM GUI OBJECTS LIKE BANGS, OR THE PRESET CLICKED
  
  public void ANALYZEE(int theValue) {
    println("boton 2");
  }
  
  /////////////
  //// toggles to activate channels
  ////////////////
  void input1(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,16);  
      input1.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,16);
      input1.setColorActive(color(255, 0, 0));
    }
  }
  void input2(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,17);
      input2.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,17);
      input2.setColorActive(color(255, 0, 0));
    }
  }
  void input3(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,18);
      input3.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,18);
      input3.setColorActive(color(255, 0, 0));
    }
  }
  void input4(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,19);
      input4.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,19);
      input4.setColorActive(color(255, 0, 0));
    }
  }
  void input5(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,20);
      input5.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,20);
      input5.setColorActive(color(255, 0, 0));
    }
  }
  void output1(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,21);
      output1.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,21);
      output1.setColorActive(color(255, 0, 0));
    }
  }
  void output2(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,22);
      output2.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,22);
      output2.setColorActive(color(255, 0, 0));
    }
  }
  void output3(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,23);
      output3.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,23);
      output3.setColorActive(color(255, 0, 0));
    }
  }
  void output4(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,24);
      output4.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,24);
      output4.setColorActive(color(255, 0, 0));
    }
  }
  void output5(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,25);
      output5.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,25);
      output5.setColorActive(color(255, 0, 0));
    }
  }
  
  /*
  public void DeleteAudio4() {
    loadedSound4.setText(" ");   //copy in the GUI
  }
  */
  
  
   
  // PRESET SAVER 
  void saver(float v) {
    //get active preset
    String theText = activePresetField.getText();
     
    cp5.getProperties().move(cp5.getController("sliderDescriptor1"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump1"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood1"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow1"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh1"), "default", theText);
        cp5.getProperties().move(cp5.getController("sliderDescriptor2"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump2"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood2"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow2"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh2"), "default", theText);
        cp5.getProperties().move(cp5.getController("sliderDescriptor3"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump3"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood3"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow3"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh3"), "default", theText);
        cp5.getProperties().move(cp5.getController("sliderDescriptor4"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump4"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood4"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow4"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh4"), "default", theText);
        cp5.getProperties().move(cp5.getController("sliderDescriptor5"), "default", theText);
        cp5.getProperties().move(cp5.getController("jump5"), "default", theText);
        cp5.getProperties().move(cp5.getController("neighborhood5"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainLow5"), "default", theText);
        cp5.getProperties().move(cp5.getController("grainHigh5"), "default", theText);
        
        //we add audio files names too
        cp5.getProperties().move(cp5.getController("activeSoundfile1"), "default", theText);
        cp5.getProperties().move(cp5.getController("activeSoundfile2"), "default", theText);
        cp5.getProperties().move(cp5.getController("activeSoundfile3"), "default", theText);
        cp5.getProperties().move(cp5.getController("activeSoundfile4"), "default", theText);
        cp5.getProperties().move(cp5.getController("activeSoundfile5"), "default", theText);
        
        //and important items from the default tab
        cp5.getProperties().move(cp5.getController("CH1Vol"), "default", theText);
        cp5.getProperties().move(cp5.getController("CH2Vol"), "default", theText);
        cp5.getProperties().move(cp5.getController("CH3Vol"), "default", theText);
        cp5.getProperties().move(cp5.getController("CH4Vol"), "default", theText);
        cp5.getProperties().move(cp5.getController("CH5Vol"), "default", theText);
        
        cp5.getProperties().move(cp5.getController("Thres1"), "default", theText);
        cp5.getProperties().move(cp5.getController("Thres2"), "default", theText);
        cp5.getProperties().move(cp5.getController("Thres3"), "default", theText);
        cp5.getProperties().move(cp5.getController("Thres4"), "default", theText);
        cp5.getProperties().move(cp5.getController("Thres5"), "default", theText);
        
        cp5.getProperties().move(cp5.getController("input1"), "default", theText);
        cp5.getProperties().move(cp5.getController("input2"), "default", theText);
        cp5.getProperties().move(cp5.getController("input3"), "default", theText);
        cp5.getProperties().move(cp5.getController("input4"), "default", theText);
        cp5.getProperties().move(cp5.getController("input5"), "default", theText);
        
        cp5.getProperties().move(cp5.getController("output1"), "default", theText);
        cp5.getProperties().move(cp5.getController("output2"), "default", theText);
        cp5.getProperties().move(cp5.getController("output3"), "default", theText);
        cp5.getProperties().move(cp5.getController("output4"), "default", theText);
        cp5.getProperties().move(cp5.getController("output5"), "default", theText);
        
        // prints the current list of properties registered and the set(s) they belong to 
        //cp5.getProperties().print();
        
        cp5.saveProperties(projectPath + "/" + theText + ".ser", theText);
        
        //update Active Preset Field
        activePresetField.setValue(theText);
        
        println("Instrument saved : "+theText);
    
    
  } 
 
  
    //LAUCH PD AND OTHER SOUND CONTROLS
    public void matrix(int theValue) {
      println("a button event from matrix button: "+theValue);
      open(dataPath("") + "/audioengine/puredata/" + "NIME2.pd" + " " + "-verbose"  );
    
      //String[] args = {dataPath("") + "/audioengine/puredata/" + "NIME2.pd" + "-path" + dataPath("") + "/audioengine/puredata/tID/" };
      //open(args); 
    }
    
    public void playButton(int theValue) {
       playSeq = true;
       stopSeq = false;
       pauseSeq = false;
    }
    public void pauseButton(int theValue) {
       pauseSeq = true;
       playSeq = false;
       stopSeq = false; 
    }
    public void stopButton(int theValue) {
       stopSeq = true;
       pauseSeq = false;
       playSeq = false;
    }
    
  
  //PLAYBACK FUNCTIONS
    
    void sliderDescriptor1(int value) {
      desCh1[indexAreaCh1] = value;
      sendOsc(value,31);
    }
    void jump1(int value) {
      jumpCh1[indexAreaCh1] = value;
      sendOsc(value,32);
    }
    void neighborhood1(int value) {
      nbhCh1[indexAreaCh1] = value;
      sendOsc(value,33);
    }
    void grainLow1(int value) {
      glCh1[indexAreaCh1] = value;
      sendOsc(value,34);
    }
    void grainHigh1(int value) {
      ghCh1[indexAreaCh1] = value;
      sendOsc(value,35);
    }
    void pedal1(boolean theFlag) {
      if(theFlag==true) {
        pedal1Active = true;
      } else {
        pedal1Active = false;
      }
    }
    void pedal2(boolean theFlag) {
      if(theFlag==true) {
        pedal2Active = true;
      } else {
        pedal2Active = false;
      }
    }
    void pedal3(boolean theFlag) {
      if(theFlag==true) {
        pedal3Active = true;
      } else {
        pedal3Active = false;
      }
    }
    void pedal4(boolean theFlag) {
      if(theFlag==true) {
        pedal4Active = true;
      } else {
        pedal4Active = false;
      }
    }
    void pedal5(boolean theFlag) {
      if(theFlag==true) {
        pedal5Active = true;
      } else {
        pedal5Active = false;
      }
    }
    void areaSw1(boolean theFlag) {
      if(theFlag==true) {
        areaSw1Active = true;
      } else {
        areaSw1Active = false;
      }
    }
    void areaSw2(boolean theFlag) {
      if(theFlag==true) {
        areaSw2Active = true;
      } else {
        areaSw2Active = false;
      }
    }
    void areaSw3(boolean theFlag) {
      if(theFlag==true) {
        areaSw3Active = true;
      } else {
        areaSw3Active = false;
      }
    }
    void areaSw4(boolean theFlag) {
      if(theFlag==true) {
        areaSw4Active = true;
      } else {
        areaSw4Active = false;
      }
    }
    void areaSw5(boolean theFlag) {
      if(theFlag==true) {
        areaSw5Active = true;
      } else {
        areaSw5Active = false;
      }
    }
    
    void sliderDescriptor2(int value) {
      desCh2[indexAreaCh2] = value;
      sendOsc(value,41);
    }
    void jump2(int value) {
      jumpCh2[indexAreaCh2] = value;
      sendOsc(value,42);
    }
    void neighborhood2(int value) {
      nbhCh2[indexAreaCh2] = value;
      sendOsc(value,43);
    }
    void grainLow2(int value) {
      glCh2[indexAreaCh2] = value;
      sendOsc(value,44);
    }
    void grainHigh2(int value) {
      ghCh2[indexAreaCh2] = value;
      sendOsc(value,45);
    }
    
    void sliderDescriptor3(int value) {
      desCh3[indexAreaCh3] = value;
      sendOsc(value,51);
    }
    void jump3(int value) {
      jumpCh3[indexAreaCh3] = value;
      sendOsc(value,52);
    }
    void neighborhood3(int value) {
      nbhCh3[indexAreaCh3] = value;
      sendOsc(value,53);
    }
    void grainLow3(int value) {
      glCh3[indexAreaCh3] = value;
      sendOsc(value,54);
    }
    void grainHigh3(int value) {
      ghCh3[indexAreaCh3] = value;
      sendOsc(value,55);
    }
    
    void sliderDescriptor4(int value) {
      desCh4[indexAreaCh4] = value;
      sendOsc(value,61);
    }
    void jump4(int value) {
      jumpCh4[indexAreaCh4] = value;
      sendOsc(value,62);
    }
    void neighborhood4(int value) {
      nbhCh4[indexAreaCh4] = value;
      sendOsc(value,63);
    }
    void grainLow4(int value) {
      glCh4[indexAreaCh4] = value;
      sendOsc(value,64);
    }
    void grainHigh4(int value) {
      ghCh4[indexAreaCh4] = value;
      sendOsc(value,65);
    }
    
    void sliderDescriptor5(int value) {
      desCh5[indexAreaCh5] = value;
      sendOsc(value,71);
    }
    void jump5(int value) {
      sendOsc(value,72);
      jumpCh5[indexAreaCh5] = value;
    }
    void neighborhood5(int value) {
      nbhCh5[indexAreaCh5] = value;
      sendOsc(value,73);
    }
    void grainLow5(int value) {
      glCh5[indexAreaCh5] = value;
      sendOsc(value,74);
    }
    void grainHigh5(int value) {
      ghCh5[indexAreaCh5] = value;
      sendOsc(value,75);
    }

  void CH1Vol(int theValue) {
    sendOsc(theValue,1);
  }
  void CH2Vol(int theValue) {
    sendOsc(theValue,2);
  }
  void CH3Vol(int theValue) {
    sendOsc(theValue,3);
  }
  void CH4Vol(int theValue) {
    sendOsc(theValue,4);
  }
  void CH5Vol(int theValue) {
    sendOsc(theValue,5);
  }
  
  void Thres1(int theValue) {
    sendOsc(theValue,6);
  }
  void Thres2(int theValue) {
    sendOsc(theValue,7);
  }
  void Thres3(int theValue) {
    sendOsc(theValue,8);
  }
  void Thres4(int theValue) {
    sendOsc(theValue,9);
  }
  void Thres5(int theValue) {
    sendOsc(theValue,10);
  }


  

  void remover(float v) {
    //find active preset
    String theText = activePresetField.getText();
    
    //find item in listbox and remove it
    l.removeItem(theText);
    println("Removed preset" + theText );
    
    //update
    //l.update(); 
    //l.updateListBoxItems();
    //cp5.loadProperties(("setA.ser"));
  }







  // function colorA will receive changes from 
  // controller with name colorA
  public void part1(int theValue) {
    //presetTxt.setText("SILEN");  
  }
  
  
      ///////////////////////////////////////////////
  //visualization STUFF
  ///////////////////////////////////////////////
  void loadData(String[] lines) {
    //String[] lines = loadStrings("kike.txt"); //we must load in the first setup (main setup of app)
    println("---------loading sequence----------------");
    print("nr of nodes: ");
    println(Integer.toString(lines.length));
    
    for(int i=0; i<lines.length;i++) {
      String[] pieces = split(lines[i], '\t');
      //println("elementos por linea: ");
      //println(Integer.toString(pieces.length));
      if (pieces.length == 3) {
        int index = Integer.parseInt(pieces[0]);
        String preset = pieces[1]; 
        int time = Integer.parseInt(pieces[2]);
        
        
        print("i ");
        print(i + " ");
        print("index ");
        print(index + " ");
        print("preset ");
        print(preset + " ");
        print("time ");
        println(time);
        
        
        addEdge(index, preset, time);     
      }
    }     
  }
  
  void addEdge(int index, String preset, int time) {
    
    String fromLabel = "dummy";
  
    
    Node to = findNode(index-1, preset, time);
    //println("node to: " + to.index);    
    to.increment();
    Node from = findNode(index, preset, time); 
    from.increment();
    //println("node from: " + from.index);
    
    for (int i = 0; i < edgeCount; i++) {
      if (edges[i].from == from && edges[i].to == to) {
        edges[i].increment();
        return;
      }
    } 
    
    Edge e = new Edge(this, from, to);
    e.increment();
    
    if (edgeCount == edges.length) {
      edges = (Edge[]) expand(edges);
    }
    edges[edgeCount++] = e;
    
    //println("nr of edges: ");
    //println(edgeCount);
  }
  
    
  Node findNode(int index, String preset, int time) {
    
    if(index == 0){
      preset = "Idle";
      time = 0;
    }
    
    
    Node n = (Node) nodeTable.get(index);
    if (n == null) {
      //if(index == 0){
      //return addNode(index, preset, 0);
      //}else{
        return addNode(index, preset, time);
      //}     
    }
    return n;
  }
  
  
  Node addNode(int index, String preset, int time) {
    Node n = new Node(this, index, preset, time);  
    if (nodeCount == nodes.length) {
      nodes = (Node[]) expand(nodes);
    }
    nodeTable.put(index, n);
    nodes[nodeCount++] = n;  
    return n;
  }
 
  

