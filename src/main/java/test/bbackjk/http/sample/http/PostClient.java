package test.bbackjk.http.sample.http;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.bbackjk.http.core.annotations.RestClient;
import test.bbackjk.http.core.bean.agent.UnirestHttpAgent;
import test.bbackjk.http.core.interfaces.RestCallback;
import test.bbackjk.http.core.wrapper.RestResponse;
import test.bbackjk.http.sample.dto.MemberDto;
import test.bbackjk.http.sample.dto.SampleRequestDto;

import java.util.List;

@RestClient(value = "HelloPost", url = "http://localhost:8080", agent = UnirestHttpAgent.class)
public interface PostClient {

    @RequestMapping(value = "/api/v1/post1", method = RequestMethod.POST)
    String post1(@RequestBody SampleRequestDto requestDto);

    @PostMapping(value = "/api/v1/post2", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String post2(SampleRequestDto requestDto);

    @PostMapping(value = "/api/v1/post3")
    MemberDto post3(@RequestBody MemberDto memberDto);

    @PostMapping(value = "/api/v1/post3")
    RestResponse<MemberDto> post31(@RequestBody MemberDto memberDto);

    @PostMapping(value = "/api/v1/post3")
    MemberDto post32(@RequestBody MemberDto memberDto, RestCallback<MemberDto> callback);

    @PostMapping(value = "/api/v1/post4")
    RestResponse<List<MemberDto>> post4(@RequestBody MemberDto memberDto);

    @PostMapping(value = "/api/v1/post4")
    List<MemberDto> post5(@RequestBody MemberDto memberDto);
}
