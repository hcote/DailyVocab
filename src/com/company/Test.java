package com.company;

import java.util.TimerTask;

public class Test extends TimerTask {

    @Override
    public void run() {
        System.out.println("This will run after 10 seconds");
    }

}
