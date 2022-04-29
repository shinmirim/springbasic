package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //private  final MemberRepository memberRepository = new MemoryMemberRepository();
    private  final MemberRepository memberRepository;

    //생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }//생성자를 통해 memberRepository안에 구현제가 무엇이 들어갈지 생각


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
