package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member", 이렇게 하면 이 패키지 밑에 있는것들만 함
//        basePackageClasses = AutoAppConfig.class, 이렇게하면 그 클래스의 패키지부터 (여기선 hello.core)
//        디폴트는 이 곳의 패키지 부터 - 여기도 hello.core
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //다른거는 스프링 빈으로 등록되지 않게 하기 위해(전의 AppConfig안지웠으니까, 기존예제코드를 유지하기 위해, 원래는 안함)
)
public class AutoAppConfig {

}
