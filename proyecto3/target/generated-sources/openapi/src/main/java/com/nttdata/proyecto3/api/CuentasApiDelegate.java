package com.nttdata.proyecto3.api;

import com.nttdata.proyecto3.model.AccountRequest;
import com.nttdata.proyecto3.model.AccountResponse;
import com.nttdata.proyecto3.model.Amount;
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
 * A delegate to be called by the {@link CuentasApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T23:43:19.454361-05:00[America/Lima]")
public interface CuentasApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /cuentas/{id} : Eliminar cuenta por su ID
     *
     * @param id  (required)
     * @return Cuenta eliminada (status code 204)
     *         or Error en eliminar la cuenta (status code 200)
     * @see CuentasApi#deleteAccountById
     */
    default ResponseEntity<Void> deleteAccountById(String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /cuentas/{numeroCuenta}/depositar : Realizar un depósito en una cuenta bancaria
     *
     * @param numeroCuenta  (required)
     * @param amount Monto a depositar (required)
     * @return Depósito realizado exitosamente (status code 200)
     *         or Error en el depósito en la cuenta (status code 200)
     * @see CuentasApi#depositAccount
     */
    default ResponseEntity<AccountResponse> depositAccount(String numeroCuenta,
        Amount amount) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : \"clienteId\", \"tipoCuenta\" : \"tipoCuenta\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : \"id\", \"saldo\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /cuentas/{id} : Obtener datos de una cuenta
     *
     * @param id  (required)
     * @return Cuenta obtenida exitosamente (status code 200)
     *         or Error en obtener datos de la cuenta (status code 200)
     * @see CuentasApi#getAccountById
     */
    default ResponseEntity<AccountResponse> getAccountById(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : \"clienteId\", \"tipoCuenta\" : \"tipoCuenta\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : \"id\", \"saldo\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /cuentas : Listar cuentas
     *
     * @return Lista de cuentas (status code 200)
     *         or Error en la obtención de cuentas (status code 200)
     * @see CuentasApi#listAccounts
     */
    default ResponseEntity<List<AccountResponse>> listAccounts() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : \"clienteId\", \"tipoCuenta\" : \"tipoCuenta\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : \"id\", \"saldo\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /cuentas : Crear una cuenta
     *
     * @param accountRequest Registrar una cuenta (required)
     * @return Cuenta registrada exitosamente (status code 200)
     *         or Error en la creacion de cuenta (status code 200)
     * @see CuentasApi#registerAccount
     */
    default ResponseEntity<AccountResponse> registerAccount(AccountRequest accountRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : \"clienteId\", \"tipoCuenta\" : \"tipoCuenta\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : \"id\", \"saldo\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /cuentas/{numeroCuenta}/retirar : Realizar un retiro de una cuenta bancaria
     *
     * @param numeroCuenta  (required)
     * @param amount Monto a depositar (required)
     * @return Retiro realizado exitosamente (status code 200)
     *         or Error en el retiro en la cuenta (status code 200)
     * @see CuentasApi#withdrawAccount
     */
    default ResponseEntity<AccountResponse> withdrawAccount(String numeroCuenta,
        Amount amount) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : \"clienteId\", \"tipoCuenta\" : \"tipoCuenta\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : \"id\", \"saldo\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
