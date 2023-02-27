package finalcase.service.impl;

import finalcase.service.InformationMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InformationMessageServiceImpl implements InformationMessageService {

    @Override
    public void sendSMSToCustomer(String customerPhone, String content) {
        this.sendSMS(customerPhone, content);
    }


    private void sendSMS(String customerPhone, String content){
        log.debug("The information messages has been sent to " + customerPhone);
    }
}
