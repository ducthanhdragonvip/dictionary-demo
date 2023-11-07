package api;

import javax.sound.sampled.*;
import java.io.File;
import com.voicerss.tts.AudioFormat;
import com.voicerss.tts.VoiceParameters;
import com.voicerss.tts.VoiceProvider;

import java.io.FileOutputStream;

public class VoiceRss {
    private static final String API_KEY = "d5bb2da2bf8a4392bf55a5f62e9c1c80";

    private static final String AUDIO_PATH = "src/audio/audio.wav";
    public static String language = "vi-vn";
    public static String Name = "CHI";
    public static double speed = 0.8;
    public static void speakWord(String word) throws Exception {
        VoiceProvider tts = new VoiceProvider(API_KEY);
        VoiceParameters params = new VoiceParameters(word, AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setLanguage(language);
        params.setVoice(Name);
        params.setRate(0);

        byte[] voice = tts.speech(params);

        FileOutputStream fos = new FileOutputStream(AUDIO_PATH);
        fos.write(voice, 0, voice.length);
        fos.flush();
        fos.close();

        File audioFile = new File(AUDIO_PATH);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();

    }

    public static void main(String[] args) throws Exception {
        speakWord("");
    }
}
