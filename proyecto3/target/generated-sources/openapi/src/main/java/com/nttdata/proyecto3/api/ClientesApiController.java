package com.nttdata.proyecto3.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T23:43:19.454361-05:00[America/Lima]")
@Controller
@RequestMapping("${openapi.bancoXYZServices.base-path:/api}")
public class ClientesApiController implements ClientesApi {

    private final ClientesApiDelegate delegate;

    public ClientesApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ClientesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ClientesApiDelegate() {});
    }

    @Override
    public ClientesApiDelegate getDelegate() {
        return delegate;
    }

}
