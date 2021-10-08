package Chapter2.Item8;

import java.lang.ref.Cleaner;

// cleaner를 안정망으로 활용하는 AutoCloseable 클래스
public class Room implements AutoCloseable{
    private static final Cleaner cleaner = Cleaner.create();

    // 청소가 필요한 자원. 절대 Room을 참조해서는 안 된다!
    private static class State implements Runnable{
        int numJunkPiles;   // 방(Room) 안의 쓰레기 수

        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }

        // close 메서드나 cleaner가 호출한다.
        @Override
        public void run(){
            System.out.println("방 청소");
            numJunkPiles = 0;
        }
    }

    // 방의 상태. cleanable과 공유한다.
    private final State state;

    // Cleanable 객체. 수거 대상이 되면 방을 청소한다.
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles){
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close(){
        cleanable.clean();
    }

}
