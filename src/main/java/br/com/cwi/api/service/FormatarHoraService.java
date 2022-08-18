package br.com.cwi.api.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FormatarHoraService {


    public String horaAtual(LocalDateTime data) {

        LocalDateTime agora = data;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return agora.format(formatter);
    }
}
