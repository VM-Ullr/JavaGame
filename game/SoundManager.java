﻿package game;
/**Classe empruntée sur le net et legérement modfié par nos soins (la classe de base ne permettait pas d'arreter la musique a sa guise)
*/

import javax.sound.sampled.*; 
import java.io.File; 
import java.io.IOException; 
import java.lang.Runnable; 
/** 
* @see http://www.anyexample.com/programming/java/java_play_wav_sound_file.xml 
*/ 
public class SoundManager implements Runnable{ 
    static Class class__ = SoundManager.class; 
    private final static int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 
     
    String sound; 
    private SoundManager(String s){sound = s;} 
     
    public static void play(String filename){ 
        new Thread(new SoundManager(filename)).start();; 
    } 
    
     public static Thread music(String filename){ 
		Thread music = new Thread(new SoundManager(filename));
		return music;
    } 
     
    public void run(){ 
        java.net.URL url=class__.getClassLoader().getResource(sound); 
        File soundFile = new File(url.getFile()); 
         
        AudioInputStream audioInputStream = null; 
        try { 
            audioInputStream = AudioSystem.getAudioInputStream(soundFile); 
        } catch (UnsupportedAudioFileException e1) { 
            e1.printStackTrace(); 
            return; 
        } catch (IOException e1) { 
            e1.printStackTrace(); 
            return; 
        } 
                AudioFormat format = audioInputStream.getFormat(); 
        SourceDataLine auline = null; 
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format); 
  
        try { 
            auline = (SourceDataLine) AudioSystem.getLine(info); 
            auline.open(format); 
        } catch (LineUnavailableException e) { 
            e.printStackTrace(); 
            return; 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return; 
        } 
  
        if (auline.isControlSupported(FloatControl.Type.PAN)) { 
            FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN); 
        } 
        auline.start(); 
        int nBytesRead = 0; 
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE]; 
                    try { 
            while (nBytesRead != -1) { 
                nBytesRead = audioInputStream.read(abData, 0, abData.length); 
                if (nBytesRead >= 0) 
                    auline.write(abData, 0, nBytesRead); 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
            return; 
        } finally { 
            auline.drain(); 
            auline.close(); 
                } 
        } 
    
    public static Thread randomSong(){
    	int rand = (int)(Math.random()*100);
    	if(rand<25){
    		return music("sfx/song.wav");
    	}else if(rand<50){
    		return music("sfx/song2.wav");
    	}else if(rand<75){
    		return music("sfx/song3.wav");
    	}
    	return music("sfx/song4.wav");
    }
    
    public static Thread randVictorySong(){
    	int rand = (int)(Math.random()*100);
    	if(rand<50){
    		return music("sfx/victory.wav");
    	}
		return music("sfx/victory2.wav");
    }
}
