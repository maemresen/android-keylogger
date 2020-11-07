package com.maemresen.infsec.keylogweb.service;

import com.maemresen.infsec.keylogweb.entity.KeyLog;

import java.util.List;

/**
 * @author Emre Sen - 14.05.2019
 * @contact maemresen07@gmail.com
 */
public interface IKeyLogService {

    public List<KeyLog> getKeyLogList();

    public KeyLog save(KeyLog keyLog);

}
