package jobhunter;

/**
 * @author Douglas Gardiner
 */
public class JobLinkedList {

    public JobNode startNode;
    private static int count = 0;
    
    public JobLinkedList(Job start) {
        JobNode currentNode = new JobNode(start);
        startNode = currentNode;
        JobLinkedList.count++;
    }
    
    public void add(JobNode currentNode) {
        JobNode current = startNode;
        if (current == null) return;
        while(current.next != null) current = current.next;
        current.next = currentNode;
    }
}
