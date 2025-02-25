package com.springboot.springboot.chat.Letter.controller;


import com.springboot.springboot.chat.Letter.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/letters")
@CrossOrigin(origins = "http://localhost:3000")
public class LetterController {

    @Autowired
    private OpenAIService openAIService;

    @GetMapping("/generate")
    public String generateLetter(
            @RequestParam String letterType,
            @RequestParam String recipient,
            @RequestParam String sender,
            @RequestParam(required = false, defaultValue = "") String additionalDetails,
            @RequestParam(required = false, defaultValue = "formal") String tone,
            @RequestParam(required = false) String previousName,
            @RequestParam(required = false) String newName,
            @RequestParam(required = false) String employeeId,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String monthlySalary,
            @RequestParam(required = false) String deductions,
            @RequestParam(required = false) String netSalary,
            @RequestParam(required = false) String dateOfPayment,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String employmentStatus,
            @RequestParam(required = false) String skills)

    {

        return openAIService.generateLetter(
                letterType, recipient, sender, additionalDetails,
                previousName, newName, employeeId, department,
                position, monthlySalary, deductions, netSalary,
                dateOfPayment, startDate, employmentStatus, skills, tone);
    }
}
