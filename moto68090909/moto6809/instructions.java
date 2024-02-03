    import java.util.regex.Matcher;
        import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.*;

        /**
         * Cette classe représente les instructions du programme.
         * Elle est responsable de l'exécution des instructions et de la mise à jour des valeurs des registres et de la mémoire.
         */
        
        public class instructions {
            CpuFrame cpu = new CpuFrame();
            ram RAM = new ram();
            public static ROMFrame romFrame = new ROMFrame();
            
            /**
             * Constructeur de la classe instructions.
             * Il initialise les fenêtres CPU, RAM et ROM.
             */
            public instructions() {
                cpu.setVisible(true);
                romFrame.setVisible(true);
                RAM.setVisible(true);
                
            }
            
                
            
            /**
             * Méthode pour définir une instruction et son opérande.D
             * @param instruction L'instruction à exécuter.
             * @param nextLine La prochaine ligne d'instruction.
             */
            
            public void setInstruction(String instruction,String nextLine) {
                
                
                    cpu.setPcTextFieldText(nextLine);
                
                cpu.setPcTextFieldText(nextLine);
                String[] parts = instruction.split(" ", 2);
                String opcode = "";
                String rest;
                String addressingMode = "";
                String operand = "";
                if (parts.length >= 1) {
                    opcode = parts[0];
                    if(parts.length > 1){
                        rest = parts[1];
                        Pattern pattern = Pattern.compile("([!@#$%^&*()_+=-]+)(.*)");
                        Matcher matcher = pattern.matcher(rest);
                        if (matcher.find()) {
                            addressingMode = matcher.group(1);
                            operand = matcher.group(2); 
                        }
                    }
                }
                if (opcode.equals("END")) {
                    romFrame.refrech();
                }
                if (opcode.equals("LDA")) {
                    cpu.setATextField(operand);
                }
                if (opcode.equals("LDB")) {
                    cpu.setBTextField(operand);
                }
                if (opcode.equals("LDX")) {
             
               
                    cpu.setXTextField(operand);
                }
                  
                 if (opcode.equals("LDY")) {
                 
                   
                    cpu.setYTextField(operand);
                }
                   
                 if (opcode.equals("LDS")) {
                 
                   
                    cpu.setSTextField(operand);
                }
                   if (opcode.equals("LDU")) {
                 
                   
                    cpu.setUTextField(operand);
                }
                if (opcode.equals("STA")) {
                    String A = cpu.getAValue();
                    romFrame.storeToMemory(operand,A);
                }
                if (opcode.equals("STB")) {
                    String b = cpu.getBValue();
                    romFrame.storeToMemory(operand,b);
                }
                if (opcode.equals("ADDA")) {
                    String A = RAM.AddToRegister(operand,cpu.getAValue());
                    cpu.setATextField(A);
                }
                if (opcode.equals("ADDB")) {
                    String B = RAM.AddToRegister(operand,cpu.getBValue());
                    cpu.setBTextField(B);
                }
                if (opcode.equals("DECA")) {
                    int value = cpu.DEC(cpu.getAValue());
                    cpu.setATextField(Integer.toHexString(value).toUpperCase());
                }
                if (opcode.equals("DECB")) {
                    int value = cpu.DEC(cpu.getBValue());
                    cpu.setBTextField(Integer.toHexString(value).toUpperCase());
                }
                if (opcode.equals("INCA")) {
                    int value = cpu.INC(cpu.getAValue());
                    cpu.setATextField(Integer.toHexString(value).toUpperCase());
                }
                if (opcode.equals("INCB")) {
                    int value = cpu.INC(cpu.getBValue());
                    cpu.setBTextField(Integer.toHexString(value).toUpperCase());
                }
                if (opcode.equals("ANDA")) {
                    int value = cpu.AND(operand,cpu.getAValue());
                    cpu.setATextField(Integer.toHexString(value).toUpperCase());
                }
                if (opcode.equals("ANDB")) {
                    int value = cpu.AND(operand,cpu.getBValue());
                    cpu.setBTextField(Integer.toHexString(value).toUpperCase());
                }
                if (opcode.equals("TAB")) {
                    String value = cpu.getAValue();
                    cpu.setBTextField(value);
                }
               
            }
        }
