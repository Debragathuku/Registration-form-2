import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration extends JFrame {

    private JTextField userIdField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField contactField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public Registration() {
        setTitle("Registration Form");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create panels
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BorderLayout());

        // Form elements
        userIdField = new JTextField();
        nameField = new JTextField();
        addressField = new JTextField();
        contactField = new JTextField();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");

        // Adding elements to form panel
        formPanel.add(new JLabel("User ID:"));
        formPanel.add(userIdField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        formPanel.add(genderPanel);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);
        formPanel.add(new JLabel("Contact:"));
        formPanel.add(contactField);

        // Adding buttons to button panel
        buttonPanel.add(registerButton);
        buttonPanel.add(exitButton);

        // Table setup
        String[] columnNames = {"User ID", "Name", "Gender", "Address", "Contact"};
        tableModel = new DefaultTableModel(columnNames, 1);
        dataTable = new JTable(tableModel);
        dataTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(dataTable);

        // Adding components to the frame
        dataPanel.add(tableScrollPane, BorderLayout.CENTER);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(dataPanel, BorderLayout.EAST);

        // Populate table with initial data
        populateTable();

        // Action listeners
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable();
                insertDataIntoDatabase();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void populateTable() {
        // Initialize the table with empty values
        String[] initialValues = {"", "", "", "", ""};
        tableModel.addRow(initialValues);
    }

    private void updateTable() {
        // Update the single row with current data
        tableModel.setValueAt(userIdField.getText(), 0, 0);
        tableModel.setValueAt(nameField.getText(), 0, 1);
        tableModel.setValueAt(maleRadioButton.isSelected() ? "Male" : "Female", 0, 2);
        tableModel.setValueAt(addressField.getText(), 0, 3);
        tableModel.setValueAt(contactField.getText(), 0, 4);
    }

    private void insertDataIntoDatabase() {
        String dbUrl = "jdbc:mysql://localhost:3306/registration";
        String dbUser = "root";
        String dbPassword = "";

        String userId = userIdField.getText();
        String name = nameField.getText();
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        String address = addressField.getText();
        String contact = contactField.getText();

        String sql = "INSERT INTO `registration 2` (`user id`, name, gender, address, contact) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            pstmt.setString(4, address);
            pstmt.setString(5, contact);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration successful!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }
}
