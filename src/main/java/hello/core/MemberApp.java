package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
/*        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/
       // MemberService memberService=new MemberServiceImpl(memberRepository);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);//@Bean붙은걸 객체 만들어서 다 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//이름은 메서드 이름 두번째는 타입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
