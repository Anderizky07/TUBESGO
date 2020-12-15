
package tubesgo;

import javax.sound.sampled.Clip;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music extends Thread {
    static Music player = new Music();
    static Clip clip;

    public Music(){

    }
    
    public static Music getInstance(){
        return player;
    }
    
    @Override
    public void run(){
    String filepath = "C:\\Users\\ACER-PC\\OneDrive\\Documents\\NetBeansProjects\\TUBESGO\\src\\img\\musik.wav";
        try {
            
            File musicPath = new File(filepath);
            System.out.println(musicPath.getAbsolutePath());
            
            if(musicPath.exists()) {
                System.out.println("Initialized");
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        }
        
        catch(Exception e){
            System.out.println("Yes");
        }
    }
}