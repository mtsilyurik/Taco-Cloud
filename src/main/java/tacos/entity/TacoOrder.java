package tacos.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Data
@Table("orders")
public class TacoOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private UUID id;

	private Date placedAt = new Date();

	@NotBlank(message="Delivery name is required")
	private String deliveryName;
	
	@NotBlank(message="Delivery street is required")
	private String deliveryStreet;
	
	@NotBlank(message="Delivery City is required")
	private String deliveryCity;

	@NotBlank
	@Size(max=2, message="Delivery state is 2 characters max")
	private String deliveryState;
	
	@NotBlank(message="Delivery zip is required")
	private String deliveryZip;
	
	@CreditCardNumber(message="Not a valid credit card number")
	private String ccNumber;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
				message="Must be formatted MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;

	@Column("tacos")
	private List<TacoUDT> tacos = new ArrayList<TacoUDT>();

	public void addTaco(TacoUDT taco) {
		System.out.println("add taco");
		this.tacos.add(taco);
	}

    @Override
	public String toString() {
		return "TacoOrder [deliveryName=" + deliveryName + ", deliveryStreet=" + deliveryStreet + ", deliveryCity="
				+ deliveryCity + ", deliveryState=" + deliveryState + ", deliveryZip=" + deliveryZip + ", ccNumber="
				+ ccNumber + ", ccExpiration=" + ccExpiration + ", ccCVV=" + ccCVV + ", tacos=" + tacos + "]";
	}


	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
