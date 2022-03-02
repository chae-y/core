package hello.core.singleton;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    
    //다른 클래스에서는 못써
    private static final SingletonService instance = new SingletonService(); //static이니까 하나만 생성
    
    public static SingletonService getInstance(){ //이걸로만 조회
        return instance;
    }

    private SingletonService() {
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
    
//    public static void main(String[] args) {
//        //이렇게 하면 의미 없음
//        SingletonService singletonService1 = new SingletonService();
//        SingletonService singletonService2 = new SingletonService();
//    }
}
