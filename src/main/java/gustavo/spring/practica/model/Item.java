package gustavo.spring.practica.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"creado", "actualizado"},
        allowGetters = true
)


public abstract class Item implements Serializable {
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creado", nullable = false, updatable = false)
    @CreatedDate
    private Date creado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "actualizado", nullable = false)
    @LastModifiedDate
    private Date actualizado;

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public Date getActualizado() {
		return actualizado;
	}

	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}

	
    
}
