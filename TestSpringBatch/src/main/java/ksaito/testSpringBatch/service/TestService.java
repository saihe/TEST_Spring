package ksaito.testSpringBatch.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static int printCounter = 0;

    public void print(){
        System.out.println("[" + (printCounter++) + "]回目のprintをした");
    }
}
