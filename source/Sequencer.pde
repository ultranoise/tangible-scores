  int nodeCount;
  //Node[] nodes = new Node[10];
  //HashMap nodeTable = new HashMap();

  int edgeCount;
  //Edge[] edges = new Edge[50];

  static final color nodeColor   = #F0C070;
  static final color nodeActiveColor = #00C070;
  static final color selectColor = #FF3030;
  static final color fixedColor  = #FF8080;
  static final color edgeColor   = #000000;

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
      strokeWeight(0.35);
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
      strokeWeight(0.5);
    
      ellipse(nodes[i].x, nodes[i].y, nodes[i].count*10, nodes[i].count*10);

      fill(125);
      text(nodes[i].preset, nodes[i].x + 10, nodes[i].y);
    
    }
    
  }
  
  ////////////////////////////////////////
  //Timer Methods
  ////////////////////////////////////////
  int updateTimeText() {   //it is only called when tmer has started
    timeTextSeconds = elapsedTime % 60;
    timeTextMinutes = elapsedTime / 60;
    timeText = nf(timeTextMinutes, 2) + ':' + nf(timeTextSeconds, 2);
    return timeTextSeconds + timeTextMinutes*60 ;
    //println(timeTextSeconds);
  }

  // this is called once per second when the timer is running
  void onTickEvent(int timerId, long timeLeftUntilFinish) {
    ++elapsedTime;
    actualTime = updateTimeText();
  }

  // this will be called after the timer finishes running
  void onFinishEvent(int timerId) {
    exit();
  }

  //event handlers that start/stop/reset the stopwatch
  void keyPressed() {
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

  int updateActivePreset(){
    int lastActive = 0;
    for (int i = 0 ; i < nodeCount ; i++) {     
      if(nodes[i].time <= actualTime){
        nodes[i].active = true;
        lastActive = nodes[i].index;
      }
    }
    return lastActive;
  }
  
  void rewindSequencer(){
    int lastActive = 0;
    for (int i = 0 ; i < nodeCount ; i++) {     
        nodes[i].active = false;
        actualTime = 0;
        lastActive = 0;    
    }
  }

  Node selection; 

  void mousePressed() {
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


  void mouseDragged() {
    if (selection != null) {
      selection.x = mouseX;
      selection.y = mouseY;
    }
  }


  void mouseReleased() {
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
  
  void increment() {
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
  
  
  void increment() {
    count++;
  }
  

  void update() {
    if (!fixed) {      
      x += constrain(dx, -5, 5);
      y += constrain(dy, -5, 5);
      
      x = constrain(x, 0, width);
      y = constrain(y, 0, height);
    }
    dx /= 2;
    dy /= 2;
  }


  void draw() {
    
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



