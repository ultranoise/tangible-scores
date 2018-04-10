
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.io.FilenameFilter;
import java.net.URL;
import java.io.FileFilter;
import java.io.IOException;

import controlP5.*;
import oscP5.*;
import netP5.*;
import javax.swing.*; 
import com.dhchoi.CountdownTimer;
import com.dhchoi.CountdownTimerService;

import java.nio.file.Paths;
import java.io.*;

//final long SECOND_IN_MILLIS = 1000;
//final long HOUR_IN_MILLIS = 36000000;

CountdownTimer timer;
int elapsedTime = 0;
boolean playSeq = false;
boolean stopSeq = false;
boolean pauseSeq = false;


String timeText = "";
final int timeTextX = 5, timeTextY = 35;  // upper left corner of displayed text
color timeTextColor = color(255, 0, 0);  // color of text (red: stopped, green: running)
int timeTextSeconds = 0, timeTextMinutes = 0; // the seconds and minutes to be displayed
  
SecondApplet s;
OscP5 oscP5;
NetAddress myRemoteLocation;

ControlP5 cp5;
//ControlWindow controlWindow;

int myColor = color(0,0,0);
int backgroundColor = 255; //150; //255;

//OpenSoundControl Variables
int CH1Input = 0;
int CH1Vol= 0;
int CH2Vol= 0;
int CH3Vol= 0;
int CH4Vol= 0;
int CH5Vol= 0;
int CH1VolOld, CH2VolOld, CH3VolOld, CH4VolOld, CH5VolOld;

int numChannels = 5;
int[] CHVol = new int[numChannels];
int[] CHVolOld = new int[numChannels];

Slider abc;
boolean firstDraw=true;
PImage splash; 

Accordion accordion;

color c = color(0, 160, 100);

Textlabel Title;
CheckBox presets;
CheckBox activeChannels;
Textarea presetTxt, presetTxt2;
Textarea infoTxt, helpTxt, myTextarea, todoTxt;
Textarea myTextlabelB;

ListBox l,p, p2;
ListBox l2;
Textfield activePresetField, activeProjectField;
Textfield activeAreaCh1, activeAreaCh2, activeAreaCh3, activeAreaCh4, activeAreaCh5;
Textfield activeChannelField;
//Textarea activeSoundfile1, activeSoundfile2, activeSoundfile3, activeSoundfile4, activeSoundfile5;
Slider samplePosition;

//Bang activated1, activated2, activated3, activated4, activated5;
boolean[] Activated = new boolean[numChannels];

int[] desCh1 = new int[100];
int[] desCh2 = new int[100];
int[] desCh3 = new int[100];
int[] desCh4 = new int[100];
int[] desCh5 = new int[100];
int[] jumpCh1 = new int[100];
int[] jumpCh2 = new int[100];
int[] jumpCh3 = new int[100];
int[] jumpCh4 = new int[100];
int[] jumpCh5 = new int[100];

int[] nbhCh1 = new int[100];
int[] nbhCh2 = new int[100];
int[] nbhCh3 = new int[100];
int[] nbhCh4 = new int[100];
int[] nbhCh5 = new int[100];

int[] glCh1 = new int[100];
int[] glCh2 = new int[100];
int[] glCh3 = new int[100];
int[] glCh4 = new int[100];
int[] glCh5 = new int[100];

int[] ghCh1 = new int[100];
int[] ghCh2 = new int[100];
int[] ghCh3 = new int[100];
int[] ghCh4 = new int[100];
int[] ghCh5 = new int[100];

int indexAreaCh1 = 0;
int indexAreaCh2 = 0;
int indexAreaCh3 = 0;
int indexAreaCh4 = 0;
int indexAreaCh5 = 0;

Slider d1, d2, d3, d4, d5;  //search center slider
Slider n1, n2, n3, n4, n5;  //neighborhood
Slider j1, j2, j3, j4, j5;  //jump
Slider s1, s2, s3, s4, s5;  //search center
Slider gl1, gl2, gl3, gl4, gl5; //grain low
Slider gh1, gh2, gh3, gh4, gh5; //grain high
float maxdesc1, maxdesc2, maxdesc3, maxdesc4, maxdesc5;

