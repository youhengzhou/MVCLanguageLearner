import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {
    private JTextField englishWordsField;
    private JTextField frenchWordsField;
    private JTextField englishField;
    private JTextField frenchField;
    private JTextField statusField;
    private String englishText;
    private String frenchText;

    public View() {
        super("Language Learner"); // frame title
        setLayout(new GridLayout(7, 2));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set exit
        Model model = new Model(); // model
        model.addView(this); // add view of this
        Controller controller = new Controller(model); // new Controller on model

        this.englishField = new JTextField("");
        this.frenchField = new JTextField("");
        this.statusField = new JTextField();
        JButton addButton = new JButton("add");
        addButton.addActionListener(controller);
        JButton practiceButton = new JButton("practice");
        practiceButton.addActionListener(controller);
        frenchField.addActionListener(controller);
        JButton showButton = new JButton("show");
        showButton.addActionListener(controller);
        this.englishWordsField = new JTextField("english words");
        this.frenchWordsField = new JTextField("french words");

        add(new JLabel("English Words"));
        add(new JLabel("French Words"));
        add(this.englishWordsField);
        add(this.frenchWordsField);
        add(new JLabel("English"));
        add(new JLabel("French"));
        add(this.englishField);
        add(this.frenchField);
        frenchField.setActionCommand("enter");
        addButton.setActionCommand("add"); // set action listener command to button
        this.add(addButton);
        practiceButton.setActionCommand("practice"); // set action listener command to button
        this.add(practiceButton);
        add(this.statusField);
        add(new JLabel(""));
        showButton.setActionCommand("show all"); // set action listener command to button
        this.add(showButton);

        this.setSize(300,300); // set frame size
        this.setVisible(true); // set visible
    }

    public String getEnglishText() {
        englishText = englishField.getText();
        return englishText;
    }

    public String getFrenchText() {
        frenchText = frenchField.getText();
        return frenchText;
    }

    public void addWord() {
        statusField.setText("entry added!");
    }

    public void showWords(ArrayList<String> englishWords, ArrayList<String> frenchWords) {
        englishWordsField.setText(String.valueOf(englishWords));
        frenchWordsField.setText(String.valueOf(frenchWords));
    }

    public void practiceWordStart() {
        englishField.setText("");
        frenchField.setText("");
        statusField.setText("take a guess!");
    }

    public void getGuess(String guessWord) {
        englishField.setText(guessWord);
    }

    public void practiceWordWin() {
        statusField.setText("well done!");
    }

    public void practiceWordLost() {
        statusField.setText("wrong! guess again");
    }

    public static void main(String[] args) {
        new View();
    }
}