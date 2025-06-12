
import view.MainView;

public class Main {
    public static void main(String[] args) throws Exception {
        // Tampilkan jendela utama
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }
}
