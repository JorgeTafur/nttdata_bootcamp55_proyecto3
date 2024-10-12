package com.nttdata.proyecto3.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CustomerRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-11T23:43:19.454361-05:00[America/Lima]")
public class CustomerRequest   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("apellido")
  private String apellido;

  @JsonProperty("dni")
  private String dni;

  @JsonProperty("email")
  private String email;

  public CustomerRequest id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * ID único del cliente
   * @return id
  */
  @ApiModelProperty(value = "ID único del cliente")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CustomerRequest nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre del cliente
   * @return nombre
  */
  @ApiModelProperty(value = "Nombre del cliente")


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public CustomerRequest apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Apellido del cliente
   * @return apellido
  */
  @ApiModelProperty(value = "Apellido del cliente")


  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public CustomerRequest dni(String dni) {
    this.dni = dni;
    return this;
  }

  /**
   * DNI del cliente
   * @return dni
  */
  @ApiModelProperty(value = "DNI del cliente")


  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public CustomerRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email del cliente
   * @return email
  */
  @ApiModelProperty(value = "Email del cliente")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerRequest customerRequest = (CustomerRequest) o;
    return Objects.equals(this.id, customerRequest.id) &&
        Objects.equals(this.nombre, customerRequest.nombre) &&
        Objects.equals(this.apellido, customerRequest.apellido) &&
        Objects.equals(this.dni, customerRequest.dni) &&
        Objects.equals(this.email, customerRequest.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, apellido, dni, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

