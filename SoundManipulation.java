import java.io.*;
/*
 * @Author Braeden Bertz
 */
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;

class SoundManipulation{

    private String path;

    /**
     * @param Path the path to the wanted sound file
     */
    SoundManipulation(String Path){
        path = Path;
    }

    SoundManipulation(){}

    /*
    * @Method: Access the sound file and get its playtime in seconds. Start the sound file using clip and set the thread to sleep for playtime
    * By putting the thread to sleep, the sound file can play for its full duration without having to create a holder or other process to keep alive after exiting the code
    * thus making it invisible
    */
     void playSound() throws LineUnavailableException {
        try {
            // Open an audio input stream.
            File soundFile = new File(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
            TimeUnit.SECONDS.sleep((long) getPlayDuration(soundFile, audioIn));//Putting it to sleep allows it to play the whole time without a holder
        } catch (UnsupportedAudioFileException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
     }

    /**
     * @param newPath Change the path of the current file to the newPath
     */
    void setPath(String newPath){
        path = newPath;
    }

    /**
     * @return path The path to the currently selected file
     */
    String getPath(){
        return path;
    }

    /**
     * @param file The actual file of the sound
     * @param audioIn the current AudioInputStream
     * @return the length of the file in seconds
     */
    double getPlayDuration(File file, AudioInputStream audioIn){
        AudioFormat audioFormat = audioIn.getFormat();
        long audioFileLength = file.length();
        long frameSize = audioFormat.getFrameSize();
        double frameRate = audioFormat.getFrameRate();
        return (audioFileLength / (frameSize * frameRate));
    }
}

