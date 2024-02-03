import javax.swing.*;
import java.awt.*;

public class CpuFrame extends JFrame {
    private JTextField pcTextField; // Declare pcTextField as a class variable
    private JTextField aTextField;
    private JTextField bTextField;
    private JTextField xTextField;
    private JTextField yTextField;
     private JTextField sTextField;
                private JTextField uTextField;

    public CpuFrame() {
        setTitle("CPU Simulation Frame");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

                // B_Register
                JPanel B_Register = new JPanel();
                B_Register.setBorder(BorderFactory.createTitledBorder("Accumulateur B"));
                bTextField = new JTextField("01", 10);
                bTextField.setHorizontalAlignment(JTextField.CENTER);
                B_Register.add(bTextField);
                gbc.gridx = 2;
                gbc.gridy = 1;
                gbc.gridheight = 2;
                gbc.fill = GridBagConstraints.BOTH;
                add(B_Register, gbc);

                // U
                JPanel U_Register = new JPanel();
                U_Register.setBorder(BorderFactory.createTitledBorder("U"));
                 uTextField = new JTextField("0000", 10);
                uTextField.setHorizontalAlignment(JTextField.CENTER);
                U_Register.add(uTextField);
                gbc.gridx = 3;
                gbc.gridy = 1;
                add(U_Register, gbc);
                
       
                // X
                JPanel X_Register = new JPanel();
                X_Register.setBorder(BorderFactory.createTitledBorder("X"));
                xTextField = new JTextField("0000", 10);
                xTextField.setHorizontalAlignment(JTextField.CENTER);
                X_Register.add(xTextField);
                gbc.gridx = 2;
                gbc.gridy = 4;
                add(X_Register, gbc);
             
                // A
                JPanel accumulatorPanel = new JPanel();
                accumulatorPanel.setBorder(BorderFactory.createTitledBorder("Accumulateur A"));
                aTextField = new JTextField("01", 10);
                aTextField.setHorizontalAlignment(JTextField.CENTER);
                accumulatorPanel.add(aTextField);
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.gridheight = 2;
                add(accumulatorPanel, gbc);

                // instruction register
                JPanel instructionRegisterPanel = new JPanel();
                instructionRegisterPanel.setBorder(BorderFactory.createTitledBorder("Instruction Register"));
                JTextField irTextField = new JTextField("INCA 4C", 10);
                irTextField.setHorizontalAlignment(JTextField.CENTER);
                instructionRegisterPanel.add(irTextField);
                gbc.gridx = 1;
                gbc.gridy = 0;
                add(instructionRegisterPanel, gbc);

                // Program Counter
                JPanel programCounterPanel = new JPanel();
                programCounterPanel.setBorder(BorderFactory.createTitledBorder("Program Counter"));
                pcTextField = new JTextField("C001 C000", 10); // Assign pcTextField to the class variable
                pcTextField.setHorizontalAlignment(JTextField.CENTER);
                programCounterPanel.add(pcTextField);
                gbc.gridx = 4;
                gbc.gridy = 1;
                gbc.gridheight = 1;
                add(programCounterPanel, gbc);

                // ALU
                JPanel aluPanel = new JPanel();
                aluPanel.setBorder(BorderFactory.createTitledBorder("ALU"));
                JTextField aluTextField = new JTextField("Mode = Inc", 10);
                aluTextField.setHorizontalAlignment(JTextField.CENTER);
                aluPanel.add(aluTextField);
                gbc.gridx = 1;
                gbc.gridy = 4;
                gbc.gridheight = 1;
                add(aluPanel, gbc);
                     // Y
                JPanel Y_Register = new JPanel();
                Y_Register.setBorder(BorderFactory.createTitledBorder("Y"));
                 yTextField = new JTextField("0000", 10);
                yTextField.setHorizontalAlignment(JTextField.CENTER);
                Y_Register.add(yTextField);
                gbc.gridx = 3;
                gbc.gridy = 4;
                add(Y_Register, gbc);


                // S
                JPanel S_Register = new JPanel();
                S_Register.setBorder(BorderFactory.createTitledBorder("S"));
                 sTextField = new JTextField("0000", 10);
                sTextField.setHorizontalAlignment(JTextField.CENTER);
                S_Register.add(sTextField);
                gbc.gridx = 4;
                gbc.gridy = 4;
                gbc.gridheight = 1;
                add(S_Register, gbc);
            }
    

    public void setPcTextFieldText(String text) {
                pcTextField.setText(text);
            }
            public void setATextField(String text) {
                aTextField.setText(text);
            }
            public void setBTextField(String text) {
                bTextField.setText(text);
            }
            public void setXTextField(String text) {
                xTextField.setText(text);
            }
              public void setYTextField(String text) {
                yTextField.setText(text);
            } 
             public void setUTextField(String text) {
                uTextField.setText(text);
            }
            public void setSTextField(String text) {
                sTextField.setText(text);
            }
            public String getAValue() {
                return aTextField.getText();
            }
            public String getBValue() {
                return bTextField.getText();
            }
            public void OR(String operand1, String operand2) {
                int op1 = Integer.parseInt(operand1, 16);
                int op2 = Integer.parseInt(operand2, 16);
                int result = op1 | op2;
                setATextField(Integer.toHexString(result));
            }
        
            // Method for DEC instruction
            public int DEC(String operand) {
                int value = Integer.parseInt(operand, 16);
                value--;
                return value;
            }
        
            // Method for INC instruction
            public int INC(String operand) {
                int value = Integer.parseInt(operand, 16);
                value++;
                return value;
            }
            public int AND(String operand1, String operand2) {
                int op1 = Integer.parseInt(operand1, 16);
                int op2 = Integer.parseInt(operand2, 16);
                int result = op1 & op2;
                return result;
            }
            
            
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CpuFrame().setVisible(true));
    }
}
