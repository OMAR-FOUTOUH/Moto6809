import javax.swing.*;
import java.awt.*;

/**
 * Cette classe représente une fenêtre affichant une liste de ROM.
 */
public class ROMFrame extends JFrame {
    static JList<String> romList;
    private JScrollPane scrollPane;
    String[] data;

    /**
     * Constructeur de la classe ROMFrame.
     * Initialise la fenêtre et les composants.
     */
    public ROMFrame() {
        setTitle("ROM");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }
   
    /**
     * Initialise les composants de la fenêtre.
     * Crée une liste de ROM et l'ajoute à un panneau de défilement.
     */
    
    String[] dataRafraichit = {
            "FC00    FF", "FC01    FF", "FC02    FF", "FC03    FF", "FC04    FF", "FC05    FF", "FC06    FF", "FC07    FF", "FC08    FF", "FC09    FF", "FC0A    FF", "FC0B    FF", "FC0C    FF", "FC0D    FF", "FC0E    FF", "FC0F    FF", "FC10    FF", "FC11    FF", "FC12    FF", "FC13    FF", "FC14    FF", "FC15    FF", "FC16    FF", "FC17    FF", "FC18    FF", "FC19    FF", "FC1A    FF", "FC1B    FF", "FC1C    FF", "FC1D    FF", "FC1E    FF", "FC1F    FF", "FC20    FF", "FC21    FF", "FC22    FF", "FC23    FF", "FC24    FF", "FC25    FF", "FC26    FF", "FC27    FF", "FC28    FF"
        };
    public void refrech(){
        romList.setListData(dataRafraichit);
        romList.repaint();
    }
    private void initializeComponents() {
        String[] data = {
            "FC00    FF", "FC01    FF", "FC02    FF", "FC03    FF", "FC04    FF", "FC05    FF", "FC06    FF", "FC07    FF", "FC08    FF", "FC09    FF", "FC0A    FF", "FC0B    FF", "FC0C    FF", "FC0D    FF", "FC0E    FF", "FC0F    FF", "FC10    FF", "FC11    FF", "FC12    FF", "FC13    FF", "FC14    FF", "FC15    FF", "FC16    FF", "FC17    FF", "FC18    FF", "FC19    FF", "FC1A    FF", "FC1B    FF", "FC1C    FF", "FC1D    FF", "FC1E    FF", "FC1F    FF", "FC20    FF", "FC21    FF", "FC22    FF", "FC23    FF", "FC24    FF", "FC25    FF", "FC26    FF", "FC27    FF", "FC28    FF"
        };
        
        this.data = data;
        romList = new JList<>(data);
        scrollPane = new JScrollPane(romList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    
    /**
     * Stocke une valeur A dans la mémoire à l'adresse spécifiée.
     * @param param l'adresse de la mémoire
     * @param A la valeur à stocker
     */
    void storeToMemory(String param, String A) {
        for (int i = 0; i < data.length; i++) {
            String[] parts = data[i].split("\\s+");
            if (parts[0].equals(param)) {
                data[i] = parts[0] + "    " + A;
                break;
            }
        }
        romList.setListData(data);
        romList.repaint();
    }
    
    /**
     * Stocke une valeur B dans la mémoire à l'adresse spécifiée.
     * @param param l'adresse de la mémoire
     * @param B la valeur à stocker
     */
    void storeBToMemory(String param, String B) {
        for (int i = 0; i < data.length; i++) {
            String[] parts = data[i].split("\\s+");
            if (parts[0].equals(param)) {
                data[i] = parts[0] + "    " + B;
                break;
            }
        }
        romList.setListData(data);
        romList.repaint();
    }

    /**
     * Méthode principale qui crée et affiche la fenêtre ROMFrame.
     * @param args les arguments de la ligne de commande
     */
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ROMFrame frame = new ROMFrame();
            frame.setVisible(true);
        });
    }
}
