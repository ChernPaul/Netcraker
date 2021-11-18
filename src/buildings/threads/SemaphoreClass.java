package buildings.threads;

public class SemaphoreClass {

    int lastThreadId;
    boolean isWaiting;

    public SemaphoreClass(int lastThreadId, boolean bool ){
        this.lastThreadId = lastThreadId;
        isWaiting = bool;
    }


    public synchronized void acquire(int threadId) throws InterruptedException {
        if (lastThreadId == threadId) {
            isWaiting = true;
            this.wait();
        }

    }

        public synchronized void release(int threadId) {
            lastThreadId = threadId;
            if(isWaiting)
                this.notify();
        }



}


