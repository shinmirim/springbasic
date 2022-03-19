package hello.hellospring.repository;  //메모리 저장소

import  hello.hellospring.domain.Member;
import java.util.Optional;
import java.util.List;


public interface MemberRepository {
    Member save(Member member);//id 비번 저장 회원이 저장소에 저장
    Optional<Member> findById(Long id); // 아이디로 회원 찾기 Optional 아이디와 회원 이름이 없을때 널이 있을 수도 있기에 감싸
    Optional<Member> findByName(String name); //findid, findname로 찾아옴
    List<Member> findAll();//지금까지 저장된 회원 리스트 모두 반환

}
