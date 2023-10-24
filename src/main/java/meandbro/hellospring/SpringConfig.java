package meandbro.hellospring;

import meandbro.hellospring.repository.MemberRepository;
import meandbro.hellospring.repository.MemoryMemberRepository;
import meandbro.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
