/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.nttdata.proyecto3.api;

import com.nttdata.proyecto3.model.TransactionRequest;
import com.nttdata.proyecto3.model.TransactionResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T23:51:38.342295-05:00[America/Lima]")
@Validated
@Api(value = "transacciones", description = "the transacciones API")
public interface TransaccionesApi {

    default TransaccionesApiDelegate getDelegate() {
        return new TransaccionesApiDelegate() {};
    }

    /**
     * GET /transacciones/historial : Listar transacciones
     *
     * @return Lista de transacciones (status code 200)
     *         or Error en la obtención de transacciones (status code 200)
     */
    @ApiOperation(value = "Listar transacciones", nickname = "listTransactions", notes = "", response = TransactionResponse.class, responseContainer = "List", tags={ "transaccion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lista de transacciones", response = TransactionResponse.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "Error en la obtención de transacciones") })
    @GetMapping(
        value = "/transacciones/historial",
        produces = { "application/json" }
    )
    default ResponseEntity<List<TransactionResponse>> listTransactions() {
        return getDelegate().listTransactions();
    }


    /**
     * POST /transacciones/deposito : Crear una transaccion de tipo Deposito
     *
     * @param transactionRequest Registrar una transaccion de tipo Deposito (required)
     * @return Transaccion tipo Deposito registrada exitosamente (status code 200)
     *         or Error en la creacion de transaccion tipo Deposito (status code 200)
     */
    @ApiOperation(value = "Crear una transaccion de tipo Deposito", nickname = "registerTransactionDeposito", notes = "", response = TransactionResponse.class, tags={ "transaccion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Transaccion tipo Deposito registrada exitosamente", response = TransactionResponse.class),
        @ApiResponse(code = 200, message = "Error en la creacion de transaccion tipo Deposito") })
    @PostMapping(
        value = "/transacciones/deposito",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<TransactionResponse> registerTransactionDeposito(@ApiParam(value = "Registrar una transaccion de tipo Deposito" ,required=true )  @Valid @RequestBody TransactionRequest transactionRequest) {
        return getDelegate().registerTransactionDeposito(transactionRequest);
    }


    /**
     * POST /transacciones/retiro : Crear una transaccion de tipo Retiro
     *
     * @param transactionRequest Registrar una transaccion de tipo Retiro (required)
     * @return Transaccion tipo Retiro registrada exitosamente (status code 200)
     *         or Error en la creacion de transaccion tipo Retiro (status code 200)
     */
    @ApiOperation(value = "Crear una transaccion de tipo Retiro", nickname = "registerTransactionRetiro", notes = "", response = TransactionResponse.class, tags={ "transaccion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Transaccion tipo Retiro registrada exitosamente", response = TransactionResponse.class),
        @ApiResponse(code = 200, message = "Error en la creacion de transaccion tipo Retiro") })
    @PostMapping(
        value = "/transacciones/retiro",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<TransactionResponse> registerTransactionRetiro(@ApiParam(value = "Registrar una transaccion de tipo Retiro" ,required=true )  @Valid @RequestBody TransactionRequest transactionRequest) {
        return getDelegate().registerTransactionRetiro(transactionRequest);
    }


    /**
     * POST /transacciones/transferencia : Crear una transaccion de tipo Transferencia
     *
     * @param transactionRequest Registrar una transaccion de tipo Transferencia (required)
     * @return Transaccion tipo Transferencia registrada exitosamente (status code 200)
     *         or Error en la creacion de transaccion tipo Transferencia (status code 200)
     */
    @ApiOperation(value = "Crear una transaccion de tipo Transferencia", nickname = "registerTransactionTransferencia", notes = "", response = TransactionResponse.class, tags={ "transaccion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Transaccion tipo Transferencia registrada exitosamente", response = TransactionResponse.class),
        @ApiResponse(code = 200, message = "Error en la creacion de transaccion tipo Transferencia") })
    @PostMapping(
        value = "/transacciones/transferencia",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<TransactionResponse> registerTransactionTransferencia(@ApiParam(value = "Registrar una transaccion de tipo Transferencia" ,required=true )  @Valid @RequestBody TransactionRequest transactionRequest) {
        return getDelegate().registerTransactionTransferencia(transactionRequest);
    }

}
