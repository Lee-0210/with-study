package com.with.www.withboot.home.service.impl;

import com.with.www.withboot.home.dto.Home;
import com.with.www.withboot.home.repository.HomeMapper;
import com.with.www.withboot.home.service.HomeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper mapper;

}
