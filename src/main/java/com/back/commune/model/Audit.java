package com.back.commune.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "audit")
public class Audit implements  Serializable{

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    @Column(name = "entity", nullable = false)
	    private String entity;

	    @NotNull
	    @Column(name = "operation", nullable = false)
	    private String operation;

	    @NotNull
	    @Column(name = "modified_by", nullable = false)
	    private String modifiedBy;

	    @NotNull
	    @Column(name = "modified_at", nullable = false)
	    private LocalDateTime modifiedAt;

	    @NotNull
	    @Column(name = "payload")
	    private String payload;

		public Audit() {
		}

		public Audit(@NotNull String entity, @NotNull String operation, @NotNull String modifiedBy,
				@NotNull LocalDateTime modifiedAt, @NotNull String payload) {
			this.entity = entity;
			this.operation = operation;
			this.modifiedBy = modifiedBy;
			this.modifiedAt = modifiedAt;
			this.payload = payload;
		}


		public String getEntity() {
			return entity;
		}

		public void setEntity(String entity) {
			this.entity = entity;
		}

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}

		public String getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

		public LocalDateTime getModifiedAt() {
			return modifiedAt;
		}

		public void setModifiedAt(LocalDateTime modifiedAt) {
			this.modifiedAt = modifiedAt;
		}

		public String getPayload() {
			return payload;
		}

		public void setPayload(String payload) {
			this.payload = payload;
		}




}
