package com.maemresen.infsec.keylogweb.service.impl;

import com.maemresen.infsec.keylogweb.entity.KeyLog;
import com.maemresen.infsec.keylogweb.repository.IKeyLogRepository;
import com.maemresen.infsec.keylogweb.service.IKeyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Emre Sen - 14.05.2019
 * @contact maemresen07@gmail.com
 */
@Service
public class KeyLogServiceDatabaseImpl implements IKeyLogService {

    @Autowired
    private IKeyLogRepository keyLogRepository;

    @Override
    public List<KeyLog> getKeyLogList() {
        return StreamSupport.stream(keyLogRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public KeyLog save(KeyLog keyLog) {
        return keyLogRepository.save(keyLog);
    }
}
