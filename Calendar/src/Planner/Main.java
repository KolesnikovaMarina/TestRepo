package Planner;

import Entities.*;
import Entities.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static private User loginUser;
    static private JFrame loginFrame;
    static private JFrame mainFrame = new JFrame("Events Calendar");;
    static private JPanel mainPanel = new JPanel();
    static private JPanel addPanel = new JPanel();
    static private JPanel editPanel = new JPanel();
    static private JPanel searchPanel = new JPanel();
    static JTextField userText;
    static JPasswordField passwordText;
    private static JTextField titleText;
    private static JLabel beginDateLabel;
    private static JTextField beginDateText;
    private static JTextField endDateText;
    private static JTextField particText;
    private static JTextField priorityText;
    private static JTextField priorityEditText;
    private static JTextField beginDateEditText;
    private static JTextField dateSearchText;
    private static JTextField particEditText;
    private static JTextField titleSearchText;
    private static JTextField endDateEditText;
    private static JTextField particSearchText;
    private static JTextArea display;
    private static JComboBox placeSearchComboBox;
    private static JComboBox placeAddComboBox;
    private static JComboBox titleEditComboBox;
    private static JComboBox placeEditComboBox;

    public static void main(String[] args) {
        loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 150);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        loginFrame.add(panel);
        placeLoginComponents(panel);

        loginFrame.setVisible(true);


        mainFrame.setResizable(false);
        loginFrame.setResizable(false);
    }

    private static void placeLoginComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(180, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 onLoginButtonClick();;
            }
        });
    }

    public static void onLoginButtonClick(){
        String login = userText.getText().trim();
        String password = new String(passwordText.getPassword());
        loginUser = User.getUserByLogin(login,password);
        if(loginUser == null) {
            JOptionPane.showMessageDialog(loginFrame,
                    "You enter invalid data, no users with such login or password",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
        else{
            placeMainFrameComponents();
        }
    }

    public  static void placeMainFrameComponents(){
        mainFrame.setSize(500, 400);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        loginFrame.setVisible(false);
        mainPanel.setLayout(new BorderLayout());


        JTabbedPane jtp = new JTabbedPane();
        jtp.setFont(new Font("TimesRoman", Font.BOLD, 16));
        jtp.setBackground(new Color(191, 195, 201));
        mainPanel.add(jtp);


        //add panel
        placeAddPanelComponents();
        jtp.addTab("Add Event", addPanel);

        //edit panel
        if(loginUser.getJobTitle().equals(JobTitle.DIRECTOR) || loginUser.getJobTitle().equals(JobTitle.LEADER)) {
            placeEditPanelComponents();
            jtp.addTab("Edit Event", editPanel);
        }

        //search panel
        placeSearchPanelComponents();
        jtp.addTab("Search Event", searchPanel);
    }

    private static void placeAddPanelComponents() {
        addPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Event Title:");
        titleLabel.setBounds(10, 10, 230, 25);
        addPanel.add(titleLabel);

        titleText = new JTextField(20);
        titleText.setBounds(250, 10, 200, 25);
        addPanel.add(titleText);

        beginDateLabel = new JLabel("Begin date (yyyy-MM-dd HH:mm):");
        beginDateLabel.setBounds(10, 40, 230, 25);
        addPanel.add(beginDateLabel);

        beginDateText = new JTextField(20);
        beginDateText.setBounds(250, 40, 160, 25);
        addPanel.add(beginDateText);

        JLabel endDateLabel = new JLabel("End date (yyyy-MM-dd HH:mm):");
        endDateLabel.setBounds(10, 70, 230, 25);
        addPanel.add(endDateLabel);

        endDateText = new JTextField(20);
        endDateText.setBounds(250, 70, 160, 25);
        addPanel.add(endDateText);

        JLabel particLabel = new JLabel("Participants:");
        particLabel.setBounds(10, 100, 230, 25);
        addPanel.add(particLabel);

        particText = new JTextField(20);
        particText.setBounds(250, 100, 200, 25);
        addPanel.add(particText);

        JLabel priorityLabel = new JLabel("Priority(1-5):");
        priorityLabel.setBounds(10, 130, 230, 25);
        addPanel.add(priorityLabel);

        priorityText = new JTextField(20);
        priorityText.setBounds(250, 130, 20, 25);
        addPanel.add(priorityText);

        JLabel placeLabel = new JLabel("Place:");
        placeLabel.setBounds(10, 160, 230, 25);
        addPanel.add(placeLabel);

        placeAddComboBox = new JComboBox(Place.values());
        placeAddComboBox.setSelectedIndex(0);
        placeAddComboBox.setBounds(250, 160, 200, 25);
        addPanel.add(placeAddComboBox);

        JButton addButton = new JButton("Add");
        addButton.setBounds(180, 200, 80, 25);
        addPanel.add(addButton);
        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onAddButtonEvents();
            }
        });
    }

    public static void onAddButtonEvents(){
        ArrayList<String> users =  new ArrayList<String>(Arrays.asList(particText.getText().split("\\s*;\\s*")));
        String warningMessage = Event.checkEvent(titleText.getText(),beginDateText.getText(),endDateText.getText(),
                placeAddComboBox.getSelectedItem().toString(),users,loginUser, Integer.parseInt(priorityText.getText()));
        if(!warningMessage.isEmpty()){
            JOptionPane.showMessageDialog(mainFrame, warningMessage,"Incorrect data", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            Event.addEvent(titleText.getText(),beginDateText.getText(),endDateText.getText(),
                    placeAddComboBox.getSelectedItem().toString(),users,loginUser, Integer.parseInt(priorityText.getText()));
            titleEditComboBox.addItem(titleText.getText());
            JOptionPane.showMessageDialog(mainFrame, "New event was successfully added","New event", JOptionPane.INFORMATION_MESSAGE);
            titleText.setText("");
            beginDateText.setText("");
            endDateText.setText("");
            particText.setText("");
            priorityText.setText("");
            placeAddComboBox.setSelectedIndex(0);


        }
    }


    private static void placeEditPanelComponents() {
        editPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Event Title:");
        titleLabel.setBounds(10, 10, 230, 25);
        editPanel.add(titleLabel);


        titleEditComboBox = new JComboBox(Event.getAllEventsTitles().toArray());
        titleEditComboBox.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                onTitleEditComboBox(e);
            }
        });
        titleEditComboBox.setBounds(250, 10, 200, 25);
        editPanel.add(titleEditComboBox);

        beginDateLabel = new JLabel("New Begin date (yyyy-MM-dd HH:mm):");
        beginDateLabel.setBounds(10, 40, 230, 25);
        editPanel.add(beginDateLabel);

        beginDateEditText = new JTextField(20);
        beginDateEditText.setBounds(250, 40, 160, 25);
        editPanel.add(beginDateEditText);

        JLabel endDateLabel = new JLabel("New End date (yyyy-MM-dd HH:mm):");
        endDateLabel.setBounds(10, 70, 230, 25);
        editPanel.add(endDateLabel);

        endDateEditText = new JTextField(20);
        endDateEditText.setBounds(250, 70, 160, 25);
        editPanel.add(endDateEditText);

        JLabel particLabel = new JLabel("New Participants:");
        particLabel.setBounds(10, 100, 230, 25);
        editPanel.add(particLabel);

        particEditText = new JTextField(20);
        particEditText.setBounds(250, 100, 200, 25);
        editPanel.add(particEditText);

        JLabel priorityLabel = new JLabel("New Priority(1-5):");
        priorityLabel.setBounds(10, 130, 230, 25);
        editPanel.add(priorityLabel);

        priorityEditText = new JTextField(20);
        priorityEditText.setBounds(250, 130, 20, 25);
        editPanel.add(priorityEditText);

        JLabel placeLabel = new JLabel("New Place:");
        placeLabel.setBounds(10, 160, 230, 25);
        editPanel.add(placeLabel);

        placeEditComboBox = new JComboBox(Place.values());
        placeEditComboBox.setBounds(250, 160, 200, 25);
        editPanel.add(placeEditComboBox);

        titleEditComboBox.setSelectedIndex(0);

        JButton editButton = new JButton("Edit");
        editButton.setBounds(120, 200, 80, 25);
        editPanel.add(editButton);
        editButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onEditButtonEvents(titleEditComboBox.getSelectedItem().toString());
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(220, 200, 80, 25);
        editPanel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onDeleteButtonEvents(titleEditComboBox.getSelectedItem().toString());
            }
        });

    }

    private static void onTitleEditComboBox(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String eventTitle= (String)cb.getSelectedItem();
        Event event  = Event.getEventByTitle(eventTitle);
        beginDateEditText.setText(Event.formatter.format(event.getBeginDate()));
        endDateEditText.setText(Event.formatter.format(event.getEndDate()));
        particEditText.setText(event.getParticipantsNames().toString().replaceAll("\\[|\\]", "").replaceAll(", ","; "));
        priorityEditText.setText(Integer.toString(event.getPriority()));
        placeEditComboBox.setSelectedItem(event.getPlace());
    }


    private static void onDeleteButtonEvents(String eventTitle) {
        int dialogResult = JOptionPane.showConfirmDialog(mainFrame, "Are you sure you want to delete " + eventTitle + " event?" ,
                                                   "Question", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Event.deleteEventByTitle(eventTitle);
            titleEditComboBox.removeItem(eventTitle);
            JOptionPane.showMessageDialog(mainFrame, eventTitle + " event was successfully deleted"," Message", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private static void onEditButtonEvents(String eventTitle) {
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(particEditText.getText().split("\\s*;\\s*")));
        String warningMessage = Event.checkEvent(titleEditComboBox.getSelectedItem().toString(), beginDateEditText.getText(), beginDateEditText.getText(),
                placeEditComboBox.getSelectedItem().toString(), users, loginUser, Integer.parseInt(priorityEditText.getText()));
        if (!warningMessage.isEmpty()) {
            JOptionPane.showMessageDialog(mainFrame, warningMessage, "Incorrect data", JOptionPane.WARNING_MESSAGE);
        }
        else {
            int dialogResult = JOptionPane.showConfirmDialog(mainFrame, "Are you sure you want to edit " + eventTitle + " event?",
                    "Question", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Event.deleteEventByTitle(eventTitle);
                Event.addEvent(eventTitle, beginDateEditText.getText(), endDateEditText.getText(),
                        placeEditComboBox.getSelectedItem().toString(), users, loginUser, Integer.parseInt(priorityEditText.getText()));
                JOptionPane.showMessageDialog(mainFrame, eventTitle + " event was successfully edited", " Message", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    private static void placeSearchPanelComponents() {
        searchPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Search Events by title:");
        titleLabel.setBounds(10, 10, 230, 25);
        searchPanel.add(titleLabel);

        titleSearchText = new JTextField(20);
        titleSearchText.setBounds(250, 10, 200, 25);
        searchPanel.add(titleSearchText);


        beginDateLabel = new JLabel("Search by date (yyyy-MM-dd HH:mm):");
        beginDateLabel.setBounds(10, 40, 230, 25);
        searchPanel.add(beginDateLabel);

        dateSearchText = new JTextField(20);
        dateSearchText.setBounds(250, 40, 160, 25);
        searchPanel.add( dateSearchText);


        JLabel particLabel = new JLabel("Search by user:");
        particLabel.setBounds(10, 70, 230, 25);
        searchPanel.add(particLabel);

        particSearchText = new JTextField(20);
        particSearchText.setBounds(250, 70, 200, 25);
        searchPanel.add(particSearchText);

        JLabel placeLabel = new JLabel("Search by place:");
        placeLabel.setBounds(10, 100, 230, 25);
        searchPanel.add(placeLabel);

        placeSearchComboBox = new JComboBox(getPlacesForSearch().toArray());
        placeSearchComboBox.setSelectedIndex(7);
        placeSearchComboBox.setBounds(250, 100, 200, 25);
        searchPanel.add(placeSearchComboBox);



        display = new JTextArea(16, 58);
        display.setEditable(false); // set textArea non-editable
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10, 170, 460, 150);
        searchPanel.add(scroll);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(180, 135, 80, 25);
        searchPanel.add(searchButton);
        searchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onSearchButtonEvents();
            }
        });
    }

    public static void onSearchButtonEvents(){
        clearDispaly();
        ArrayList<Entities.Event> events= Event.search(titleSearchText.getText().trim(),
                dateSearchText.getText().trim(),particSearchText.getText().trim(),placeSearchComboBox.getSelectedItem().toString());
        if(!events.isEmpty()) {
            for (Entities.Event event : events) {
                printEvent(event);
            }
        }else
        {
            display.append( "No events with such parametres");
        }
    }

    public static void clearDispaly(){
        display.setText("");
    }

    public static void printEvent(Entities.Event event){
        display.append( "Title: " + event.getTitle() + "\n");
        display.append( "Begin Date: " + Event.formatter.format(event.getBeginDate()) + "\n");
        display.append( "End Date: " + Event.formatter.format(event.getEndDate()) + "\n");
        display.append( "Creator: " + event.getCreator().getName() + "\n");
        display.append( "Priority: " + event.getPriority() + "\n");
        display.append( "Place: " + event.getPlace() + "\n");
        display.append( "Participants: ");
        for(String user:event.getParticipantsNames()){
            display.append(user+"; " );
        }
        display.append( "\n ------------------------------------------- \n");

    }

    public static ArrayList<String> getPlacesForSearch() {
        ArrayList<String> places = new ArrayList<String>();
        for(Place place:Place.values()) {
            places.add(place.toString());
        }
        places.add(Place.noPlace);
        return places;
    }

}
