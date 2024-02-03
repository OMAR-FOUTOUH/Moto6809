/**
 * Cette classe représente une fenêtre d'application pour la gestion de la RAM.
 * Elle affiche une liste de valeurs de la RAM et permet de modifier ces valeurs.
 * Lorsqu'une valeur est modifiée, la classe `ram` met à jour la liste et affiche la nouvelle valeur.
 * La classe `ram` utilise un modèle de liste par défaut pour stocker les valeurs de la RAM.
 * Lorsqu'un élément de la liste est sélectionné, une nouvelle fenêtre s'ouvre pour permettre à l'utilisateur de saisir une nouvelle valeur.
 * La nouvelle valeur est ensuite mise à jour dans le modèle de liste et affichée dans la liste principale.
 * La classe `ram` utilise également une méthode `AddToRegister` pour effectuer des calculs sur les valeurs de la RAM.
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.Color;
import javax.swing.DefaultListModel;

/**
 * Classe représentant une fenêtre affichant la RAM et permettant de modifier ses valeurs.
 */
public class ram extends JFrame {
    private int selectedListIndex;
    private DefaultListModel<String> listModel;

    /**
     * Constructeur de la classe ram.
     * Initialise les composants de la fenêtre et définit son titre.
     */
    public ram() {
        initComponents();
        setTitle("RAM");
    }

    /**
     * Méthode pour ajouter une valeur à un registre de la RAM.
     * @param param1 La première partie de l'élément de la liste sélectionné.
     * @param param2 La deuxième partie de l'élément de la liste sélectionné.
     * @return La somme des deux valeurs en hexadécimal.
     */
    public String AddToRegister(String param1, String param2) {
        int lineIndex = -1;
        String secondElement = "";
        for (int i = 0; i < listModel.getSize(); i++) {
            String element = listModel.getElementAt(i);
            String firstElement = element.split("\\s+")[0];
            if (param1.equals(firstElement)) {
                lineIndex = i;
                secondElement = element.split("\\s+")[1];
                System.out.println("secondElement: " + secondElement);
                break;
            }
        }
        int param2Int = Integer.parseInt(param2, 16);
        int secondElementInt = Integer.parseInt(secondElement, 16);
        int sum = param2Int + secondElementInt;
        String hexSum = Integer.toHexString(sum).toUpperCase();
        System.out.println("Sum: " + hexSum);
        return hexSum;
    }

    /**
     * Méthode pour initialiser les composants de la fenêtre.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel1.setText("RAM");

        jScrollPane1.setToolTipText("");

        listModel = new DefaultListModel<>();
        String[] strings = {"0000    00", "0001    00", "0002    00", "0003    00", "0004    00", "0005    00", "0006    00", "0007    00", "0008    00", "0009    00", "000A    00", "000B    00", "000C    00", "000D    00", "000E    00", "000F    00", "0010    00", "0011    00", "0012    00", "0013    00", "0014    00", "0015    00", "0016    00", "0017    00", "0018    00", "0019    00", "001A    00", "001B    00", "001C    00", "001D    00", "001E    00", "001F    00", "0020    00", "0021    00", "0022    00", "0023    00", "0024    00", "0025    00", "0026    00", "0027    00", "0028    00", "0029    00", "002A    00", "002B    00", "002C    00", "002D    00", "002E    00", "002F    00", "0030    00", "0031    00", "0032    00", "0033    00", "0034    00", "0035    00", "0036    00", "0037    00", "0038    00", "0039    00", "003A    00", "003B    00", "003C    00", "003D    00", "003E    00", "003F    00"};
        for (String element : strings) {
            listModel.addElement(element);
        }

        JList<String> jList1 = new JList<>(listModel);
        jList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (jList1.getSelectedIndex() != -1) {
                    selectedListIndex = jList1.getSelectedIndex();
                    JFrame nouvelleValeurRAMFrame = new JFrame("Nouvelle valeur RAM");
                    String nouvelleAdresse = "";
                    nouvelleValeurRAMFrame.setSize(170, 130);
                    nouvelleValeurRAMFrame.setResizable(false);
                    String selectedElement = jList1.getModel().getElementAt(selectedListIndex);
                    JTextField nouvelleAdresseTextField = new JTextField();
                    nouvelleAdresseTextField.setColumns(2);
                    JLabel nouvelleAdresseLabel = new JLabel("Nouvelle Adresse");
                    nouvelleAdresseLabel.setFont(new java.awt.Font("lucida Console", java.awt.Font.BOLD, 14));
                    nouvelleAdresseLabel.setForeground(Color.BLACK);
                    JButton ok_button = new JButton("OK");
                    ok_button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String nouvelleAdresse = nouvelleAdresseTextField.getText();
                            String updatedElement = selectedElement.substring(0, selectedElement.length() - 2) + nouvelleAdresse;
                            System.out.print("" + selectedListIndex + updatedElement);
                            DefaultListModel<String> listModel = (DefaultListModel<String>) jList1.getModel();
                            jList1.setModel(listModel);
                            listModel.setElementAt(updatedElement, selectedListIndex);
                            jList1.revalidate();
                            jList1.repaint();
                            nouvelleValeurRAMFrame.dispose();
                        }
                    });
                    nouvelleValeurRAMFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
                    nouvelleValeurRAMFrame.getContentPane().add(nouvelleAdresseLabel);
                    nouvelleValeurRAMFrame.getContentPane().add(nouvelleAdresseTextField);
                    nouvelleValeurRAMFrame.getContentPane().add(ok_button);
                    PlainDocument doc = (PlainDocument) nouvelleAdresseTextField.getDocument();
                    doc.setDocumentFilter(new DocumentFilter() {
                        @Override
                        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                            if (fb.getDocument().getLength() + string.length() <= 2) {
                                super.insertString(fb, offset, string.toUpperCase(), attr);
                            }
                        }
                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            if (fb.getDocument().getLength() - length + text.length() <= 2) {
                                super.replace(fb, offset, length, text.toUpperCase(), attrs);
                            }
                        }
                    });
                    nouvelleValeurRAMFrame.setVisible(true);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jList1);

        pack();
    }

    /**
     * Méthode principale pour exécuter l'application.
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ram().setVisible(true);
            }
        });
    }

    private JLabel jLabel1;
    private JList<String> jList1;
    private JScrollPane jScrollPane1;
}
