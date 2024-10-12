package com.nttdata.proyecto3.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TransactionRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T23:43:19.454361-05:00[America/Lima]")
public class TransactionRequest   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("tipo")
  private String tipo;

  @JsonProperty("monto")
  private Double monto;

  @JsonProperty("fecha")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate fecha;

  @JsonProperty("cuentaOrigen")
  private String cuentaOrigen;

  @JsonProperty("cuentaDestino")
  private String cuentaDestino;

  public TransactionRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID único de la transaccion
   * @return id
  */
  @ApiModelProperty(value = "ID único de la transaccion")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TransactionRequest tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Tipo de transaccion (DEPOSITO, RETIRO, TRANSFERENCIA)
   * @return tipo
  */
  @ApiModelProperty(value = "Tipo de transaccion (DEPOSITO, RETIRO, TRANSFERENCIA)")


  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public TransactionRequest monto(Double monto) {
    this.monto = monto;
    return this;
  }

  /**
   * Monto de la transaccion
   * @return monto
  */
  @ApiModelProperty(value = "Monto de la transaccion")


  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public TransactionRequest fecha(LocalDate fecha) {
    this.fecha = fecha;
    return this;
  }

  /**
   * Fecha de la transaccion
   * @return fecha
  */
  @ApiModelProperty(value = "Fecha de la transaccion")

  @Valid

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public TransactionRequest cuentaOrigen(String cuentaOrigen) {
    this.cuentaOrigen = cuentaOrigen;
    return this;
  }

  /**
   * Cuenta Origen de la transaccion RETIRO o TRANSFERENCIA
   * @return cuentaOrigen
  */
  @ApiModelProperty(value = "Cuenta Origen de la transaccion RETIRO o TRANSFERENCIA")


  public String getCuentaOrigen() {
    return cuentaOrigen;
  }

  public void setCuentaOrigen(String cuentaOrigen) {
    this.cuentaOrigen = cuentaOrigen;
  }

  public TransactionRequest cuentaDestino(String cuentaDestino) {
    this.cuentaDestino = cuentaDestino;
    return this;
  }

  /**
   * Cuenta Destino de la transaccion DEPOSITO o TRANSFERENCIA
   * @return cuentaDestino
  */
  @ApiModelProperty(value = "Cuenta Destino de la transaccion DEPOSITO o TRANSFERENCIA")


  public String getCuentaDestino() {
    return cuentaDestino;
  }

  public void setCuentaDestino(String cuentaDestino) {
    this.cuentaDestino = cuentaDestino;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionRequest transactionRequest = (TransactionRequest) o;
    return Objects.equals(this.id, transactionRequest.id) &&
        Objects.equals(this.tipo, transactionRequest.tipo) &&
        Objects.equals(this.monto, transactionRequest.monto) &&
        Objects.equals(this.fecha, transactionRequest.fecha) &&
        Objects.equals(this.cuentaOrigen, transactionRequest.cuentaOrigen) &&
        Objects.equals(this.cuentaDestino, transactionRequest.cuentaDestino);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tipo, monto, fecha, cuentaOrigen, cuentaDestino);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    monto: ").append(toIndentedString(monto)).append("\n");
    sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
    sb.append("    cuentaOrigen: ").append(toIndentedString(cuentaOrigen)).append("\n");
    sb.append("    cuentaDestino: ").append(toIndentedString(cuentaDestino)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

