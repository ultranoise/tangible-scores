

  ///////////////////////
  /////CONTROL EVENT
  /////////////////////
  public void controlEvent(ControlEvent theEvent) {
   
    ////////////
    //tabs  CHANGE SIZE OF CANVAS DEPENDING ON ACTIVE TAB
    ////////////
    if (theEvent.isTab()) {  
      if(theEvent.getTab().getId() == 1){   //DEFAULT (MAIN)
        frame.setSize(580, 600);
      }
      if(theEvent.getTab().getId() == 2){ // COMPOSER
        frame.setSize(740, 765);
      }
    }
    

     //////////////////////////
   //AREAS
 ///////////////////////////////
    if (theEvent.name().equals("saveAreaCh1")) {
      println("SAVED CH1 " + desCh1[indexAreaCh1] + " PARAMETERS TO AREA " + indexAreaCh1);
    }
    if (theEvent.name().equals("saveAreaCh2")) {
      println("SAVED CH2 " + desCh2[indexAreaCh2] + " PARAMETERS TO AREA " + indexAreaCh2);
    }
    if (theEvent.name().equals("saveAreaCh3")) {
      println("SAVED CH3 " + desCh3[indexAreaCh3] + " PARAMETERS TO AREA " + indexAreaCh3);
    }
    if (theEvent.name().equals("saveAreaCh4")) {
      println("SAVED CH4 " + desCh4[indexAreaCh4] + " PARAMETERS TO AREA " + indexAreaCh4);
    }
    if (theEvent.name().equals("saveAreaCh5")) {
      println("SAVED CH5 " + desCh5[indexAreaCh5] + " PARAMETERS TO AREA " + indexAreaCh5);
    }
    
    
    ////////////////////////////
    ///////////LOAD SOUND
    ////////////////////////////
    if (theEvent.name().equals("LOAD SOUND1")) {   //creates exception but we will solve it
          
         fileChooser1.setFileFilter(filter);  //we add the filter of showing only WAV or AIFF

        int result = fileChooser1.showOpenDialog(this);  //open dialog
        
        if (result == JFileChooser.APPROVE_OPTION) {
          selectedFile = fileChooser1.getSelectedFile();
          println("Selected file: " + selectedFile.getAbsolutePath());
          
          loadedSound1.setText(selectedFile.getName());   //copy in the GUI
            
          sendOscString(selectedFile.getAbsolutePath(), 111); //Pass the file to Pd
          sendOscString(selectedFile.getName(), 116); 
         
          //copy opened file to project folder (we need to save it for using it in real time)
          
          Path copy_from_1 = Paths.get(selectedFile.getAbsolutePath());
          Path copy_to_1 = Paths.get(projectPath + "/ch1/" + selectedFile.getName());
          try {
            Files.copy(copy_from_1, copy_to_1, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
           } catch (IOException e) {
            System.err.println(e);
           }
           
        
         }

         
      
    }
    if (theEvent.name().equals("LOAD SOUND2")) {   //creates exception but we will solve it
        
        //fileChooser2.setCurrentDirectory(new File(System.getProperty("/Users/iclab/Documents/timbre/timbreID-examples-0.6.4/sound/")));  
          
        //fileChooser2.setFileFilter(filter);
        
        int result = fileChooser2.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
          selectedFile = fileChooser2.getSelectedFile();
          println("Selected file: " + selectedFile.getAbsolutePath());
          println("file" + selectedFile.getName());
          
          loadedSound2.setText(selectedFile.getName());
          
          sendOscString(selectedFile.getAbsolutePath(), 112);  
          sendOscString(selectedFile.getName(), 117);
          
          //copy opened file to project folder
          
         Path copy_from_1 = Paths.get(selectedFile.getAbsolutePath());
         Path copy_to_1 = Paths.get(projectPath + "/ch2/" + selectedFile.getName());
         try {
            Files.copy(copy_from_1, copy_to_1, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
          } catch (IOException e) {
            System.err.println(e);
          }
          
        }
          
        
        
    }
    if (theEvent.name().equals("LOAD SOUND3")) {   //creates exception but we will solve it
        
        //fileChooser3.setCurrentDirectory(new File(System.getProperty("/Users/iclab/Documents/timbre/timbreID-examples-0.6.4/sound/")));  
          
        //fileChooser3.setFileFilter(filter);
        
        int result = fileChooser3.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser3.getSelectedFile();
          println("Selected file: " + selectedFile.getAbsolutePath());
          println("file" + selectedFile.getName());
          
          loadedSound3.setText(selectedFile.getName());
          
          sendOscString(selectedFile.getAbsolutePath(), 113);
          sendOscString(selectedFile.getName(), 118);
    
         //copy opened file to project folder
         
         Path copy_from_1 = Paths.get(selectedFile.getAbsolutePath());
         Path copy_to_1 = Paths.get(projectPath + "/ch3/" + selectedFile.getName());
         try {
            Files.copy(copy_from_1, copy_to_1, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
          } catch (IOException e) {
            System.err.println(e);
          }
        
        }
    }
    if (theEvent.name().equals("LOAD SOUND4")) {   //creates exception but we will solve it
        
        //fileChooser4.setCurrentDirectory(new File(System.getProperty("/Users/iclab/Documents/timbre/timbreID-examples-0.6.4/sound/")));  
          
        //fileChooser4.setFileFilter(filter);
        
        int result = fileChooser4.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser4.getSelectedFile();
          println("Selected file: " + selectedFile.getAbsolutePath());
          println("file" + selectedFile.getName());
          
          loadedSound4.setText(selectedFile.getName());
          
          sendOscString(selectedFile.getAbsolutePath(), 114);
          sendOscString(selectedFile.getName(), 119);  
        
           //copy opened file to project folder
           
         Path copy_from_1 = Paths.get(selectedFile.getAbsolutePath());
         Path copy_to_1 = Paths.get(projectPath + "/ch4/" + selectedFile.getName());
         try {
            Files.copy(copy_from_1, copy_to_1, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
          } catch (IOException e) {
            System.err.println(e);
          }
          
          
        }
    }
    if (theEvent.name().equals("LOAD SOUND5")) {   //creates exception but we will solve it
        
        //fileChooser5.setCurrentDirectory(new File(System.getProperty("/Users/iclab/Documents/timbre/timbreID-examples-0.6.4/sound/")));  
          
        //fileChooser5.setFileFilter(filter);
        
        int result = fileChooser5.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser5.getSelectedFile();
          println("Selected file: " + selectedFile.getAbsolutePath());
          println("file" + selectedFile.getName());
          
          loadedSound5.setText(selectedFile.getName());
          
          sendOscString(selectedFile.getAbsolutePath(), 115);
          sendOscString(selectedFile.getName(), 120);    
        
          //copy opened file to project folder
          
          Path copy_from_1 = Paths.get(selectedFile.getAbsolutePath());
          Path copy_to_1 = Paths.get(projectPath + "/ch5/" + selectedFile.getName());
          try {
            Files.copy(copy_from_1, copy_to_1, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
           } catch (IOException e) {
            System.err.println(e);
           }  
           
        }
    }
    
   
    
    ///////////////////////
    ///////////Delete loaded audio field
    ///////////////////////
    if (theEvent.name().equals("DeleteAudio1")) {   //creates exception but we will solve it
        //clear loadedSound1
        loadedSound1.setText(" ");   //copy in the GUI
        loadedSound1.setUpdate(true);
        loadedSound1.update();
        sendOscString(loadedSound1.getStringValue(), 121);
    }
    if (theEvent.name().equals("DeleteAudio2")) {   //creates exception but we will solve it
        loadedSound2.setText(" ");   //copy in the GUI
        loadedSound2.setUpdate(true); 
        loadedSound2.update();
        sendOscString(loadedSound2.getStringValue(), 122);
    }
    if (theEvent.name().equals("DeleteAudio3")) {   //creates exception but we will solve it
        loadedSound3.setText(" ");   //copy in the GUI
        loadedSound3.setUpdate(true);
        loadedSound3.update();
        sendOscString(loadedSound3.getStringValue(), 123);
    }
    
    if (theEvent.name().equals("DeleteAudio4")) {   //creates exception but we will solve it
        loadedSound4.setText(" ");   //copy in the GUI
        loadedSound4.setUpdate(true);
        loadedSound4.update();
        sendOscString(loadedSound4.getStringValue(), 124);
    }
    
    if (theEvent.name().equals("DeleteAudio5")) {   //creates exception but we will solve it
        loadedSound5.setText(" ");   //copy in the GUI
        loadedSound5.setUpdate(true);
        loadedSound5.update();
        sendOscString(loadedSound5.getStringValue(), 125);
    }
    
       
    ///////////////////////////////////////////////
    ///////////RECEIVES CLICK ON LIST OF PRESETS
    ///////////////////////////////////////////////
    
    if(theEvent.isGroup() && theEvent.name().equals("savedInstruments")){
      int test = (int)theEvent.group().value();
      //String clicked = theEvent.group().name();
      
      //println("Preset number "+ test);
      //println("Preset nameee "+ theEvent.name().getStringValue());
      //println("Preset nameee " + theEvent.group().getStringValue());
      //println("Preset name "+ l.getItem(test).getName());
      
      //load preset
      cp5.loadProperties((projectPath + "/" + l.getItem(test).getName())+".ser");
      println("Preset loaded: "+ l.getItem(test).getName());
      
      //write in active preset field
      activePresetField.setValue(l.getItem(test).getName());
      //println("Preset sent to active "+ l.getItem(test).getName());  
  

      //send values of new loaded sounds (/presetsoundfile1)    
     sendOscString(loadedSound1.getStringValue(), 121);
     sendOscString(loadedSound2.getStringValue(), 122); 
     sendOscString(loadedSound3.getStringValue(), 123); 
     sendOscString(loadedSound4.getStringValue(), 124); 
     sendOscString(loadedSound5.getStringValue(), 125);  
     
     //read descriptor data from arrays loaded in string file
      String lines[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "desCh1.txt");
      for (int i = 0 ; i < lines.length; i++) {
        desCh1[i] = Integer.parseInt(lines[i]);
      }
      String jumps[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "jumpCh1.txt");
      for (int i = 0 ; i < jumps.length; i++) {
        jumpCh1[i] = Integer.parseInt(jumps[i]);
      }
      String nbh[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "nbhCh1.txt");
      for (int i = 0 ; i < nbh.length; i++) {
        nbhCh1[i] = Integer.parseInt(nbh[i]);
      }
      String gl[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "glCh1.txt");
      for (int i = 0 ; i < gl.length; i++) {
        glCh1[i] = Integer.parseInt(gl[i]);
      }
      String gh[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "ghCh1.txt");
      for (int i = 0 ; i < gh.length; i++) {
        ghCh1[i] = Integer.parseInt(gh[i]);
      }
      
      String lines2[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "desCh2.txt");
      for (int i = 0 ; i < lines2.length; i++) {
        desCh2[i] = Integer.parseInt(lines2[i]);
      }
      String jumps2[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "jumpCh2.txt");
      for (int i = 0 ; i < jumps2.length; i++) {
        jumpCh2[i] = Integer.parseInt(jumps2[i]);
      }
      String nbh2[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "nbhCh2.txt");
      for (int i = 0 ; i < nbh2.length; i++) {
        nbhCh2[i] = Integer.parseInt(nbh2[i]);
      }
      String gl2[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "glCh2.txt");
      for (int i = 0 ; i < gl2.length; i++) {
        glCh2[i] = Integer.parseInt(gl2[i]);
      }
      String gh2[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "ghCh2.txt");
      for (int i = 0 ; i < gh2.length; i++) {
        ghCh2[i] = Integer.parseInt(gh2[i]);
      }
      
      
      
      String lines3[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "desCh3.txt");
      for (int i = 0 ; i < lines3.length; i++) {
        desCh3[i] = Integer.parseInt(lines3[i]);
      }
      String jumps3[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "jumpCh3.txt");
      for (int i = 0 ; i < jumps3.length; i++) {
        jumpCh3[i] = Integer.parseInt(jumps3[i]);
      }
      String nbh3[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "nbhCh3.txt");
      for (int i = 0 ; i < nbh3.length; i++) {
        nbhCh3[i] = Integer.parseInt(nbh3[i]);
      }
      String gl3[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "glCh3.txt");
      for (int i = 0 ; i < gl3.length; i++) {
        glCh3[i] = Integer.parseInt(gl3[i]);
      }
      String gh3[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "ghCh3.txt");
      for (int i = 0 ; i < gh3.length; i++) {
        ghCh3[i] = Integer.parseInt(gh3[i]);
      }
      
      
      
      String lines4[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "desCh4.txt");
      for (int i = 0 ; i < lines4.length; i++) {
        desCh4[i] = Integer.parseInt(lines4[i]);
      }
      String jumps4[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "jumpCh4.txt");
      for (int i = 0 ; i < jumps4.length; i++) {
        jumpCh4[i] = Integer.parseInt(jumps4[i]);
      }
      String nbh4[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "nbhCh4.txt");
      for (int i = 0 ; i < nbh4.length; i++) {
        nbhCh4[i] = Integer.parseInt(nbh4[i]);
      }
      String gl4[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "glCh4.txt");
      for (int i = 0 ; i < gl4.length; i++) {
        glCh4[i] = Integer.parseInt(gl4[i]);
      }
      String gh4[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "ghCh4.txt");
      for (int i = 0 ; i < gh4.length; i++) {
        ghCh4[i] = Integer.parseInt(gh4[i]);
      }
      
      
      
      String lines5[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "desCh5.txt");
      for (int i = 0 ; i < lines5.length; i++) {
        desCh5[i] = Integer.parseInt(lines5[i]);
      }
      String jumps5[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "jumpCh5.txt");
      for (int i = 0 ; i < jumps5.length; i++) {
        jumpCh5[i] = Integer.parseInt(jumps5[i]);
      }
      String nbh5[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "nbhCh5.txt");
      for (int i = 0 ; i < nbh5.length; i++) {
        nbhCh5[i] = Integer.parseInt(nbh5[i]);
      }
      String gl5[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "glCh5.txt");
      for (int i = 0 ; i < gl5.length; i++) {
        glCh5[i] = Integer.parseInt(gl5[i]);
      }
      String gh5[] = loadStrings((projectPath + "/" + l.getItem(test).getName()) + "ghCh5.txt");
      for (int i = 0 ; i < gh5.length; i++) {
        ghCh5[i] = Integer.parseInt(gh5[i]);
      }
     
     //we have to send in order!!! (values arrive PD via OSC non ordered)
     /*
      sendOsc(Math.round(n1.getValue()),33); 
      sendOsc(Math.round(j1.getValue()),32);   
      sendOsc(Math.round(d1.getValue()),31); 
      sendOsc(Math.round(gl1.getValue()),34);
      sendOsc(Math.round(gh1.getValue()),35);
    
      sendOsc(Math.round(n2.getValue()),43); 
      sendOsc(Math.round(j2.getValue()),42);   
      sendOsc(Math.round(d2.getValue()),41); 
      sendOsc(Math.round(gl2.getValue()),44);
      sendOsc(Math.round(gh2.getValue()),45);
      
      sendOsc(Math.round(n3.getValue()),53); 
      sendOsc(Math.round(j3.getValue()),52);   
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
      */
    }
    
    
    
    if(theEvent.isGroup() && theEvent.name().equals("savedProjects")){
      
      int test = (int)theEvent.group().value();
      println("------ loading project -----------");
      println("Project name: "+ p.getItem(test).getName());
      
      //write in active project field
      activeProjectField.setValue(p.getItem(test).getName());
      
      //update path of this project
      projectPath = dataPath("") + "/projects/" + p.getItem(test).getName();
      //println("pathhh" + projectPath);
      projectName =   p.getItem(test).getName();
      projectDefined = true;
      
      //send a preset change signal to audioengine
      sendOsc(1, 0);
      //send OSC name announcement to audioengine
      sendOscString(projectName,100);
      
      //read all the presets (.ser extension) in project´ folder and load them in presets
      
      //esto funciona para todos
      //File folder = new File(projectPath);
      //File[] listOfFiles = folder.listFiles();
      
      
      File dir = new File(projectPath);
      File[] listOfFiles = dir.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.toLowerCase().endsWith(".ser");
        }
      });
      
      
      //update presets list
      println("presets found: ");
      l.clear();
      presetCounter = 0;
      String name;
      for (File file : listOfFiles) {
          if (file.isFile()) {
              System.out.println(file.getName());
              name = file.getName();
              if (name.indexOf(".") > 0) {
                name = name.substring(0, name.lastIndexOf("."));
                System.out.println(name);
                l.addItem(name, presetCounter);
                presetCounter=presetCounter+1; 
              }
          }
      }
      
      
      //load the sequencer file for this project
      //sequencer file
      instantiated = false;
      lines = null;
      lines = loadStrings(projectPath + "/sequencer.txt");
      
      //NODES init from the file
      edgeCount = 0;
      nodeCount = 0;
      nodeTable.clear();
      nodeTable = new HashMap();
      loadData(lines); 
      println("loaded sequencer");
      
      for (int i = 0 ; i < nodeCount ; i++) { 
        print("node: ");
        print(i + " ");
        print("index: ");
        print(nodes[i].index + " ");
        print("preset: ");
        print(nodes[i].preset + " ");
        print("time: ");
        println(nodes[i].time + " ");   
     }
     println("---------                ----------------");
     instantiated = true; 
    }
    
  
  
    if(theEvent.name().equals("assignedChannels")){  //INPUT CHANNEL NUMBER
      int test = (int)theEvent.group().value();
      test = test - 1;
      println("channel number "+test);
      activeChannelField.setValue(l2.getItem(test).getName());
      ListBoxItem lbi2;
      for (int i=0;i<5;i++) {  //CHANGE COLOR OF THE ITEM CLICKED
        lbi2 = l2.getItem(i);
        if(i==test){
          lbi2.setColorBackground(0xafafff00);
        }
        else {
          lbi2.setColorBackground(0xffff0000);
        }
      }
      
      println(l2.getItem(test).getName());
    }
    
  
  }
