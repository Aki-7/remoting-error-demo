package io.jenkins.plugins;

import hudson.Extension;
import hudson.model.Computer;
import hudson.model.TaskListener;
import hudson.slaves.ComputerListener;
import jenkins.model.Jenkins;

import java.io.IOException;

@Extension
public class SampleComputerListener extends ComputerListener {
    @Override
    public final void onOnline(Computer c, TaskListener listener) throws IOException, InterruptedException {
        if (c instanceof Jenkins.MasterComputer) return;
        c.getChannel().call(new SampleCommand());
    }
}
