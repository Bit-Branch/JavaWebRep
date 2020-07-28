package by.epam.committiee.resource;

import java.util.ResourceBundle;

public class MessageManager {

    private static final String PARAM_MESSAGES_NAME = "prop/messages";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(PARAM_MESSAGES_NAME);

    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}