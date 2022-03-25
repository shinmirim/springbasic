package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService {
    //메모리, 고정할인 정책 구현체 활용해 사용
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //member 찾기
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);// 단일 책임 원칙이 잘 지켜짐
        //할인을 따로 관리함

        //order 최종생성된 주문 반환
        return new Order(memberId, itemName, itemPrice, discountPrice );

    }
}
