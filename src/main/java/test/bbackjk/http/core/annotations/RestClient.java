package test.bbackjk.http.core.annotations;

import org.springframework.core.annotation.AliasFor;
import test.bbackjk.http.core.bean.agent.RestTemplateAgent;
import test.bbackjk.http.core.bean.mapper.DefaultResponseMapper;
import test.bbackjk.http.core.interfaces.HttpAgent;
import test.bbackjk.http.core.interfaces.ResponseMapper;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestClient {

    @AliasFor("context")
    String value() default "";
    @AliasFor("value")
    String context() default "";
    String url() default "";

    Class<? extends HttpAgent> agent() default RestTemplateAgent.class;
    Class<? extends ResponseMapper> mapper() default DefaultResponseMapper.class;
}
