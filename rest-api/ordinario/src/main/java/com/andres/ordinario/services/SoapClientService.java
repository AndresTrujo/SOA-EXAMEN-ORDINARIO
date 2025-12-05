package com.andres.ordinario.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SoapClientService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String SOAP_URL = "http://127.0.0.1:8000/";

    public String inscribirAlumno(String matricula, String curp, String nombre, String apellido, String email) {

        String soapBody = """
                    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uav="uav.soap.inscripciones">
                       <soapenv:Header/>
                       <soapenv:Body>
                          <uav:inscribir_alumno>
                             <uav:matricula>%s</uav:matricula>
                             <uav:curp>%s</uav:curp>
                             <uav:nombre>%s</uav:nombre>
                             <uav:apellido>%s</uav:apellido>
                             <uav:email>%s</uav:email>
                          </uav:inscribir_alumno>
                       </soapenv:Body>
                    </soapenv:Envelope>
                """
                .formatted(matricula, curp, nombre, apellido, email);

        return callSoap(soapBody);
    }

    public String consultarAlumno(String matricula) {

        String soapBody = """
                    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uav="uav.soap.inscripciones">
                       <soapenv:Header/>
                       <soapenv:Body>
                          <uav:consultar_alumno>
                             <uav:matricula_buscada>%s</uav:matricula_buscada>
                          </uav:consultar_alumno>
                       </soapenv:Body>
                    </soapenv:Envelope>
                """
                .formatted(matricula);

        return callSoap(soapBody);
    }

    public String editarAlumno(String matricula, String nombre, String apellido, String email, String estatus) {

        String soapBody = """
                    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uav="uav.soap.inscripciones">
                       <soapenv:Header/>
                       <soapenv:Body>
                          <uav:editar_alumno>
                             <uav:matricula>%s</uav:matricula>
                             <uav:nuevo_nombre>%s</uav:nuevo_nombre>
                             <uav:nuevo_apellido>%s</uav:nuevo_apellido>
                             <uav:nuevo_email>%s</uav:nuevo_email>
                             <uav:nuevo_estatus>%s</uav:nuevo_estatus>
                          </uav:editar_alumno>
                       </soapenv:Body>
                    </soapenv:Envelope>
                """
                .formatted(matricula, nombre, apellido, email, estatus);

        return callSoap(soapBody);
    }

    public String eliminarAlumno(String matricula) {

        String soapBody = """
                    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:uav="uav.soap.inscripciones">
                       <soapenv:Header/>
                       <soapenv:Body>
                          <uav:eliminar_alumno>
                             <uav:matricula>%s</uav:matricula>
                          </uav:eliminar_alumno>
                       </soapenv:Body>
                    </soapenv:Envelope>
                """
                .formatted(matricula);

        return callSoap(soapBody);
    }

    private String callSoap(String xml) {
        return restTemplate.postForObject(SOAP_URL, xml, String.class);
    }
}