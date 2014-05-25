package resourcemanager.system.peer.rm;

import common.simulation.RequestResource;
import java.util.List;
import se.sics.kompics.address.Address;
import se.sics.kompics.network.Message;
import se.sics.kompics.timer.ScheduleTimeout;
import se.sics.kompics.timer.Timeout;

/**
 * User: jdowling
 */
public class RequestResources {

    public static class Request extends Message {

        private final long jobID;
        private final int numCpus;
        private final int amountMemInMb;

        public Request(Address source, Address destination, long jobID, int numCpus, int amountMemInMb) {
            super(source, destination);
            this.numCpus = numCpus;
            this.amountMemInMb = amountMemInMb;
            this.jobID = jobID;
        }

        public int getAmountMemInMb() {
            return amountMemInMb;
        }

        public int getNumCpus() {
            return numCpus;
        }

        public long getJobID() {
            return jobID;
        }

    }

    public static class Response extends Message implements Comparable<Response>{

        private final boolean success;
        private final int numOfJobInQueue;
        private final long jobID;

        public Response(Address source, Address destination, long jobID, boolean success, int numOfJobInQueue) {
            super(source, destination);
            this.success = success;
            this.jobID = jobID;
            this.numOfJobInQueue = numOfJobInQueue;
        }

        public boolean isSuccess() {
            return success;
        }

        public int getNumOfJobInQueue() {
            return numOfJobInQueue;
        }

        public long getJobID() {
            return jobID;
        }
  
        @Override
        public int compareTo(Response other) {
            if (this.numOfJobInQueue == other.numOfJobInQueue) {
                if (success) {
                    return -1;
                }
                return 1;
            }
            return this.numOfJobInQueue - other.numOfJobInQueue;
        }

    }

    public static class RequestTimeout extends Timeout {

        private final Address destination;

        RequestTimeout(ScheduleTimeout st, Address destination) {
            super(st);
            this.destination = destination;
        }

        public Address getDestination() {
            return destination;
        }
    }

    public static class AssignJob extends Message {

        private final RequestResource job;

        public AssignJob(Address source, Address destination, RequestResource job) {
            super(source, destination);
            this.job = job;
        }

        public RequestResource getJob() {
            return job;
        }

    }

}
