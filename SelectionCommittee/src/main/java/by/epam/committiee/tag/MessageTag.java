package by.epam.committiee.tag;

import by.epam.committiee.command.RequestParameters;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageTag extends TagSupport {
    private static final long serialVersionUID = 1L;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        HttpSession session = pageContext.getSession();
        Object msg = session.getAttribute(RequestParameters.MESSAGE);

        if (msg != null) {
            Object loc = session.getAttribute(RequestParameters.LOCALE);
            Locale locale = loc != null ? (Locale) loc
                    : pageContext.getRequest().getLocale();

            ResourceBundle bundle = ResourceBundle.getBundle(
                    "resources.bundle.pagecontent", locale);
            try {
                out.print(bundle.getString(msg.toString()));
            } catch (IOException e) {
                throw new JspException();
            }
            session.removeAttribute(RequestParameters.MESSAGE);
        }

        return SKIP_BODY;
    }

}
