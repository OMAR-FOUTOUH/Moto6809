import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.Color;

public class EditeurMoto extends JFrame {
    private CpuFrame cpuFrame = new CpuFrame();
    instructions Instructions = new instructions();
    
    /**
     * Constructeur de la classe EditeurMoto.
     * Initialise et lance l'éditeur Motorola 6809.
     */
    public EditeurMoto() {
        start();
    }
    
    /**
     * Méthode principale qui crée une instance de EditeurMoto et la lance.
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        EditeurMoto editeurMoto = new EditeurMoto();
    }

    /**
     * Méthode qui initialise et affiche l'interface graphique de l'éditeur.
     */
    JTextArea textArea = new JTextArea();
    public void start() {
        JFrame frame = new JFrame("Editeur Motorola 6809");
        //JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("lucida Console", Font.PLAIN, 14));
        int rows = 5;
        int columns = 5;
        textArea.setRows(rows);
        textArea.setColumns(columns);
        frame.add(textArea);

        JMenuBar menuBar = new JMenuBar();
        JButton assemblerButton = new JButton("Assemble");
        assemblerButton.setFont(new Font("lucida Console", Font.PLAIN, 14));

        assemblerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instruction = textArea.getText();
                parseInstruction(instruction);
            }
        });

        menuBar.add(assemblerButton);
        frame.setJMenuBar(menuBar);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } 

    /**
     * Méthode qui analyse et exécute les instructions saisies par l'utilisateur.
     * @param instruction La chaîne de caractères contenant les instructions.
     */
    
    private void parseInstruction(String instruction) {
        String[] lines = instruction.split("\\r?\\n");

        Timer timer = new Timer(3000, new ActionListener() {
            private int currentIndex = 0;
            public void start() {
                JFrame frame = new JFrame("Editeur Motorola 6809");

                frame.setSize(200, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (currentIndex < lines.length) {
                    String line = lines[currentIndex];
                    textArea.getHighlighter().removeAllHighlights();
                    if (currentIndex >= 0 && currentIndex < textArea.getLineCount()) {
                    try {
                        int start = textArea.getLineStartOffset(currentIndex);
                        int end = textArea.getLineEndOffset(currentIndex);
                        textArea.getHighlighter().addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(Color.lightGray));

                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    } 
                    
                }
                    String nextLine = null;
                    if (currentIndex < lines.length - 1) {
                        nextLine = lines[currentIndex + 1];
                    }

                    if (nextLine == null) {
                        ((Timer) e.getSource()).stop();
                    } else {
                        Instructions.setInstruction(line, nextLine);
                        currentIndex++;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                }
                
                
                
            }
            
        });

        timer.setRepeats(true);
        timer.start();
    }
}


