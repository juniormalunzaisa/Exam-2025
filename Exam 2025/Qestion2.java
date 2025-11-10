import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Qestion2 extends JFrame {
    private JTextArea textArea;
    private JLabel lblYears;
    private final int SALES_LIMIT = 500;

    public Qestion2() {
        setTitle("Product Sales Application");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        JButton btnLoad = new JButton("Load Product Data");
        JButton btnSave = new JButton("Save Product Data");
        textArea = new JTextArea(10, 35);
        textArea.setEditable(false);
        lblYears = new JLabel("Years Processed: 0");

        add(btnLoad);
        add(btnSave);
        add(new JScrollPane(textArea));
        add(lblYears);

        btnLoad.addActionListener(e -> loadProductData());
        btnSave.addActionListener(e -> saveProductData());

        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());
        exitItem.addActionListener(e -> System.exit(0));
    }

    private void loadProductData() {
        int[][] sales = {
                {300, 150, 700},
                {250, 200, 600}
        };
        String[] products = {"Microphone", "Speakers", "Mixing Desk"};

        int totalSales = 0;
        int salesOverLimit = 0;
        int salesUnderLimit = 0;
        int yearsProcessed = sales.length;
        int totalEntries = 0;

        StringBuilder sb = new StringBuilder("DATA LOG\n====================\n");

        for (int i = 0; i < yearsProcessed; i++) {
            sb.append("Year " + (i + 1) + ":\n");
            for (int j = 0; j < products.length; j++) {
                int value = sales[i][j];
                sb.append(products[j] + ": " + value + "\n");
                totalSales += value;
                totalEntries++;
                if (value > SALES_LIMIT) salesOverLimit++;
                else salesUnderLimit++;
            }
        }

        double avgSales = (double) totalSales / totalEntries;

        sb.append("\nTotal Sales: " + totalSales);
        sb.append("\nAverage Sales: " + String.format("%.0f", avgSales));
        sb.append("\nSales over limit: " + salesOverLimit);
        sb.append("\nSales under limit: " + salesUnderLimit);
        sb.append("\n====================");

        textArea.setText(sb.toString());
        lblYears.setText("Years Processed: " + yearsProcessed);
    }


    private void saveProductData() {
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }


    private void clearData() {
        textArea.setText("");
        lblYears.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Qestion2().setVisible(true));
    }
}