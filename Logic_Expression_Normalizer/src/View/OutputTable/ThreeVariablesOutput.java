package View.OutputTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.InputTable.ThreeVariablesFrm;
import Controller.BinaryComparator.MintermComparator;
import Model.PairCombination;
import Controller.StringConverters.ChangeDataForm.PairCombinationUtils;
import Model.Minterm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controller.CombineMinterms.ParityCheck;
import Controller.SetCover.AddX.PrimeImplicantTableCellRenderer;
import Model.PrimeImplicant;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JTable;
import Controller.SetCover.GetCoverPIs.BooleanSimplication;
import Controller.StringConverters.BooleanExpressionConverter3Variables;

/**
 *
 * @author LENOVO
 */
public class ThreeVariablesOutput extends javax.swing.JFrame implements ActionListener {

    private DefaultTableModel tableModel;
    private DefaultTableModel tableModel1;
    private ArrayList<Minterm> minterms;
    private ThreeVariablesFrm threeVariablesFrm;

    public ThreeVariablesOutput() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tblIntermediate3Variables.getModel();
        tableModel1 = (DefaultTableModel) tblPi3Variables.getModel();
        addActionListener();
    }

    public ThreeVariablesOutput(ThreeVariablesFrm threeVariablesFrm) {
        this();
        this.threeVariablesFrm = threeVariablesFrm;
        insertValueIntoColumn();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConvertAgain = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPi3Variables = new javax.swing.JTable();
        txtFinalEquation3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblIntermediate3Variables = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConvertAgain.setText("Convert Again");

        tblPi3Variables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "0", "1", "2", "3", "4", "5", "6", "7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPi3Variables.setRowHeight(30);
        tblPi3Variables.setRowSelectionAllowed(false);
        tblPi3Variables.setShowGrid(true);
        tblPi3Variables.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPi3Variables);
        if (tblPi3Variables.getColumnModel().getColumnCount() > 0) {
            tblPi3Variables.getColumnModel().getColumn(0).setResizable(false);
            tblPi3Variables.getColumnModel().getColumn(0).setPreferredWidth(300);
            tblPi3Variables.getColumnModel().getColumn(1).setResizable(false);
            tblPi3Variables.getColumnModel().getColumn(2).setResizable(false);
            tblPi3Variables.getColumnModel().getColumn(3).setResizable(false);
            tblPi3Variables.getColumnModel().getColumn(4).setResizable(false);
            tblPi3Variables.getColumnModel().getColumn(5).setResizable(false);
            tblPi3Variables.getColumnModel().getColumn(6).setResizable(false);
            tblPi3Variables.getColumnModel().getColumn(7).setResizable(false);
            tblPi3Variables.getColumnModel().getColumn(8).setResizable(false);
        }

        txtFinalEquation3.setEditable(false);
        txtFinalEquation3.setToolTipText("");
        txtFinalEquation3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinalEquation3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Intermediate Table");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Pi Table");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Final Equation : ");
        jLabel3.setToolTipText("");

        tblIntermediate3Variables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Column 1", "Column 2", "Column 3", "Column 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIntermediate3Variables.setRowHeight(30);
        tblIntermediate3Variables.setRowSelectionAllowed(false);
        tblIntermediate3Variables.setShowGrid(true);
        tblIntermediate3Variables.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblIntermediate3Variables);
        if (tblIntermediate3Variables.getColumnModel().getColumnCount() > 0) {
            tblIntermediate3Variables.getColumnModel().getColumn(0).setResizable(false);
            tblIntermediate3Variables.getColumnModel().getColumn(1).setResizable(false);
            tblIntermediate3Variables.getColumnModel().getColumn(2).setResizable(false);
            tblIntermediate3Variables.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(626, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtFinalEquation3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(btnConvertAgain)))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFinalEquation3))
                    .addComponent(btnConvertAgain, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFinalEquation3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinalEquation3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalEquation3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThreeVariablesFrm threeVariablesFrm = new ThreeVariablesFrm();
                threeVariablesFrm.setVisible(true);
                // Tạo ThreeVariablesOutput với tham chiếu đến threeVariablesFrm
                new ThreeVariablesOutput(threeVariablesFrm).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvertAgain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblIntermediate3Variables;
    private javax.swing.JTable tblPi3Variables;
    private javax.swing.JTextField txtFinalEquation3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        var obj = e.getSource();
        if (obj.equals(btnConvertAgain)) {
            ThreeVariablesFrm threeVariablesFrm = new ThreeVariablesFrm();
            threeVariablesFrm.setVisible(true);
            this.dispose();
        }
    }

    private void addActionListener() {
        btnConvertAgain.addActionListener(this);
    }

    private void insertValueIntoColumn() {
        String selectedOption = threeVariablesFrm.getSelectedOption();
        String filename = "D:\\Netbeans\\OOP\\" + (selectedOption.equals("POS") ? "POS.txt" : "SOP.txt");
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String data = reader.readLine();
            minterms = new ArrayList<>();
            while (data != null) {
                Minterm minterm = createMintermFromFile(data);
                if (minterm != null) {
                    minterms.add(minterm);
                }
                data = reader.readLine();
            }
            Collections.sort(minterms, new MintermComparator());

            // Chuyển đổi minterms sang dạng PairCombination
            List<PairCombination> pairCombinations = minterms.stream()
                    .map(m -> new PairCombination(m.getMinterm(), m.getValue()))
                    .collect(Collectors.toList());
            // Kết hợp các minterm
            boolean[] isCombined = new boolean[pairCombinations.size()];
            List<PairCombination> combinedPairCombinations = ParityCheck.combineMinterms(pairCombinations, isCombined);
            List<PairCombination> newCombinedPairs = ParityCheck.combinePairCombinations(combinedPairCombinations);
            List<PairCombination> lastCombinedPair = ParityCheck.combinePairCombinations(newCombinedPairs);

            List<PairCombination> primeImplicants1 = ParityCheck.findPrimeImplicants(lastCombinedPair);
            List<PairCombination> primeImplicants2 = ParityCheck.findPrimeImplicants(newCombinedPairs);
            List<PairCombination> primeImplicants3 = ParityCheck.findPrimeImplicants(combinedPairCombinations);

            List<PairCombination> primeImplicants = new ArrayList<>();
            primeImplicants.addAll(primeImplicants1);
            primeImplicants.addAll(primeImplicants2);
            primeImplicants.addAll(primeImplicants3);
            

            // Điền dữ liệu vào bảng, đảm bảo mỗi cột có thể chứa số hàng cần thiết
            int maxRows = Math.max(minterms.size(), Math.max(combinedPairCombinations.size(), newCombinedPairs.size()));

            for (int i = 0; i < maxRows; i++) {
                // Nếu tableModel không đủ hàng thì thêm hàng mới
                if (i >= tableModel.getRowCount()) {
                    tableModel.addRow(new Object[]{null, null, null,null});
                }
                // Điền dữ liệu vào cột 1 ,cột 2,cột 3, cột 4 nếu hàng không tồn tại giá trị thì điền khoảng trắng
                tableModel.setValueAt(i < minterms.size() ? minterms.get(i).toString() : "", i, 0);
                PairCombination pc = i < combinedPairCombinations.size() ? combinedPairCombinations.get(i) : new PairCombination("", "");
                tableModel.setValueAt(pc.getIndices() + " " + pc.getCombinedMinterm(), i, 1);
                PairCombination pc1 = i < newCombinedPairs.size() ? newCombinedPairs.get(i) : new PairCombination("", "");
                tableModel.setValueAt(pc1.getIndices() + " " + pc1.getCombinedMinterm(), i, 2);
                PairCombination pc2 = i < lastCombinedPair.size() ? lastCombinedPair.get(i) : new PairCombination("", "");
                tableModel.setValueAt(pc2.getIndices() + " " + pc2.getCombinedMinterm(), i, 3);
            }
            insertIntoPiTable(primeImplicants);
        } catch (IOException ex) {
            Logger.getLogger(ThreeVariablesOutput.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error reading the file: " + ex.getMessage());
        }
        setCellRenderers();
        clearContentsOfFile(filename);
    }

    private Minterm createMintermFromFile(String data) {
        if (data == null || data.trim().isEmpty()) {
            return null;
        }
        String[] parts = data.split("\\s+"); // Split based on whitespace
        if (parts.length == 2) {
            return new Minterm(parts[0], parts[1]);
        }
        return null;
    }

    private void clearContentsOfFile(String filename) {
        try (FileWriter fw = new FileWriter(filename, false)) {
            // Ghi đè một chuỗi rỗng lên file, điều này sẽ làm sạch nội dung file
            fw.write("");
        } catch (IOException ex) {
            Logger.getLogger(ThreeVariablesOutput.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error clearing the file: " + ex.getMessage());
        }
    }

    private void setCellRenderers() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(CENTER);
        for (int i = 0; i <= 3; i++) {
            tblIntermediate3Variables.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tblIntermediate3Variables.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(CENTER);
    }

    private void insertIntoPiTable(List<PairCombination> primeImplicants) {
        // Đảm bảo tableModel1 có đủ số lượng hàng.
        while (tableModel1.getRowCount() < primeImplicants.size()) {
            tableModel1.addRow(new Object[]{null});
        }

        // Điền giá trị vào từng hàng của tableModel1.
        for (int i = 0; i < primeImplicants.size(); i++) {
            PairCombination primeImplicant = primeImplicants.get(i);
            tableModel1.setValueAt(primeImplicant.getIndices() + " " + primeImplicant.getCombinedMinterm(), i, 0);
        }
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tblPi3Variables.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(CENTER);
        applyPrimeImplicantRenderer(tblPi3Variables, primeImplicants);
        insertValueIntoTable(primeImplicants);
    }

    private void applyPrimeImplicantRenderer(JTable table, List<PairCombination> primeImplicants) {
        PrimeImplicantTableCellRenderer renderer = new PrimeImplicantTableCellRenderer(primeImplicants);
        table.setDefaultRenderer(Object.class, renderer);
        table.repaint(); // Đảm bảo bảng được cập nhật với dữ liệu mới
    }

    private void insertValueIntoTable(List<PairCombination> primeImplicants) {
        List<String> inputPairs = PairCombinationUtils.convertToInputPairs(primeImplicants);
        List<PrimeImplicant> parsedImplicants = PrimeImplicant.parseInputPairs(inputPairs);
        Set<Integer> allMinterms = new HashSet<>();
        parsedImplicants.forEach(pi -> allMinterms.addAll(pi.getMinterms()));
        List<PrimeImplicant> essentialPIs = BooleanSimplication.findEssentialPrimeImplicants(parsedImplicants, allMinterms);
        // Xác định các minterms chưa được phủ bởi EPIs.
        // Tạo một Set mới để lưu trữ các minterms của EPIs
        Set<Integer> mintermsOfEPIs = new HashSet<>();
        // Thêm các minterms từ mỗi EPI vào Set
        essentialPIs.forEach(epi -> mintermsOfEPIs.addAll(epi.getMinterms()));

        Set<Integer> mintermsToCover = new HashSet<>(allMinterms);
        mintermsToCover.removeAll(mintermsOfEPIs);

        // Xác định các Non-EPIs.
        List<PrimeImplicant> nonEpis = new ArrayList<>(parsedImplicants);
        nonEpis.removeAll(essentialPIs);
        // Bây giờ bạn có nonEpis và mintermsToCover, bạn có thể tìm ra phủ nhỏ nhất.
        List<PrimeImplicant> minimumNonEPIsCover = BooleanSimplication.findMinimumCoverOfNonEPIs(nonEpis, mintermsToCover, essentialPIs);
        // Kết hợp các EPIs và Non-EPIs để có được tập hợp tối giản cuối cùng
        minimumNonEPIsCover.addAll(essentialPIs);
        String minimumNonEPIsCoverText = minimumNonEPIsCover.stream()
                .map(PrimeImplicant::getImplicant)
                .collect(Collectors.joining(","));

        String selectedOption = threeVariablesFrm.getSelectedOption(); // Giả sử bạn đã có một form hoặc phương thức để lấy tùy chọn này

        // Chuyển đổi minimumNonEPIsCoverText thành mảng chuỗi để đưa vào hàm chuyển đổi
        String[] implicantsArray = minimumNonEPIsCoverText.split(",");

        String text;
        if ("POS".equals(selectedOption)) {
            text = BooleanExpressionConverter3Variables.toPOS(implicantsArray); // Giả sử đã được cập nhật để nhận mảng chuỗi
        } else {
            text = BooleanExpressionConverter3Variables.toSOP(implicantsArray); // Giả sử đã được cập nhật để nhận mảng chuỗi
        }
        // Đặt văn bản cho thành phần GUI
        txtFinalEquation3.setText(text);
    }

}