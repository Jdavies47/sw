import javax.swing.*;

/**
 * Created by Zsolt Pazmandy on 18/02/16.
 * Executable main class.
 */
public class T9GUI extends JFrame {
    public static void main(String[] args) {

        T9GUIModel model = new T9GUIModel();
        T9GUIView view = new T9GUIView(model);

        model.addObserver(view);
        view.setVisible(true);
        view.setSize(280, 180);
        view.setLocation(550, 200);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Predictive Text");
        view.isResizable();
    }
}
