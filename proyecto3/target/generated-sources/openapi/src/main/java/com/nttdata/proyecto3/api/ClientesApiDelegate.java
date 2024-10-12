package com.nttdata.proyecto3.api;

import com.nttdata.proyecto3.model.CustomerRequest;
import com.nttdata.proyecto3.model.CustomerResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ClientesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T23:43:19.454361-05:00[America/Lima]")
public interface ClientesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /clientes/{id} : Eliminar cliente por su ID
     *
     * @param id  (required)
     * @return Cliente eliminado (status code 204)
     *         or Error al eliminar el cliente (status code 200)
     * @see ClientesApi#deleteCustomerById
     */
    default ResponseEntity<Void> deleteCustomerById(String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clientes/{id} : Obtener datos de un cliente
     *
     * @param id  (required)
     * @return Cliente obtenido exitosamente (status code 200)
     *         or Error en obtener datos del cliente (status code 200)
     * @see ClientesApi#getCustomerById
     */
    default ResponseEntity<CustomerResponse> getCustomerById(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellido\" : \"apellido\", \"id\" : 0, \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clientes : Listar clientes
     *
     * @return Lista de clientes (status code 200)
     *         or Error en la obtención de clientes (status code 200)
     * @see ClientesApi#listCustomers
     */
    default ResponseEntity<List<CustomerResponse>> listCustomers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellido\" : \"apellido\", \"id\" : 0, \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clientes : Crear un cliente
     *
     * @param customerRequest Registrar un cliente (required)
     * @return Cliente registrado exitosamente (status code 200)
     *         or Error en la creacion de cliente (status code 200)
     * @see ClientesApi#registerCustomer
     */
    default ResponseEntity<CustomerResponse> registerCustomer(CustomerRequest customerRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellido\" : \"apellido\", \"id\" : 0, \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clientes/{id} : Actualizar un cliente
     *
     * @param id  (required)
     * @param customerRequest Detalles del cliente actualizada (required)
     * @return Cliente actualizado exitosamente (status code 200)
     *         or Error en la actualización de cliente (status code 200)
     * @see ClientesApi#updateCustomer
     */
    default ResponseEntity<CustomerResponse> updateCustomer(String id,
        CustomerRequest customerRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellido\" : \"apellido\", \"id\" : 0, \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
