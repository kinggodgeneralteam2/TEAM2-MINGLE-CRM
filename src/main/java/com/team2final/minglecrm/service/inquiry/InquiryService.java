package com.team2final.minglecrm.service.inquiry;

import com.team2final.minglecrm.controller.inquiry.response.InquiryResponse;
import com.team2final.minglecrm.entity.inquiry.Inquiry;
import com.team2final.minglecrm.persistence.repository.Inquiry.InquiryRepository;
import com.team2final.minglecrm.persistence.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public List<InquiryResponse> getAllInquiries() {
        List<Inquiry> inquiries = inquiryRepository.findAll();
        return inquiries.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private InquiryResponse convertToDTO(Inquiry inquiry) {
        return InquiryResponse.builder()
                .date(inquiry.getDate())
                .inquiry(inquiry.getInquiry())
                .type(inquiry.getType())
                .build();
    }
}
