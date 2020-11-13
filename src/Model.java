import java.util.*;

public class Model {
    private String englishText;
    private String frenchText;
    private String randomWord;
    private HashMap<String,String> dictionary;
    private List<View> views;

    public Model()
    {
        this.englishText = "";
        this.frenchText = "";
        dictionary = new HashMap<>();
        views = new ArrayList<View>();
    }

    public void addView(View view){
        views.add(view);
    }

    public String randomWord()
    {
        if(dictionary.isEmpty())
        {
            randomWord = "Dictionary Empty";
        }
        Collection<String> keys= dictionary.keySet();
        ArrayList<String> allkeys = new ArrayList<>();
        allkeys.addAll(keys);
        Collections.shuffle(allkeys);
        return randomWord = allkeys.get(0);
    }

    public boolean isCorrect(String englishWord, String frenchWord)
    {
        String answer = dictionary.get(englishWord);
        if (answer.equals(frenchWord)) {
            return true;
        } else {
            return false;
        }
    }

    public void addWord()
    {
        dictionary.put(englishText,frenchText);
    }

    public void getEnglishText() {
        for (View view : views) {
            englishText = view.getEnglishText();
        }
    }

    public void getFrenchText() {
        for (View view : views) {
            frenchText = view.getFrenchText();
        }
    }

    public void updateViewAdd() { // updates view for add
        getEnglishText();
        getFrenchText();
        addWord();
        for (View view : views) {
            view.addWord();
        }
    }

    public void updateViewShowWords() {
        Collection<String> key = dictionary.keySet();
        ArrayList<String> keys = new ArrayList<>();
        keys.addAll(key);
        System.out.println(keys);

        Collection<String> value = dictionary.values();
        ArrayList<String> values = new ArrayList<>();
        values.addAll(value);
        System.out.println(values);

        for (View view : views) {
            view.showWords(keys,values);
        }
    }

    public void updateViewPractice() { // updates view for setting up practice
        randomWord();
        for (View view : views) {
            view.practiceWordStart();
            view.getGuess(randomWord);
        }
    }

    public void updateViewPracticeCheck() { // updates view for checking if user entered word is correct
        getFrenchText();
        if (isCorrect(randomWord, frenchText) == true){
            for (View view : views) {
                view.practiceWordWin();
                return;
            }
        } else {
            for (View view : views) {
                view.practiceWordLost();
                return;
            }
        }
    }
}