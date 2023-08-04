package com.example.clienteinfomicroservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.clienteinfomicroservice.model.ClienteInfo;

@RestController
public class ClienteController {

    /*@GetMapping()
    public String carro(@RequestParam (name = "tipoDocumento") String tipoDocumento) {
                System.out.println(tipoDocumento);
        return "sirve" ;
    }*/

    @GetMapping("/cliente-info")
    public ResponseEntity<ClienteInfo> getClienteInfo(@RequestParam (name = "tipoDocumento") String tipoDocumento,
            @RequestParam (name = "numeroDocumento")String numeroDocumento) {
        // Validar los datos de entrada
        if (!tipoDocumento.equalsIgnoreCase("C") && !tipoDocumento.equalsIgnoreCase("P")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Código 400
        }

        if (!numeroDocumento.equals("23445322")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Código 404
        }

        // Datos quemados para el cliente con número de documento 23445322
        ClienteInfo clienteInfo = new ClienteInfo(
                "Juan",
                "Carlos",
                "Pérez",
                "Gómez",
                "1234567890",
                "Calle 123, Barrio XYZ",
                "Ciudad ABC");

        return new ResponseEntity<>(clienteInfo, HttpStatus.OK); // Código 200
    }
}
