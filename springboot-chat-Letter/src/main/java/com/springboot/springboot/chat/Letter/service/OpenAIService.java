package com.springboot.springboot.chat.Letter.service;

import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

    public String generateLetter(String letterType, String recipient, String sender, String additionalDetails,
                                 String previousName, String newName, String employeeId, String department,
                                 String position, String monthlySalary, String deductions, String netSalary,
                                 String dateOfPayment, String startDate, String employmentStatus, String skills, String tone)  {
        // Call the AI service here (e.g., OpenAI API)
        // For now, just return a detailed letter based on the input params.

        String letter = "";

        switch (letterType.toLowerCase()) {
            case "epf_etf_name_change":
                letter = generateEPFETFNameChangeLetter(recipient, sender, additionalDetails, previousName, newName, employeeId, department, tone);
                break;
            case "skill_assessment":
                letter = generateSkillAssessmentLetter(recipient, sender, additionalDetails, tone , skills);
                break;
            case "salary_undertaking":
                letter = generateSalaryUndertakingLetter(recipient, sender, additionalDetails, tone , deductions , netSalary , dateOfPayment , monthlySalary);
                break;
            case "salary_confirmation":
                letter = generateSalaryConfirmationLetter(recipient, sender, additionalDetails, tone , employeeId , department , position , dateOfPayment , monthlySalary);
                break;
            case "employee_confirmation":
                letter = generateEmployeeConfirmationLetter(recipient, sender, additionalDetails, tone , employeeId , position , department , startDate , employmentStatus);
                break;
            default:
                letter = "Unknown letter type.";
        }

        return letter;
    }

    private String generateEPFETFNameChangeLetter(String recipient, String sender, String additionalDetails, String previousName, String newName, String employeeId, String department, String tone) {
        // Validate required fields
        if (previousName.isEmpty() || newName.isEmpty() || employeeId.isEmpty() || department.isEmpty()) {
            return "Error: Missing required details. Please provide Previous Name, New Name, Employee ID, and Department.";
        }

        // More detailed letter template
        return "Subject: Request for EPF/ETF Name Change\n\n" +
                "Dear " + recipient + ",\n\n" +
                "I hope this message finds you well. I am writing to formally request a name change in my EPF/ETF records due to " + additionalDetails + ". " +
                "Below are the details of my request:\n\n" +
                "- **Previous Name:** " + previousName + "\n" +
                "- **New Name:** " + newName + "\n" +
                "- **Employee ID:** " + employeeId + "\n" +
                "- **Department:** " + department + "\n\n" +
                "I have attached the necessary documentation (e.g., a copy of my National Identity Card, Marriage Certificate, etc.) to support this request.\n\n" +
                "Please let me know if you require any further details or documentation to process this change. I appreciate your assistance in making this update as soon as possible.\n\n" +
                "Thank you for your attention to this matter.\n\n" +
                "Sincerely,\n" + sender;
    }


    private String generateSkillAssessmentLetter(String recipient, String sender, String additionalDetails, String tone , String skills) {
        // More detailed letter template
        return "Subject: Request for Skill Assessment\n\n" +
                "Dear " + recipient + ",\n\n" +
                "I hope this message finds you well. I would like to request a formal skill assessment in relation to my work performance and career progression within [Company Name]. I believe this evaluation will help in identifying my strengths, areas for improvement, and potential development opportunities.\n\n" +
                "I am specifically interested in an assessment of my skills in the following areas:\n" +
                "-"+ skills +"\n" +
                "I would appreciate any feedback or suggestions that could help me enhance my abilities and contribute further to the success of the company.\n\n" +
                "Please let me know the next steps, or if you need any additional information from my side.\n\n" +
                "Thank you for considering my request.\n\n" +
                "Best Regards,\n" + sender;
    }

    private String generateSalaryUndertakingLetter(String recipient, String sender, String additionalDetails, String tone , String deductions , String netSalary , String dateOfPayment , String monthlySalary) {
        // More detailed letter template
        return "Subject: Salary Undertaking Letter\n\n" +
                "Dear " + recipient + ",\n\n" +
                "I hope this message finds you well. I am writing to provide an undertaking regarding my salary for the purpose of [reason for the undertaking, e.g., applying for a loan, mortgage, etc.]. " +
                "I, " + sender + ", hereby undertake to ensure that my salary remains consistent with the following details:\n\n" +
                "- Monthly Salary: " + monthlySalary + "\n" +
                "- Deductions (if any):" + deductions + "\n" +
                "- Net Salary:" + netSalary + "\n" +
                "- Date of Payment:" + dateOfPayment + "\n\n" +
                "I understand that my salary is subject to change based on company policies or any other relevant circumstances, and I will notify the relevant authorities of any such changes promptly.\n\n" +
                "Please let me know if you require any further information or documentation.\n\n" +
                "Thank you for your consideration.\n\n" +
                "Sincerely,\n" + sender;
    }

    private String generateSalaryConfirmationLetter(String recipient, String sender, String additionalDetails, String tone , String employeeId , String department , String position , String dateOfPayment , String monthlySalary) {
        // More detailed letter template
        return "Subject: Salary Confirmation Letter\n\n" +
                "Dear " + recipient + ",\n\n" +
                "I am writing to confirm the details of my salary, as requested for [purpose, e.g., visa application, loan approval, etc.]. Below are the details of my current salary:\n\n" +
                "- Employee Name: " + sender + "\n" +
                "- Employee ID:" + employeeId + "\n" +
                "- Department:" + department + "\n" +
                "- Position:" + position + "\n" +
                "- Monthly Salary: " + monthlySalary + "\n" +
                "- Date of Payment: " + dateOfPayment + "\n\n" +
                "Please feel free to contact me if you need any further verification or documentation.\n\n" +
                "Thank you for your assistance in this matter.\n\n" +
                "Sincerely,\n" + sender;
    }

    private String generateEmployeeConfirmationLetter(String recipient, String sender, String additionalDetails, String tone , String employeeId , String position , String department , String startDate , String employmentStatus) {
        // More detailed letter template
        return "Subject: Employee Confirmation Letter\n\n" +
                "Dear " + recipient + ",\n\n" +
                "I am writing to confirm the employment status of " + sender + " in Creative Software. The details of their employment are as follows:\n\n" +
                "- Employee Name: " + sender + "\n" +
                "- Employee ID: " + employeeId + "\n" +
                "- Position: " + position + "\n" +
                "- Department: " + department + "\n" +
                "- Date of Employment: " + startDate + "\n" +
                "- Current Employment Status: " + employmentStatus + "\n" +
                "Should you require any additional details or clarification, please feel free to contact us.\n\n" +
                "Thank you for your attention to this request.\n\n" +
                "Sincerely,\n" + sender;
    }
}
