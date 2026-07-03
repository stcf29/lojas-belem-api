package miranda.sergio.comercio.service;

import miranda.sergio.comercio.dto.FormFaleConosco;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private final JavaMailSender mailSender;

    public ContatoService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarEmail(FormFaleConosco form) {

        SimpleMailMessage mensagem = new SimpleMailMessage();

        mensagem.setTo("meusite@gmail.com");

        mensagem.setSubject("Novo contato pelo site");

        mensagem.setText(
                "Nome: " + form.getNome() +
                        "\n\nEmail: " + form.getEmail() +
                        "\n\nTelefone: " + form.getTelefone() +
                        "\n\nAssunto: " + form.getAssunto() +
                        "\n\nMensagem:\n" + form.getMensagem());

        mailSender.send(mensagem);
    }
}
