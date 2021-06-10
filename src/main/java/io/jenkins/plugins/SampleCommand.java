package io.jenkins.plugins;

import hudson.remoting.Engine;
import hudson.remoting.EngineListener;
import jenkins.security.MasterToSlaveCallable;
import org.apache.commons.math3.complex.Complex;

public class SampleCommand extends MasterToSlaveCallable {
    @Override
    public Void call() throws InterruptedException {
        try {
            Engine currentEngine = Engine.current();
            currentEngine.addListener(new SampleListener());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class SampleListener implements EngineListener {

        @Override
        public void status(String s) {
            if (s.equals("Terminated")) {
                System.out.println(new Complex(1.0, 4.0));
            }
        }

        @Override
        public void status(String s, Throwable throwable) {}

        @Override
        public void error(Throwable throwable) {}

        @Override
        public void onDisconnect() {}

        @Override
        public void onReconnect() {

        }
    }
}
