package jobhunter.data;

import jobhunter.data.Job;

/**
 * @author Douglas Gardiner
 */
public class JobNode {

    public Job job;
    public JobNode next;
    
    public JobNode(Job start) {
        job = start;
        next = null;
    }
}
