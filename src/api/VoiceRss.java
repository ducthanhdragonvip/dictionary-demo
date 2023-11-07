package api;


import com.voicerss.tts.AudioFormat;
import com.voicerss.tts.VoiceParameters;
import com.voicerss.tts.VoiceProvider;

public class VoiceRss {
    private static final String API_KEY = "d5bb2da2bf8a4392bf55a5f62e9c1c80";

    private static final String AUDIO_PATH = "src/audio/audio.wav";
    public static String language = "vi-vn";
    public static String Name = "CHI";
    public static double speed = 0.8;
    public static void speakWord(String word) throws Exception {
        VoiceProvider tts = new VoiceProvider(API_KEY);


    }
}
