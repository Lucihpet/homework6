import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    private Map<String, List<List<Integer>>> indexes;

    // disable default constructor
    private MyMiniSearchEngine() {
    }

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.

    private void index(List<String> texts) {
        this.indexes = new HashMap<>();

        for (int i = 0; i < texts.size(); i++) {
            String str = texts.get(i);
            List<String> words = Arrays.asList(str.split(" "));
            List<Integer> wordsIndex = new ArrayList<>();

            for (int j = 0; j < words.size(); j++) {

                for (int k = j; k < words.size(); k++) {
                    if (words.get(j).equals(words.get(k)))
                        wordsIndex.add(j);
                }

                indexes.put(words.get(j), Arrays.asList(Collections.singletonList(i), wordsIndex));
            }
        }
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.

    public List<Integer> search(String keyPhrase) {
        List<Integer> returnList = new ArrayList<>();

        if(indexes.containsKey(keyPhrase)) {
            List<List<Integer>> found = indexes.get(keyPhrase);

            for (int i = 0; i < found.size(); i++) {
                returnList.add(found.get(i).get(0));
            }
        }

        return new ArrayList<>(); // place holder
    }
}
