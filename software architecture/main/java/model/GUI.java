import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private PlayerManager playerManager;
    private RefreeManager RefreeManager;
    private ReportGenerator reportGenerator;

    private JTextField playerNameField;
    private JTextField playerDOBField;
    private JComboBox<String> categoryComboBox;

    private JTextField RefreeUsernameField;
    private JPasswordField RefreePasswordField;
    private JTextField playerIDField;
    private JTextField goalField;
    private JTextField pointsystemField;
    private JTextField scoreboardField;

    private JTextField reportsPlayerIDField;

    private boolean isModeratorLoggedIn = false;

    public GUI() {
        this.frame = new JFrame("Football Match");
        this.tabbedPane = new JTabbedPane();
        this.playerManager = new PlayerManager();
        this.RefreeManager = new RefreeManager();
        this.reportGenerator = new ReportGenerator();

        initializeGUI();
    }

    private void initializeGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Create tabs
        createPlayerRegistrationTab();
        createModeratorTab();
        createReportsTab();

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    private void createPlayerRegistrationTab() {
        JPanel playerRegistrationPanel = new JPanel();
        playerRegistrationPanel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        playerNameField = new JTextField();
        JLabel dobLabel = new JLabel("Date of Birth:");
        playerDOBField = new JTextField();
        JLabel categoryLabel = new JLabel("Category:");

        String[] categories = {"Novice", "Intermediate", "Professional"};
        categoryComboBox = new JComboBox<>(categories);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPlayer();
            }
        });

        playerRegistrationPanel.add(nameLabel);
        playerRegistrationPanel.add(playerNameField);
        playerRegistrationPanel.add(dobLabel);
        playerRegistrationPanel.add(playerDOBField);
        playerRegistrationPanel.add(categoryLabel);
        playerRegistrationPanel.add(categoryComboBox);
        playerRegistrationPanel.add(registerButton);

        tabbedPane.addTab("Player Registration", playerRegistrationPanel);
    }

    private void createModeratorTab() {
        JPanel moderatorPanel = new JPanel();
        moderatorPanel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        RefreeUsernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        RefreePasswordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginModerator();
            }
        });

        JLabel playerIDLabel = new JLabel("Player ID:");
        playerIDField = new JTextField();
        JLabel goalLabel = new JLabel("Goal:");
        goalField = new JTextField();
        JLabel pointsystemLabel = new JLabel("Pointsystem:");
        pointsystemField = new JTextField();
        JLabel scoreboardLabel = new JLabel("Scoreboard:");
        scoreboardField = new JTextField();
        JButton submitScoreButton = new JButton("Submit Score");
        submitScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitScore();
            }
        });

        moderatorPanel.add(usernameLabel);
        moderatorPanel.add(RefreeUsernameField);
        moderatorPanel.add(passwordLabel);
        moderatorPanel.add(RefreePasswordField);
        moderatorPanel.add(loginButton);
        moderatorPanel.add(playerIDLabel);
        moderatorPanel.add(playerIDField);
        moderatorPanel.add(goalLabel);
        moderatorPanel.add(goalField);
        moderatorPanel.add(pointsystemLabel);
        moderatorPanel.add(pointsystemField);
        moderatorPanel.add(scoreboardLabel);
        moderatorPanel.add(scoreboardField);
        moderatorPanel.add(submitScoreButton);

        tabbedPane.addTab("Refree", moderatorPanel);
    }

    private void createReportsTab() {
        JPanel reportsPanel = new JPanel();
        reportsPanel.setLayout(new GridLayout(2, 2));

        JLabel playerIDLabel = new JLabel("Player ID:");
        reportsPlayerIDField = new JTextField();
        JButton averageScoreButton = new JButton("Generate Average Score Report");
        averageScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateAverageScoreReport();
            }
        });

        JButton fullReportButton = new JButton("Generate Full Report");
        fullReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateFullReport();
            }
        });

        reportsPanel.add(playerIDLabel);
        reportsPanel.add(reportsPlayerIDField);
        reportsPanel.add(averageScoreButton);
        reportsPanel.add(fullReportButton);

        tabbedPane.addTab("Reports", reportsPanel);
    }

    private void registerPlayer() {
        try {
            String name = playerNameField.getText();
            String dob = playerDOBField.getText();
            String category = (String) categoryComboBox.getSelectedItem();

            playerManager.registerPlayer(name,dob,category);
            JOptionPane.showMessageDialog(frame, "Player registered successfully!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, "Error registering player: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loginModerator() {
        try {
            String username = RefreeUsernameField.getText();
            char[] passwordChars = RefreePasswordField.getPassword();
            String password = new String(passwordChars);

            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Username and Password are required fields.");
            }

            // Check moderator credentials
            if (RefreeManager.login(username, password)) {
                JOptionPane.showMessageDialog(frame, "Refree login successful");
                // Update login status
                isModeratorLoggedIn = true;
            } else {
                JOptionPane.showMessageDialog(frame, "Refree login failed");
            }

            RefreeUsernameField.setText("");
            RefreePasswordField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error logging in: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void submitScore() {
        try {
            // Check if the moderator is logged in
            if (!isModeratorLoggedIn) {
                throw new IllegalStateException("Refree must log in before submitting scores.");
            }

            int playerID = Integer.parseInt(playerIDField.getText());
            int goal = Integer.parseInt(goalField.getText());
            int pointsystem = Integer.parseInt(pointsystemField.getText());
            int scoreboard = Integer.parseInt(scoreboardField.getText());

            // Perform input validation before submitting the score
            if (goal < 0 || pointsystem < 0 || scoreboard < 0) {
                throw new IllegalArgumentException("Scores cannot be negative.");
            }

            RefreeManager.inputScores(playerID, goal, pointsystem, scoreboard);
            JOptionPane.showMessageDialog(frame, "Score submitted successfully!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            JOptionPane.showMessageDialog(frame, "Error submitting score: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateAverageScoreReport() throws NumberFormatException {
        try {
            int playerID = Integer.parseInt(reportsPlayerIDField.getText());
            String report = reportGenerator.generateAverageScoreReport(playerID);
            JOptionPane.showMessageDialog(frame, report);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, "Error generating average score report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateFullReport() throws NumberFormatException {
        try {
            int playerID = Integer.parseInt(reportsPlayerIDField.getText());
            String report = reportGenerator.generateFullReport(playerID);
            JOptionPane.showMessageDialog(frame, report);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, "Error generating full report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
