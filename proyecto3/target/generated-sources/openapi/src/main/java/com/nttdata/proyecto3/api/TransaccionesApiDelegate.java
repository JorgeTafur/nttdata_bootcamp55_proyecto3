package com.nttdata.proyecto3.api;

import com.nttdata.proyecto3.model.TransactionRequest;
import com.nttdata.proyecto3.model.TransactionResponse;
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
 * A delegate to be called by the {@link TransaccionesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T23:43:19.454361-05:00[America/Lima]")
public interface TransaccionesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /transacciones/historial : Listar transacciones
     *
     * @return Lista de transacciones (status code 200)
     *         or Error en la obtención de transacciones (status code 200)
     * @see TransaccionesApi#listTransactions
     */
    default ResponseEntity<List<TransactionResponse>> listTransactions() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"fecha\" : \"2000-01-23\", \"tipo\" : \"tipo\", \"monto\" : 0.8008281904610115, \"cuentaDestino\" : \"cuentaDestino\", \"cuentaOrigen\" : \"cuentaOrigen\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transacciones/deposito : Crear una transaccion de tipo Deposito
     *
     * @param transactionRequest Registrar una transaccion de tipo Deposito (required)
     * @return Transaccion tipo Deposito registrada exitosamente (status code 200)
     *         or Error en la creacion de transaccion tipo Deposito (status code 200)
     * @see TransaccionesApi#registerTransactionDeposito
     */
    default ResponseEntity<TransactionResponse> registerTransactionDeposito(TransactionRequest transactionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"fecha\" : \"2000-01-23\", \"tipo\" : \"tipo\", \"monto\" : 0.8008281904610115, \"cuentaDestino\" : \"cuentaDestino\", \"cuentaOrigen\" : \"cuentaOrigen\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transacciones/retiro : Crear una transaccion de tipo Retiro
     *
     * @param transactionRequest Registrar una transaccion de tipo Retiro (required)
     * @return Transaccion tipo Retiro registrada exitosamente (status code 200)
     *         or Error en la creacion de transaccion tipo Retiro (status code 200)
     * @see TransaccionesApi#registerTransactionRetiro
     */
    default ResponseEntity<TransactionResponse> registerTransactionRetiro(TransactionRequest transactionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"fecha\" : \"2000-01-23\", \"tipo\" : \"tipo\", \"monto\" : 0.8008281904610115, \"cuentaDestino\" : \"cuentaDestino\", \"cuentaOrigen\" : \"cuentaOrigen\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transacciones/transferencia : Crear una transaccion de tipo Transferencia
     *
     * @param transactionRequest Registrar una transaccion de tipo Transferencia (required)
     * @return Transaccion tipo Transferencia registrada exitosamente (status code 200)
     *         or Error en la creacion de transaccion tipo Transferencia (status code 200)
     * @see TransaccionesApi#registerTransactionTransferencia
     */
    default ResponseEntity<TransactionResponse> registerTransactionTransferencia(TransactionRequest transactionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"fecha\" : \"2000-01-23\", \"tipo\" : \"tipo\", \"monto\" : 0.8008281904610115, \"cuentaDestino\" : \"cuentaDestino\", \"cuentaOrigen\" : \"cuentaOrigen\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
