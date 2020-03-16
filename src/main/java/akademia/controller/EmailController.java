package akademia.controller;

import akademia.model.MyEmail;
import akademia.service.EmailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Controller
public class EmailController {
  private final EmailSender emailSender;
  private final TemplateEngine templateEngine;

  public EmailController(EmailSender emailSender, TemplateEngine templateEngine) {
    this.emailSender = emailSender;
    this.templateEngine = templateEngine;
  }

  @GetMapping("/")
  public String home() {
    return "index";
  }

  @PostMapping("/send")
  public String sendMail(@ModelAttribute MyEmail myEmail) {
    Context context = new Context();
    context.setVariable("body", myEmail.getBody());
    String templateMail = templateEngine.process("template-mail", context);
    emailSender.sendEmail(myEmail.getAddress(), myEmail.getSubject(), templateMail);
    return "index";
  }

  @GetMapping("/sender")
  public String sender() {
    return "sender";
  }
}
