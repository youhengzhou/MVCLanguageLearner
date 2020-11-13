import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Model model;

    public Controller(Model model){
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) { // gets called by view/frame when add or practice button is pressed
        if (e.getActionCommand().equals("add")) {
            model.updateViewAdd();
        }
        if (e.getActionCommand().equals("practice")) {
            model.updateViewPractice();
        }
        if (e.getActionCommand().equals("enter")) {
            model.updateViewPracticeCheck();
        }
        if (e.getActionCommand().equals("show all")) {
            model.updateViewShowWords();
        }
    }
}