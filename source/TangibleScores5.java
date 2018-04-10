import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import javax.swing.JFileChooser; 
import javax.swing.filechooser.FileNameExtensionFilter; 
import java.io.File; 
import java.nio.file.CopyOption; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
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

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class TangibleScores5 extends PApplet {









//import java.nio.file.StandardCopyOption;











 






//final long SECOND_IN_MILLIS = 1000;
//final long HOUR_IN_MILLIS = 36000000;

CountdownTimer timer;
int elapsedTime = 0;
boolean playSeq = false;
boolean stopSeq = false;
boolean pauseSeq = false;


String timeText = "";
final int timeTextX = 5, timeTextY = 35;  // upper left corner of displayed text
int timeTextColor = color(255, 0, 0);  // color of text (red: stopped, green: running)
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

int c = color(0, 160, 100);

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

public void setup() {
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

public void draw() {
  
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

public void fileToPd(int channel){
    int result = fileChooser1.showOpenDialog(this);
    println("result : " + result);
    
    if (result == JFileChooser.APPROVE_OPTION) {
          selectedFile = fileChooser1.getSelectedFile();
          println("Selected file: " + selectedFile.getAbsolutePath());
          println("file: " + selectedFile.getName());       
          loadedSound1.setText(selectedFile.getName());           
     }
}


public void loadDemoProject(){
    
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
      
      //read all the presets (.ser extension) in project\u00b4 folder and load them in presets
      
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


final long SECOND_IN_MILLIS = 1000;
final long HOUR_IN_MILLIS = 36000000;



class TestCanvas extends Canvas {
  
  float n;
  float a;
  int time;
  public void setup(PApplet p) {
    //println("starting a test canvas.");

    
    time=0;
  }
  public void draw(PApplet p) {
    noFill();
    stroke(204, 102, 0);
    beginShape();
vertex(0.0f, 228.5763f);
bezierVertex(0.0f, 228.5763f, -112.0f, 225.93628f, 0.0f, 228.5763f);
bezierVertex(112.0f, 231.21631f, 169.0f, 220.65625f, 169.0f, 220.65625f);
bezierVertex(169.0f, 220.65625f, 283.0f, 199.53613f, 284.0f, 199.53613f);
bezierVertex(285.0f, 199.53613f, 319.0f, 227.5203f, 322.0f, 228.04831f);
bezierVertex(325.0f, 228.5763f, 397.0f, 225.93628f, 399.0f, 225.4083f);
bezierVertex(401.0f, 224.88028f, 438.0f, 211.15219f, 440.0f, 210.62418f);
bezierVertex(442.0f, 210.09619f, 485.0f, 219.60025f, 485.0f, 219.60025f);
bezierVertex(485.0f, 219.60025f, 572.0f, 223.29626f, 572.0f, 223.29626f);
bezierVertex(572.0f, 223.29626f, 664.0f, 205.87216f, 665.0f, 205.34415f);
bezierVertex(666.0f, 204.81616f, 734.0f, 180.0f, 734.0f, 180.0f);
bezierVertex(734.0f, 180.0f, 770.0f, 205.34415f, 772.0f, 205.87216f);
endShape();

stroke(104, 202, 0);
beginShape();
vertex(5.0f, 119.09059f);
bezierVertex(5.0f, 119.09059f, 5.0f, 119.09059f, 5.0f, 119.09059f);
bezierVertex(5.0f, 119.09059f, 47.0f, 136.14424f, 48.0f, 136.14424f);
bezierVertex(49.0f, 136.14424f, 110.0f, 139.79858f, 113.0f, 139.79858f);
bezierVertex(116.0f, 139.79858f, 154.0f, 154.416f, 158.0f, 155.02505f);
bezierVertex(162.0f, 155.63412f, 226.0f, 148.93448f, 229.0f, 147.71635f);
bezierVertex(232.0f, 146.49823f, 254.0f, 138.58047f, 269.0f, 131.88083f);
bezierVertex(284.0f, 125.18118f, 295.0f, 118.48154f, 300.0f, 117.87247f);
bezierVertex(305.0f, 117.26341f, 290.0f, 110.56377f, 333.0f, 117.26341f);
bezierVertex(376.0f, 123.96306f, 380.0f, 125.79024f, 397.0f, 130.05365f);
bezierVertex(414.0f, 134.31706f, 444.0f, 141.01671f, 446.0f, 141.01671f);
bezierVertex(448.0f, 141.01671f, 474.0f, 127.61742f, 477.0f, 140.40765f);
bezierVertex(480.0f, 153.19788f, 510.0f, 130.6627f, 479.0f, 141.62576f);
bezierVertex(448.0f, 152.58882f, 650.0f, 113.0f, 650.0f, 113.0f);
bezierVertex(650.0f, 113.0f, 741.0f, 114.21811f, 741.0f, 114.21811f);
bezierVertex(741.0f, 114.21811f, 757.0f, 141.62576f, 757.0f, 141.62576f);
bezierVertex(757.0f, 141.62576f, 813.0f, 142.23482f, 813.0f, 142.23482f);
endShape();

stroke(204, 102, 100);
beginShape();
vertex(5.0f, 309.0f);
bezierVertex(5.0f, 309.0f, 5.0f, 309.0f, 5.0f, 309.0f);
bezierVertex(5.0f, 309.0f, 65.0f, 276.0f, 65.0f, 276.0f);
bezierVertex(65.0f, 276.0f, 118.0f, 336.0f, 118.0f, 336.0f);
bezierVertex(118.0f, 336.0f, 122.0f, 319.0f, 140.0f, 311.0f);
bezierVertex(158.0f, 303.0f, 165.0f, 298.0f, 169.0f, 298.0f);
bezierVertex(173.0f, 298.0f, 202.0f, 303.0f, 220.0f, 317.0f);
bezierVertex(238.0f, 331.0f, 261.0f, 347.0f, 269.0f, 343.0f);
bezierVertex(277.0f, 339.0f, 294.0f, 307.0f, 302.0f, 303.0f);
bezierVertex(310.0f, 299.0f, 283.0f, 284.0f, 349.0f, 299.0f);
bezierVertex(415.0f, 314.0f, 410.0f, 314.0f, 417.0f, 314.0f);
bezierVertex(424.0f, 314.0f, 441.0f, 323.0f, 442.0f, 323.0f);
bezierVertex(443.0f, 323.0f, 490.0f, 327.0f, 490.0f, 327.0f);
bezierVertex(490.0f, 327.0f, 509.0f, 318.0f, 510.0f, 318.0f);
bezierVertex(511.0f, 318.0f, 529.0f, 321.0f, 531.0f, 325.0f);
bezierVertex(533.0f, 329.0f, 533.0f, 335.0f, 538.0f, 333.0f);
bezierVertex(543.0f, 331.0f, 559.0f, 318.0f, 559.0f, 318.0f);
bezierVertex(559.0f, 318.0f, 571.0f, 321.0f, 571.0f, 322.0f);
bezierVertex(571.0f, 323.0f, 591.0f, 329.0f, 592.0f, 329.0f);
bezierVertex(593.0f, 329.0f, 604.0f, 325.0f, 604.0f, 325.0f);
bezierVertex(604.0f, 325.0f, 643.0f, 317.0f, 643.0f, 317.0f);
bezierVertex(643.0f, 317.0f, 650.0f, 320.0f, 651.0f, 320.0f);
bezierVertex(652.0f, 320.0f, 695.0f, 323.0f, 696.0f, 322.0f);
bezierVertex(697.0f, 321.0f, 674.0f, 335.0f, 719.0f, 321.0f);
bezierVertex(764.0f, 307.0f, 768.0f, 308.0f, 770.0f, 308.0f);
bezierVertex(772.0f, 308.0f, 779.0f, 322.0f, 783.0f, 323.0f);
bezierVertex(787.0f, 324.0f, 803.0f, 323.0f, 803.0f, 323.0f);
endShape();

stroke(4, 102, 200);
beginShape();
vertex(12.0f, 406.0f);
bezierVertex(12.0f, 406.0f, 12.0f, 405.0f, 12.0f, 406.0f);
bezierVertex(12.0f, 407.0f, 36.0f, 403.0f, 36.0f, 403.0f);
bezierVertex(36.0f, 403.0f, 41.0f, 407.0f, 42.0f, 409.0f);
bezierVertex(43.0f, 411.0f, 47.0f, 412.0f, 52.0f, 410.0f);
bezierVertex(57.0f, 408.0f, 85.0f, 400.0f, 85.0f, 400.0f);
bezierVertex(85.0f, 400.0f, 89.0f, 397.0f, 91.0f, 400.0f);
bezierVertex(93.0f, 403.0f, 92.0f, 402.0f, 93.0f, 403.0f);
bezierVertex(94.0f, 404.0f, 114.0f, 405.0f, 118.0f, 406.0f);
bezierVertex(122.0f, 407.0f, 128.0f, 401.0f, 129.0f, 401.0f);
bezierVertex(130.0f, 401.0f, 128.0f, 399.0f, 133.0f, 405.0f);
bezierVertex(138.0f, 411.0f, 141.0f, 411.0f, 141.0f, 411.0f);
bezierVertex(141.0f, 411.0f, 138.0f, 403.0f, 143.0f, 412.0f);
bezierVertex(148.0f, 421.0f, 160.0f, 424.0f, 167.0f, 450.0f);
bezierVertex(174.0f, 476.0f, 170.0f, 453.0f, 180.0f, 479.0f);
bezierVertex(190.0f, 505.0f, 202.0f, 556.0f, 192.0f, 498.0f);
bezierVertex(182.0f, 440.0f, 181.0f, 430.0f, 182.0f, 428.0f);
bezierVertex(183.0f, 426.0f, 185.0f, 411.0f, 191.0f, 409.0f);
bezierVertex(197.0f, 407.0f, 219.0f, 398.0f, 222.0f, 398.0f);
bezierVertex(225.0f, 398.0f, 235.0f, 397.0f, 235.0f, 400.0f);
bezierVertex(235.0f, 403.0f, 235.0f, 415.0f, 235.0f, 415.0f);
bezierVertex(235.0f, 415.0f, 236.0f, 413.0f, 237.0f, 415.0f);
bezierVertex(238.0f, 417.0f, 236.0f, 416.0f, 239.0f, 418.0f);
bezierVertex(242.0f, 420.0f, 250.0f, 423.0f, 253.0f, 430.0f);
bezierVertex(256.0f, 437.0f, 236.0f, 432.0f, 263.0f, 440.0f);
bezierVertex(290.0f, 448.0f, 301.0f, 449.0f, 305.0f, 447.0f);
bezierVertex(309.0f, 445.0f, 312.0f, 430.0f, 311.0f, 428.0f);
bezierVertex(310.0f, 426.0f, 307.0f, 424.0f, 308.0f, 419.0f);
bezierVertex(309.0f, 414.0f, 307.0f, 415.0f, 313.0f, 411.0f);
bezierVertex(319.0f, 407.0f, 319.0f, 405.0f, 330.0f, 405.0f);
bezierVertex(341.0f, 405.0f, 348.0f, 405.0f, 350.0f, 405.0f);
bezierVertex(352.0f, 405.0f, 353.0f, 405.0f, 359.0f, 405.0f);
bezierVertex(365.0f, 405.0f, 369.0f, 405.0f, 371.0f, 405.0f);
bezierVertex(373.0f, 405.0f, 538.0f, 412.0f, 540.0f, 412.0f);
bezierVertex(542.0f, 412.0f, 679.0f, 412.0f, 682.0f, 412.0f);
bezierVertex(685.0f, 412.0f, 757.0f, 411.0f, 757.0f, 411.0f);
bezierVertex(757.0f, 411.0f, 800.0f, 413.0f, 800.0f, 413.0f);
endShape();

stroke(4, 2, 200);
beginShape();
vertex(22.0f, 540.0f);
bezierVertex(22.0f, 540.0f, 20.0f, 540.0f, 22.0f, 540.0f);
bezierVertex(24.0f, 540.0f, 41.0f, 541.0f, 43.0f, 541.0f);
bezierVertex(45.0f, 541.0f, 127.0f, 546.0f, 127.0f, 546.0f);
bezierVertex(127.0f, 546.0f, 192.0f, 544.0f, 196.0f, 544.0f);
bezierVertex(200.0f, 544.0f, 234.0f, 523.0f, 235.0f, 523.0f);
bezierVertex(236.0f, 523.0f, 297.0f, 512.0f, 299.0f, 511.0f);
bezierVertex(301.0f, 510.0f, 358.0f, 544.0f, 358.0f, 544.0f);
bezierVertex(358.0f, 544.0f, 416.0f, 549.0f, 418.0f, 549.0f);
bezierVertex(420.0f, 549.0f, 437.0f, 553.0f, 437.0f, 553.0f);
bezierVertex(437.0f, 553.0f, 621.0f, 542.0f, 634.0f, 543.0f);
bezierVertex(647.0f, 544.0f, 751.0f, 523.0f, 752.0f, 523.0f);
bezierVertex(753.0f, 523.0f, 801.0f, 536.0f, 810.0f, 541.0f);
endShape();


/*
    int steps = 10;
    
    if( millis() > time ){
      time = millis() + 200;
        for (int i = 0; i <= steps; i++) {
          float t = i / float(steps);
          float x = bezierPoint(22, 20, 22, 22, t);
          float y = bezierPoint(540, 541, 541, 541, t);
          ellipse(x, y, 5, 5);
        }
    }

*/

  }
  



  
  
  
}


//GUI Builder

public void guiBuilder() {
  
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
                    
                    + "mirar si hay un enveloping m\u00e1s r\u00e1pido y menos bruto, m\u00e1s logaritmico"
                    
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
     .setScrollSensitivity(1.0f)
     .moveTo("Composer")
     ;
     
     
     d1 = cp5.addSlider("sliderDescriptor1")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265)
      .setSize(550,40)
      .setRange(0,1000)
      .setScrollSensitivity(1.0f)
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
     .setScrollSensitivity(1.0f)
     .moveTo("Composer")
     ;
     
     
     d2 = cp5.addSlider("sliderDescriptor2")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265+separatorPlayback)
      .setSize(550,40)
      .setRange(0,1000)
      .setScrollSensitivity(1.0f)
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
     .setScrollSensitivity(1.0f)
     .moveTo("Composer")
     ;
     
     
     d3 = cp5.addSlider("sliderDescriptor3")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265+separatorPlayback*2)
      .setSize(550,40)
      .setRange(0,1000)
      .setScrollSensitivity(1.0f)
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
     .setScrollSensitivity(1.0f)
     .moveTo("Composer")
     ;
     
     
     d4 = cp5.addSlider("sliderDescriptor4")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265+separatorPlayback*3)
      .setSize(550,40)
      .setRange(0,1000)
      .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
      .setScrollSensitivity(1.0f)
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
     .setScrollSensitivity(1.0f)
     .moveTo("Composer")
     ;
     
     
     d5 = cp5.addSlider("sliderDescriptor5")
      .setLabel("SEARCH CENTER ")
      .setPosition(115,265+separatorPlayback*4)
      .setSize(550,40)
      .setRange(0,1000)
      .setColorCaptionLabel(color(0))
     .setColorValueLabel(color(0))
      .setScrollSensitivity(1.0f)
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
      
      //read all the presets (.ser extension) in project\u00b4 folder and load them in presets
      
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
  public void numberboxDescriptor1(int theInt) {
    d1.setValue(theInt);
  }
  public void numberboxDescriptor2(int theInt) {
    d2.setValue(theInt);
  }
  public void numberboxDescriptor3(int theInt) {
    d3.setValue(theInt);
  }
  public void numberboxDescriptor4(int theInt) {
    d4.setValue(theInt);
  }
  public void numberboxDescriptor5(int theInt) {
    d5.setValue(theInt);
  }

 public void showMaxDescriptor1(int theInt) {
    maxdesc1=theInt;
  }
  public void showMaxDescriptor2(int theInt) {
    maxdesc2=theInt;
  }
  public void showMaxDescriptor3(int theInt) {
    maxdesc3=theInt;
  }
  public void showMaxDescriptor4(int theInt) {
    maxdesc4=theInt;
  }
  public void showMaxDescriptor5(int theInt) {
    maxdesc5=theInt;
  }

  // GET EVENTS FROM GUI OBJECTS LIKE BANGS, OR THE PRESET CLICKED
  
  public void ANALYZEE(int theValue) {
    println("boton 2");
  }
  
  /////////////
  //// toggles to activate channels
  ////////////////
  public void input1(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,16);  
      input1.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,16);
      input1.setColorActive(color(255, 0, 0));
    }
  }
  public void input2(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,17);
      input2.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,17);
      input2.setColorActive(color(255, 0, 0));
    }
  }
  public void input3(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,18);
      input3.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,18);
      input3.setColorActive(color(255, 0, 0));
    }
  }
  public void input4(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,19);
      input4.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,19);
      input4.setColorActive(color(255, 0, 0));
    }
  }
  public void input5(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,20);
      input5.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,20);
      input5.setColorActive(color(255, 0, 0));
    }
  }
  public void output1(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,21);
      output1.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,21);
      output1.setColorActive(color(255, 0, 0));
    }
  }
  public void output2(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,22);
      output2.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,22);
      output2.setColorActive(color(255, 0, 0));
    }
  }
  public void output3(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,23);
      output3.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,23);
      output3.setColorActive(color(255, 0, 0));
    }
  }
  public void output4(boolean theFlag) {
    if(theFlag==false) {
      sendOsc(1,24);
      output4.setColorActive(color(0, 255, 0));
    } else {
      sendOsc(0,24);
      output4.setColorActive(color(255, 0, 0));
    }
  }
  public void output5(boolean theFlag) {
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
  public void saver(float v) {
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
    
    public void sliderDescriptor1(int value) {
      desCh1[indexAreaCh1] = value;
      sendOsc(value,31);
    }
    public void jump1(int value) {
      jumpCh1[indexAreaCh1] = value;
      sendOsc(value,32);
    }
    public void neighborhood1(int value) {
      nbhCh1[indexAreaCh1] = value;
      sendOsc(value,33);
    }
    public void grainLow1(int value) {
      glCh1[indexAreaCh1] = value;
      sendOsc(value,34);
    }
    public void grainHigh1(int value) {
      ghCh1[indexAreaCh1] = value;
      sendOsc(value,35);
    }
    public void pedal1(boolean theFlag) {
      if(theFlag==true) {
        pedal1Active = true;
      } else {
        pedal1Active = false;
      }
    }
    public void pedal2(boolean theFlag) {
      if(theFlag==true) {
        pedal2Active = true;
      } else {
        pedal2Active = false;
      }
    }
    public void pedal3(boolean theFlag) {
      if(theFlag==true) {
        pedal3Active = true;
      } else {
        pedal3Active = false;
      }
    }
    public void pedal4(boolean theFlag) {
      if(theFlag==true) {
        pedal4Active = true;
      } else {
        pedal4Active = false;
      }
    }
    public void pedal5(boolean theFlag) {
      if(theFlag==true) {
        pedal5Active = true;
      } else {
        pedal5Active = false;
      }
    }
    public void areaSw1(boolean theFlag) {
      if(theFlag==true) {
        areaSw1Active = true;
      } else {
        areaSw1Active = false;
      }
    }
    public void areaSw2(boolean theFlag) {
      if(theFlag==true) {
        areaSw2Active = true;
      } else {
        areaSw2Active = false;
      }
    }
    public void areaSw3(boolean theFlag) {
      if(theFlag==true) {
        areaSw3Active = true;
      } else {
        areaSw3Active = false;
      }
    }
    public void areaSw4(boolean theFlag) {
      if(theFlag==true) {
        areaSw4Active = true;
      } else {
        areaSw4Active = false;
      }
    }
    public void areaSw5(boolean theFlag) {
      if(theFlag==true) {
        areaSw5Active = true;
      } else {
        areaSw5Active = false;
      }
    }
    
    public void sliderDescriptor2(int value) {
      desCh2[indexAreaCh2] = value;
      sendOsc(value,41);
    }
    public void jump2(int value) {
      jumpCh2[indexAreaCh2] = value;
      sendOsc(value,42);
    }
    public void neighborhood2(int value) {
      nbhCh2[indexAreaCh2] = value;
      sendOsc(value,43);
    }
    public void grainLow2(int value) {
      glCh2[indexAreaCh2] = value;
      sendOsc(value,44);
    }
    public void grainHigh2(int value) {
      ghCh2[indexAreaCh2] = value;
      sendOsc(value,45);
    }
    
    public void sliderDescriptor3(int value) {
      desCh3[indexAreaCh3] = value;
      sendOsc(value,51);
    }
    public void jump3(int value) {
      jumpCh3[indexAreaCh3] = value;
      sendOsc(value,52);
    }
    public void neighborhood3(int value) {
      nbhCh3[indexAreaCh3] = value;
      sendOsc(value,53);
    }
    public void grainLow3(int value) {
      glCh3[indexAreaCh3] = value;
      sendOsc(value,54);
    }
    public void grainHigh3(int value) {
      ghCh3[indexAreaCh3] = value;
      sendOsc(value,55);
    }
    
    public void sliderDescriptor4(int value) {
      desCh4[indexAreaCh4] = value;
      sendOsc(value,61);
    }
    public void jump4(int value) {
      jumpCh4[indexAreaCh4] = value;
      sendOsc(value,62);
    }
    public void neighborhood4(int value) {
      nbhCh4[indexAreaCh4] = value;
      sendOsc(value,63);
    }
    public void grainLow4(int value) {
      glCh4[indexAreaCh4] = value;
      sendOsc(value,64);
    }
    public void grainHigh4(int value) {
      ghCh4[indexAreaCh4] = value;
      sendOsc(value,65);
    }
    
    public void sliderDescriptor5(int value) {
      desCh5[indexAreaCh5] = value;
      sendOsc(value,71);
    }
    public void jump5(int value) {
      sendOsc(value,72);
      jumpCh5[indexAreaCh5] = value;
    }
    public void neighborhood5(int value) {
      nbhCh5[indexAreaCh5] = value;
      sendOsc(value,73);
    }
    public void grainLow5(int value) {
      glCh5[indexAreaCh5] = value;
      sendOsc(value,74);
    }
    public void grainHigh5(int value) {
      ghCh5[indexAreaCh5] = value;
      sendOsc(value,75);
    }

  public void CH1Vol(int theValue) {
    sendOsc(theValue,1);
  }
  public void CH2Vol(int theValue) {
    sendOsc(theValue,2);
  }
  public void CH3Vol(int theValue) {
    sendOsc(theValue,3);
  }
  public void CH4Vol(int theValue) {
    sendOsc(theValue,4);
  }
  public void CH5Vol(int theValue) {
    sendOsc(theValue,5);
  }
  
  public void Thres1(int theValue) {
    sendOsc(theValue,6);
  }
  public void Thres2(int theValue) {
    sendOsc(theValue,7);
  }
  public void Thres3(int theValue) {
    sendOsc(theValue,8);
  }
  public void Thres4(int theValue) {
    sendOsc(theValue,9);
  }
  public void Thres5(int theValue) {
    sendOsc(theValue,10);
  }


  

  public void remover(float v) {
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
  public void loadData(String[] lines) {
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
  
  public void addEdge(int index, String preset, int time) {
    
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
  
    
  public Node findNode(int index, String preset, int time) {
    
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
  
  
  public Node addNode(int index, String preset, int time) {
    Node n = new Node(this, index, preset, time);  
    if (nodeCount == nodes.length) {
      nodes = (Node[]) expand(nodes);
    }
    nodeTable.put(index, n);
    nodes[nodeCount++] = n;  
    return n;
  }
 
  


//OpenSoundControl Management

/////////////////////////////////////////////////////////////////
////////////receiverssssss
/////////////////////////////////////////////////////////////////

/* incoming osc message are forwarded to the oscEvent method. */
public void oscEvent(OscMessage theOscMessage) {

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

public void sendOsc(int value, int parameter) {
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

public void sendOscString(String value, int parameter) {

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
    //println("sent to Pd: " + myMessage);
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


  int nodeCount;
  //Node[] nodes = new Node[10];
  //HashMap nodeTable = new HashMap();

  int edgeCount;
  //Edge[] edges = new Edge[50];

  static final int nodeColor   = 0xffF0C070;
  static final int nodeActiveColor = 0xff00C070;
  static final int selectColor = 0xffFF3030;
  static final int fixedColor  = 0xffFF8080;
  static final int edgeColor   = 0xff000000;

public class PFrame extends JFrame {
  public PFrame(int width, int height) {
    setBounds(100, 100, width, height);
    s = new SecondApplet();
    add(s);
    s.init();
    show();
  }
}


public class SecondApplet extends PApplet {
    
  boolean firstEntry = true;
  public String hola = "hola";

  PFont font;

  /*
  Node[] nodes = new Node[10];
  HashMap nodeTable = new HashMap();
  Edge[] edges = new Edge[50];
  int edgeCount;
  */
  int actualTime=0;
  int lastActiveNode = 0;
  int activeNode = 0;
  
  public void setup() {

    background(255);
    textSize(32);
    noStroke();
    
    //timer creation
    timer = CountdownTimerService.getNewCountdownTimer(this).configure(SECOND_IN_MILLIS, HOUR_IN_MILLIS);
    updateTimeText();
    
    //NODES init from the file
    /*
    loadData(lines);   
    
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
    */
    
    //other
    font = createFont("arial", 20);
    //.setFont(createFont("arial",14))
    textFont(font);  
    smooth();
    
  }

  public void draw() {

    background(255);
    
    fill(color(200)); 
    rect(5,5,80,30);
    
    rect(90,5,280,30);
    
    //update active node
    activeNode = updateActivePreset();
    
        //detect change of preset 
        if(activeNode != lastActiveNode){  
          lastActiveNode = activeNode;
          println("new preset loaded by seq: " + nodes[activeNode].preset);
          
          //////load preset 
          cp5.loadProperties((projectPath + "/" + nodes[activeNode].preset)+".ser");
          println("Preset loaded by seq: "+ nodes[activeNode].preset);
          
          //write in active preset field
          activePresetField.setValue(nodes[activeNode].preset);
          //println("Preset sent to active "+ l.getItem(test).getName());  
      
    
          //send values of new loaded sounds (/presetsoundfile1)    
         sendOscString(loadedSound1.getStringValue(), 121);
         sendOscString(loadedSound2.getStringValue(), 122); 
         sendOscString(loadedSound3.getStringValue(), 123); 
         sendOscString(loadedSound4.getStringValue(), 124); 
         sendOscString(loadedSound5.getStringValue(), 125);  
          
          ////////////////
        }
    
    //show timer
    fill(color(0));  
    text(timeText, timeTextX +10, timeTextY - 10);
    
    if(playSeq) {
      if(timer.isRunning()) {
          // STOP_IMMEDIATELY: stop immediately as soon as button was clicked
          //timer.stop(CountdownTimer.StopBehavior.STOP_IMMEDIATELY); // stop stopwatch
          //timeTextColor = color(255, 0, 0);  // red: stopped
        }
        else {
          // Even though the stopwatch was previously stopped with STOP_IMMEDIATELY,
          // the stopwatch will not start from where it was stopped
          // but rather count another full second before updating the timeText.
          // This is because the CountdownTimer was initially configured
          // to have one second as the smallest unit of a tick interval.
          // Decreasing the CountdownTimer's tick interval can fine tune this behavior.  
          timer.start(); // resume stopwatch
          timeTextColor = color(0, 255, 0);  // green: running
        }
      playSeq=false;
    }
    
    if(pauseSeq){
      if(timer.isRunning()) {
          // STOP_IMMEDIATELY: stop immediately as soon as button was clicked
          timer.stop(CountdownTimer.StopBehavior.STOP_IMMEDIATELY); // stop stopwatch
          timeTextColor = color(255, 0, 0);  // red: stopped
        }
        else {
          // Even though the stopwatch was previously stopped with STOP_IMMEDIATELY,
          // the stopwatch will not start from where it was stopped
          // but rather count another full second before updating the timeText.
          // This is because the CountdownTimer was initially configured
          // to have one second as the smallest unit of a tick interval.
          // Decreasing the CountdownTimer's tick interval can fine tune this behavior.  
          //timer.start(); // resume stopwatch
          //timeTextColor = color(0, 255, 0);  // green: running
        }
      pauseSeq=false;
    }
    
    if(stopSeq) {
      // STOP_AFTER_INTERVAL: reset after full second tick has passed
      timer.reset(CountdownTimer.StopBehavior.STOP_AFTER_INTERVAL); // reset stopwatch (stops first if it was running)
      timeTextColor = color(255, 0, 0);  // red: stopped
    
      elapsedTime = 0;
      
      int lastActive = 0;
      for (int i = 0 ; i < nodeCount ; i++) {     
        nodes[i].active = false;
        actualTime = 0;
        lastActive = 0;    
      }
      
      updateTimeText();
      
      stopSeq = false;
    }
    
    
    //time to next preset
    if(activeNode < nodeCount-1){
      text("Seconds to next change: " + Integer.toString(nodes[activeNode+1].time - actualTime), timeTextX + 100, timeTextY - 10);
    }
    else {  
      text("end of sequence ", timeTextX + 100, timeTextY - 10);
    }
    /*
    print("actual node: ");
    println(nodes[lastActiveNode].preset);
    print("time of actual node: ");
    println(nodes[lastActiveNode].time);
    print("time of next node: ");
    println(nodes[lastActiveNode+1].time);
    print("actual Time: ");
    println(actualTime);
    */
    
    //nodes update and draw
    for (int i = 0; i < nodeCount; i++) {
      nodes[i].update();
    }
    
    //println("edges: " + edgeCount);
    for (int i = 0 ; i < edgeCount ; i++) {   
      stroke(edgeColor);
      strokeWeight(0.35f);
      line(edges[i].from.x, edges[i].from.y, edges[i].to.x, edges[i].to.y);    
    }
    
    //println("nodos: " + nodeCount);
    for (int i = 0 ; i < nodeCount ; i++) {
      
      if(nodes[i].active){
        fill(nodeActiveColor);
      } else{
        fill(nodeColor);
      }
      
      stroke(0);
      strokeWeight(0.5f);
    
      ellipse(nodes[i].x, nodes[i].y, nodes[i].count*10, nodes[i].count*10);

      fill(125);
      text(nodes[i].preset, nodes[i].x + 10, nodes[i].y);
    
    }
    
  }
  
  ////////////////////////////////////////
  //Timer Methods
  ////////////////////////////////////////
  public int updateTimeText() {   //it is only called when tmer has started
    timeTextSeconds = elapsedTime % 60;
    timeTextMinutes = elapsedTime / 60;
    timeText = nf(timeTextMinutes, 2) + ':' + nf(timeTextSeconds, 2);
    return timeTextSeconds + timeTextMinutes*60 ;
    //println(timeTextSeconds);
  }

  // this is called once per second when the timer is running
  public void onTickEvent(int timerId, long timeLeftUntilFinish) {
    ++elapsedTime;
    actualTime = updateTimeText();
  }

  // this will be called after the timer finishes running
  public void onFinishEvent(int timerId) {
    exit();
  }

  //event handlers that start/stop/reset the stopwatch
  public void keyPressed() {
    if(key == '1')  {
        if(timer.isRunning()) {
          // STOP_IMMEDIATELY: stop immediately as soon as button was clicked
          timer.stop(CountdownTimer.StopBehavior.STOP_IMMEDIATELY); // stop stopwatch
          timeTextColor = color(255, 0, 0);  // red: stopped
        }
        else {
          // Even though the stopwatch was previously stopped with STOP_IMMEDIATELY,
          // the stopwatch will not start from where it was stopped
          // but rather count another full second before updating the timeText.
          // This is because the CountdownTimer was initially configured
          // to have one second as the smallest unit of a tick interval.
          // Decreasing the CountdownTimer's tick interval can fine tune this behavior.  
          timer.start(); // resume stopwatch
          timeTextColor = color(0, 255, 0);  // green: running
        }
    }
    else if(key == '0')  {  // reset stopwatch
      // STOP_AFTER_INTERVAL: reset after full second tick has passed
      timer.reset(CountdownTimer.StopBehavior.STOP_AFTER_INTERVAL); // reset stopwatch (stops first if it was running)
      timeTextColor = color(255, 0, 0);  // red: stopped
    
      elapsedTime = 0;
      
      int lastActive = 0;
      for (int i = 0 ; i < nodeCount ; i++) {     
        nodes[i].active = false;
        actualTime = 0;
        lastActive = 0;    
      }
         
      updateTimeText();
      
      
    }
    else if(key == 'r')  {  // reset stopwatch
    
      if(timer.isRunning()) {
          // STOP_IMMEDIATELY: stop immediately as soon as button was clicked
          timer.stop(CountdownTimer.StopBehavior.STOP_IMMEDIATELY); // stop stopwatch
          timeTextColor = color(255, 0, 0);  // red: stopped
        }
      // STOP_AFTER_INTERVAL: reset after full second tick has passed
      timer.reset(CountdownTimer.StopBehavior.STOP_AFTER_INTERVAL); // reset stopwatch (stops first if it was running)
      timeTextColor = color(255, 0, 0);  // red: stopped
    
      elapsedTime = 0;
      updateTimeText();
      rewindSequencer();
      
      
    }
    else if(key == 'a')  {  // add a new node
      addEdge(15, "mierda",1);
    }
    else { // mouseButton == MIDDLE    
      //exit(); // exit program
    }
  }
  
  ///////////////////////////////////////////////
  //visualization STUFF
  ///////////////////////////////////////////////
  /*
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

        addEdge(index, preset, time);     
      }
    }
    
    
  }
*/
/*
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

*/

  /*
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
  */
  /*
  Node addNode(int index, String preset, int time) {
    Node n = new Node(this, index, preset, time);  
    if (nodeCount == nodes.length) {
      nodes = (Node[]) expand(nodes);
    }
    nodeTable.put(index, n);
    nodes[nodeCount++] = n;  
    return n;
  }
 */

  public int updateActivePreset(){
    int lastActive = 0;
    for (int i = 0 ; i < nodeCount ; i++) {     
      if(nodes[i].time <= actualTime){
        nodes[i].active = true;
        lastActive = nodes[i].index;
      }
    }
    return lastActive;
  }
  
  public void rewindSequencer(){
    int lastActive = 0;
    for (int i = 0 ; i < nodeCount ; i++) {     
        nodes[i].active = false;
        actualTime = 0;
        lastActive = 0;    
    }
  }

  Node selection; 

  public void mousePressed() {
    // Ignore anything greater than this distance
    float closest = 20;
    for (int i = 0; i < nodeCount; i++) {
      Node n = nodes[i];
      float d = dist(mouseX, mouseY, n.x, n.y);
      if (d < closest) {
        selection = n;
        closest = d;
      }
    }
    if (selection != null) {
      if (mouseButton == LEFT) {
        selection.fixed = true;
      } else if (mouseButton == RIGHT) {
        selection.fixed = false;
      }
    }
}


  public void mouseDragged() {
    if (selection != null) {
      selection.x = mouseX;
      selection.y = mouseY;
    }
  }


  public void mouseReleased() {
    selection = null;
  }


} //END OF SECOND APPLET CLASS


////////////////////////////////////////////////////////////////////////////////////////
//EDGE
// Code from Visualizing Data, First Edition, Copyright 2008 Ben Fry.
// Based on the GraphLayout example by Sun Microsystems.


class Edge {
  Node from;
  Node to;
  float len;
  int count;

  private PApplet p;

  public Edge(PApplet p, Node from, Node to) {
    this.from = from;
    this.to = to;
    this.len = 50;
    this.p = p;
  }
  

  public void draw() {
    
  }
  
  public void increment() {
    count++;
  }
  
}

//////////////////////////////////////////////////////////////////////////////////////////
//NODE
// Code from Visualizing Data, First Edition, Copyright 2008 Ben Fry.
// Based on the GraphLayout example by Sun Microsystems.


class Node {
  float x, y;
  float dx, dy;
  boolean fixed;
  String preset;
  int count;
  int index;
  private PApplet p;
  int time;
  boolean active;

  public Node(PApplet p, int index, String preset, int time) {
    this.preset = preset;
    x = random(50,width-50);
    y = random(50,height-50);
    this.p = p;
    this.time = time;
    this.index = index;
    this.active = false;
  }
  
  
  public void increment() {
    count++;
  }
  

  public void update() {
    if (!fixed) {      
      x += constrain(dx, -5, 5);
      y += constrain(dy, -5, 5);
      
      x = constrain(x, 0, width);
      y = constrain(y, 0, height);
    }
    dx /= 2;
    dy /= 2;
  }


  public void draw() {
    
    /*
    fill(nodeColor);
    stroke(0);
    strokeWeight(0.5);
    
    ellipse(x, y, count*10, count*10);
    float w = textWidth(label);

    if (count > w+2) {
      fill(0);
      textAlign(CENTER, CENTER);
      text(label, x, y);
    }
    */
  }
}



  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "TangibleScores5" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
