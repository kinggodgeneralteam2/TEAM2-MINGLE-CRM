package com.team2final.minglecrm.service.inquiry;

import com.team2final.minglecrm.controller.inquiry.request.InquiryReplyRequest;
import com.team2final.minglecrm.controller.inquiry.response.InquiryReplyResponse;
import com.team2final.minglecrm.controller.inquiry.response.InquiryResponse;
import com.team2final.minglecrm.entity.employee.Employee;
import com.team2final.minglecrm.entity.inquiry.Inquiry;
import com.team2final.minglecrm.entity.inquiry.InquiryReply;
import com.team2final.minglecrm.persistence.repository.Inquiry.InquiryReplyRepository;
import com.team2final.minglecrm.persistence.repository.Inquiry.InquiryRepository;
import com.team2final.minglecrm.persistence.repository.customer.CustomerRepository;
import com.team2final.minglecrm.persistence.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final InquiryReplyRepository inquiryReplyRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public List<InquiryResponse> getAllInquiries() {
        List<Inquiry> inquiries = inquiryRepository.findAll();
        return inquiries.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private InquiryResponse convertToDTO(Inquiry inquiry) {
        return InquiryResponse.builder()
                .customerId(inquiry.getCustomer().getId())
                .name(inquiry.getCustomer().getName())
                .date(inquiry.getDate())
                .inquiry(inquiry.getInquiry())
                .type(inquiry.getType())
                .build();
    }

    @Transactional
    public InquiryReplyResponse replyToInquiry(InquiryReplyRequest request) {
        // 현재 로그인한 사용자의 정보를 가져온다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        // 로그인한 사용자의 이메일을 이용하여 사용자 정보를 가져온다.
        Employee employee = employeeRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("로그인한 사용자를 찾을 수 없습니다."));

        Inquiry inquiry = inquiryRepository.findById(request.getInquiryId())
                .orElseThrow(() -> new RuntimeException("문의를 찾을 수 없습니다."));

        InquiryReply inquiryReply = InquiryReply.builder()
                .inquiry(inquiry)
                .employee(employee)
                .reply(request.getReply())
                .date(LocalDateTime.now())
                .build();

        InquiryReply saveReply = inquiryReplyRepository.save(inquiryReply);

        return convertToReplyDTO(saveReply);
    }

    private InquiryReplyResponse convertToReplyDTO(InquiryReply inquiryReply) {
        return InquiryReplyResponse.builder()
                .id(inquiryReply.getId())
                .inquiryId(inquiryReply.getInquiry().getId())
                .email(inquiryReply.getEmployee().getEmail())
                .reply(inquiryReply.getReply())
                .date(inquiryReply.getDate())
                .build();
    }
}
