import javax.swing.*;
import java.awt.*;

public class CustomFrame extends JFrame {
    public CustomFrame() {
        setTitle("Architecture interne du 6809");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
        pack();
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    private void initUI() {
        // Main panel with GridBagLayout for flexible component placement
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Helper method to add a JLabel to the panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridy = 0;

        // PC and FC00 labels and fields
        addLabelFieldPair(mainPanel, gbc, "PC", 4);
        addLabelFieldPair(mainPanel, gbc, "FC00", 4);

        // LDA #S6F label and field
        gbc.gridy++;
        addLabelFieldPair(mainPanel, gbc, "LDA #$6F", 4);

        // S and U labels and fields
        gbc.gridy++;
        addLabelFieldPair(mainPanel, gbc, "S", 4);
        addLabelFieldPair(mainPanel, gbc, "U", 4);

        // A and B labels and fields
        gbc.gridy++;
        addLabelFieldPair(mainPanel, gbc, "A", 2);
        addLabelFieldPair(mainPanel, gbc, "B", 2);

        // DP and other fields
        gbc.gridy++;
        addLabelFieldPair(mainPanel, gbc, "DP", 2);
        addLabelFieldPair(mainPanel, gbc, "00000100", 8);

        // X and Y labels and fields
        gbc.gridy++;
        addLabelFieldPair(mainPanel, gbc, "X", 4);
        addLabelFieldPair(mainPanel, gbc, "Y", 4);

        // Add main panel to frame
        add(mainPanel);
    }

    private void addLabelFieldPair(JPanel panel, GridBagConstraints gbc, String label, int columns) {
        // Label
        gbc.gridx = 0;
        panel.add(new JLabel(label), gbc);

        // Text Field
        gbc.gridx = 1;
        JTextField textField = new JTextField(columns);
        textField.setText("0000"); // Default text
        panel.add(textField, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomFrame());
    }
}
