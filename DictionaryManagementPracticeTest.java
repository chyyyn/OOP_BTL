import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

import static org.junit.Assert.*;

public class DictionaryManagementPracticeTest {
    @Test
    public void testUpdateWord() {
        DictionaryManagement manipulator = new DictionaryManagement();
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("word1", "definition1");
        manipulator.updateWord(dictionary, 0, "newDefinition", "path/to/your/file");
        assertEquals("newDefinition", dictionary.get("word1"));
    }

    @Test
    public void testDeleteWord() {
        DictionaryManagement manipulator = new DictionaryManagement();
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("word1", "definition1");
        manipulator.deleteWord(dictionary, 0, "path/to/your/file");
        assertFalse(dictionary.containsKey("word1"));
    }

    @Test
    public void testAddWord() {
        DictionaryManagement manipulator = new DictionaryManagement();
        String word = "word2";
        String definition = "definition2";
        String filePath = "path/to/your/file";
        manipulator.addWord(word, definition, filePath);

        // Read the file and check if the word was added
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean foundWord = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals(word)) {
                    foundWord = true;
                    break;
                }
            }
            reader.close();
            assertTrue(foundWord);
        } catch (IOException e) {
            fail("IOException");
        }
    }
}
