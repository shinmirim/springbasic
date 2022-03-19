package hello.hellospring.repository; //구현체

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{ //인터페이스 가져와서 해당 실체를 만들어줌 인터페이스는 선언만 해줌 즉 정의서 설계도
    //option + enter 하면 implements 메서드 할 수 있음

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 키 값을 생성해주는 아이

    @Override
    public Member save(Member member){
        member.setId(++sequence); //sequence 에 올려주고 store에 넣기 전에 id // 고객이름의 경우 입력만 받으면 되지만 id 는 시스템에서 등록해 저장되기에 이 과정을 거쳐야한다.
        store.put(member.getId(), member); //store에 넣어주기
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));// 만약 결과가 없다면 ? --> Optional.ofNullable로 감싸 널도 감싸지도록 한다.
    }

    @Override   
    public Optional<Member> findByName(String name) {
        //자바 람다 ?
        return store.values().stream()
                .filter(member -> member.getName().equals(name))   //파라미터에 넘어온 이름과 같은지 확인하고 같은 경우에만 필터링이 된다. 찾으면 반 -->루프를 돌면 찾으면 반환 없으면 NULL로 optional로 해서 나
                .findAny();
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());// Member 가 모두 반환이 된다.

    }

    public void clearStore(){
        store.clear();
    }
}
