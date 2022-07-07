package com.interview.enableu.task.service.url;

import com.interview.enableu.task.exception.UrlStatusNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

import static com.interview.enableu.task.service.helper.ConstantsHelper.*;
import static com.interview.enableu.task.service.helper.PropertiesHelper.URL;

@Service
public class UrlUtilService {
    private Boolean isUrlAvailable;

    public void checkUrlConnection() {
        try (Socket socket = new Socket(new URL(URL).getHost(), 80)) {
            isUrlAvailable = socket.isConnected();
        } catch (IOException e) {
            isUrlAvailable = false;
        }
    }

    public String createUrlStatusMessageText(){
        if(isUrlAvailable != null){
            String urlAvailability = isUrlAvailable ? AVAILABLE : UNAVAILABLE;
            return String.format("%s is %s", URL, urlAvailability);
        } else {
            throw new UrlStatusNotFoundException(URL_STATUS_NOT_FIND_EXCEPTION_MESSAGE);
        }
    }
}
