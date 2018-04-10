

This the readme for compiling the GUI program for controlling Tangible Scores and its audioengine.

This repository of code has two parts. One has been written for Processing 2.2.1. It won´t run under Processing 3. The other one is written for Pure Data, using the timbreID library by William Brent which I have modified extensively. 

For the processing code:
1) Open the TangibleScores.pde sketch and include all the other pde files of this folder as tabs in your project. 
2) You need the following Processing libraries: controlP5, oscP5, netP5. The rest are java native libs. 

For the Pure Data code:
1) Tangible Scores need the following Pure Data libraries: arraysize, creb, cyclone, freeverb, Gem, hcs, iemlib, list.abs, mapping, maxlib, mrpeach, oscx, purepd, rtc, timbreID, zexy. Install them using the deken plugin. 
2) Once Tangible Scores are running under Pd they can be left in the background of the GUI platform. No interaction is needed but you will need to configure the Audio Settings according to your system.
