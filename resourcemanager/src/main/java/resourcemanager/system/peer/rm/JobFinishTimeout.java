/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourcemanager.system.peer.rm;

import se.sics.kompics.timer.ScheduleTimeout;
import se.sics.kompics.timer.Timeout;

/**
 *
 * @author Mark
 */
public class JobFinishTimeout extends Timeout {

    private final long jobID;

    public JobFinishTimeout(ScheduleTimeout request, long jobID) {
        super(request);
        this.jobID = jobID;
    }

    public long getJobID() {
        return jobID;
    }
}
