package ru.bobans.Utils;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

/**
 * Created by GrishukovVM on 28.06.2016.
 */
public class FcikValidationEventHandler implements ValidationEventHandler {
    Integer count=0;
    String Error = "";
    @Override
    public boolean handleEvent(ValidationEvent validationEvent) {
        System.out.println("\nОшибка валидации: " + ++count);
        System.out.println("Сообщение:  " + validationEvent.getMessage());
        System.out.println("Расширенное сообщение:  " + validationEvent.getLinkedException() + "\n");
        Error+="\r\nMESSAGE " + count +" :" + validationEvent.getMessage();
        return true;
    }

    public Integer getCount() {
        return count;
    }

    public String getError() {
        return Error;
    }
}
