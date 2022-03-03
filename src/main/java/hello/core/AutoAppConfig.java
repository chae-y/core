package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //다른거는 스프링 빈으로 등록되지 않게 하기 위해(전의 AppConfig안지웠으니까, 기존예제코드를 유지하기 위해, 원래는 안함)
)
public class AutoAppConfig {

}
