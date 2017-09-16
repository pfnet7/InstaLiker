package project.instaLiker;

import javax.swing.*;

public class DialogPanel {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField linkField;
    private int browserChoice;

    public DialogPanel() {
        loginField = new JTextField(15);
        passwordField = new JPasswordField(15);
        linkField = new JTextField(15);

        Object[] inputPanel = new Object[]{"Login:", loginField, "Password:", passwordField, "Instagram link:", linkField};
        browserChoice = JOptionPane.showOptionDialog(null,
                                                     inputPanel,
                                                     null,
                                                     JOptionPane.DEFAULT_OPTION,
                                                     JOptionPane.QUESTION_MESSAGE,
                                                     null,
                                                     BROWSERS.values(),
                                                     null);
    }

    public String getLogin() {
        return loginField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public String getInstagramLink() {
        return linkField.getText();
    }

    public int getBrowserChoice() {
        return browserChoice;
    }

    private enum BROWSERS {
        FIREFOX, CHROME, IE, OPERA
    }

}