Numberbox nb1, nb2, nb3, nb4, nb5;
Toggle input1, input2, input3, input4, input5, output1, output2, output3, output4, output5;
Toggle pedal1, pedal2, pedal3, pedal4, pedal5;
boolean pedal1Active = false;
boolean pedal2Active = false;
boolean pedal3Active = false;
boolean pedal4Active = false;
boolean pedal5Active = false;
int pedalVal1, pedalVal2, pedalVal3, pedalVal4, pedalVal5;
int separatorPlayback = 100;

Toggle areaSw1, areaSw2, areaSw3, areaSw4, areaSw5;
boolean areaSw1Active = false;
boolean areaSw2Active = false;
boolean areaSw3Active = false;
boolean areaSw4Active = false;
boolean areaSw5Active = false;

Canvas cc;
Tab main, composer, sequencerTab, info, help, todo;
  //saving instruments presets
  int presetCounter = 0;

File f;

JFileChooser fileChooser1,fileChooser2,fileChooser3,fileChooser4,fileChooser5, fileChooserSer;
FileNameExtensionFilter filter, filterSer; 

Textlabel loadedSound1, loadedSound2, loadedSound3, loadedSound4, loadedSound5;

File selectedFile;



int projectCounter = 0;

PImage play, pause, stop, matrix, midi;// = {loadImage("button_a.png"),loadImage("button_a.png"),loadImage("button_a.png")};

String projectPath;
boolean projectSaved = true;
boolean projectDefined = false;
File[] projects;
String projectName;

//sequencer
boolean drawSequencer = false;
String[] lines;
Edge[] edges = new Edge[50];
Node[] nodes = new Node[10];
HashMap nodeTable = new HashMap();
boolean instantiated = false;


boolean drawSequencerTab = false;
boolean drawInfoTab = false;
boolean drawTodoTab = false;

/*
public void init() {
  /// to make a frame not displayable, you can 
  // use frame.removeNotify() 
  frame.removeNotify(); 
 
  frame.setUndecorated(true); 
 
  // addNotify, here i am not sure if you have  
  // to add notify again.   
  frame.addNotify(); 
  super.init();
}
*/

void setup() {
  frame.setLocation(displayWidth/4 - 200, displayHeight/4);
  size(600, 400,OPENGL);
  
  
  frame.setResizable(true);
  
  
  /* start oscP5, listening for incoming messages at port 12000 */
  oscP5 = new OscP5(this,12000);
  myRemoteLocation = new NetAddress("127.0.0.1",12001);
  //myRemoteLocation = new NetAddress("192.168.178.25",12001);
  
  cp5 = new ControlP5(this);
  
  //draw splash Screen
  splash = loadImage("splash.jpg"); 
  image(splash, 0, 0); 
  
  //init OSC arrays
  for (int i=0; i < numChannels; i++) {         
    CHVol[i] = 0;
    CHVolOld[i] = 0;
    Activated[i] = false;
  }
  
  //canvas control
  //cc = new MyCanvas();
  //cc.pre(); // use cc.post(); to draw on top of existing controllers.
  
  //String workingdir = System.getProperty("user.dir");
  String workingdir = "/Users/iclab/Documents/timbre/timbreID-examples-0.6.4/sound/";
  fileChooser1 = new JFileChooser(new File(workingdir));
  fileChooser2 = new JFileChooser(new File(workingdir));
  fileChooser3 = new JFileChooser(new File(workingdir));
  fileChooser4 = new JFileChooser(new File(workingdir));
  fileChooser5 = new JFileChooser(new File(workingdir));
  filter = new FileNameExtensionFilter("WAV & AIFF files", "wav", "aif");
  filterSer = new FileNameExtensionFilter("Tangible Projects", "ser");

  
  //JFileChooser fileChooser = new JFileChooser(new File(workingdir));
  
  
  //sequencer file
  //lines = loadStrings("positions.txt");
  
  //imgs = {loadImage("button_a.png"),loadImage("button_a.png"),loadImage("button_a.png")};
  play = loadImage("playSmall2.png");
  pause = loadImage("pauseSmall.png");
  stop = loadImage("stopSmall.png");
  matrix = loadImage("netSmall.png");
  midi = loadImage("midiSmall.png");

  
  //println(dataPath(""));
  File dir = new File(dataPath("") + "/projects");
  dir.mkdir();
  
  File dirrr = new File(dataPath("") + "/other");
  dirrr.mkdir();
  
  
}

