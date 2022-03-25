package hello.core;

// 잘 되는지 테스

import hello.core.member.Grade;
import hello.core.member.MemberService;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;


public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);//가입한 회
        memberService.join(member); //회원가입이 되어야함

        //제대로 회원가입이 되었는지 확인
        Member findMember = memberService.findMember(1l);// 가입한 회원과 찾는 회원이 같으 잘 된것
        System.out.println("new member="+member.getName());
        System.out.println("find Member="+findMember.getName());


    }
}
