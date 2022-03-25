package hello.core.order;

public interface OrderService {
    //createOrder 주문생성:회원id, 상품명, 상품가격 -> 리턴으로 주문결과 반환하는 부분
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