void draw() {
  
  //FIRST LOAD SPLASH SCREEN
  if (millis() < 5000)//in milliseconds
  {
    //background(255, 204, 0);
    image(splash, 0, 0); 
  }
  //LOAD CONTROL SCREEN
  else {
    //refresh
    background(90);//backgroundColor);

    //DRAW THE GUI ELEMENTS and INIT THEM to zero
    if(firstDraw) {
      frame.setSize(580, 600);
      
      noStroke();
      guiBuilder();
      firstDraw=false;   
      
      //create sequencer screen
      if(drawSequencer){
        PFrame f = new PFrame(width, height);
        //frame.setTitle("first window");
        f.setTitle("Sequencer");
      }
      
      
      //test to see the path in the exported app in Mac
      /*
      println("*********");
      //println(sketchPath("") + "data/projects/");
      //File director = new File (".");
      String logPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString() + "/../data/projects/";
      println(logPath);
      println("*********");
      //URL fileUrl = this.getClass().getProtectionDomain().getCodeSource().getLocation();
      File file2 = new File(logPath);
      String grandParent = file2.getParentFile().getParent();
      println(grandParent + "/data/projects");
      println("*********");
      */
      
      //get available projects
      File ff = new File(dataPath("") + "/projects"); // current directory

      FileFilter directoryFilter = new FileFilter() {
        public boolean accept(File file) {
          return file.isDirectory();
        }
      };

      projects = ff.listFiles(directoryFilter);   // files
      System.out.print("+++++ Projects: ");
      for (File file : projects) {
        if (file.isDirectory()) {
          System.out.print("directory:");
          try {          
                println(file.getCanonicalPath());
                println(file.getName());
                ListBoxItem pbi =p.addItem(file.getName(), projectCounter); 
                projectCounter=projectCounter+1;
                
              } catch(IOException ie) {
                  ie.printStackTrace();
              }
        } else {
          //System.out.print("     file:");
        }
           
      }
      
      //LOAD DEMO PROJECT AT INIT
      loadDemoProject();
      
      //test launching PD
      println("run pure data");
      
      try {
      //Runtime.getRuntime().exec("open" + " " + dataPath("") + "/audioengine/puredata/Pd-0.48-1-i386.app");
      String cmd = "open " + dataPath("") + "/audioengine/puredata/TangibleScoresToolkit.pd";
      Process p = Runtime.getRuntime().exec(cmd);
      }
      catch(IOException e) {
      println("runExternalCommand: IOException:" + e);
      }
      println("open" + " " + dataPath("") + "/audioengine/puredata/Pd-0.48-1-i386.app");
      
    
    } // END FIRST DRAW

    //check OSC senders every frame
    //init OSC arrays
    for (int i=0; i < numChannels; i++) {         
      if(CHVol[i] != CHVolOld[i]){
        sendOsc(CHVol[i],i+1);
        CHVolOld[i] = CHVol[i];
      }
    }
   
   
    
   
   
  
  } //end of second screen loop
  
  
} //end of main loop (draw)

void fileToPd(int channel){
    int result = fileChooser1.showOpenDialog(this);
    println("result : " + result);
    
    if (result == JFileChooser.APPROVE_OPTION) {
          selectedFile = fileChooser1.getSelectedFile();
          println("Selected file: " + selectedFile.getAbsolutePath());
          println("file: " + selectedFile.getName());       
          loadedSound1.setText(selectedFile.getName());           
     }
}


void loadDemoProject(){
    
      println("------ loading project -----------");
      println("Project name: demo");
      
      //write in active project field
      activeProjectField.setValue("demo");
      
      //update path of this project
      projectPath = dataPath("") + "/projects/" + "demo";
      
      projectName =  "demo";
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
      
      
     println("---------                ----------------");
     instantiated = true; 
}

