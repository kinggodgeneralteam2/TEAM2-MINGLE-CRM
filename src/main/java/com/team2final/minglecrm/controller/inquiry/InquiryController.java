package com.team2final.minglecrm.controller.inquiry;

import com.team2final.minglecrm.controller.inquiry.request.InquiryReplyRequest;
import com.team2final.minglecrm.controller.inquiry.response.InquiryReplyResponse;
import com.team2final.minglecrm.controller.inquiry.response.InquiryResponse;
import com.team2final.minglecrm.service.inquiry.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    @GetMapping("api/v1/inquiries")
    @PreAuthorize("hasAnyRole('CONSULTANT', 'STAFF', 'MARKETER', 'MANAGER')")
    public List<InquiryResponse> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @PostMapping("api/v1/inquiries/reply")
    @PreAuthorize("hasRole('CONSULTANT')")
    public InquiryReplyResponse replyToInquiry(@RequestBody InquiryReplyRequest request) {
        return inquiryService.replyToInquiry(request);
    }


}
