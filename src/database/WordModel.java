package database;

/**
 * Class cho từ trong database
 */
public class WordModel {
    private int index;
    private String word;
    private String meaning;

    public WordModel(int index,String word, String meaning) {
        this.index = index;
        this.word = word;
        this.meaning = meaning;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    @Override
    public String toString() {
        return word;
    }
}
