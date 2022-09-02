package org.ron.m3.spring.example3;

import org.springframework.stereotype.Service;

@Service
public class HWServiceImpl implements HWService {

    //    @Autowired
    private HWHelper hwHelper;

    public HWServiceImpl(HWHelper hwHelper) {
        this.hwHelper = hwHelper;
    }

    public String getText() {
        return hwHelper.assembleMessage();
    }
}
