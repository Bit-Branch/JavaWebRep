package by.epam.committiee.servlet;

import by.epam.committiee.mail.MailSender;

public class EmailTest {
    public static void main(String[] args) {
        MailSender mailSender = new MailSender("dorhead@mail.ru", "Registration", "You successfully registered");
        mailSender.send();
    }
}
