import java.io.*;
import java.util.*;


public class DictionaryManagement {

    public void insertFromCommandline() {

    }

    public void showAllWords() {

    }

    public void insertFromFile() {

    }

    public void dictionaryLookup() {

    }

    public void dictionaryExportToFile() {

    }

    public void updateWord(Map<String, String> dictionary, int index, String newDefinition, String filePath) {
        try {
            if (dictionary == null) {
                throw new NullPointerException();
            }
            List<String> keys = new ArrayList<>(dictionary.keySet());
            String wordToUpdate = keys.get(index);
            dictionary.put(wordToUpdate, newDefinition);
            exportToFile(dictionary, filePath);
        } catch (NullPointerException e) {
            System.out.println("Null Exception");
        }
    }

    public void deleteWord(Map<String, String> dictionary, int index, String filePath) {
        try {
            if (dictionary == null) {
                throw new NullPointerException();
            }
            List<String> keys = new ArrayList<>(dictionary.keySet());
            String wordToDelete = keys.get(index);
            dictionary.remove(wordToDelete);
            // Reset the trie here
            exportToFile(dictionary, filePath);
        } catch (NullPointerException e) {
            System.out.println("Null Exception");
        }
    }

    public void addWord(String word, String definition, String filePath) {
        try {
            if (word == null) {
                throw new NullPointerException();
            }
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(word + "\n" + definition + "\n");
            bufferedWriter.close();
        } catch (NullPointerException e) {
            System.out.println("Null Exception");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private void exportToFile(Map<String, String> dictionary, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                bufferedWriter.write(entry.getKey() + "\n" + entry.getValue() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
