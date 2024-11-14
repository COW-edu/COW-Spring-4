package practice.kimyunjincrudapi.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.kimyunjincrudapi.member.Member;
import practice.kimyunjincrudapi.member.controller.dto.CreateMemberRequest;
import practice.kimyunjincrudapi.member.controller.dto.MemberResponse;
import practice.kimyunjincrudapi.member.controller.dto.UpdateMemberRequest;
import practice.kimyunjincrudapi.member.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(CreateMemberRequest createMemberRequest) {
        Long id = memberRepository.generateId();
        Member member = createMemberRequest.toEntity(id);
        memberRepository.save(member);
    }

    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }

    public MemberResponse getMember(String name) {
        Member member = memberRepository.findByName(name);
        return MemberResponse.from(member);
    }

    public MemberResponse updateMember(String name, UpdateMemberRequest request) {
        Member member = memberRepository.findByName(name);
        member.update(request.getUsername(), request.getEmail());
        return MemberResponse.from(member);
    }

    public void deleteMember(String name) {
        memberRepository.deleteByName(name);
    }

    public void deleteAllMembers() {
        memberRepository.deleteAll();
    }
}
