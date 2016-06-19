package by.zmitser.webapp.service.impl;


import by.zmitser.webapp.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailServiceImpl implements EmailService{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Override
    public void sendEmail() {
        LOGGER.debug("EmailServiceImpl: save() method is called!");
    }
}
