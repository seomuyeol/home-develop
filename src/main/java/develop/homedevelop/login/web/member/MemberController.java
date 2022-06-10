package develop.homedevelop.login.web.member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import develop.homedevelop.login.domain.member.CrudMemberRepository;
import develop.homedevelop.login.domain.member.Member;
import develop.homedevelop.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

	private final CrudMemberRepository crudMemberRepository; 
	private final MemberRepository memberRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/add")
	public String addForm(@ModelAttribute("member") Member member) {
		return "members/addMemberForm";
	}

	@PostMapping("/add")
	public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "members/addMemberForm";
		}
		memberRepository.save(member);
		return "redirect:/";
	}
}