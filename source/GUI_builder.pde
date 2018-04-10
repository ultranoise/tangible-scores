

//GUI Builder

void guiBuilder() {
  
  cp5 = new ControlP5(this);
  
  drawInfoTab = false;
  
  
  //********************************************************* 
  //Title
  //********************************************************* 
  /*
  Title = cp5.addTextlabel("Title")
                    .setText("Tangible Scores")
                    .setPosition(290,15)
                    .setColorValue(0xffffffff)
                    .setFont(createFont("Arial", 18))
                    ;
  */                 
                    
  //********************************************************* 
  //TABS
  //********************************************************* 
      composer = cp5.addTab("Composer")
       .setColorBackground(color(100, 40, 0))
       .setColorLabel(color(255))
       .setColorActive(color(255,128,0))
       ;
       
     if(drawSequencerTab)    {
       
      cp5.addTab("Sequencer")
       .setColorBackground(color(200, 60, 200))
       .setColorLabel(color(255))
       .setColorActive(color(255,128,0))
       .addCanvas(new TestCanvas())
       ;
      }
      if(drawInfoTab)    {
        println("creo la info tab --------");
      info = cp5.addTab("Info")
       .setColorBackground(color(0, 160, 100))
       .setColorLabel(color(255))
       .setColorActive(color(255,128,0))
       ;
      }
      if(drawTodoTab)    {  
     todo = cp5.addTab("Todo")
       .setColorBackground(color(10, 10, 250))
       .setColorLabel(color(255))
       .setColorActive(color(255,128,0))
       ; 
      } 
      
     help =  cp5.addTab("Help")
       .setColorBackground(color(10, 10, 250))
       .setColorLabel(color(255))
       .setColorActive(color(255,128,0))
       ;
     
     //cp5.getTab("default").setVisible(false);
     main = cp5.getTab("default")
     .activateEvent(true)
     .setLabel("Main")
     .setId(1)
     ;
     
     main.setWidth(55);
     
    cp5.getTab("Composer")
     .activateEvent(true)
     .setId(2)
     ;
  
  //********************************************************* 
  // group number 1, contains 5 bangs and a visualizer
  //********************************************************* 
  Group projects = cp5.addGroup("Projects")
                .setBackgroundColor(color(0, 64))
                .setBackgroundHeight(200)
                ;
  
   cp5.addTextfield("saveProjectAsField")
     .setLabel("New Project")
     .setPosition(8,5)
     .setSize(120,20)
     .setFont(createFont("arial",10))
     .setAutoClear(true)
     .setColorBackground(color(120))
     .setColorLabel(color(255))
     .setGroup(projects)
     ;  
 
   activeProjectField = cp5.addTextfield("activeProject")
     .setLabel("Active Project")
     .setPosition(8,45)
     .setSize(120,20)
     .setFont(createFont("arial",12))
     .setAutoClear(true)
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(255) 
     .setColorCaptionLabel(255)
     .setColorLabel(color(255))
     .setGroup(projects)
     ;
 
   p = cp5.addListBox("savedProjects")
     .setPosition(8, 105)
     .setSize(185, 90)
     .setItemHeight(20)
     .setBarHeight(20)
     .setColorBackground(color(120))
     .setColorActive(color(220))
     .setColorForeground(205)
     .setGroup(projects)
     ;

  p.captionLabel().toUpperCase(true);
  p.captionLabel().set("Available Projects");
  p.captionLabel().setColor(0xffff0000);
  p.captionLabel().style().marginTop = 3;
  p.valueLabel().style().marginTop = 3;
  p.setColorLabel(color(255)); 

  //buttons
  cp5.addButton("saveProject", 0, 140, 6, 40, 18).setCaptionLabel("  save").setColorBackground(color(128)).setGroup(projects);
  
  
  //*********************************************************
  // group number 4, contains a bang and a slider
  //*********************************************************
  Group g4 = cp5.addGroup("Sequencer")
                .setBackgroundColor(color(0, 64))
                .setBackgroundHeight(40)
                ; 
  
  cp5.addButton("playButton")
     .setValue(128)
     .setPosition(5,20)
     .setImages(play,play,play)
     .updateSize()
     .setGroup(g4)
     ;
    cp5.addButton("pauseButton")
     .setValue(128)
     .setPosition(72,12)
     .setImages(pause,pause,pause)
     .updateSize()
     .setGroup(g4)
     ;
  cp5.addButton("stopButton")
     .setValue(128)
     .setPosition(130,12)
     .setImages(stop,stop,stop)
     .updateSize()
     .setGroup(g4)
     ;
/*
cp5.addTextfield("sequencerField")
     .setLabel("new preset to sequencer")
     .setPosition(8,65)
     .setSize(120,20)
     .setFont(createFont("arial",10))
     .setAutoClear(true)
     .setColorBackground(color(120))
     .setColorLabel(color(255))
     .setGroup(g4)
     ;  
 */
 /*
   p2 = cp5.addListBox("savedPresets4Sequencer")
     .setPosition(8,130)
     .setSize(120, 120)
     .setItemHeight(20)
     .setBarHeight(20)
     .setColorBackground(color(120))
     .setColorActive(color(220))
     .setColorForeground(205)
     .setGroup(g4)
     ;

  p2.captionLabel().toUpperCase(true);
  p2.captionLabel().set("Available Presets");
  p2.captionLabel().setColor(0xffff0000);
  p2.captionLabel().style().marginTop = 3;
  p2.valueLabel().style().marginTop = 3;
  p2.setColorLabel(color(255)); 

  cp5.addButton("addPreset4Sequencer", 0, 140, 61, 40, 12).setCaptionLabel("  ADD").setColorBackground(color(128)).setGroup(g4);
  cp5.addButton("removePreset4Sequencer", 0, 140, 76, 40, 12).setCaptionLabel("  REMOVE").setColorBackground(color(128)).setGroup(g4);
  */

  //*********************************************************
  // group number 4, contains a bang and a slider
  //*********************************************************
  Group g5 = cp5.addGroup("Audio Server")
                .setBackgroundColor(color(0, 64))
                .setBackgroundHeight(40)
                ; 
  




  //*********************************************************
  // group number 3, contains various bangs
  //*********************************************************
  Group g3 = cp5.addGroup("Active Channels")
                .setBackgroundColor(color(0, 64))
                .setBackgroundHeight(10)
                ;
  
  input1 = cp5.addToggle("input1")
     .setPosition(5,20)
     .setSize(25,10)
     .setValue(false)
     .setLabel("input1")
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
     
   input2 =  cp5.addToggle("input2")
     .setPosition(45,20)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
    input3 = cp5.addToggle("input3")
     .setPosition(85,20)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
    input4 = cp5.addToggle("input4")
     .setPosition(125,20)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
    input5 = cp5.addToggle("input5")
     .setPosition(165,20)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
     
    output1 = cp5.addToggle("output1")
     .setPosition(5,50)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
     output2 = cp5.addToggle("output2")
     .setPosition(45,50)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
     output3 = cp5.addToggle("output3")
     .setPosition(85,50)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
     output4 = cp5.addToggle("output4")
     .setPosition(125,50)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
     output5 = cp5.addToggle("output5")
     .setPosition(165,50)
     .setSize(25,10)
     .setValue(false)
     .setGroup(g3)
     .setMode(ControlP5.SWITCH)
     .setColorActive(color(0, 255, 0))
     ;
    
      //g3.setBackgroundHeight(20);



  //*********************************************************
  // create a new accordion with the groups
  // add g1, g2, and g3 to the accordion.
  //*********************************************************
  
  accordion = cp5.addAccordion("acc")
                 .setPosition(10,30)
                 .setWidth(200)
                 .setHeight(450)
                 .addItem(projects)
                 .addItem(g4)
                 .addItem(g3)
                 .addItem(g5)               
                 ;
                 
  //Accordion shortcuts    
  /*  
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.open(0,1,2);}}, 'o');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.close(0,1,2);}}, 'c');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.setWidth(300);}}, '1');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.setPosition(0,0);accordion.setItemHeight(190);}}, '2'); 
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.setCollapseMode(ControlP5.ALL);}}, '3');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.setCollapseMode(ControlP5.SINGLE);}}, '4');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {cp5.remove("myGroup1");}}, '0');
  */
  //init - open it at beginning 
  accordion.open(0,1,2,3);
  
  // use Accordion.MULTI to allow multiple group 
  // to be open at a time.
  accordion.setCollapseMode(Accordion.MULTI);
  
  
  //*********************************************************
  // TAB 1 DEFAULT - FIRST SCREEN (DEFAULT - MAIN)
  //********************************************************* 
  
    //BACKGROUND RECTANGE AS TEXTBOX
    cp5.addTextarea("backSolid")
                  .setPosition(250,30)
                  .setSize(320,539)
                  .setColor(color(128))
                  .setColorBackground(color(180))
                  .setColorForeground(color(180));
                  ;  
  
  
    // INPUT VUMETERS
      cp5.addSlider("CH1Input")
       .setPosition(300,50)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;  
     
      cp5.addSlider("CH2Input")
       .setPosition(350,50)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
     
      cp5.addSlider("CH3Input")
       .setPosition(400,50)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
     
      cp5.addSlider("CH4Input")
       .setPosition(450,50)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
     
      cp5.addSlider("CH5Input")
       .setPosition(500,50)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
     
     
     
     // OUTPUT VUMETERS
       
      cp5.addSlider("CH1Output")
       .setPosition(300,250)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
       
      cp5.addKnob("CH1Vol")  //myKnobA =
       .setRange(-50,50)
       .setValue(0)
       .setPosition(300,450)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
       
       cp5.addKnob("Thres1")  //myKnobA =
       .setRange(0,100)
       .setValue(45)
       .setPosition(300,500)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
     
      cp5.addSlider("CH2Output")
       .setPosition(350,250)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
      cp5.addKnob("CH2Vol") 
       .setRange(-50,50)
       .setValue(0)
       .setPosition(350,450)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
       cp5.addKnob("Thres2")  //myKnobA =
       .setRange(0,100)
       .setValue(45)
       .setPosition(350,500)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
     
     cp5.addSlider("CH3Output")
       .setPosition(400,250)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
       
     cp5.addKnob("CH3Vol") 
       .setRange(-50,50)
       .setValue(0)
       .setPosition(400,450)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
       
       cp5.addKnob("Thres3")  //myKnobA =
       .setRange(0,100)
       .setValue(45)
       .setPosition(400,500)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
               
     cp5.addSlider("CH4Output")
       .setPosition(450,250)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
     cp5.addKnob("CH4Vol") 
       .setRange(-50,50)
       .setValue(0)
       .setPosition(450,450)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
     cp5.addKnob("Thres4")  //myKnobA =
       .setRange(0,100)
       .setValue(45)
       .setPosition(450,500)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
     
     cp5.addSlider("CH5Output")
       .setPosition(500,250)
       .setSize(20,150)
       .setRange(0,100)
       .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
       ;
       
     cp5.addKnob("CH5Vol") 
       .setRange(-50,50)
       .setValue(0)
       .setPosition(500,450)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
       
       cp5.addKnob("Thres5")  //myKnobA =
       .setRange(0,100)
       .setValue(45)
       .setPosition(500,500)
       .setRadius(15)
       .setDragDirection(Knob.VERTICAL)
       .setColorCaptionLabel(color(0))
       ;
     
    cp5.addButton("matrix")
     .setValue(128)
     .setPosition(35,490)
     .setImages(matrix,matrix,matrix)
     .updateSize();
     
     cp5.addButton("midi")
     .setValue(128)
     .setPosition(120,490)
     .setImages(midi,midi,midi)
     .updateSize();
       
     
  //*********************************************************
  // TAB INFO
  //*********************************************************   
    if(drawInfoTab){
       infoTxt = cp5.addTextarea("infoTxt")
                  .setPosition(100,100)
                  .setSize(200,200)
                  .setFont(createFont("arial",12))
                  .setLineHeight(14)
                  .setColor(color(128))
                  .moveTo("Info")
                  .setColorBackground(color(255,100))
                  .setColorForeground(color(255,100));
                  ;
      infoTxt.setText("Lorem Ipsum is simply dummy text of the printing and typesetting"
                    +" industry. Lorem Ipsum has been the industry's standard dummy text"
                    +" ever since the 1500s, when an unknown printer took a galley of type"
                    +" and scrambled it to make a type specimen book. It has survived not"
                    +" only five centuries, but also the leap into electronic typesetting,"
                    +" remaining essentially unchanged. It was popularised in the 1960s"
                    +" with the release of Letraset sheets containing Lorem Ipsum passages,"
                    +" and more recently with desktop publishing software like Aldus"
                    +" PageMaker including versions of Lorem Ipsum."
                    );
      
      }
  //*********************************************************
  // TAB HELP
  //********************************************************* 
      
        helpTxt = cp5.addTextarea("txt")
                  .setPosition(100,100)
                  .setSize(200,200)
                  .setFont(createFont("arial",12))
                  .setLineHeight(14)
                  .setColor(color(128))
                  .moveTo("Help")
                  .setColorBackground(color(255,100))
                  .setColorForeground(color(255,100));
                  ;
      helpTxt.setText("Lorem Ipsum is simply dummy text of the printing and typesetting"
                    +" industry. Lorem Ipsum has been the industry's standard dummy text"
                    +" ever since the 1500s, when an unknown printer took a galley of type"
                    +" and scrambled it to make a type specimen book. It has survived not"
                    +" only five centuries, but also the leap into electronic typesetting,"
                    +" remaining essentially unchanged. It was popularised in the 1960s"
                    +" with the release of Letraset sheets containing Lorem Ipsum passages,"
                    +" and more recently with desktop publishing software like Aldus"
                    +" PageMaker including versions of Lorem Ipsum."
                    );
        
  //*********************************************************
  // TAB TO DO
  //********************************************************* 
      if(drawTodoTab){
        todoTxt = cp5.addTextarea("todoTxt")
                  .setPosition(100,100)
                  .setSize(200,200)
                  .setFont(createFont("arial",12))
                  .setLineHeight(14)
                  .setColor(color(128))
                  .moveTo("Todo")
                  .setColorBackground(color(255,100))
                  .setColorForeground(color(255,100));
                  ;
        todoTxt.setText("Introducir machine learning"
        
                    +" Visualizacion de ondas"
                    
                    +" Arrancar Pd desde Processing"
                    
                    + "Opcion submix to stereo"
                    
                    + "mirar el tema de la densidad de analisis, cuantos index por segundo hay que sacar"
                    
                    + "implementar detect change"
                    
                    + "botones del sequencer"
                    
                    + "carga de presets y variables en Pd"
                    
                    + "visualizador de estado de Pd (vivo o no)"
                    
                    + "mirar si hay un enveloping más rápido y menos bruto, más logaritmico"
                    
                    + "el proyecto tambien tiene que guardar el secuenciador, y el file de seq debe guardarse en el folder de proyecto"
                    );
  }
        
  //*********************************************************
  // TAB SEQUENCER
  //********************************************************* 
    //cp5.addCanvas(cc); //.moveTo("Sequencer"); // add the canvas to cp5
    //cc.moveTo("Sequencer");
  
  //*********************************************************
  // TAB COMPOSER
  //********************************************************* 
  /*
  cp5.addTextlabel("TitleCOMP")
      .setText("snapshot y tooltip!")
      .setPosition(20,25)
      .setColorValue(0xffffffff)
      .setFont(createFont("Arial", 24))
      .moveTo("Composer")
      ;
  */
   
   ///////////////////////////////
   /// LOAD AND ANALYSIS GUI
   ///////////////////////////////
 //BACKGROUND RECTANGE AS TEXTBOX
    cp5.addTextarea("backSolidChannels")
                  .setPosition(10,95)
                  .setSize(425,150)
                  .setColor(color(128))
                  .setColorBackground(color(180))
                  .setColorForeground(color(180))
                  .moveTo("Composer")
                  ;   
   cp5.addTextarea("backSolidChannels2")
                  .setPosition(445,95)
                  .setSize(285,150)
                  .setColor(color(128))
                  .setColorBackground(color(180))
                  .setColorForeground(color(180))
                  .moveTo("Composer")
                  ;  
   //file background solid color
   cp5.addTextarea("backFile1")
                  .setPosition(150,125)
                  .setSize(165,12)
                  .setColor(color(80))
                  .setColorBackground(color(80))
                  .setColorForeground(color(80))
                  .moveTo("Composer")
                  ; 
    cp5.addTextarea("backFile2")
                  .setPosition(150,141)
                  .setSize(165,12)
                  .setColor(color(80))
                  .setColorBackground(color(80))
                  .setColorForeground(color(80))
                  .moveTo("Composer")
                  ;
   cp5.addTextarea("backFile3")
                  .setPosition(150,157)
                  .setSize(165,12)
                  .setColor(color(80))
                  .setColorBackground(color(80))
                  .setColorForeground(color(80))
                  .moveTo("Composer")
                  ; 
    cp5.addTextarea("backFile4")
                  .setPosition(150,173)
                  .setSize(165,12)
                  .setColor(color(80))
                  .setColorBackground(color(80))
                  .setColorForeground(color(80))
                  .moveTo("Composer")
                  ;  
   cp5.addTextarea("backFile5")
                  .setPosition(150,189)
                  .setSize(165,12)
                  .setColor(color(80))
                  .setColorBackground(color(80))
                  .setColorForeground(color(80))
                  .moveTo("Composer")
                  ; 
                  
 
 
     // LISTS OF CHANNELS
    l2 = cp5.addListBox("assignedChannels")
     .setPosition(15, 125)
     .setSize(110, 120)
     .setItemHeight(15)
     .setBarHeight(15)
     .setColorBackground(color(120))
     .setColorActive(color(220))
     .setColorForeground(205)
     .setColorLabel(255) 
     .moveTo("Composer")
     ;

    l2.captionLabel().toUpperCase(true);
    l2.captionLabel().set(" Synthesis Channels");
    l2.captionLabel().setColor(0xffff0000);
    l2.captionLabel().style().marginTop = 3;
    l2.valueLabel().style().marginTop = 3;
    l2.setColorLabel(color(255)); 
  
    for (int i=1;i<6;i++) {
      ListBoxItem lbi2 = l2.addItem("Channel "+i, i);
      lbi2.setColorBackground(255);//0xffff0000);
    }
    
     
   cp5.addBang("LOAD SOUND1")
     .setLabel(" ")
     .setPosition(130,125)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ;
     /*
   cp5.addBang("ANALYZE1")
     .setLabel("")
     .setPosition(290,125)
     .setSize(12,12)
     .moveTo("Composer")
     ;
     */
     
    cp5.addNumberbox("showMaxDescriptor1")
     .setLabel(" ")
     .setPosition(325,125)
     .setSize(50,12)
     .setValue(0)
     .setLock(true)
     .moveTo("Composer")
     ; 
   cp5.addBang("DeleteAudio1")
     .setLabel("")
     .setPosition(390,125)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ;
   cp5.addBang("LOAD SOUND2")
     .setLabel(" ")
     .setPosition(130,141)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ;
    
    cp5.addNumberbox("showMaxDescriptor2")
     .setLabel(" ")
     .setPosition(325,141)
     .setSize(50,12)
     .setLock(true)
     .moveTo("Composer")
     ;  
     cp5.addBang("DeleteAudio2")
     .setLabel("")
     .setPosition(390,141)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ;
     cp5.addBang("LOAD SOUND3")
     .setLabel(" ")
     .setPosition(130,158)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ;
     /*
    cp5.addBang("ANALYZE3")
     .setLabel("")
     .setPosition(290,158)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ; 
     */
     cp5.addNumberbox("showMaxDescriptor3")
     .setLabel(" ")
     .setPosition(325,158)
     .setSize(50,12)
     .setValue(0)
     .setLock(true)
     .moveTo("Composer")
     ;
   cp5.addBang("DeleteAudio3")
     .setLabel("")
     .setPosition(390,158)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ;  
     cp5.addBang("LOAD SOUND4")
     .setLabel(" ")
     .setPosition(130,173)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ; 
     /*
     cp5.addBang("ANALYZE4")
     .setLabel("")
     .setPosition(290,173)
     .setSize(12,12)
     .moveTo("Composer")
     ;
     */
     cp5.addNumberbox("showMaxDescriptor4")
     .setLabel(" ")
     .setPosition(325,173)
     .setSize(50,12)
     .setValue(0)
     .setLock(true)
     .moveTo("Composer")
     ;  
     
     cp5.addBang("DeleteAudio4")
     .setLabel("")
     .setPosition(390,173)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ;
     
     cp5.addBang("LOAD SOUND5")
     .setLabel(" Load File ")
     .setPosition(130,190)
     .setSize(12,12)
     .setTriggerEvent(Bang.RELEASE)
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ; 

     cp5.addNumberbox("showMaxDescriptor5")
     .setLabel(" Descriptors")
     .setPosition(325,190)
     .setSize(50,12)
     .setValue(0)
     .setColorCaptionLabel(0)
     .setLock(true)
     .moveTo("Composer")
     ;
     
   cp5.addBang("DeleteAudio5")
     .setLabel("Delete")
     .setPosition(390,190)
     .setSize(12,12)
     .setColorCaptionLabel(0)
     .setTriggerEvent(Bang.RELEASE)
     .moveTo("Composer")
     ;  
     /*
     activeSoundfile1 = cp5.addTextarea("activeSoundfile1")
     .setPosition(230,125) //(230,125)
     .setSize(250,13)
     .setFont(createFont("arial",14))
     .setLineHeight(15)
     .setColor(color(255))
     .setColorBackground(color(255,100))
     .setColorForeground(color(255,100))
     .moveTo("Composer")
     ;
     activeSoundfile1.setText("Lorem Ipsum is simply");
     */
     //Preset Text Visualizer   
     
     
    
     
  loadedSound1 = cp5.addTextlabel("activeSoundfile1")
                  .setPosition(150,123)
                  .setFont(createFont("arial",10))
                  .setLineHeight(12)
                  .setColor(color(255))
                  .moveTo("Composer")
                  .setColorBackground(color(155))
                  .setColorForeground(color(255));
                  //;
  //activeSoundfile1.setText("silence");
     
     
     loadedSound2 = cp5.addTextlabel("activeSoundfile2")
                 .setPosition(150,139)
                 .setFont(createFont("arial",10))
                  .setLineHeight(12)
                  .setColor(color(255))
                  .moveTo("Composer")
                  .setColorBackground(color(155))
                  .setColorForeground(color(255));
     //;
     
     loadedSound3 = cp5.addTextlabel("activeSoundfile3")
     .setPosition(150,155)
     .setSize(250,16)
     .setFont(createFont("arial",10))
                  .setLineHeight(12)
                  .setColor(color(255))
                  .setColorBackground(color(155))
                  .setColorForeground(color(155))
     .moveTo("Composer")
     ;
     loadedSound4 = cp5.addTextlabel("activeSoundfile4")
     .setPosition(150,171)
     .setSize(250,16)
     .setFont(createFont("arial",10))
                  .setLineHeight(12)
                  .setColor(color(255))
                  .setColorBackground(color(155))
                  .setColorForeground(color(155))
     .moveTo("Composer")
     ;
     loadedSound5 = cp5.addTextlabel("activeSoundfile5")
     .setPosition(150,187)
     .setSize(250,16)
     .setFont(createFont("arial",10))
                  .setLineHeight(12)
                  .setColor(color(255))
                  .setColorBackground(color(155))
                  .setColorForeground(color(155))
     .moveTo("Composer")
     ;
     
     cp5.addNumberbox("areaTouched")
     .setLabel("Area SURFACE 1")
     .setPosition(15,215)
     .setSize(55,12)
     .setValue(0)
     .setColorCaptionLabel(0)
     .setLock(true)
     .moveTo("Composer")
     ;
     cp5.addNumberbox("areaTouched2")
     .setLabel("Area SURFACE 2")
     .setPosition(100,215)
     .setSize(55,12)
     .setValue(0)
     .setColorCaptionLabel(0)
     .setLock(true)
     .moveTo("Composer")
     ;
     cp5.addNumberbox("areaTouched3")
     .setLabel("Area SURFACE 3")
     .setPosition(190,215)
     .setSize(55,12)
     .setValue(0)
     .setColorCaptionLabel(0)
     .setLock(true)
     .moveTo("Composer")
     ;
     cp5.addNumberbox("areaTouched4")
     .setLabel("Area SURFACE 4")
     .setPosition(280,215)
     .setSize(55,12)
     .setValue(0)
     .setColorCaptionLabel(0)
     .setLock(true)
     .moveTo("Composer")
     ;
     cp5.addNumberbox("areaTouched5")
     .setLabel("Area SURFACE 5")
     .setPosition(370,215)
     .setSize(55,12)
     .setValue(0)
     .setColorCaptionLabel(0)
     .setLock(true)
     .moveTo("Composer")
     ;
    
     
     
     /////////////////////////////////////////
     //// PLAYBACK PARAMETERS
     /////////////////////////////////////////
     //BACKGROUND RECTANGE AS TEXTBOX
    cp5.addTextarea("backSolid2")
                  .setPosition(10,255)
                  .setSize(720,80)
                  .setColor(color(128))
                  .setColorBackground(color(180))
                  .setColorForeground(color(180))
                  .moveTo("Composer")
                  ;  
     cp5.addTextarea("backSolid3")
                  .setPosition(10,355)
                  .setSize(720,80)
                  .setColor(color(128))
                  .setColorBackground(color(180))
                  .setColorForeground(color(180))
                  .moveTo("Composer")
                  ; 
                  
     cp5.addTextarea("backSolid4")
                  .setPosition(10,455)
                  .setSize(720,80)
                  .setColor(color(128))
                  .setColorBackground(color(180))
                  .setColorForeground(color(180))
                  .moveTo("Composer")
                  ; 
     cp5.addTextarea("backSolid5")
                  .setPosition(10,555)
                  .setSize(720,80)
                  .setColor(color(128))
                  .setColorBackground(color(180))
                  .setColorForeground(color(180))
                  .moveTo("Composer")
                  ; 
                  
     cp5.addTextarea("backSolid6")
                  .setPosition(10,655)
                  .setSize(720,80)
                  .setColor(color(128))
                  .setColorBackground(color(180))
                  .setColorForeground(color(180))
                  .moveTo("Composer")
                  ; 
                  
     cp5.addTextlabel("titleCH1")
      .setText("CH1")
      .setPosition(15,255)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
     
     nb1 = cp5.addNumberbox("numberboxDescriptor1")
     .setLabel(" ") //4) Enter Descriptor Position or play with slider")
     .setPosition(670,265)
     .setSize(40,14)
     .setScrollSensitivity(1.0)
     .moveTo("Composer")
     ;
     
     
     d1 = cp5.addSlider("sliderDescriptor1")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265)
      .setSize(550,40)
      .setRange(0,1000)
      .setScrollSensitivity(1.0)
      .moveTo("Composer")
      .setColorCaptionLabel(color(0))
      .setColorValueLabel(color(0))
      ;
      
       
   cp5.addTextfield("areaEditCh1")
     .setLabel("Edit")
     .setPosition(60,270)
     .setSize(20,20)
     .setFont(createFont("arial",10))
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .setAutoClear(true)
     .moveTo("Composer")
     ;
     
 
  activeAreaCh1 = cp5.addTextfield("activeAreaCh1")
     .setLabel("Active")
     .setPosition(85,270)
     .setSize(20,20)
     .setFont(createFont("arial",12))
     .setAutoClear(true)
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ;  
     
   cp5.addTextlabel("AreaCh1")
      .setText("AREA")
      .setPosition(55,255)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
      
   cp5.addBang("saveAreaCh1")
     .setLabel("save")
     .setPosition(35,272)
     .setSize(10,10)
     .setTriggerEvent(Bang.RELEASE)
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ; 
     
   areaSw1 = cp5.addToggle("areaSw1")
     .setPosition(12,272)
     .setLabel("area")
     .setSize(10,10)
     .setValue(true)
     .moveTo("Composer")
     ; 
      
      
      
      
   j1 = cp5.addSlider("jump1")
     .setLabel("jump")
     .setPosition(50,310)
     .setRange(0,100)
     .setSize(100,15)
     .moveTo("Composer")
     .setColorCaptionLabel(color(0))
       .setColorValueLabel(color(0))
     ;
     
   n1 = cp5.addSlider("neighborhood1")
     .setLabel("Neighborhood")
     .setPosition(210,310)
     .setRange(0,100)
     .setSize(100,15)
     .setValue(0)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .moveTo("Composer")
     ;
     
   gl1=cp5.addSlider("grainLow1")
     .setLabel("Grain LOW")
     .setSize(100,15)
     .setPosition(410,310)
     .setRange(1,300)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .moveTo("Composer")
     ;
     
   gh1=cp5.addSlider("grainHigh1")
     .setLabel("Grain HIGH")
     .setPosition(570,310)
     .setSize(100,15)
     .setRange(1,3000)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .moveTo("Composer")
     ;
     
   pedal1 = cp5.addToggle("pedal1")
     .setPosition(20,310)
     .setLabel("pedal")
     .setSize(25,10)
     .moveTo("Composer")
     ;  
      
   
     
     
   cp5.addTextlabel("titleCH2")
      .setText("CH2")
      .setPosition(15,255+separatorPlayback)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
     
     nb2 = cp5.addNumberbox("numberboxDescriptor2")
     .setLabel(" ") //4) Enter Descriptor Position or play with slider")
     .setPosition(670,265+separatorPlayback)
     .setSize(40,14)
     .setScrollSensitivity(1.0)
     .moveTo("Composer")
     ;
     
     
     d2 = cp5.addSlider("sliderDescriptor2")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265+separatorPlayback)
      .setSize(550,40)
      .setRange(0,1000)
      .setScrollSensitivity(1.0)
      .setColorCaptionLabel(color(0))
      .setColorValueLabel(color(0))
      .moveTo("Composer")
      ;
      
    cp5.addTextfield("areaEditCh2")
     .setLabel("Edit")
     .setPosition(60,270+separatorPlayback)
     .setSize(20,20)
     .setFont(createFont("arial",10))
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .setAutoClear(true)
     .moveTo("Composer")
     ;
     
 
  activeAreaCh2 = cp5.addTextfield("activeAreaCh2")
     .setLabel("Active")
     .setPosition(85,270+separatorPlayback)
     .setSize(20,20)
     .setFont(createFont("arial",12))
     .setAutoClear(true)
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ;  
     
   cp5.addTextlabel("AreaCh2")
      .setText("AREA")
      .setPosition(55,255+separatorPlayback)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
      
   cp5.addBang("saveAreaCh2")
     .setLabel("save")
     .setPosition(35,272+separatorPlayback)
     .setSize(10,10)
     .setTriggerEvent(Bang.RELEASE)
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ; 
     
   areaSw2 = cp5.addToggle("areaSw2")
     .setPosition(12,272+separatorPlayback)
     .setLabel("area")
     .setSize(10,10)
     .setValue(true)
     .moveTo("Composer")
     ; 
      
      
      
      
      
   j2=cp5.addSlider("jump2")
     .setLabel("jump")
     .setPosition(50,310+separatorPlayback)
     .setRange(0,100)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setSize(100,15)
     .moveTo("Composer")
     ;
     
   n2 = cp5.addSlider("neighborhood2")
     .setLabel("Neighborhood")
     .setPosition(210,310+separatorPlayback)
     .setRange(0,100)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setSize(100,15)
     .setValue(0)
     .moveTo("Composer")
     ;
     
   gl2=cp5.addSlider("grainLow2")
     .setLabel("Grain LOW")
     .setSize(100,15)
     .setPosition(410,310+separatorPlayback)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setRange(1,300)
     .moveTo("Composer")
     ;
     
   gh2=cp5.addSlider("grainHigh2")
     .setLabel("Grain HIGH")
     .setPosition(570,310+separatorPlayback)
     .setSize(100,15)
     .setRange(1,3000)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .moveTo("Composer")
     ;
     
     pedal2 = cp5.addToggle("pedal2")
     .setPosition(20,310+separatorPlayback)
     .setLabel("pedal")
     .setSize(25,10)
     .moveTo("Composer")
     ;
  
  cp5.addTextlabel("titleCH3")
      .setText("CH3")
      .setPosition(15,255+separatorPlayback*2)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
  
  nb3 = cp5.addNumberbox("numberboxDescriptor3")
     .setLabel(" ") //4) Enter Descriptor Position or play with slider")
     .setPosition(670,265+separatorPlayback*2)
     .setSize(40,14)
     .setScrollSensitivity(1.0)
     .moveTo("Composer")
     ;
     
     
     d3 = cp5.addSlider("sliderDescriptor3")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265+separatorPlayback*2)
      .setSize(550,40)
      .setRange(0,1000)
      .setScrollSensitivity(1.0)
      .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
      .moveTo("Composer")
      ;
      
      cp5.addTextfield("areaEditCh3")
     .setLabel("Edit")
     .setPosition(60,270+separatorPlayback*2)
     .setSize(20,20)
     .setFont(createFont("arial",10))
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .setAutoClear(true)
     .moveTo("Composer")
     ;
     
 
  activeAreaCh3 = cp5.addTextfield("activeAreaCh3")
     .setLabel("Active")
     .setPosition(85,270+separatorPlayback*2)
     .setSize(20,20)
     .setFont(createFont("arial",12))
     .setAutoClear(true)
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ;  
     
   cp5.addTextlabel("AreaCh3")
      .setText("AREA")
      .setPosition(55,255+separatorPlayback*2)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
      
   cp5.addBang("saveAreaCh3")
     .setLabel("save")
     .setPosition(35,272+separatorPlayback*2)
     .setSize(10,10)
     .setTriggerEvent(Bang.RELEASE)
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ; 
     
   areaSw3 = cp5.addToggle("areaSw3")
     .setPosition(12,272+separatorPlayback*2)
     .setLabel("area")
     .setSize(10,10)
     .setValue(true)
     .moveTo("Composer")
     ; 
      
      
      
      
      
   j3=cp5.addSlider("jump3")
     .setLabel("jump")
     .setPosition(50,310+separatorPlayback*2)
     .setRange(0,100)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setSize(100,15)
     .moveTo("Composer")
     ;
     
   n3 = cp5.addSlider("neighborhood3")
     .setLabel("Neighborhood")
     .setPosition(210,310+separatorPlayback*2)
     .setRange(0,100)
     .setSize(100,15)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setValue(0)
     .moveTo("Composer")
     ;
     
   gl3=cp5.addSlider("grainLow3")
     .setLabel("Grain LOW")
     .setSize(100,15)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setPosition(410,310+separatorPlayback*2)
     .setRange(1,300)
     .moveTo("Composer")
     ;
     
   gh3=cp5.addSlider("grainHigh3")
     .setLabel("Grain HIGH")
     .setPosition(570,310+separatorPlayback*2)
     .setSize(100,15)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setRange(1,3000)
     .moveTo("Composer")
     ;
     
     pedal3 = cp5.addToggle("pedal3")
     .setPosition(20,310+separatorPlayback*2)
     .setLabel("pedal")
     .setSize(25,10)
     .moveTo("Composer")
     ;
    
    cp5.addTextlabel("titleCH4")
      .setText("CH4")
      .setPosition(15,255+separatorPlayback*3)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
    
    nb4 = cp5.addNumberbox("numberboxDescriptor4")
     .setLabel(" ") //4) Enter Descriptor Position or play with slider")
     .setPosition(670,265+separatorPlayback*3)
     .setSize(40,14)
     .setScrollSensitivity(1.0)
     .moveTo("Composer")
     ;
     
     
     d4 = cp5.addSlider("sliderDescriptor4")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265+separatorPlayback*3)
      .setSize(550,40)
      .setRange(0,1000)
      .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
      .setScrollSensitivity(1.0)
      .moveTo("Composer")
      ;
       cp5.addTextfield("areaEditCh4")
     .setLabel("Edit")
     .setPosition(60,270+separatorPlayback*3)
     .setSize(20,20)
     .setFont(createFont("arial",10))
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .setAutoClear(true)
     .moveTo("Composer")
     ;
     
 
  activeAreaCh4 = cp5.addTextfield("activeAreaCh4")
     .setLabel("Active")
     .setPosition(85,270+separatorPlayback*3)
     .setSize(20,20)
     .setFont(createFont("arial",12))
     .setAutoClear(true)
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ;  
     
   cp5.addTextlabel("AreaCh4")
      .setText("AREA")
      .setPosition(55,255+separatorPlayback*3)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
      
   cp5.addBang("saveAreaCh4")
     .setLabel("save")
     .setPosition(35,272+separatorPlayback*3)
     .setSize(10,10)
     .setTriggerEvent(Bang.RELEASE)
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ; 
     
   areaSw4 = cp5.addToggle("areaSw4")
     .setPosition(12,272+separatorPlayback*3)
     .setLabel("area")
     .setSize(10,10)
     .setValue(true)
     .moveTo("Composer")
     ; 
      
      
      
      
      
      
   j4=cp5.addSlider("jump4")
     .setLabel("jump")
     .setPosition(50,310+separatorPlayback*3)
     .setRange(0,100)
     .setSize(100,15)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .moveTo("Composer")
     ;
     
   n4 = cp5.addSlider("neighborhood4")
     .setLabel("Neighborhood")
     .setPosition(210,310+separatorPlayback*3)
     .setRange(0,100)
     .setSize(100,15)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setValue(0)
     .moveTo("Composer")
     ;
     
   gl4=cp5.addSlider("grainLow4")
     .setLabel("Grain LOW")
     .setSize(100,15)
     .setPosition(410,310+separatorPlayback*3)
     .setRange(1,300)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .moveTo("Composer")
     ;
     
   gh4=cp5.addSlider("grainHigh4")
     .setLabel("Grain HIGH")
     .setPosition(570,310+separatorPlayback*3)
     .setSize(100,15)
     .setRange(1,3000)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .moveTo("Composer")
     ;    
     
     pedal4 = cp5.addToggle("pedal4")
     .setPosition(20,310+separatorPlayback*3)
     .setLabel("pedal")
     .setSize(25,10)
     .moveTo("Composer")
     ;
   
   cp5.addTextlabel("titleCH5")
      .setText("CH5")
      .setPosition(15,255+separatorPlayback*4)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
   
    nb5 = cp5.addNumberbox("numberboxDescriptor5")
     .setLabel(" ") //4) Enter Descriptor Position or play with slider")
     .setPosition(670,265+separatorPlayback*4)
     .setSize(40,14)
     .setScrollSensitivity(1.0)
     .moveTo("Composer")
     ;
     
     
     d5 = cp5.addSlider("sliderDescriptor5")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265+separatorPlayback*4)
      .setSize(550,40)
      .setRange(0,1000)
      .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
      .setScrollSensitivity(1.0)
      .moveTo("Composer")
      ;
       cp5.addTextfield("areaEditCh5")
     .setLabel("Edit")
     .setPosition(60,270+separatorPlayback*4)
     .setSize(20,20)
     .setFont(createFont("arial",10))
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .setAutoClear(true)
     .moveTo("Composer")
     ;
     
 
  activeAreaCh5 = cp5.addTextfield("activeAreaCh5")
     .setLabel("Active")
     .setPosition(85,270+separatorPlayback*4)
     .setSize(20,20)
     .setFont(createFont("arial",12))
     .setAutoClear(true)
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ;  
     
   cp5.addTextlabel("AreaCh5")
      .setText("AREA")
      .setPosition(55,255+separatorPlayback*4)
      .setColorValue(0)
      .setFont(createFont("Arial", 10))
      .moveTo("Composer")
      ;
      
   cp5.addBang("saveAreaCh5")
     .setLabel("save")
     .setPosition(35,272+separatorPlayback*4)
     .setSize(10,10)
     .setTriggerEvent(Bang.RELEASE)
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ; 
     
   areaSw5 = cp5.addToggle("areaSw5")
     .setPosition(12,272+separatorPlayback*4)
     .setLabel("area")
     .setSize(10,10)
     .setValue(true)
     .moveTo("Composer")
     ; 
      
      
      
      
      
      
   j5=cp5.addSlider("jump5")
     .setLabel("jump")
     .setPosition(50,310+separatorPlayback*4)
     .setRange(0,100)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setSize(100,15)
     .moveTo("Composer")
     ;
     
   n5 = cp5.addSlider("neighborhood5")
     .setLabel("Neighborhood")
     .setPosition(210,310+separatorPlayback*4)
     .setRange(0,100)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setSize(100,15)
     .setValue(0)
     .moveTo("Composer")
     ;
     
   gl5=cp5.addSlider("grainLow5")
     .setLabel("Grain LOW")
     .setSize(100,15)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .setPosition(410,310+separatorPlayback*4)
     .setRange(1,300)
     .moveTo("Composer")
     ;
     
   gh5=cp5.addSlider("grainHigh5")
     .setLabel("Grain HIGH")
     .setPosition(570,310+separatorPlayback*4)
     .setSize(100,15)
     .setRange(1,3000)
     .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
     .moveTo("Composer")
     ;
     
     pedal5 = cp5.addToggle("pedal5")
     .setPosition(20,310+separatorPlayback*4)
     .setLabel("pedal")
     .setSize(25,10)
     .moveTo("Composer")
     ;
    ////////////////////////////////////
    /// SAVERS & LOADERS
    ///////////////////////////////////

    cp5.addTextfield("savePresetField")
     .setLabel("Save Preset As")
     .setPosition(460,120)
     .setSize(120,20)
     .setFont(createFont("arial",10))
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .setAutoClear(true)
     .moveTo("Composer")
     ;
     
 
  activePresetField = cp5.addTextfield("activeInstrument")
     .setLabel("Active Instrument")
     .setPosition(460,180)
     .setSize(120,20)
     .setFont(createFont("arial",12))
     .setAutoClear(true)
     .setColorBackground(color(255, 128))
     .setColorActive(color(0))
     .setColorForeground(color(0, 0,0))
     .setColorValueLabel(0) 
     .setColorCaptionLabel(0)
     .moveTo("Composer")
     ;
  

  // LISTS OF PRESETS
  l = cp5.addListBox("savedInstruments")
     .setPosition(600, 140)
     .setSize(120, 120)
     .setItemHeight(20)
     .setBarHeight(20)
     .setColorBackground(color(120))
     .setColorActive(color(220))
     .setColorForeground(205)
     .setColorLabel(255) 
     .moveTo("Composer")
     ;
     

  l.captionLabel().toUpperCase(true);
  l.captionLabel().set("Saved Instruments");
  l.captionLabel().setColor(0xffff0000);
  l.captionLabel().style().marginTop = 3;
  l.valueLabel().style().marginTop = 3;
  l.setColorLabel(color(255)); 
  
  
  //buttons
  //cp5.addButton("saver", 0, 60, 60, 30, 12).setCaptionLabel("save").setColorBackground(color(255, 128)).moveTo("Composer");
  cp5.addButton("saver")
     .setValue(0)
     .setPosition(460,160)
     .setSize(30,20)
     .setColorBackground(color(128))
     .setCaptionLabel("save")
     .moveTo("Composer")
     ;
  //cp5.addButton("remover", 0, 301, 50, 80, 12).setCaptionLabel("remove").setColorBackground(color(0, 100, 50)).moveTo("Composer");

} //END OF GuiBuilder CODE (NO MORE DEFINITIONS BELOW HERE)



  


