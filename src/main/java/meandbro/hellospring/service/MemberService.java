package meandbro.hellospring.service;

import meandbro.hellospring.domain.Member;
import meandbro.hellospring.repository.MemberRepository;
import meandbro.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */

    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
     * 전체 회원 조회
     * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*
     * 특정 회원 조회
     * */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}