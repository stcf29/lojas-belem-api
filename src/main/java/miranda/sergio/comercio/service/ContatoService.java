package miranda.sergio.comercio.service;

import com.resend.Resend;
import miranda.sergio.comercio.dto.FormFaleConosco;
import org.springframework.beans.factory.annotation.Value;
import com.resend.services.emails.model.SendEmailRequest;
import com.resend.services.emails.model.SendEmailResponse;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Value("${resend.api.key}")
    private String apiKey;

    public void enviarEmail(FormFaleConosco form) {
        Resend resend = new Resend(apiKey);
        SendEmailRequest request = SendEmailRequest.builder().from("Ver-O-Centro <onboarding@resend.dev>")
                .to("vemanoelmiranda@gmail.com")
                .subject(form.getAssunto())
                .html("""
                        <h2>Novo contato</h2>

                        <p><b>Nome:</b> %s</p>

                        <p><b>Email:</b> %s</p>

                        <p><b>Telefone:</b> %s</p>
                        
                        <p><b>Assunto:</b> %s</p>

                        <p><b>Mensagem:</b></p>

                        <p>%s</p>
                        """
                        .formatted(form.getNome(), form.getEmail(), form.getTelefone(), form.getAssunto(), form.getMensagem())).build();
        SendEmailResponse response = resend.emails().send(request);
        System.out.println(response.getId());
    }
}
