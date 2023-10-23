package database;

import java.util.ArrayList;

public class DictionaryData {
    private static int idMax = 0;

    private static final RadixTree<WordModel> tree = new RadixTree<>();

    static {
        importFromDatabase();
    }
    public static ArrayList<WordModel> prefixSearch(String prefix) {
        prefix = prefix.toLowerCase();
        return tree.prefixSearch(prefix, 100);
    }
    public static void importFromDatabase() {
        ArrayList<WordModel> wordModels = new ArrayList<>();
        MysqlConnector.takeDataToArray(wordModels);
        for (WordModel w : wordModels) {
            idMax = Math.max(w.getIndex(), idMax);
            tree.insert(new String(w.getWord() + String.valueOf(w.getIndex())).toLowerCase(), w);
        }
    }
}
