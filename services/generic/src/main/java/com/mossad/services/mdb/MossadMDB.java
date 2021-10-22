/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services.mdb;

import com.mossad.lib.domain.constants.Constants;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.MessageDrivenContext;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mmigdal
 */
@MessageDriven(mappedName = Constants.JMS_MAPPING_NAME_QUEUE, activationConfig = {
    @ActivationConfigProperty(propertyName = Constants.JMS_ACKNOWLEDGE_MODE, propertyValue = Constants.JMS_AUTO_KNOWLEDGE),
    @ActivationConfigProperty(propertyName = Constants.JMS_DESTINATION_TYPE, propertyValue = Constants.JMS_QUEUE)
})
public class MossadMDB implements MessageListener {

    private final Logger log = Logger.getLogger(getClass().getName());
    private MessageDrivenContext mdc;

    @Override
    public void onMessage(Message message) {
        log.log(Level.FINE, " Here is MDB {0}", message.toString());
    }
}
